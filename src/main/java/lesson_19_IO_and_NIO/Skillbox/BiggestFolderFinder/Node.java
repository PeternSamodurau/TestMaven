package lesson_19_IO_and_NIO.Skillbox.BiggestFolderFinder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Node {
    private List<Node> children;
    private File folder;
    private long size;
    private int level;
    private long limit;


    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public Node(File folder , long limit) {
        this.folder = folder;
        this.limit = limit;
        children = new ArrayList<>();
    }
    public long getLimit(){
        return limit;
    }

    public List<Node> getChildren() {
        return children;
    }

    public File getFolder() {
        return folder;
    }

    public void addChild(Node node) {
        node.setLevel(level + 1);
        children.add(node);
    }

    private void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        String size = SizeCalculator.getHumanReadableSize(getSize());
        builder.append(folder.getName() + " - " + size  + "\n");
        for (Node child: children){
            if (child.getSize() < limit){
                continue;
            }
            builder.append("  ".repeat(level +1) + child.toString());
        }
        return builder.toString();
    }

}
