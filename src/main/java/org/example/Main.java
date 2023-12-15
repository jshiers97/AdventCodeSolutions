package org.example;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static org.example.Day1.solveDay1;
import static org.example.Day2.solveDay2;
import static org.example.Day2_2.solveDay2_2;
import static org.example.Day3.solveDay3;
import static org.example.Day3_2.solveDay3_2;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws Exception {
        solveDay1();
        solveDay2();
        solveDay2_2();
        solveDay3();
        solveDay3_2();
    }
}
