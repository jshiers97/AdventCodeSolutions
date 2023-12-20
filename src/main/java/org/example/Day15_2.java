package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day15_2 {
    public static void solveDay15_2() {
        Map<Integer, List<String>> boxToLabels = new HashMap<>();
        Map<String, Integer> values = new HashMap<>();
        try {
            File file = new File("src/main/resources/input15.txt");
            BufferedReader in = new BufferedReader(new FileReader(file));
            String str;
            while ((str = in.readLine()) != null) {
                str.trim();
                String[] arr = str.split(",");

                for (String s : arr) {
                    int curr = 0;
                    for (int i = 0; i < s.length(); i++) {
                        char c = s.charAt(i);
                        if (c == '-') {
                            String check = s.substring(0, i);
                            if (boxToLabels.containsKey(curr)) {
                                if (boxToLabels.get(curr).contains(check)) {
                                    boxToLabels.get(curr).remove(check);
                                }
                            }
                        } else if (c == '=') {
                            if (!boxToLabels.containsKey(curr)) {
                                boxToLabels.put(curr, new ArrayList<>());
                            }
                            String check = s.substring(0, i);
                            //check if it has check in this array
                            boolean replaced = false;
                            for (int j = 0; j < boxToLabels.get(curr).size(); j++) {
                                if (boxToLabels.get(curr).get(j).equals(check)) {
                                    boxToLabels.get(curr).set(j, check);
                                    int valOfLabel = Integer.parseInt(s.substring(i + 1));
                                    System.out.println(valOfLabel);
                                    values.put(check, valOfLabel);
                                    replaced = true;
                                    break;
                                }
                            }
                            if (!replaced) {
                                boxToLabels.get(curr).add(check);
                                int valOfLabel = Integer.parseInt(s.substring(i + 1));
                                values.put(check, valOfLabel);
                            }

                        } else {
                            int val = ((int) c);
                            curr += val;
                            curr *= 17;
                            curr %= 256;
                        }
                    }
                }


            }
            int res = 0;
            for (Integer key : boxToLabels.keySet()) {
                List<String> list = boxToLabels.get(key);
                if(list.size()==0){
                    continue;
                }
                for (int i = 0; i < list.size(); i++) {
                    int val = (key + 1) * (i + 1) * values.get(list.get(i));
                    System.out.println(val);
                    res += val;
                }
            }
            System.out.println(res);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}

