package STACK.WEEK1_CKW.BOJ_2493;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();

        stack.push(N);
        int n=N-1;
        while(n>0){
            if(num[stack.peek()]<num[n]){
                num[stack.pop()]=n;
            }
            else{
                stack.push(n--);
            }
            if(stack.isEmpty()){
                stack.push(n--);
            }
        }

        while(!stack.isEmpty()){
            num[stack.pop()]=0;
        }
        num[0]=0;

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i=1; i<=N; i++){
            bw.write(num[i]+" ");
        }

        bw.flush();



    }

}
