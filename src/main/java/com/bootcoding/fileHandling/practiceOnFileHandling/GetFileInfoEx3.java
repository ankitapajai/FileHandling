package com.bootcoding.fileHandling.practiceOnFileHandling;

import java.io.File;
import java.io.IOException;

public class GetFileInfoEx3 {
    public static void main(String[] args) {

        File file = new File("D:\\programs\\FileOperationEx2.csv");

        if (file.exists()) {

            System.out.println("The name of the file is:" + file.getName());

            System.out.println("The path of the file is: " + file.getPath());

            System.out.println("is File Writable: " + file.canWrite());

            System.out.println("is File readable: " + file.canRead());

            System.out.println("The length of the file is: " + file.length());
        }else{
            System.out.println("File does not exist: ");
        }
    }
}
