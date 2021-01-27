package com.duguyuan;

import java.io.*;
import java.util.Scanner;

public class WordsNumber {

    public static int count(String longStr, String shortStr) {
        int count = 0;
        int start = 0;
        int length = shortStr.length();
        while((start = longStr.indexOf(shortStr, start)) != -1) {
            count++;
            start += length;
        }
        return count;
    }

    public static int countWord(String word) {
        File file = null;
        FileReader fis = null;
        BufferedReader br = null;
        int count = 0;
        try {
            file = new File("src/demo.txt");
            fis = new FileReader(file);
            br = new BufferedReader(fis);
            String line = null;
            while((line = br.readLine()) != null) {
                count += count(line, word);
            }
            return count;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String word = in.nextLine(); // 可输入 johnny 进行测试
        System.out.println(word + "在文件中出现了" + countWord(word) + "次");
    }

}
