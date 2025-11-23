package BACKTRACKING.WEEK6_CKW.BOJ_1182;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, S;
    static int[] arr;
    static int count=0;

    public static void check(int depth, int sum){

        if(depth==N){
            if(sum==S){
                count++;
            }
            return;
        }

        check(depth+1, sum+arr[depth]);
        check(depth+1, sum);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        check(0,0);

        if(S==0)
            count--;

        System.out.println(count);

    }

}
