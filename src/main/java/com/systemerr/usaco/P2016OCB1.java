// 10/10

package com.systemerr.usaco;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class P2016OCB1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("diamond.in"));
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[] diamonds = new int[N];
        for (int i = 0; i < N; i++) {
            diamonds[i] = scanner.nextInt();
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            int total = 0;
            System.out.println("Diamond " + i + " with size " + diamonds[i]);
            for (int j = 0; j < N; j++) {
                if (diamonds[j] <= diamonds[i] + K && diamonds[j] >= diamonds[i]) {
                    total++;
                    System.out.println(" - Added diamond " + j + " with size " + diamonds[j]);
                }
            }
            max = Math.max(max, total);
            total = 0;
            System.out.println("Diamond " + i + " with size " + diamonds[i]);
            for (int j = 0; j < N; j++) {
                if (diamonds[j] >= diamonds[i] - K && diamonds[j] <= diamonds[i]) {
                    total++;
                    System.out.println(" - Added diamond " + j + " with size " + diamonds[j]);
                }
            }
            max = Math.max(max, total);
        }
        PrintWriter pw = new PrintWriter("diamond.out");
        pw.print(max);
        pw.close();
    }
}
