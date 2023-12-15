package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Day1 {
    public static void solveDay1(){
        StringBuilder contentBuilder=new StringBuilder();

        int sum=0;
        try{
            File file=new File("src/main/resources/input1.txt");
            BufferedReader in = new BufferedReader(new FileReader(file));
            String str;
            while ((str = in.readLine()) != null) {

                int firstVal=0;
                for(int i=0; i<str.length(); i++){
                    char c=str.charAt(i);
                    if(Character.isAlphabetic(c)){
                        if(c=='o'){
                            if(i+2 <str.length() && str.substring(i, i+3).equals("one")){
                                firstVal+=1 * 10;
                                break;
                            }
                        }
                        else if(c=='t' ){
                            if(i+2 <str.length() && str.substring(i, i+3).equals("two")) {
                                firstVal+=2 * 10;
                                break;
                            }
                            if(i+4 < str.length() && str.substring(i, i+5).equals("three")){
                                firstVal+=3 * 10;
                                break;
                            }


                        }
                        else if(c=='f'){
                            if(i+3 <str.length() && str.substring(i, i+4).equals("five")) {
                                firstVal+=5 * 10;
                                break;
                            }
                            if(i+3 < str.length() && str.substring(i, i+4).equals("four")){
                                firstVal+=4 * 10;
                                break;
                            }
                        }
                        else if(c=='s'){
                            if(i+2 <str.length() && str.substring(i, i+3).equals("six")) {
                                firstVal+=6 * 10;
                                break;
                            }
                            if(i+4 < str.length() && str.substring(i, i+5).equals("seven")){
                                firstVal+=7 * 10;
                                break;
                            }
                        }
                        else if(c=='e'){
                            if(i+4 < str.length() && str.substring(i, i+5).equals("eight")){
                                firstVal+=8 * 10;
                                break;
                            }
                        }
                        else if(c=='n'){
                            if(i+3 < str.length() && str.substring(i, i+4).equals("nine")){
                                firstVal+=9 * 10;
                                break;
                            }
                        }
                        else{
                            continue;
                        }
                    }
                    else{
                        firstVal+= Character.getNumericValue(c) * 10;
                        break;
                    }
                }
                for(int i=str.length()-1; i>=0; i--){
                    char c=str.charAt(i);
                    if(Character.isAlphabetic(c)){
                        if(c=='o'){
                            if(i+2 <str.length() && str.substring(i, i+3).equals("one")){
                                firstVal+=1;
                                break;
                            }
                        }
                        else if(c=='t' ){
                            if(i+2 <str.length() && str.substring(i, i+3).equals("two")) {
                                firstVal+=2 ;
                                break;
                            }
                            if(i+4 < str.length() && str.substring(i, i+5).equals("three")){
                                firstVal+=3 ;
                                break;
                            }


                        }
                        else if(c=='f'){
                            if(i+3 <str.length() && str.substring(i, i+4).equals("five")) {
                                firstVal+=5 ;
                                break;
                            }
                            if(i+3 < str.length() && str.substring(i, i+4).equals("four")){
                                firstVal+=4 ;
                                break;
                            }
                        }
                        else if(c=='s'){
                            if(i+2 <str.length() && str.substring(i, i+3).equals("six")) {
                                firstVal+=6 ;
                                break;
                            }
                            if(i+4 < str.length() && str.substring(i, i+5).equals("seven")){
                                firstVal+=7 ;
                                break;
                            }
                        }
                        else if(c=='e'){
                            if(i+4 < str.length() && str.substring(i, i+5).equals("eight")){
                                firstVal+=8 ;
                                break;
                            }
                        }
                        else if(c=='n'){
                            if(i+3 < str.length() && str.substring(i, i+4).equals("nine")){
                                firstVal+=9 ;
                                break;
                            }
                        }
                        else{
                            continue;
                        }
                    }
                    else{
                        firstVal+= Character.getNumericValue(c) ;
                        break;
                    }
                }

                sum+=firstVal;
            }

            in.close();
        } catch (IOException e) {
            System.err.println("HTML File Read Error: " + e.getMessage());
        }
        System.out.println("Day 1 solution is " + sum);

    }




}
