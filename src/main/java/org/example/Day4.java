package org.example;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Day4 {
    public static void solveDay4(){
        int res=0;
        try {

            File file = new File("src/main/resources/input4.txt");
            BufferedReader in = new BufferedReader(new FileReader(file));
            String str;
            while ((str = in.readLine()) != null) {
                String[] arr=str.split(":");
                String[] allNums=arr[1].split("\\|");
                String[] winNums=allNums[0].trim().split("\\s+");
                String[] drawnNums=allNums[1].trim().split("\\s+");
                Set<Integer> winners=new HashSet<>();
                for(String num: winNums){
                    int val=Integer.parseInt(num);
                    winners.add(val);
                }
                int count=0;
                for(String num: drawnNums){
                    int val=Integer.parseInt(num);
                    if(winners.contains(val)){
                        if(count==0){
                            count=1;
                        }
                        else{
                            count*=2;
                        }
                    }
                }
                res+=count;


            }
        } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        System.out.println("Day 4 solution is " + res);

    }

}
