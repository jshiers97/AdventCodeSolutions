package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day13 {
    static int total=0;
    public static int solveDay13(){
        try{
            File file=new File("src/main/resources/input13.txt");
            BufferedReader in = new BufferedReader(new FileReader(file));
            String str;
            List<List<Character>> grid=new ArrayList<>();
            while((str=in.readLine()) !=null){
                List<Character> insert=new ArrayList<>();
                str=str.trim();
                if(str.equals("")){
                    int vert=analyzeVertical(grid, grid.size(), grid.get(0).size());

                    int hori=analyzeHorizontal(grid, grid.size(), grid.get(0).size()) * 100;

                    total+=vert;
                    total+=hori;
                    grid=new ArrayList<>();
                }
                else{
                    for(char c: str.toCharArray()){
                        insert.add(c);
                    }
                    grid.add(insert);
                }



            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Day 13 solution is " + total);
        return total;
    }
    public static int analyzeHorizontal(List<List<Character>> grid, int m, int n){
        Map<Integer, String> map=new HashMap<>();
        for(int i=0; i<m; i++){
            StringBuilder insert=new StringBuilder();
            for(int j=0; j<n; j++){
                insert.append(grid.get(i).get(j));
            }
            map.put(i, insert.toString());
        }
        int first=0;
        int second=1;
        int startMirror=-1;

        while(second < m){
            boolean found=true;
            if(map.get(first).equals(map.get(second))){
                startMirror=first;
                int tempFirst=first;
                int tempSecond=second;
                while(tempSecond < m && tempFirst>=0){
                    if(!map.get(tempFirst).equals(map.get(tempSecond))){
                        found=false;
                        break;
                    }
                    else{
                        tempSecond++;
                        tempFirst--;
                    }
                }
                if(found){
                    return startMirror+1;
                }
                else{
                    first++;
                    second++;
                }
            }
            else{
                first++;
                second++;
            }
        }
        return 0;
    }

    public static int analyzeVertical(List<List<Character>> grid, int m, int n){
        Map<Integer, String> map=new HashMap<>();
        for(int i=0; i<n; i++){
            StringBuilder insert=new StringBuilder();
            for(int j=0; j<m; j++){
                insert.append(grid.get(j).get(i));
            }

            map.put(i, insert.toString());
        }
        int first=0;
        int second=1;
        int startMirror=-1;

        while(second < n){
            boolean found=true;
            if(map.get(first).equals(map.get(second))){
                startMirror=first;
                int tempFirst=first;
                int tempSecond=second;
                while(tempSecond < n && tempFirst>=0){
                    if(!map.get(tempFirst).equals(map.get(tempSecond))){
                        found=false;
                        break;
                    }
                    else{
                        tempSecond++;
                        tempFirst--;
                    }
                }
                if(found){
                    return startMirror+1;
                }
                else{
                    first++;
                    second++;
                }
            }
            else{
                first++;
                second++;
            }
        }
        return 0;

    }

}
