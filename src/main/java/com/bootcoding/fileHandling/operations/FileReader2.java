package com.bootcoding.fileHandling.operations;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReader2 {

    public static void main(String[] args) {
        File file = new File("\"C:\\programs\\data.txt\"");

        try{

            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";
            while((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
