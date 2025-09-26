package BFS.Week5_YJH.BOJ_6593;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int L,R,C;
    static String [][][] graph;
    static int[][][] visited;
    static int[] destination = new int[3];

    static Queue<int[]> queue;
    static int[] dz = {0,0,0,0,1,-1};
    static int[] dy = {0,-1,0,1,0,0};
    static int[] dx = {-1,0,1,0,0,0};

    static int ans = 0;

    public static int bfs(){
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int z = tmp[0];
            int y = tmp[1];
            int x = tmp[2];

            for (int i = 0; i < 6; i++) {
                int nz = z + dz[i];
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(nz == destination[0] && ny == destination[1] && nx == destination[2]){
                    return visited[z][y][x] + 1;
                }
                if(nz < 0 || ny < 0 || nx < 0 || nz >= L || ny >= R || nx >= C) continue;
                if(visited[nz][ny][nx] != -1 || graph[nz][ny][nx].equals("#")) continue;
                queue.add(new int[]{nz,ny,nx});
                visited[nz][ny][nx] = visited[z][y][x] + 1;
            }

        }
        return -1;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        do {
            String line = br.readLine();
            String[] li = line.split(" ");
            L = Integer.parseInt(li[0]);
            R = Integer.parseInt(li[1]);
            C = Integer.parseInt(li[2]);

            if(L == 0 || R == 0 || C == 0)
                break;

            graph = new String[L][R][C];
            visited = new int[L][R][C];

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    Arrays.fill(graph[i][j], " ");
                    Arrays.fill(visited[i][j], -1);
                }
            }

            queue = new LinkedList<>();

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String tmp = br.readLine();
                    String[] tmpLi = tmp.split("");

                    for (int k = 0; k < C; k++) {
                        graph[i][j][k] = tmpLi[k];

                        if (graph[i][j][k].equals("S")) { //시작점
                            queue.add(new int[]{i, j, k});
                            visited[i][j][k] = 0;
                        }
                        if (graph[i][j][k].equals("E")) { //도착점
                            destination[0] = i;
                            destination[1] = j;
                            destination[2] = k;

                        }
                    }
                }
                br.readLine();
            }

            int tmp = bfs();

//            for (int i = 0; i < L; i++) {
//                for (int j = 0; j < R; j++) {
//                    for (int k = 0; k < C; k++) {
//                        System.out.print(visited[i][j][k] + " ");
//                    }
//                    System.out.println();
//                }
//                System.out.println();
//            }
            if(tmp == -1){
                System.out.println("Trapped!");
            }else{
                System.out.println("Escaped in " + tmp + " minute(s).");
            }
        } while (true);
    }
}
