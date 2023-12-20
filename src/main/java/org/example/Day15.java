package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day15 {
    public static void solveDay15(){
        long total=0;
        try{
            File file=new File("src/main/resources/input15.txt");
            BufferedReader in = new BufferedReader(new FileReader(file));
            String str;
            while((str=in.readLine()) !=null){
                str.trim();
                String[] arr=str.split(",");
                for(String s: arr){
                    int curr=0;
                    for(char c: s.toCharArray()){
                        int val=((int)c);
                        curr+=val;
                        curr*=17;
                        curr%=256;
                    }
                    total+=curr;
                }


            }
            System.out.println("Day 15 solution is " + total);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
