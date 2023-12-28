package com.bootcoding.fileHandling.directory;

import java.io.File;

public class DirectoryListEx1 {
    public static void main(String[] args) {

        new DirectoryListEx1().listAllFolders("D:\\codeSoft");
    }

    private void listAllFolders(String directoryPath) {
        File file = new File(directoryPath);
        if (file.isDirectory()) {
            String[] list = file.list();
            File[] files = file.listFiles();
            for (File f : files) {
                if (!f.getName().startsWith("")) ;
                if (f.isDirectory()) {
                    listAllFolders(f.getPath());
                } else {
                    print(f);
                }
            }
        }else{
            print(file);
        }
    }

    private void print(File file) {
    System.out.println(file.getPath() + "/" + file.getName());
    }
}
