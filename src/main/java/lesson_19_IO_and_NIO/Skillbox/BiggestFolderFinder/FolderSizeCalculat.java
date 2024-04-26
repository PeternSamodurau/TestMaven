package lesson_19_IO_and_NIO.Skillbox.BiggestFolderFinder;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class FolderSizeCalculat extends RecursiveTask<Long> {

    private Node node;

    public FolderSizeCalculat(Node node) {
        this.node = node;
    }

    @Override
    protected Long compute() {

        File folder = node.getFolder();

        if (folder.isFile()){
            long length = folder.length();
            node.setSize(length);
            return length;
        }

        long sum = 0;

        List<FolderSizeCalculat> subTasks = new LinkedList<>();
        File[] files = folder.listFiles();

        for (File file : files){

            Node child = new Node(file, node.getLimit());
            FolderSizeCalculat task = new FolderSizeCalculat(child);
            task.fork(); // асинхронный запуск
            subTasks.add(task);
            node.addChild(child);
        }

        for (FolderSizeCalculat task : subTasks){
            sum += task.join();
        }
        node.setSize(sum);
        return sum;
    }
}
