package BACKTRACKING.WEEK6_CKW.BOJ_9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] board;
    static int count=0;

    public static boolean check(int row) {
        for (int i = 0; i < row; i++) {
            if (board[i] == board[row]) {
                return false;
            }

            else if(Math.abs(row-i) == Math.abs(board[row]-board[i])) {
                return false;
            }

        }
        return true;
    }

    public static void nQueen(int row) {
        if(row==N){
            count++;
            return;
        }

        for(int i=0; i<N; i++){
            board[row]=i;
            if(check(row))
                nQueen(row+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N];

        nQueen(0);

        System.out.println(count);

    }

}
