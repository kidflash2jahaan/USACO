// 6/10

package com.systemerr.usaco;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class P2016TCB1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("pails.in"));
        int X = scanner.nextInt();
        int Y = scanner.nextInt();
        int M = scanner.nextInt();
        int biggerBucket = Math.max(X, Y);
        int smallerBucket = Math.min(X, Y);
        int biggerBuckets = 0;
        int smallerBuckets = (M / smallerBucket);
        int max = 0;
        for (int i = 0; i < smallerBuckets; i++) {
            int result = biggerBuckets * biggerBucket + smallerBuckets * smallerBucket;
            if (result > M) {
                biggerBuckets--;
                i -= 1;
            } else {
                max = Math.max(max, result);

                biggerBuckets++;
                smallerBuckets--;
            }
        }
        PrintWriter pw = new PrintWriter("pails.out");
        pw.print(max);
        pw.close();
    }
}
