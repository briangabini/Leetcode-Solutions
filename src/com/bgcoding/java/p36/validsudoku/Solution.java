package com.bgcoding.java.p36.validsudoku;

import java.util.HashSet;
import java.util.Set;

// Brute force
// Time Complexity: O(n^2)
// Space Complexity: O(n^2)
class Solution {
    private static int BOARD_SIZE = 9;
    private static int SQUARE_SIZE = 3;

    public boolean isValidSudoku(char[][] board) {

        // check rows for duplicates
        for (int row = 0; row < BOARD_SIZE; row++) {
            Set<Character> seen = new HashSet<>();
            for (int i = 0; i < BOARD_SIZE; i++) {
                if (board[row][i] == '.') continue;
                if (seen.contains(board[row][i])) return false;
                seen.add(board[row][i]);
            }
        }

        // check columns for duplicates
        for (int col = 0; col < BOARD_SIZE; col++) {
            Set<Character> seen = new HashSet<>();
            for (int i = 0; i < BOARD_SIZE; i++) {
                if (board[i][col] == '.') continue;
                if (seen.contains(board[i][col])) return false;
                seen.add(board[i][col]);
            }
        }

        // check squares for duplicates
        // use division for rows
        // use modulo for columns
        for (int square = 0; square < BOARD_SIZE; square++) {
            Set<Character> seen = new HashSet<>();
            // loop below checks the content of a square
            for (int i = 0; i < SQUARE_SIZE; i++) {
                for (int j = 0; j < SQUARE_SIZE; j++) {
                    int row = (square / SQUARE_SIZE) * SQUARE_SIZE + i;
                    int col = (square % SQUARE_SIZE) * SQUARE_SIZE + j;
                    if (board[row][col] == '.') continue;
                    if (seen.contains(board[row][col])) return false;
                    seen.add(board[row][col]);
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board1 = {
                {'1', '2', '.', '.', '3', '.', '.', '.', '.'},
                {'4', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '.', '3'},
                {'5', '.', '.', '.', '6', '.', '.', '.', '4'},
                {'.', '.', '.', '8', '.', '3', '.', '.', '5'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '.', '.', '.', '.', '.', '2', '.', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '8'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        boolean output1 = solution.isValidSudoku(board1);
        System.out.println(output1);
    }
}

