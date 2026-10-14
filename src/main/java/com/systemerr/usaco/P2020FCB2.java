// 10/10

package com.systemerr.usaco;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P2020FCB2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        List<Integer> flowers = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            flowers.add(scanner.nextInt());
        }
        int total = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                List<Integer> picture = flowers.subList(i, j + 1);
                float average = 0;
                for (Integer k : picture) {
                    average += k;
                }
                average /= (float) picture.size();
                if (average == Math.round(average) && picture.contains(Math.round(average))) {
                    total++;
                }
            }
        }
        System.out.println(total);
    }
}
