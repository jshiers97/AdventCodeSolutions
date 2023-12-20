package org.example;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Day16 {
    static List<List<Character>> grid=new ArrayList<>();
    static int[][] DIRECTIONS=new int[][]{ {0,1}, {1,0}, {0, -1}, {-1, 0} };
    public static void solveDay16(){
        try{
            File file=new File("src/main/resources/input16.txt");
            BufferedReader in = new BufferedReader(new FileReader(file));
            String str;
            while((str=in.readLine()) !=null){
                List<Character> insert=new ArrayList<>();
                for(char c: str.toCharArray()){
                    insert.add(c);
                }
                grid.add(insert);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int m=grid.size();
        int n=grid.get(0).size();

        int energized=0;
        boolean[][][] seen=new boolean[m][n][4];
        boolean[][] uniques=new boolean[m][n];
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{0,0,0});
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int r=curr[0];
            int c=curr[1];
            if(r>=m || r < 0 || c>=n || c< 0){
                continue;
            }
            int dir=curr[2];
            char ch=grid.get(r).get(c);
            if(!uniques[r][c]){
                energized++;
                uniques[r][c]=true;
            }
            if(!seen[r][c][dir]){

                seen[r][c][dir]=true;
            }
            else{
                continue;
            }
            if(ch=='.'){
                int x=r+DIRECTIONS[dir][0];
                int y = c+DIRECTIONS[dir][1];
                if(x>= m || y>=n || y<0 || x<0){
                    continue;
                }
                else{
                    q.offer(new int[]{x,y, dir});
                }

            }
            else if(ch=='/'){
                if(dir==0){
                    int x=r+DIRECTIONS[3][0];
                    int y = c+DIRECTIONS[3][1];
                    if(x>= m || y>=n || y<0 || x<0){
                        continue;
                    }
                    else{
                        q.offer(new int[]{x,y, 3});
                    }

                }
                else if(dir==1){
                    int x=r+DIRECTIONS[2][0];
                    int y = c+DIRECTIONS[2][1];
                    if(x>= m || y>=n || y<0 || x<0){
                        continue;
                    }
                    else{
                        q.offer(new int[]{x,y, 2});
                    }

                }
                else if(dir==2){
                    int x=r+DIRECTIONS[1][0];
                    int y = c+DIRECTIONS[1][1];
                    if(x>= m || y>=n || y<0 || x<0){
                        continue;
                    }
                    q.offer(new int[]{x,y, 1});
                }
                else if(dir==3){
                    int x=r+DIRECTIONS[0][0];
                    int y = c+DIRECTIONS[0][1];
                    if(x>= m || y>=n || y<0 || x<0){
                        continue;
                    }
                    q.offer(new int[]{x,y, 0});
                }
            }
            else if(ch=='\\'){
                if(dir==0){
                    int x=r+DIRECTIONS[1][0];
                    int y = c+DIRECTIONS[1][1];
                    if(x>= m || y>=n || y<0 || x<0){
                        continue;
                    }
                    q.offer(new int[]{x,y, 1});
                }
                else if(dir==1){
                    int x=r+DIRECTIONS[0][0];
                    int y = c+DIRECTIONS[0][1];
                    if(x>= m || y>=n || y<0 || x<0){
                        continue;
                    }
                    q.offer(new int[]{x,y, 0});
                }
                else if(dir==2){
                    int x=r+DIRECTIONS[3][0];
                    int y = c+DIRECTIONS[3][1];
                    if(x>= m || y>=n || y<0 || x<0){
                        continue;
                    }
                    q.offer(new int[]{x,y, 3});
                }
                else if(dir==3){
                    int x=r+DIRECTIONS[2][0];
                    int y = c+DIRECTIONS[2][1];
                    if(x>= m || y>=n || y<0 || x<0){
                        continue;
                    }
                    q.offer(new int[]{x,y, 2});
                }
            }
            else if(ch=='-'){
                if(dir==1 || dir == 3){
                    int x=r+DIRECTIONS[0][0];
                    int y = c+DIRECTIONS[0][1];
                    if(x>= m || y>=n || y<0 || x<0){

                    }
                    else{
                        q.offer(new int[]{x,y, 0});
                    }

                    x=r+DIRECTIONS[2][0];
                    y=c+DIRECTIONS[2][1];
                    if(x>= m || y>=n || y<0 || x<0){

                    }
                    else{
                        q.offer(new int[]{x,y, 2});
                    }

                }
                else{
                    int x=r+DIRECTIONS[dir][0];
                    int y = c+DIRECTIONS[dir][1];
                    if(x>= m || y>=n || y<0 || x<0){
                        continue;
                    }
                    q.offer(new int[]{x,y, dir});
                }
            }
            else if(ch=='|'){
                if(dir==0 || dir == 2){
                    int x=r+DIRECTIONS[1][0];
                    int y = c+DIRECTIONS[1][1];
                    if(x>= m || y>=n || y<0 || x<0){

                    }
                    else{
                        q.offer(new int[]{x,y, 1});
                    }

                    x=r+DIRECTIONS[3][0];
                    y=c+DIRECTIONS[3][1];
                    if(x>= m || y>=n || y<0 || x<0){

                    }
                    else{
                        q.offer(new int[]{x,y, 3});
                    }
                }
                else{
                    int x=r+DIRECTIONS[dir][0];
                    int y = c+DIRECTIONS[dir][1];
                    if(x>= m || y>=n || y<0 || x<0){
                        continue;
                    }
                    q.offer(new int[]{x,y, dir});
                }
            }

        }
        System.out.println("Day 16 solution is " + energized);

    }

}
