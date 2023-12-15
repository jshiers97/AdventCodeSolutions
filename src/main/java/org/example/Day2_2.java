package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day2_2 {


    public static int solveDay2_2() throws Exception {

        //map will contain max # of that color cube allowed in bag

        int res=0;
        try {
            File file = new File("src/main/resources/input2.txt");
            BufferedReader in = new BufferedReader(new FileReader(file));
            String str;
            while ((str = in.readLine()) != null) {


                String[] idArr=str.split(":");
                int id= Integer.parseInt(idArr[0].split("\\s+")[1]);


                String[] draws=idArr[1].split(";", -1);

                int red=0;
                int blue=0;
                int green=0;

                //each draw will be
                for(String draw: draws){

                    String[] colorNumbers=draw.split(",", -1);
                    for(String pair: colorNumbers){
                        pair.trim();

                        String color=pair.split("\\s+", -1)[2];

                        int val=Integer.parseInt(pair.split("\\s+")[1]);
                        if(color.equals("red")){
                            red=Math.max(red, val);
                        }
                        else if(color.equals("blue")){
                            blue=Math.max(blue, val);
                        }
                        else{
                            green=Math.max(green,val);
                        }
                    }
                }
                int temp= red * green * blue;
                res+=temp;


            }


        } catch(Exception e){
            throw new Exception(e);
        }

        System.out.println("Day 2 part 2 solution is" + res);
        return res;
    }


}

