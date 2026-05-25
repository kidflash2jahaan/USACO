// 10/10

package com.systemerr.usaco;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class P2017FCB3 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("cowsignal.in"));
        
        int M = scanner.nextInt();
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        
        String original = "";
        for (int m = 0; m <= M; m++) {
            original += scanner.nextLine() + "\n";
        }
        original = original.strip();

        String result = "";

        for (int m = 0; m < M; m++) {
            String originalLine = original.split("\n")[m];
            String scaledLine = "";
            for (int n = 0; n < N; n++) {
                scaledLine += String.valueOf(originalLine.charAt(n)).repeat(K);
            }
            scaledLine += "\n";
            result += scaledLine.repeat(K);
        }

        PrintWriter pw = new PrintWriter("cowsignal.out");
        pw.print(result.stripTrailing());
        pw.close();
    }
}
