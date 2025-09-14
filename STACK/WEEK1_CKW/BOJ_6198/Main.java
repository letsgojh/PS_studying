package STACK.WEEK1_CKW.BOJ_6198;

import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] building = new int[N];

        for(int i=0; i<N; i++) {
            building[i] = Integer.parseInt(br.readLine());
        }
        /*
        long cnt = 0;

        for(int i=0; i<N; i++) {
            int tmp = building[i];
            for(int j=i+1; j<N; j++) {
                if(tmp <= building[j]) {
                    break;
                }
                cnt++;
            }
        }*/

        Stack<Integer> stack = new Stack<Integer>();
        int n=1;
        long cnt=0;
        stack.push(0);
        while(n<N){
            int tmp=stack.size();
            for(int j=0; j<tmp; j++) {
                if (building[stack.peek()] <= building[n]) {
                    stack.pop();
                }
                else break;
            }
            cnt+=stack.size();
            stack.push(n++);
        }


        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(cnt+"\n");

        bw.flush();



    }



}
