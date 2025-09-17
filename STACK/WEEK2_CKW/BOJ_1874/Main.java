package STACK.WEEK2_CKW.BOJ_1874;

import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] num = new int[n];

        for(int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<Integer>();
        int a = 0;
        StringBuilder ans = new StringBuilder();

        for(int i=0; i<n; i++) {
            while(a<=n){
                if(stack.isEmpty()){
                    ans.append("+\n");
                    //bw.write("+"+"\n");
                    stack.push(++a);
                }
                if(stack.peek()==num[i]){
                    stack.pop();
                    ans.append("-\n");
                    //bw.write("-"+"\n");
                    break;
                }
                else{
                    stack.push(++a);
                    ans.append("+\n");
                    //bw.write("+"+"\n");
                }
            }

        }

        if(!stack.isEmpty()){
            System.out.println("NO");
        }
        else{
            System.out.println(ans);
        }

    }

}
