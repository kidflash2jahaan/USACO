// 5/12

package com.systemerr.usaco;

import java.util.Scanner;

public class P2026FCB1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final long T = Integer.parseInt(scanner.nextLine());
        StringBuilder result = new StringBuilder();

        for (long test = 0; test < T; test++) {
            String[] line = scanner.nextLine().split(" ");

            long A = Long.parseLong(line[0]);
            long B = Long.parseLong(line[1]);
            final long cA = Long.parseLong(line[2]);
            final long cB = Long.parseLong(line[3]);
            final long fA = Long.parseLong(line[4]);

            long swaps = B / cB;

            B -= cB * swaps;
            A += cA * swaps;

            long neededA = fA - A;
            long neededB = (long) Math.ceil(neededA * ((double) cB / cA)) - B;

            long x = 0;
            if (neededA > 0) {
                if (cA >= cB) {
                    A += neededA;
                    x = neededA;
                } else {
                    x = neededB;
                    for (int i = 0; i < 2; i++) {
                        x = neededB + i;
                        boolean worstCaseSuccess = true;
                        for (long addedA = 0; addedA <= 2; addedA++) {
                            long addedB = x - addedA;
                            long newA = A + addedA;
                            long newB = B + addedB;

                            swaps = newB / cB;

                            newB -= cB * swaps;
                            newA += cA * swaps;

                            if (newA < fA) {
                                worstCaseSuccess = false;
                                break;
                            }
                        }
                        if (worstCaseSuccess) {
                            break;
                        }
                    }
                }
            }
            result.append(x);

            if (T - test > 1) {
                result.append("\n");
            }
        }

        System.out.println(result);
    }
}