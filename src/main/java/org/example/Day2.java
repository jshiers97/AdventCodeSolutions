package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day2 {


    public static int solveDay2() throws Exception {

        //map will contain max # of that color cube allowed in bag
        Map<String, Integer> mapping=new HashMap<>();
        mapping.put("red",12 );
        mapping.put("green", 13);
        mapping.put("blue", 14);
        int sum=0;
        try {
            File file = new File("src/main/resources/input2.txt");
            BufferedReader in = new BufferedReader(new FileReader(file));
            String str;
            while ((str = in.readLine()) != null) {
                //index 0 will have id of game
                //index 1

                String[] idArr=str.split(":");
                int id= Integer.parseInt(idArr[0].split("\\s+")[1]);


                String[] draws=idArr[1].split(";", -1);

                boolean valid=true;


                for(String draw: draws){
                    if(!valid){
                        break;
                    }
                    String[] colorNumbers=draw.split(",", -1);
                    for(String pair: colorNumbers){
                        pair.trim();
                        String color=pair.split("\\s+", -1)[2];
                        int val=Integer.parseInt(pair.split("\\s+")[1]);
                        if(mapping.get(color) < val){
                            valid=false;
                            break;
                        }
                    }
                }
                if(valid){
                    sum+=id;
                }

            }


        } catch(Exception e){
            throw new Exception(e);
        }

        System.out.println("Day 2 solution is " + sum);
        return sum;
    }


}

