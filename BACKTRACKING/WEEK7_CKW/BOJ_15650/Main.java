package BACKTRACKING.WEEK7_CKW.BOJ_15650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N,M;
    static int[] ans;

    public static void backtracking(int depth){

        if(depth==M){
            for(int i=0;i<M;i++){
                System.out.print(ans[i]+" ");
            }
            System.out.println();
            return;
        }

        for(int i=1; i<=N; i++){
            boolean check=true;
            for(int j=0; j<depth; j++){
                if(ans[j]>=i)
                    check=false;
            }
            if(check) {
                ans[depth] = i;
                backtracking(depth+1);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ans = new int[M];

        backtracking(0);

    }

}
