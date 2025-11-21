package BFS.WEEK5_CKW.BOJ_1600;

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

        int K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken()); //가로길이(x)
        int H = Integer.parseInt(st.nextToken()); //세로길이(y)

        int[][] map = new int[H+2][W+2];
        int[][][] visit = new int[H+2][W+2][K+1];
        for(int i=0; i<H+2; i++) {
            for (int j = 0; j < W + 2; j++)
                Arrays.fill(visit[i][j], Integer.MAX_VALUE);
        }

        for(int i=1; i<=H; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=W; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[]> q = new LinkedList<>();
        map[1][1] = 1;
        q.add(new int[]{1, 1, 0, 0});
        // y좌표, x좌표, 총 움직인 수, 말 따라한 수

        int[] malxmove = new int[]{1, 2, 2, 1, -1, -2, -2, -1};
        int[] malymove = new int[]{2, 1, -1, -2, -2, -1, 1, 2};

        int[] xmove = new int[]{1, 0, -1, 0};
        int[] ymove = new int[]{0, -1, 0, 1};
        //오른쪽, 아래, 왼쪽, 위

        boolean find = false;
        int min = Integer.MAX_VALUE;

        while(!q.isEmpty()){
            int xtmp, ytmp;
            int[] tmp = q.poll();

            if(tmp[0]==H && tmp[1]==W){
                find = true;
                if(min>tmp[2])
                    min = tmp[2];
                continue;
            }

            if(tmp[3]<K) { // 말 움직임 관련
                for(int i=0; i<8; i++){
                    xtmp = tmp[1] + malxmove[i];
                    ytmp = tmp[0] + malymove[i];

                    if(xtmp>0 && ytmp>0 && xtmp<=W && ytmp<=H){
                        if(map[ytmp][xtmp]==0 && visit[ytmp][xtmp][tmp[3]+1]>tmp[2]){
                            visit[ytmp][xtmp][tmp[3]+1]=tmp[2];
                            q.add(new int[]{ytmp, xtmp, tmp[2]+1, tmp[3]+1});
                        }
                    }
                }
            }

            for(int i=0; i<4; i++){ // 그냥 움직임 관련
                xtmp = tmp[1] + xmove[i];
                ytmp = tmp[0] + ymove[i];
                if(xtmp>0 && ytmp>0 && xtmp<=W && ytmp<=H){
                    if(map[ytmp][xtmp]==0 && visit[ytmp][xtmp][tmp[3]]>tmp[2]){
                        visit[ytmp][xtmp][tmp[3]]=tmp[2];
                        q.add(new int[]{ytmp, xtmp, tmp[2]+1, tmp[3]});
                    }
                }
            }

        }

        if(!find)
            System.out.println(-1);
        else
            System.out.println(min);


    }

}
