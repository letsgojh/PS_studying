package BFS.WEEK5_CKW.BOJ_13549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.System.exit;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{N, 0});
        int min = Integer.MAX_VALUE;
        int[] visit = new int[100001];
        Arrays.fill(visit, Integer.MAX_VALUE);

        if(N==K){
            System.out.println(0);
            exit(0);
        }

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            if(cur[0]+1>=0 && cur[0]+1<=100000){
                if(visit[cur[0]+1]>cur[1]+1) {
                    visit[cur[0] + 1] = cur[1] + 1;
                    q.add(new int[]{cur[0] + 1, cur[1] + 1});
                }
            }

            if(cur[0]-1>=0 && cur[0]-1<=100000){
                if(visit[cur[0]-1]>cur[1]+1) {
                    visit[cur[0] - 1] = cur[1] + 1;
                    q.add(new int[]{cur[0] - 1, cur[1] + 1});
                }
            }

            if(cur[0]*2>=0 && cur[0]*2<=100000){
                if(visit[cur[0]*2]>cur[1]) {
                    visit[cur[0] * 2] = cur[1];
                    q.add(new int[]{cur[0] * 2, cur[1]});
                }
            }

        }

        System.out.println(visit[K]);


    }

}
