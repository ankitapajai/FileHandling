package com.bootcoding.fileHandling.practiceOnFileHandling;

import java.io.File;
import java.io.IOException;

public class CreateFile_Ex1 {
    public static void main(String[] args) {

        File file = new File("D:\\programs\\FileOperationEx3.js");

        try{
            if(file.createNewFile()){
                System.out.println("file " + file.getName() + " is created successfully!..");
            }else{
                System.out.println("file is already exist in directory");
            }

        }catch (IOException ex){
            System.out.println("an unwanted error occurred! ");
            ex.printStackTrace();
        }
    }
}
