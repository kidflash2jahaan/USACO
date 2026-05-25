// 10/10

package com.systemerr.usaco;

import java.io.*;
import java.util.Scanner;

public class P2019SCB1 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileReader("shell.in"));

        int N = scanner.nextInt();
        int result = 0;
        int[][] swaps = new int[N][3];

        for (int i = 0; i < swaps.length; i++) {
            swaps[i] = new int[]{scanner.nextInt(), scanner.nextInt(), scanner.nextInt()};
        }

        for (int i = 1; i <= 3; i++) {
            int pos = i;
            int score = 0;

            for (int[] swap : swaps) {
                int a = swap[0];
                int b = swap[1];
                int g = swap[2];

                if (pos == a) pos = b;
                else if (pos == b) pos = a;
                if (pos == g) score++;
            }

            result = Math.max(result, score);
        }

        PrintWriter pw = new PrintWriter("shell.out");
        pw.print(result);
        pw.close();
    }
}
