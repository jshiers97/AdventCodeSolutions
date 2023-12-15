package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Day3_2 {

    //NOTE: this solution assumes there are at most 2 part numbers adjacent to each gear. If there are more than 2,
    //then by definition we shouldn't be adding the gear ratio of those gear parts to the total sum. Apparently
    //this is not a possibility because I didn't consider gears with more than 2 part numbers and my solution still passed

    static int[][] DIRECTIONS=new int[][]{ {0,1}, {1,0}, {0,-1}, {-1, 0}, {1,1}, {-1,-1}, {-1, 1}, {1, -1}};
    public static long solveDay3_2() throws Exception {

        //grid of input file
        List<List<Character>> grid=new ArrayList<>();

        //total sum value we will add to and return in the end
        long sum=0;

        //use this try catch to construct grid
        try{
            File file=new File("src/main/resources/input3.txt");
            BufferedReader in = new BufferedReader(new FileReader(file));
            String str;
            List<Character> insert=new ArrayList<>();
            while ((str = in.readLine()) != null) {
                for(char c: str.toCharArray()){
                    insert.add(c);
                }
                grid.add(insert);
                insert=new ArrayList<>();
            }
        } catch (Exception e) {
            throw new Exception(e);
        }

        int m=grid.size();
        int n=grid.get(0).size();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                char c=grid.get(i).get(j);
                Integer first=null;
                Integer second=null;
                if(!Character.isDigit(c) && c!='.'){

                    for(int[] dir: DIRECTIONS){
                        int x=i+dir[0];
                        int y=j+dir[1];
                        if(x < 0 || x>=m || y < 0 || y>=n || !Character.isDigit(grid.get(x).get(y))){
                            continue;
                        }
                        else{

                            int temp=findVal(grid, x, y, m, n);
                            if(first==null){
                                first=temp;
                            }
                            else if(second==null){
                                second=temp;
                            }
                            else{
                                break;
                            }

                        }
                    }
                    if(first!=null && second!=null){
                        sum+= (first * second);
                    }

                }
            }
        }
        System.out.println("Day 3 solution is " + sum);
        return sum;
    }

    // might try to write a recursive version of this method at some point
    public static int findVal(List<List<Character>> grid, int r, int c, int m, int n){
        int curr=0;
        while(c>0 && Character.isDigit(grid.get(r).get(c-1))){
            c--;
        }
        while(c<n && Character.isDigit(grid.get(r).get(c))){
            char ch=grid.get(r).get(c);

            curr+= (ch-'0');
            curr*=10;
            grid.get(r).set(c, '.');
            c++;

        }
        return curr/10;

    }

}

