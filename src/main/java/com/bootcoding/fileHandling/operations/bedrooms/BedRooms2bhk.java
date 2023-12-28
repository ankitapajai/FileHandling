package com.bootcoding.fileHandling.operations.bedrooms;

import com.bootcoding.fileHandling.model.FileInfo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BedRooms2bhk {
    public static void main(String[] args) {
        File file = new File("src/main/resources/housing.csv");

        try {
            BufferedReader bReader = new BufferedReader(new FileReader(file));
            String line = bReader.readLine();

            List<FileInfo> houses = new ArrayList<>();
            while ((line = bReader.readLine()) != null) {
                FileInfo house = buildHouse(line);
                houses.add(house);
            }

            System.out.println("Total Houses: " + houses.size());

//            List<FileInfo> houses2bhk = houses.stream().filter(house -> house.getBedrooms() == 2)
//                    .collect(Collectors.toList());

            //print 2bhk bedrooms.......
            List<FileInfo> houses2bhk = new ArrayList<>();
            for (int i = 0; i < houses.size(); i++) {
                if (houses.get(i).getBedrooms() == 2) {
                    houses2bhk.add(houses.get(i));
                }
            }

            dataWrite(houses2bhk, "./2bhk.csv");
            for (int i = 0; i < houses2bhk.size(); i++) {
                System.out.println(houses2bhk.get(i).toString());
            }

            //print 3bhk bedrooms.......
            List<FileInfo> houses3bhk = new ArrayList<>();
            for (int i = 0; i < houses.size(); i++) {
                if (houses.get(i).getBedrooms() == 3) {
                    houses3bhk.add(houses.get(i));
                }
            }

            dataWrite(houses3bhk, "./3bhk.csv");
            for (int i = 0; i < houses3bhk.size(); i++) {
                System.out.println(houses3bhk.get(i).toString());
            }


            //print 4bhk bedrooms.......
            List<FileInfo> houses4bhk = new ArrayList<>();
            for (int i = 0; i < houses.size(); i++) {
                if (houses.get(i).getBedrooms() == 4) {
                    houses4bhk.add(houses.get(i));
                }
            }

            dataWrite(houses4bhk, "./4bhk.csv");
            for (int i = 0; i < houses4bhk.size(); i++) {
                System.out.println(houses4bhk.get(i).toString());
            }


        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private static void dataWrite(List<FileInfo> houses2bhk, String path) {
        File file = new File(path);
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


        private static String toCsv(FileInfo house){
            return house.getSquareFeet()
                    + "," + house.getBedrooms()
                    + "," + house.getBathrooms()
                    + "," + house.getNeighbourhood()
                    + "," + house.getYear()
                    + "," + house.getPrice();
        }

        private static FileInfo buildHouse(String line){
            String[] tokens = line.split(",");
            return FileInfo.builder()
                    .squareFeet(Integer.parseInt(tokens[0]))
                    .bedrooms(Integer.parseInt(tokens[1]))
                    .bathrooms(Integer.parseInt(tokens[2]))
                    .neighbourhood(tokens[3])
                    .year(Integer.parseInt(tokens[4]))
                    .price(Double.parseDouble(tokens[5]))
                    .build();
        }
    }


