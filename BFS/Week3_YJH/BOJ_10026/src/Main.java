package BFS.Week3_YJH.BOJ_10026.src;

import java.util.Scanner;
import java.util.Queue;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    static int N;
    static char[][] graph_string;
    static int[][] graph_int_normal;
    static int[][] graph_int_disease;
    static Queue<int[]> queue_normal = new LinkedList<>();
    static Queue<int[]> queue_disease = new LinkedList<>();
    static int[][] visited_normal;
    static int[][] visited_disease;
    static int[] dy = new int[]{0,-1,0,1};
    static int[] dx = new int[]{-1,0,1,0};
    static int ans_normal = 0;
    static int ans_disease = 0;


    public static void bfs_normal(int y, int x, char color){
        queue_normal.add(new int[] {y,x});
        visited_normal[y][x] = 1;
        graph_int_normal[y][x] = -1;


        while(!queue_normal.isEmpty()){
            int[] tmp = queue_normal.poll();
            int y1 = tmp[0];
            int x1 = tmp[1];

            for(int i = 0; i<4; i++){
                int ny = y1 + dy[i];
                int nx = x1 + dx[i];

                if(ny < 0 || nx < 0 || ny >=N || nx >= N) continue;
                if(visited_normal[ny][nx] == 1 || graph_string[ny][nx] != color) continue;
                visited_normal[ny][nx] = 1;
                queue_normal.add(new int[]{ny,nx});
                graph_int_normal[ny][nx] = -1;
            }
        }
        ans_normal++;

    }

    public static void bfs_disease(int y, int x, char color){
        queue_disease.add(new int[] {y,x});
        visited_disease[y][x] = 1;
        graph_int_disease[y][x] = -1;

        while(!queue_disease.isEmpty()){
            int[] tmp = queue_disease.poll();
            int y1 = tmp[0];
            int x1 = tmp[1];

            for(int i = 0; i<4; i++){
                int ny = y1 + dy[i];
                int nx = x1 + dx[i];

                if(ny < 0 || nx < 0 || ny >=N || nx >= N) continue;
                if(visited_disease[ny][nx] == 1) continue;
                if(color == 'B'){
                    if(graph_string[ny][nx] != color){
                        continue;
                    } 
                }else{
                    if(graph_string[ny][nx] == 'B')
                        continue;
                }
                visited_disease[ny][nx] = 1;
                queue_disease.add(new int[]{ny,nx});
                graph_int_disease[ny][nx] = -1;
            }
        }
        ans_disease++;

    }
    public static void main(String[] args) throws Exception {

        Scanner keyboard = new Scanner(System.in);
        
        N = keyboard.nextInt();
        keyboard.nextLine();
        
        graph_string = new char[N][N];
        graph_int_normal = new int[N][N];
        graph_int_disease = new int[N][N];
        visited_normal = new int[N][N];
        visited_disease = new int[N][N];

        for(int i = 0; i<N; i++){
            Arrays.fill(graph_int_normal[i], 0);
            Arrays.fill(graph_int_disease[i], 0);
            Arrays.fill(visited_normal[i], 0);
            Arrays.fill(visited_disease[i], 0);
            
        }


        for (int i = 0; i < N; i++) {
            String tmp = keyboard.nextLine();
            char[] li = tmp.toCharArray();

            for (int j = 0; j < li.length; j++) {
                graph_string[i][j] = li[j];
            }

        }

        for (int i = 0; i < N; i++) {
            for(int k = 0; k<N; k++){
                if(visited_normal[i][k] != 1 && graph_int_normal[i][k] != -1){
                    bfs_normal(i, k, graph_string[i][k]);
                }if(visited_disease[i][k] != 1&&graph_int_disease[i][k] != -1){
                    bfs_disease(i, k, graph_string[i][k]);
                }
            }
        }

        System.out.print(ans_normal + " " + ans_disease);

        keyboard.close();
    }
}
