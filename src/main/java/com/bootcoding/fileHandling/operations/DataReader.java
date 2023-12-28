package com.bootcoding.fileHandling.operations;

import com.bootcoding.fileHandling.model.FileInfo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataReader {

    public static void main(String[] args) {
        File file = new File("src/main/resources/housing.csv");

        try {

            BufferedReader bReader = new BufferedReader(new FileReader(file));
            String line = bReader.readLine();

            List<FileInfo> houses = new ArrayList<>();
            while( (line = bReader.readLine()) != null){
                FileInfo house = buildHouse(line);
                houses.add(house);
            }

            System.out.println("Total Houses: " + houses.size());

            List<FileInfo> houses2bhk = houses.stream().filter(house -> house.getBedrooms() == 2)
                    .collect(Collectors.toList());

            //print 3bhk bedrooms.......
            List<FileInfo> houses3bhk = new ArrayList<>();
            for (int i = 0 ; i < houses.size() ; i++){
                if(houses.get(i).getBedrooms()==3){
                    houses3bhk.add(houses.get(i));
                }
            }

            for(int i = 0 ; i < houses3bhk.size() ; i++){
                System.out.println(houses3bhk.get(i).toString());
            }


            //print 4bhk bedrooms......
            List<FileInfo> houses4bhk = new ArrayList<>();
            for(int i = 0; i < houses.size(); i++){
                if(houses.get(i).getBedrooms()==4){
                    houses4bhk.add(houses.get(i));
                }
            }

            for(int i = 0; i < houses4bhk.size(); i++){
                System.out.println(houses4bhk.get(i).toString());
            }


            //print 5bhk bedrooms......
            List<FileInfo> houses5bhk = new ArrayList<>();
            for(int i = 0; i < houses.size(); i++){
                if(houses.get(i).getBedrooms() == 5){
                    houses5bhk.add(houses.get(i));
                }
            }

            for(int i = 0; i < houses.size(); i++){
                System.out.println(houses5bhk.get(i).toString());
            }


            dataWrite(houses2bhk);
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    private static void dataWrite(List<FileInfo> houses2bhk) {
        File file = new File("./2bhk.csv");
        StringBuffer sb = new StringBuffer();
        for(FileInfo house : houses2bhk){
            String line = toCsv(house);
            sb.append(line);
            sb.append("\n");
        }
        try{
            FileWriter fw = new FileWriter(file);
            fw.write(sb.toString());
            fw.flush();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    private static String toCsv(FileInfo house) {
        return house.getSquareFeet()
                + "," + house.getBedrooms()
                + "," + house.getBathrooms()
                + "," + house.getNeighbourhood()
                + "," + house.getYear()
                + "," + house.getPrice();
    }

    private static FileInfo buildHouse(String line) {
        String[] tokens = line.split(",");
        return FileInfo.builder()
                .squareFeet(Integer.valueOf(tokens[0]))
                .bedrooms(Integer.valueOf(tokens[1]))
                .bathrooms(Integer.valueOf(tokens[2]))
                .neighbourhood(tokens[3])
                .year(Integer.valueOf(tokens[4]))
                .price(Double.valueOf(tokens[5]))
                .build();
    }

}
