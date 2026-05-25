// 10/10

package com.systemerr.usaco;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class P2019FCB1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("mixmilk.in"));
        int c1 = scanner.nextInt();
        int m1 = scanner.nextInt();
        int c2 = scanner.nextInt();
        int m2 = scanner.nextInt();
        int c3 = scanner.nextInt();
        int m3 = scanner.nextInt();

        final int[] c = {c1, c2, c3};
        int[] m = {m1, m2, m3};

        for (int i = 0; i < 100; i++) {
            int a = i % 3;
            int b = a != 2 ? a + 1 : 0;

            int delta = c[b] - m[b];
            if (m[a] <= delta) {
                m[b] += m[a];
                m[a] = 0;
            } else {
                m[b] = c[b];
                m[a] -= delta;
            }
        }

        PrintWriter pw = new PrintWriter("mixmilk.out");
        pw.println(m[0]);
        pw.println(m[1]);
        pw.print(m[2]);
        pw.close();
    }
}
