package com.bootcoding.fileHandling.practiceOnFileHandling;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ReadFileEx2 {
    public static void main(String[] args) {

        try{
            File file = new File("D:\\programs\\data.txt");
            Scanner dataReader = new Scanner(file);
            while(dataReader.hasNextLine()){
                String fileData = dataReader.nextLine();
                System.out.println(fileData);
            }
            dataReader.close();


        }catch(IOException ex){
            System.out.println("unexpected error occurred: ");
            ex.printStackTrace();
        }

    }
}
