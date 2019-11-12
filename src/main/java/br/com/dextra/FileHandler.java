package br.com.dextra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileHandler {

    private String content;

    public void load(String fileName) {
        try {
            content = new Scanner(new File(fileName)).useDelimiter("\\Z").next();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void revert() {
        char[] in = content.toCharArray();
        int begin=0;
        int end=in.length-1;
        char temp;
        while(end>begin){
            temp = in[begin];
            in[begin]=in[end];
            in[end] = temp;
            end--;
            begin++;
        }
        content = new String(in);
    }

    public void save(String fileName) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(content);

            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public String getContent() {
        return this.content;
    }

}
