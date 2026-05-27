// 10/10

package com.systemerr.usaco;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class P2017OCB1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("lostcow.in"));

        int x = scanner.nextInt();
        int y = scanner.nextInt();

        int i = 0;
        int pos = x;
        int posPrev;
        int distance = 0;
        int delta;
        while (true) {
            delta = (int) Math.pow(-2, i);
            posPrev = pos;
            pos = x + delta;
            if (delta >= 0 && y >= posPrev && y <= pos || delta <= 0 && y <= posPrev && y >= pos) {
                distance += Math.abs(y - posPrev);
                break;
            }
            distance += Math.abs(pos - posPrev);
            i++;
        }
        PrintWriter pw = new PrintWriter("lostcow.out");
        pw.print(distance);
        pw.close();
    }
}
