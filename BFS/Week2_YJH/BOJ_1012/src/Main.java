package BFS.Week2_YJH.BOJ_1012.src;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Queue;

public class Main {
    
    static int T,M,N,K;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dy = new int[]{0,-1,0,1};
    static int[] dx = new int[]{-1,0,1,0};
    static int[][] graph;
    static int[][] visited;
    static int ans;
    
    
    static void search(){ //전체 그래프에서 배추 있는 곳에서만 bfs

        ans = 0;
        for(int i = 0; i<N; i++){
            for(int k = 0; k<M; k++){
                if(graph[i][k] == 1 && visited[i][k] == 0){
                    bfs(i,k);
                }
            }
        }
        System.out.println(ans);
    }

    static void bfs(int i, int k){
        queue.add(new int[] {i,k});
        visited[i][k] = 1;

        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int y1 = tmp[0];
            int x1 = tmp[1];

            for(int j = 0;j<4; j++){
                int ny = y1+ dy[j];
                int nx = x1 + dx[j];

                if(ny <0 || nx <0 || ny >=N || nx >= M) continue;
                if(visited[ny][nx] == 1 || graph[ny][nx] == 0) continue;

                queue.add(new int[] {ny,nx});
                visited[ny][nx] = 1;

            }
        }

        ans++;
    }

    public static void main(String[] args) throws Exception {
    
        Scanner keyboard = new Scanner(System.in);

        T = keyboard.nextInt();

        for (int i = 0; i < T; i++) {
            M = keyboard.nextInt();
            N = keyboard.nextInt();
            K = keyboard.nextInt();
            keyboard.nextLine();

            graph = new int[N][M];
            visited = new int[N][M];

            for (int j = 0; j < N; j++) {
                Arrays.fill(graph[j], 0);
                Arrays.fill(visited[j], 0);
            }

            for (int k = 0; k < K; k++) {
                //System.out.println(k);
                int y = keyboard.nextInt();
                int x = keyboard.nextInt();
                keyboard.nextLine();

                graph[x][y] = 1;

            }

            search();
        }

        keyboard.close();
    }
}