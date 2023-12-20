package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Day17_2 {


    static int[][] DIRECTIONS = new int[][] { {0,1}, {1,0}, {0, -1}, {-1, 0}};
    public static final int EAST=0;
    public static final int SOUTH=1;
    public static final int WEST=2;
    public static final int NORTH=3;

    class Edge{
        int x;
        int y;
        int heatLoss;

        int direction;
        int blocks;
        int total;
        public  Edge(int x, int y){
            this.x=x;
            this.y=y;
        }

    }


    public void solveDay17_2(){
        List<List<Integer>> grid = new ArrayList<>();
        try{
            File file=new File("src/main/resources/input17.txt");
            BufferedReader in = new BufferedReader(new FileReader(file));
            String str;
            while((str=in.readLine()) !=null){
                List<Integer> insert=new ArrayList<>();
                for(char c: str.toCharArray()){
                    int val= c - '0';
                    insert.add(val);
                }
                grid.add(insert);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int m=grid.size();
        int n=grid.get(0).size();

        PriorityQueue<Edge> pq = new PriorityQueue<Edge>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                if(o1.total!=o2.total){
                    return Integer.compare(o1.total, o2.total);
                }
                else if(o1.direction==o2.direction && o1.blocks!=o2.blocks){
                    return Integer.compare(o1.blocks, o2.blocks);
                }
                else if(o1.y!=o2.y){
                    return Integer.compare(o1.y, o2.y);
                }
                else{
                    return Integer.compare(o1.x, o2.x);
                }
            }
        });

        Set<String>visited=new HashSet<>();

        //one of two possible first moves to 0,1
        Edge insert=new Edge(0, 1);
        insert.total=grid.get(0).get(1);
        insert.heatLoss=grid.get(0).get(1);
        insert.direction=EAST;
        insert.blocks=1;
        pq.offer(insert);

        //second of two possible first moves to 1,0
        insert=new Edge(1, 0);
        insert.total=grid.get(1).get(0);
        insert.heatLoss=grid.get(1).get(0);
        insert.direction=SOUTH;
        insert.blocks=1;
        pq.offer(insert);


        while(!pq.isEmpty()){
            Edge curr=pq.poll();
            int x=curr.x;
            int y=curr.y;
            int prevDirection=curr.direction;
            int blocks=curr.blocks;
            if(x==m-1 && y==n-1){
                System.out.println("Day 17 part 2 solution is " + curr.total);
                return;
            }
            String visit=curr.x + "x" + curr.y +"y" + curr.blocks + "blocks" + curr.direction + "dir";
            if(visited.contains(visit)){
                continue;
            }
            else{
                visited.add(visit);
            }

            if(blocks < 4){

                int r=x+DIRECTIONS[prevDirection][0];
                int c=y+DIRECTIONS[prevDirection][1];
                if(r<0 || r>=m || c<0 || c>=n){
                    continue;
                }
                Edge addEdge=new Edge(r, c);
                addEdge.blocks=blocks+1;
                addEdge.heatLoss=grid.get(r).get(c);
                addEdge.total=curr.total+grid.get(r).get(c);
                addEdge.direction=prevDirection;
                pq.offer(addEdge);

            }
            else{
                for(int i=0; i<DIRECTIONS.length; i++){
                    if((i==EAST && prevDirection==WEST) || (i==WEST && prevDirection==EAST) || (i==NORTH && prevDirection==SOUTH) || (i==SOUTH && prevDirection==NORTH)){
                        continue;
                    }
                    else if(blocks==10 && i==prevDirection){
                        continue;
                    }
                    else{
                        int r=x+DIRECTIONS[i][0];
                        int c=y+DIRECTIONS[i][1];
                        if(r<0 || r>=m || c<0 || c>=n){
                            continue;
                        }
                        Edge addEdge=new Edge(r, c);
                        if(i==prevDirection){
                            addEdge.blocks=blocks+1;
                        }
                        else{
                            addEdge.blocks=1;
                        }
                        addEdge.heatLoss=grid.get(r).get(c);
                        addEdge.total=curr.total+grid.get(r).get(c);
                        addEdge.direction=i;
                        pq.offer(addEdge);
                    }
                }
            }


        }





    }

}
