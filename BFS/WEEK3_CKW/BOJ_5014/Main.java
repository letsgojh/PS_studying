package BFS.WEEK3_CKW.BOJ_5014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        queue.add(S);
        int[] count = new int[F+1];
        Arrays.fill(count, Integer.MAX_VALUE);
        count[S] = 0;
        boolean[] visit = new boolean[F+1];
        Arrays.fill(visit, false);

        while(!queue.isEmpty()) {
            int tmp = queue.poll();
            if(tmp == G){
                System.out.println(count[tmp]);
                return;
            }

            if(tmp + U <= F && count[tmp + U] > count[tmp] && !visit[tmp+U]){
                queue.add(tmp+U);
                visit[tmp+U] = true;
                count[tmp+U] = count[tmp] + 1;
            }

            if(tmp - D > 0 && count[tmp - D] > count[tmp] && !visit[tmp-D]){
                queue.add(tmp-D);
                visit[tmp-D] = true;
                count[tmp-D] = count[tmp] + 1;
            }

        }
        System.out.println("use the stairs");



    }

}
