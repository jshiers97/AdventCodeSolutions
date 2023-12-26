package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Day14 {
    static List<List<Character>> grid=new ArrayList<>();
    public static int solveDay14() {

        try {
            File file = new File("src/main/resources/input14.txt");
            BufferedReader in = new BufferedReader(new FileReader(file));
            String str;

            while ((str = in.readLine()) != null) {
                List<Character> insert = new ArrayList<>();
                for(char c: str.toCharArray()){
                    insert.add(c);
                }
                grid.add(insert);


            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        shift();
        int m=grid.size();
        int n=grid.get(0).size();
        int mult=m;
        int total=0;
        for(int i=0; i<m; i++){
            int stones=0;
            for(int j=0; j<n; j++){
                if(grid.get(i).get(j)=='O'){
                    stones++;
                }
            }
            total+= (stones * mult);
            mult--;

        }

        System.out.println("Day 14 solution is " + total);
        return total;
    }
    public static void shift(){
        int m=grid.size();
        int n=grid.get(0).size();
        for(int col=0; col<n; col++){
            //int top=0;
            int bottom=1;
            while(bottom < m){
                if(grid.get(bottom).get(col)=='O' && grid.get(bottom-1).get(col)=='.'){
                    int top=bottom-1;
                    while(top>0 && grid.get(top-1).get(col)=='.'){
                        top--;
                    }
                    grid.get(bottom).set(col,'.');
                    grid.get(top).set(col, 'O');
                }
                bottom++;
            }
        }

    }


}
