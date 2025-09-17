package BFS.Week3_YJH.BOJ_7569.src;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Queue;

public class Main {

    static int M,N,H;
    static int[][][] graph;
    static int[][][] visited;
    static Queue<int[]> queue = new LinkedList<>();
    static boolean flag = false; //bfs 시작 전, 완성여부 확인하는 변수
    static int ans = 0;
    //위,아래,상하좌우 6방향 bfs
    static int[] dz = new int[]{0,0,0,0,1,-1}; 
    static int[] dy = new int[]{0,-1,0,1,0,0};
    static int[] dx = new int[]{-1,0,1,0,0,0};


    public static void bfs(){
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int z = tmp[0];
            int y = tmp[1];
            int x = tmp[2];

            for(int i = 0; i<6;i ++){
                int nz = z + dz[i];
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(nz < 0 || ny < 0 || nx < 0 || nz >= H || ny >= N || nx >= M) continue;
                if(visited[nz][ny][nx] == 1) continue;
                if(graph[nz][ny][nx] != 0) continue;
                queue.add(new int[]{nz,ny,nx});
                visited[nz][ny][nx] = 1;
                graph[nz][ny][nx] = graph[z][y][x] + 1;


            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);

        M = keyboard.nextInt();
        N = keyboard.nextInt();
        H = keyboard.nextInt();
        keyboard.nextLine();

        graph = new int[H][N][M];
        visited = new int[H][N][M];

        for(int i = 0; i<H; i++){
            for(int k = 0; k<N; k++){
                Arrays.fill(graph[i][k], 0);
                Arrays.fill(visited[i][k], 0);
            }
        }

        for (int i = 0; i < H; i++) {
            for (int k = 0; k < N; k++) {
                String tmp = keyboard.nextLine();
                String[] li = tmp.split(" ");

                for (int j = 0; j < li.length; j++) {

                    if(Integer.parseInt(li[j]) == 1){ //토마토 입력받으면서 queue에 넣어두기
                        queue.add(new int[] {i,k,j});
                        visited[i][k][j] = 1; //방문여부도 미리 표시
                    }
                    graph[i][k][j] = Integer.parseInt(li[j]);
                }
            }
        }

        //만약 bfs 전에 완성되어있는지(토마토 다 익었는지) 확인
        for(int i = 0; i<H; i++){
            for(int k = 0; k<N; k++){
                for(int j = 0; j<M; j++){
                    if(graph[i][k][j] == 0){
                        flag = true; //bfs 한번이라도 돌아야 된다면 true
                    }

                }
            }
        }

        bfs();

        // System.out.println();
        // for(int i = 0; i<H; i++){
        //     for(int k = 0; k<N; k++){
        //         for(int j = 0; j<M; j++){
        //             System.out.print(graph[i][k][j] + " ");
        //         }
        //         System.out.println();
        //     }
        //     System.out.println();
        // }

        if(!flag){
            ans = 0;
            System.out.print(ans);
        }else{
            for(int i = 0; i<H; i++){
                for(int k = 0; k<N; k++){
                    for(int j = 0; j<M; j++){
                        if(graph[i][k][j] == 0){ //안익은 토마토 있다면 -1
                            ans = -1;
                            System.out.print(ans);
                            return;
                        }else{
                            if(ans <= graph[i][k][j]){
                                ans = graph[i][k][j];
                            }
                        }
                    }
                }
            }
        
            System.out.print(ans-1);
        }   

        keyboard.close();
    }
}
