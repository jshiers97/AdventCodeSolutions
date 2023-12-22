package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day13_2 {
    static int total=0;
    public static int solveDay13_2(){
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
                    System.out.println(vert);
                    int hori=analyzeHorizontal(grid, grid.size(), grid.get(0).size()) * 100;
                    System.out.println(hori);
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

        System.out.println("Day 13 part 2 solution is " + total);
        return total;
    }
    public static int analyzeHorizontal(List<List<Character>> grid, int m, int n){

        int first=0;
        int second=1;
        int startMirror=-1;

        while(second < m){
            boolean found=true;
            int diff=0;
            int copyFirst=first;
            startMirror=copyFirst;
            int copySecond=second;
            while(found && copyFirst >=0 && copySecond < m){
                for(int i=0; i<n; i++){
                    if(grid.get(copyFirst).get(i)!=grid.get(copySecond).get(i)){
                        diff++;
                        if(diff>1){
                            found=false;
                            break;
                        }
                    }
                }
                if(!found){
                    break;
                }
                else{
                    copyFirst--;
                    copySecond++;
                }
            }
            if(found && diff==1){

                return startMirror+1;
            }
            else{
                second++;
                first++;
            }

        }
        return 0;
    }

    public static int analyzeVertical(List<List<Character>> grid, int m, int n){
        int first=0;
        int second=1;
        int startMirror=-1;

        while(second < n){
            boolean found=true;
            int diff=0;
            int copyFirst=first;
            startMirror=copyFirst;
            int copySecond=second;
            while(found && copyFirst >=0 && copySecond < n){
                for(int i=0; i<m; i++){
                    if(grid.get(i).get(copyFirst)!=grid.get(i).get(copySecond)){
                        diff++;
                        if(diff>1){
                            found=false;
                            break;
                        }
                    }
                }
                if(!found){
                    break;
                }
                else{
                    copyFirst--;
                    copySecond++;
                }
            }
            if(found && diff==1){

                return startMirror+1;
            }
            else{
                second++;
                first++;
            }

        }
        return 0;

    }

}
