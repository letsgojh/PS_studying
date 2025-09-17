package BFS.Week1_YJH.BOJ_2178.src;

import java.util.Scanner;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int h,w;
    static int[][] graph;
    static int[][] visited;
    static int[][] distance;

    static Queue<int[]> queue = new LinkedList<>();


    static int[] dy = {0,-1,0,1};
    static int[] dx = {-1,0,1,0};

    public static void bfs(int y, int x){
        queue.add(new int[]{y,x});
        visited[y][x] = 1;

        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int y1 = tmp[0];
            int x1 = tmp[1];

            for(int i = 0; i<4; i++){
                int ny = y1 + dy[i];
                int nx = x1 + dx[i];


                //System.out.println("ny = " + ny + "nx = " + nx);
                if(ny < 0 || nx < 0 || ny >= h || nx >=w) continue;
                if(visited[ny][nx] == 1 || graph[ny][nx] == 0) continue;

                visited[ny][nx] = 1;
                distance[ny][nx] = distance[y1][x1] + 1;
                queue.add(new int[]{ny,nx});
            }
            
        }

    }

    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);

        h = keyboard.nextInt();
        w = keyboard.nextInt();
        keyboard.nextLine();

        graph = new int[h][w];
        visited = new int[h][w];
        distance = new int[h][w];


        for(int i = 0; i<h; i++){
            Arrays.fill(graph[i], 0); // graph 초기화
            Arrays.fill(visited[i],0);
            Arrays.fill(distance[i], 0);
        }


        for(int i = 0; i<h; i++){
            String tmp = keyboard.nextLine();

            char[] li = tmp.toCharArray();

            for (int k = 0; k<li.length; k++) {
                graph[i][k] = li[k]-'0';
            }
        }

        distance[0][0] = 1; //처음은 1부터 시작
        bfs(0,0);

        // for(int i = 0; i<h; i++){
        //     for(int k= 0; k<w; k++){
        //         System.out.print(distance[i][k] + " ");
        //     }
        //     System.out.println();
        // }

        System.out.print(distance[h-1][w-1]);
    
        keyboard.close();
    }
}
