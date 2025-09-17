package STACK.WEEK1_CKW.BOJ_17298;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] nge = new int[N];
        int[] num = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<Integer>();
        int n=1;

        stack.push(0);
        while(n<N){
            if(num[n]>num[stack.peek()]){
                num[stack.pop()] = num[n];
            }
            else{
                stack.push(n++);
            }
            if(stack.isEmpty()) {
                stack.push(n++);
            }
        }

        while(!stack.isEmpty()){
            num[stack.pop()] = -1;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i=0;i<N;i++){
            bw.write(num[i]+ " ");
        }


        bw.flush();


    }
}
