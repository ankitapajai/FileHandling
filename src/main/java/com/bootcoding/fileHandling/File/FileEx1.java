package com.bootcoding.fileHandling.File;

import java.io.*;
import java.util.Scanner;

public class FileEx1 {
    public static void main(String[] args) {

        File file = new File("C:\\programs\\dd.txt");

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        

        try {
            if (!file.exists()) {
                file.createNewFile();
            } else {
                file.delete();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}



