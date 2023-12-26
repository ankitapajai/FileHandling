package com.bootcoding.fileHandling.operations;

import java.io.File;
import java.io.IOException;

public class FileWriter2 {

    public static void main(String[] args) {
        try{
            FileWriter2 fw = new FileWriter2(new File("./data.txt"), true);

            for(int i = 0; i < 10; i++){
                fw.write(generateData());
            }
            fw.flush();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    private static String generateData(){
        StringBuffer sb = new StringBuffer();
        for(int i =0; i < 10000; i++){
            sb.append("");
            sb.append("\n");
        }
        return sb.toString();
    }
}
