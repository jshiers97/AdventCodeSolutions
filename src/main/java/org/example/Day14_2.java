package org.example;

import java.io.*;
import java.util.*;

class Day14_2 {
    static List<List<Character>> grid=new ArrayList<>();
    static Map<Integer, String> map=new HashMap<>();
    static Set<String> seen=new HashSet<>();
    public static int solveDay14_2() {

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
        long count=1;
        long iterations=1000000000;

        // Most complicated logic of the solution. After each 4 direction shift, we will create a string of the entire grid
        // If we have seen a string before, that means we have seen the current configuration of this grid. That means we
        // can skip a bunch of the iterations by simply getting the mod of iterations and our current iteration (iterations % count).
        // otherwise, we would be doing a lot of recalculation of a given grid state which would make our program take a long time
        // finish.
        while(count <= iterations){
            shiftNorth();
            shiftWest();
            shiftSouth();
            shiftEast();
            String temp=convert();
            if(seen.contains(temp)){
                iterations= (iterations % count);
                count=0;
                break;

            }
            else{
                seen.add(temp);
                count++;
            }

        }

        //if we broke out of the previous while loop, that means we ran into a grid state we have seen before. This loop
        //will continue the shifting the appropriate number of times (1000000000 % count, where count was the iteration
        // we were on when we saw a repeated grid state)
        while(count < iterations){
            shiftNorth();
            shiftWest();
            shiftSouth();
            shiftEast();
            count++;
        }

        //this loop just sums
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

        System.out.println("Day 14 part 2 solution is " + total);
        return total;
    }
    public static void shiftNorth(){
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
    public static void shiftSouth(){
        int m=grid.size();
        int n=grid.get(0).size();
        for(int col=0; col<n; col++){
            //int top=0;
            int bottom=m-2;
            while(bottom >=0 ){
                if(grid.get(bottom).get(col)=='O' && grid.get(bottom+1).get(col)=='.'){
                    int top=bottom+1;
                    while(top < m-1 && grid.get(top+1).get(col)=='.'){
                        top++;
                    }
                    grid.get(bottom).set(col,'.');
                    grid.get(top).set(col, 'O');
                }
                bottom--;
            }
        }
    }

    public static void shiftWest(){
        int m=grid.size();
        int n=grid.get(0).size();
        for(int row=0; row<m; row++){
            int left=1;
            while(left<n){
                if(grid.get(row).get(left)=='O' && grid.get(row).get(left-1)=='.'){
                    int temp=left-1;
                    while(temp > 0 && grid.get(row).get(temp-1)=='.'){
                        temp--;
                    }
                    grid.get(row).set(left,'.');
                    grid.get(row).set(temp, 'O');
                }
                left++;
            }
        }
    }

    public static void shiftEast(){
        int m=grid.size();
        int n=grid.get(0).size();
        for(int row=0; row<m; row++){
            int left=n-2;
            while(left>=0){
                if(grid.get(row).get(left)=='O' && grid.get(row).get(left+1)=='.'){
                    int temp=left+1;
                    while(temp < n-1 && grid.get(row).get(temp+1)=='.'){
                        temp++;
                    }
                    grid.get(row).set(left,'.');
                    grid.get(row).set(temp, 'O');
                }
                left--;
            }
        }
    }

    public static String convert(){
        StringBuilder res=new StringBuilder();
        for(int i=0; i<grid.size(); i++){
            for(int j=0; j<grid.get(0).size(); j++){
                res.append(grid.get(i).get(j));
            }
        }
        return res.toString();
    }


}
