package BFS.Week5_YJH.BOJ_2468;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N;
    static int Max = -1; //최고 높이를 기록
    static int Min = 101; //최저 높이를 기록
    static int[][] graph;
    static int[][] visited;

    static Queue<int[]> queue;
    static int []dy = {0,-1,0,1};
    static int []dx = {-1,0,1,0};
    static Integer ans = 1; //가장 작은 값은 모든 graph가 하나도 안잠기는 1
    static int tmp_ans = 0;

    public static void bfs(int y,int x,int number){
        queue.add(new int[]{y,x});
        visited[y][x] = 1;

        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int y1 = tmp[0];
            int x1 = tmp[1];

            for (int i = 0; i < 4; i++) {
                int ny = y1 + dy[i];
                int nx = x1 + dx[i];

                if(ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
                if(visited[ny][nx] == 1) continue;
                if(graph[ny][nx] <= number) continue;

                visited[ny][nx] = 1;
                queue.add(new int[]{ny,nx});
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        visited = new int[N][N];

        for (int i = 0; i < N; i++) {//초기화
            Arrays.fill(graph[i],-1);
            Arrays.fill(visited[i],0);
        }

        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            String [] li = tmp.split(" ");

            for (int j = 0; j < li.length; j++) {
                graph[i][j] = Integer.parseInt(li[j]);

                if(graph[i][j] >= Max){ //가장 큰 것 찾기
                    Max = graph[i][j];
                }
                if(graph[i][j] <= Min){ //가장 작은 것 찾기
                    Min = graph[i][j];
                }
            }
        }


        for (int i = Min; Max >= i; i++) {
            for (int a = 0; a < N; a++) {
                for (int b = 0; b < N; b++) {
                    visited[a][b] = 0; //방문여부 처음으로
                }
            }

            queue = new LinkedList<int[]>();
            tmp_ans = 0;
            for (int k = 0; k < N; k++) {
                for (int j = 0; j < N; j++) {
                    if(visited[k][j] == 0 && graph[k][j] > i){
                        bfs(k,j,i);
                        tmp_ans++;
                    }
                }
            }

//            System.out.println();
//            for (int q = 0; q < N; q++) {
//                for (int p = 0; p < N; p++) {
//                    System.out.print(visited[q][p] + " ");
//                }
//                System.out.println();
//            }

            if(tmp_ans >= ans)
                ans = tmp_ans;
        }

        bw.write(ans.toString());
        bw.flush();

        bw.close();
        br.close();
    }
}
