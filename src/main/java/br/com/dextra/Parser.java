package br.com.dextra;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Parser {

    private String content;

    public void loadFile(String fileName) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                if (!sb.toString().isEmpty()) {
                    sb.append(System.lineSeparator());
                }
                sb.append(line);
                line = br.readLine();
            }
            content = sb.toString();
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                        System.out.println(e);
                }
            }
        }
    }

    public void parse() {
        content = new StringBuilder(content).reverse().toString();
    }

    public void writeFile(String fileName) {
        try {
            PrintWriter writer = new PrintWriter(fileName, "UTF-8");
            writer.println(content);
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public String getContent() {
        return this.content;
    }

}
