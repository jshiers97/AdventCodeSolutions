package org.example;

import java.io.*;
import java.util.*;

public class Day4_2 {
    //You process the original and all copies of Card X before you move on to X+1.
    //I might rethink how I do the final block of code at the bottom (beneath the catch)
    //there might be a way to optimize it
    public static void solveDay4_2(){


        // this map will keep track of the number of each card we have as we go along from
        //card 1 to card N.
        Map<Integer, Integer> mapOurCardToCount=new HashMap<>();

        //this map will keep track of how many matches card x has (lets call it N). Depending on
        // how many copies of card x we have, we will have to add 1 copy of the next N cards for
        // every copy of card x we have.
        Map<Integer, Integer> mapCardToMatches=new HashMap<>();

        int cardNum=1;
        try {

            File file = new File("src/main/resources/input4.txt");
            BufferedReader in = new BufferedReader(new FileReader(file));
            String str;

            while ((str = in.readLine()) != null) {

                //just some basic parsing here. Splitting lines by colon, then | to separate
                //winning numbers from our drawn numbers.
                String[] arr=str.split(":");
                String[] allNums=arr[1].split("\\|");
                String[] winNums=allNums[0].trim().split("\\s+");
                String[] drawnNums=allNums[1].trim().split("\\s+");


                //easy to check for matches if winning numbers are in a HashSet
                Set<Integer> winners=new HashSet<>();
                for(String num: winNums){
                    int val=Integer.parseInt(num);
                    winners.add(val);
                }

                //keep track of how many matches this card has
                int matches=0;
                for(String num: drawnNums){
                    int val=Integer.parseInt(num);
                    if(winners.contains(val)){
                        matches++;
                    }

                }

                //we start with 1 original for each card, so put that in our map here
                mapOurCardToCount.put(cardNum, 1);

                //this will keep track of how many matches each card has
                mapCardToMatches.put(cardNum, matches);
                cardNum++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int totalCards=0;
        //we start with card 1. Get the number of copies we have at each card value i.
        //increment totalCards by this value at each iteration.
        for(int i=1; i<cardNum; i++){
            int currMatches=mapCardToMatches.get(i);
            int totalOfCurrCard=mapOurCardToCount.get(i);
            totalCards+=totalOfCurrCard;

            //Lets call the number of matches our current card has X. For all copies we have
            // of this current card, add 1 to the number of copies we have of the next X cards.
            for(int x=1; x<=totalOfCurrCard; x++){
                for(int j=1; j<=currMatches; j++){
                    mapOurCardToCount.put(i+j, mapOurCardToCount.get(i+j)+1);
                }
            }



        }
        System.out.println("Day 4 part 2 solution is " + totalCards);

    }

}
