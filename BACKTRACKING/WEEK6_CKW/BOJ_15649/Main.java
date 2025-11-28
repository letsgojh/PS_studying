package BACKTRACKING.WEEK6_CKW.BOJ_15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;

    public static void backtracking(int[] ans, int depth){
        if(depth == M){
            for(int i=0; i<M; i++){
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i=1; i<=N; i++){
            boolean exist = false;
            for(int j=0; j<depth; j++){
                if(ans[j]==i) {
                    exist = true;
                    break;
                };
            }
            if(!exist){
                ans[depth]=i;
                backtracking(ans, depth+1);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] ans = new int[M+1];

        for(int i=1; i<=N; i++){
            ans[0]=i;
            backtracking(ans, 1);
        }

    }



}
