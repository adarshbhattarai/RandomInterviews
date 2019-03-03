package com.adarsh;

/**
 * Created by adarshbhattarai on 3/3/19.
 */

public class WordSearch {

    /*
     *
     *
     * Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where
 "adjacent" cells are those horizontally or vertically neighboring.
 The same letter cell may not be used more than once.
     * board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.

     * */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        String word = "ABCCED";

        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};//new char[3][4];

        wordsearch(board,word);
        wordsearch(board,"SEE");
        wordsearch(board,"ABCB");
    }

    private static void wordsearch(char[][] board, String word) {
        // TODO Auto-generated method stub
        boolean boardHasWord=false;
        boolean[][] b = new boolean[board.length][board[0].length];

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if (search(board, word, i,j,b,0)) {
                    boardHasWord = true;
                    System.out.println("word :: "+ word + " :: is in board." );
                    break;
                }
            }
        }
        if(!boardHasWord)
            System.out.println("word :: "+ word + " :: is not in board." );

    }

    private static boolean search(char[][] board, String word, int moveX, int moveY, boolean[][] b,int i) {
        // TODO Auto-generated method stub
        if(i==word.length()) return true;
        if(moveX<0 ||  moveY<0 || moveX==board.length || moveY == board[moveX].length) return false;
        if(board[moveX][moveY] != word.charAt(i)) return false;
        if(b[moveX][moveY]) return false;
        b[moveX][moveY]= true;
        boolean exist = search(board, word, moveX-1, moveY, b, i+1) ||
                search(board, word, moveX+1, moveY, b, i+1) ||
                search(board, word, moveX, moveY+1, b, i+1) ||
                search(board, word, moveX, moveY-1, b, i+1) ;
        b[moveX][moveY]= false;
        return exist;
    }

}