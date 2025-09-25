package BFS.Week4_YJH.BOJ_2583;

import java.io.*;
import java.util.*;

public class Main {

    static int M,N,K;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dy = {0,-1,0,1};
    static int[] dx = {-1,0,1,0};
    static int start_y;
    static int start_x;
    static int end_y;
    static int end_x;

    static int ans = 0;
    static List<Integer> ansList = new ArrayList<>();
    static int[][] graph;
    static int[][] visited;
    
    public static void bfs(int y, int x){
        int tmp_ans = 1;
        queue.add(new int[] {y,x});
        visited[y][x] = 1;
        
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int y1 = tmp[0];
            int x1 = tmp[1];

            for (int i = 0; i <4; i++) {
                int ny = y1 + dy[i];
                int nx = x1 + dx[i];

                if(ny <0 || nx < 0 || ny>=M || nx >= N) continue;
                if(visited[ny][nx] == 1 || graph[ny][nx] == -1) continue;
                visited[ny][nx] = 1;
                queue.add(new int[]{ny,nx});
                graph[ny][nx] = -1;
                tmp_ans++;
            }
        }
        ans++;
        ansList.add(tmp_ans);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" "); //한줄 입력받으려면 이렇게
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);

        graph = new int[M][N];
        visited = new int[M][N];

        for (int i = 0; i < M; i++) {
            Arrays.fill(graph[i], 0);
            Arrays.fill(visited[i], 0);
        }

        for (int i = 0; i < K; i++) {
            String[] tmp = br.readLine().split(" ");
            start_x = Integer.parseInt(tmp[0]);
            start_y = Integer.parseInt(tmp[1]);
            end_x = Integer.parseInt(tmp[2]);
            end_y = Integer.parseInt(tmp[3]);


            for (int tmp1 = M - start_y - 1; tmp1 > M - end_y - 1; tmp1--) {
                for (int tmp2 = start_x; tmp2 < end_x; tmp2++) {
                    graph[tmp1][tmp2] = -1;
                    visited[tmp1][tmp2] = 1;
                }
            }
        }
            for (int a = 0; a < M; a++) {
                for (int b = 0; b < N; b++) {
                    if (visited[a][b] == 0 && graph[a][b] != -1) {
                        bfs(a, b);
                    }
                }
            }


            System.out.println(ans);

            //정렬 어케하더라..
            Collections.sort(ansList);

            for (Integer i : ansList) {
                System.out.print(i + " ");
            }
        }

}
