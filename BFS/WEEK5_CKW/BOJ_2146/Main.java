package BFS.WEEK5_CKW.BOJ_2146;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int[] xmove = {1, 0, -1, 0};
    static int[] ymove = {0, -1, 0, 1};
    //오른쪽, 아래, 왼쪽, 위

    public static void bfs(int a, int b, int c){
        for(int i=0; i<4; i++){
            if(a+ymove[i]<0 || b+xmove[i]<0 || a+ymove[i]>=map.length || b+xmove[i]>=map[0].length)
                continue;
            if(map[a+ymove[i]][b+xmove[i]] == 1){
                map[a+ymove[i]][b+xmove[i]] = c;
                bfs(a+ymove[i], b+xmove[i], c);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        map = new int[N][N];


        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int k=2;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++) {
                if(map[i][j]==1) {
                    map[i][j]=k;
                    bfs(i, j, k);
                    k++;
                }
            }
        }

        int[][][] visit = new int[N][N][k];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++) {
                Arrays.fill(visit[i][j], Integer.MAX_VALUE);
            }
        }

        Queue<int[]> q = new LinkedList<>();
        //y좌표, x좌표, 섬번호, 다리길이

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]>1){
                    for(int m=0; m<4; m++){
                        if(i+ymove[m]<0 || j+xmove[m]<0 || i+ymove[m]>=map.length || j+xmove[m]>=map[0].length)
                            continue;
                        if(map[i+ymove[m]][j+xmove[m]]==0) {
                            visit[i+ymove[m]][j+xmove[m]][map[i][j]] = 1;
                            q.add(new int[]{i+ymove[m], j+xmove[m], map[i][j], 1});
                        }
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            for(int i=0; i<4; i++){
                int y = tmp[0]+ymove[i]; int x = tmp[1]+xmove[i];
                if(y<0 || x<0 || y>=map.length || x>=map[0].length)
                    continue;
                if(map[y][x]==0) {
                    if(visit[y][x][tmp[2]]>tmp[3]+1) {
                        visit[y][x][tmp[2]]=tmp[3]+1;
                        q.add(new int[]{y, x, tmp[2], tmp[3]+1});
                    }
                }
                else if(map[y][x]!=tmp[2]){
                    min=Math.min(min, tmp[3]);
                }
            }
        }

        System.out.println(min);

    }

}
