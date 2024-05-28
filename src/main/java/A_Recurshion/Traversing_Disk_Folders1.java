package A_Recurshion;

import java.io.File;

public class Traversing_Disk_Folders1 {
    public static void main(String[] args) {
        String startPath = "src/main/java";
        File startDir = new File(startPath);
        if (startDir.exists() && startDir.isDirectory()) {
            traverseDirectory(startDir, 0);
        } else {
            System.out.println("Директория не существует или не является папкой.");
        }
    }

    private static void traverseDirectory(File dir, int indentLevel) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    System.out.println(getIndent(indentLevel) + "[D] " + file.getName());
                    traverseDirectory(file, indentLevel + 1);
                } else {
                    System.out.println(getIndent(indentLevel) + "[F] " + file.getName());
                }
            }
        }
    }

    private static String getIndent(int level) {
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < level; i++) {
            indent.append("│  "); // Используем символы "│" и "─" для отступов
        }
        return indent.toString();
    }
}
