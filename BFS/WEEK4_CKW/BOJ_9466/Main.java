package BFS.WEEK4_CKW.BOJ_9466;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visit, finish;
    static int[] student;
    static int count;

    static void bfs(int i){
        if(finish[i])
            return;

        if(visit[i]){
            finish[i]=true;
            count++;
        }
        visit[i]=true;
        bfs(student[i]);
        finish[i]=true;
        visit[i]=false;
     }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());


        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            count=0;
            student = new int[n+1];
            visit = new boolean[n+1];
            finish = new boolean[n+1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                student[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j <= n; j++) {
                bfs(j);
            }


            System.out.println(n-count);

        }


        }

}
