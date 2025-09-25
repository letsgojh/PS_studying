package STACK.WEEK2_CKW.BOJ_10773;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<k; i++) {
            int a = Integer.parseInt(br.readLine());
            if(a==0){
                stack.pop();
            }
            else
                stack.push(a);

        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt=0;

        while(!stack.isEmpty()){
            cnt+=stack.pop();
        }

        bw.write(cnt+"\n");
        bw.flush();


    }

}
