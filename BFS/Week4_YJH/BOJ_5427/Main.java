package BFS.Week4_YJH.BOJ_5427;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static final int INF = 99999;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String [][] graph;
    static int testCase;

    static int[][] graph_fire;
    static int[][] graph_person;

    static Queue<int[]> queue_fire;
    static Queue<int[]> queue_person;

    static int[][] visited_fire;
    static int[][] visited_person;

    static int[] dy = {0,-1,0,1};
    static int[] dx = {-1,0,1,0};


    public static void print_fire_graph(int w , int h ) throws IOException {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                bw.write(String.valueOf(graph_fire[i][j]) + " ");
            }
            bw.newLine();
        }
    }

    public static void print_person_graph(int w , int h ) throws IOException {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                bw.write(String.valueOf(graph_person[i][j]) + " ");
            }
            bw.newLine();
        }
    }

    public static void bfs_fire(int w, int h){
        while(!queue_fire.isEmpty()){
            int[] tmp = queue_fire.poll();
            int y = tmp[0];
            int x = tmp[1];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny <0 || nx < 0 || ny >= h || nx >= w) {continue;}
                if(visited_fire[ny][nx] == 1) {continue;}
                if(graph_fire[ny][nx] != INF) {continue;}
                queue_fire.add(new int[] {ny,nx});
                visited_fire[ny][nx] = 1;
                graph_fire[ny][nx] = graph_fire[y][x] + 1;
            }
        }
    }

    public static int bfs_person(int w, int h) {
        while (!queue_person.isEmpty()) {
            int[] tmp = queue_person.poll();
            int y = tmp[0];
            int x = tmp[1];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || nx < 0 || ny >= h || nx >= w) {
                    return graph_person[y][x] + 1;
                }
                if (visited_person[ny][nx] == 1) continue;
                if (graph_person[ny][nx] != INF) continue;
                if (graph_person[y][x] + 1 >= graph_fire[ny][nx]) continue;

                queue_person.add(new int[]{ny, nx});
                graph_person[ny][nx] = graph_person[y][x] + 1;
                visited_person[ny][nx] = 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {

       String test_case_str = br.readLine();
       testCase = Integer.parseInt(test_case_str);

        for (int i = 0; i < testCase; i++) {
            String wAndh = br.readLine();

            int w = Integer.parseInt(wAndh.split(" ")[0]);
            int h = Integer.parseInt(wAndh.split(" ")[1]);


            graph = new String[h][w];
            graph_fire = new int[h][w];
            graph_person = new int[h][w];
            visited_fire = new int[h][w];
            visited_person = new int[h][w];
            queue_fire = new LinkedList<>();
            queue_person = new LinkedList<>();

            for(int k = 0; k<h; k++){ //초기화
                Arrays.fill(graph[k],"");
                Arrays.fill(graph_fire[k],INF); //초기값 표시
                Arrays.fill(graph_person[k],INF);
                Arrays.fill(visited_fire[k],0);
                Arrays.fill(visited_person[k],0);
            }


            for(int k = 0; k<h; k++){
                    String tmp = br.readLine();
                    String[] li = tmp.trim().split("");

                for (int j = 0; j < li.length; j++) {
                    if(li[j].equals("#")){ //벽은 -1로 표시
                        graph_fire[k][j] = -1;
                        graph_person[k][j] = -1;
                    }else if(li[j].equals("@")){ //상근이 위치는 0으로 기록
                        queue_person.add(new int[]{k,j});
                        visited_person[k][j] = 1;
                        graph_person[k][j] = 0;
                    }else if(li[j].equals("*")){ //불 기록
                        queue_fire.add(new int[]{k,j});
                        graph_fire[k][j] = 0;
                        graph_person[k][j] = -1;
                        visited_fire[k][j] = 1;
                    }
                    graph[k][j] = li[j];
                }
            }

//            System.out.println("before bfs");
//            System.out.println("fire");
//            print_fire_graph(w, h);
//            bw.flush();
//
//            System.out.println("person");
//            print_person_graph(w,h);
//            bw.flush();
//
//
//            System.out.println("after bfs");
            bfs_fire(w, h);
//            System.out.println("fire");
//            print_fire_graph(w,h);
//            bw.flush();

            int ans = bfs_person(w, h);
//            System.out.println("person");
//            print_person_graph(w,h);
//            bw.flush();

            if(ans == -1) {
                bw.write("IMPOSSIBLE\n");
                bw.flush();
            }else{
                bw.write(Integer.toString(ans) + "\n");
                bw.flush();
            }

        }

        br.close();
        bw.close();
    }
}
