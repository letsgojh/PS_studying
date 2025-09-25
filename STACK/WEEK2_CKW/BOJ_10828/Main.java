package STACK.WEEK2_CKW.BOJ_10828;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < N; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            String st = str.nextToken();
            if(st.equals("push")){
                stack.push(Integer.parseInt(str.nextToken()));
            }
            else if(st.equals("pop")){
                if(stack.isEmpty())
                    bw.write("-1"+"\n");
                else
                    bw.write(stack.pop() + "\n");
            }
            else if(st.equals("size")){
                bw.write(stack.size() + "\n");
            }
            else if(st.equals("empty")){
                if(stack.isEmpty())
                    bw.write("1"+"\n");
                else bw.write("0"+"\n");
            }
            else if(st.equals("top")){
                if(stack.isEmpty())
                    bw.write("-1"+"\n");
                else bw.write(stack.peek() +"\n");
            }

        }

        bw.flush();

    }

}
