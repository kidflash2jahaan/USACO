// 10/10

package com.systemerr.usaco;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class P2016FCB2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("speeding.in"));
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[][] roadSegments = new int[N][2];
        int[][] journeySegments = new int[M][2];

        for (int n = 0; n < N; n++) roadSegments[n] = new int[]{scanner.nextInt(), scanner.nextInt()};
        for (int m = 0; m < M; m++) journeySegments[m] = new int[]{scanner.nextInt(), scanner.nextInt()};

        int[] road = new int[100];
        int[] journey = new int[100];

        int progress = 0;
        for (int[] roadSegment : roadSegments) {
            for (int i = progress; i < progress + roadSegment[0]; i++) {
                road[i] = roadSegment[1];
            }
            progress += roadSegment[0];
        }
        progress = 0;
        for (int[] journeySegment : journeySegments) {
            for (int i = progress; i < progress + journeySegment[0]; i++) {
                journey[i] = journeySegment[1];
            }
            progress += journeySegment[0];
        }
        int max = 0;
        for (int i = 0; i < road.length; i++) {
            max = Math.max(max, journey[i] - road[i]);
        }
        PrintWriter pw = new PrintWriter("speeding.out");
        pw.print(max);
        pw.close();
    }
}
