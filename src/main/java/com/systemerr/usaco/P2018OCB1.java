// 7/10

package com.systemerr.usaco;

import java.io.*;
import java.util.*;

public class P2018OCB1 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileReader("tttt.in"));
        final char[][] board = new char[3][3];
        for (int x = 0; x < 3; x++) {
            board[x] = scanner.next().toCharArray();
        }

        PrintWriter pw = new PrintWriter("tttt.out");
        pw.println(individualVictories(board));
        pw.print(teamVictories(board));
        pw.close();
    }

    public static int individualVictories(char[][] board) {
        int individualVictories = 0;

        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) individualVictories++;
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) individualVictories++;
        }
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) individualVictories++;
        if (board[2][0] == board[1][1] && board[1][1] == board[0][2]) individualVictories++;

        return individualVictories;
    }

    public static int teamVictories(char[][] board) {
        int teamVictories = 0;
        ArrayList<Character> players = new ArrayList<>();

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (!players.contains(board[x][y])) players.add(board[x][y]);
            }
        }

        List<List<Character>> teams = new ArrayList<>();
        for (int playerN1 = 0; playerN1 < players.size(); playerN1++) {
            char player1 = players.get(playerN1);
            for (char player2 : players) {
                if (player1 != player2 && !teams.contains(List.of(player1, player2)) && !teams.contains(List.of(player2, player1)))
                    teams.add(List.of(player1, player2));
            }
        }

        for (List<Character> team : teams) {
            char[][] newBoard = new char[3][3];

            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    newBoard[x][y] = board[x][y];
                    if (newBoard[x][y] == team.get(1)) newBoard[x][y] = team.get(0);
                }
            }

            boolean teamWon = false;
            for (int i = 0; i < 3; i++) {
                if (!teamWon && newBoard[i][0] == newBoard[i][1] && newBoard[i][1] == newBoard[i][2] && (board[i][0] != board[i][1] || board[i][1] != board[i][2])) teamWon = true;
                if (!teamWon && newBoard[0][i] == newBoard[1][i] && newBoard[1][i] == newBoard[2][i] && (board[0][i] != board[1][i] || board[1][i] != board[2][i])) teamWon = true;
            }
            if (!teamWon && newBoard[0][0] == newBoard[1][1] && newBoard[1][1] == newBoard[2][2] && (board[0][0] != board[1][1] || board[1][1] != board[2][2])) teamWon = true;;
            if (!teamWon && newBoard[2][0] == newBoard[1][1] && newBoard[1][1] == newBoard[0][2] && (board[2][0] != board[1][1] || board[1][1] != board[0][2])) teamWon = true;;

            if (teamWon) teamVictories++;
        }

        return teamVictories;
    }
}
