package com.systemerr.usaco;

import java.util.Scanner;

public class P2026FCB3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int N = scanner.nextInt();
        final int K = scanner.nextInt();
        final int Q = scanner.nextInt();

        int[][] field = new int[N][N];
        StringBuilder result = new StringBuilder();

        for (int q = 0; q < Q; q++) {
            int r = scanner.nextInt();
            int c = scanner.nextInt();
            int v = scanner.nextInt();

            field[r - 1][c - 1] = v;

            int max = 0;
            for (int xStart = 0; xStart <= N - K; xStart++) {
                for (int yStart = 0; yStart <= N - K; yStart++) {
                    int sum = 0;
                    for (int x = xStart; x < K + xStart; x++) {
                        for (int y = yStart; y < K + yStart; y++) {
                           sum += field[x][y];
                        }
                    }
                    max = Math.max(sum, max);
                }
            }

            result.append(max);
            if (Q - q > 1) result.append("\n");
        }

        System.out.println(result);
    }
}
