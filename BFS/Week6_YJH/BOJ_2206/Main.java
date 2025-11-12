package BFS.Week6_YJH.BOJ_2206;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    static int M,N;
    static int[][] graph;
    static int[][][] distance; //거리겸 visited 기록, 3차원의 0번 index에는 벽 안부쉈을때 기록, 1번은 벽 부쉈을때 기록
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dy = {0,-1,0,1};
    static int[] dx = {-1,0,1,0};


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static int bfs(){
        while(!queue.isEmpty()){
            int[] move = queue.poll();
            int broke = move[0];
            int y1 = move[1];
            int x1 = move[2];

            if(y1 == M-1 && x1 == N-1) return 1;

            for (int i = 0; i < 4; i++) {
                int ny = y1 + dy[i];
                int nx = x1 + dx[i];

                if(ny == M-1 && nx == N-1){
                    return distance[broke][y1][x1] +1;
                }
                if(ny <0 || nx < 0 || ny >= M || nx >=N) continue;
                if(graph[ny][nx] == 0){
                    if(distance[broke][ny][nx] != 0) continue;
                    else {
                        distance[broke][ny][nx] = distance[broke][y1][x1] + 1;
                        queue.add(new int[]{broke,ny,nx});
                    }
                }else if(graph[ny][nx] == 1){
                    if(broke == 1) continue;
                    distance[1][ny][nx] = distance[broke][y1][x1] + 1;
                    queue.add(new int[]{1,ny,nx});
                    //broke = 1;
                }
            }
        }
        return -1;
    }

    public static void main (String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);

        graph = new int[M][N];
        distance = new int[2][M][N];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < M; j++) {
                Arrays.fill(distance[i][j],0); //거리만 -1로 초기화
            }
        }

        for (int i = 0; i < M; i++) {
            String tmp = br.readLine();
            String[] li = tmp.split("");

            for (int k = 0; k < li.length; k++) {
                graph[i][k] = Integer.parseInt(li[k]);
            }
        }

        queue.add(new int[]{0,0,0}); //시작 값 넣어주기
        distance[0][0][0] = 1;
        distance[1][0][0] = 1;

        int ans = bfs();

//        for (int i = 0; i < 2; i++) {
//            for (int j = 0; j < M; j++) {
//                for (int k = 0; k < N; k++) {
//                    System.out.print(distance[i][j][k] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println("\n");
//        }

        bw.write(Integer.toString(ans));
        bw.flush();
    }
}
