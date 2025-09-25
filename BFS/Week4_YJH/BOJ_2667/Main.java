package BFS.Week4_YJH.BOJ_2667;

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    static int num; //번호 몇번인지 기록
    static List<Integer> ans_list = new ArrayList<>();
    static int[][] graph;
    static int[][] record;
    static int[][] visited;
    static Queue<int[]> queue;

    static int[] dy = {0,-1,0,1};
    static int[] dx = {-1,0,1,0};


    public static void bfs(int i, int j){
        int ans = 0;
        queue.add(new int[]{i,j});
        record[i][j] = num;
        visited[i][j] = 1;

        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int y = tmp[0];
            int x = tmp[1];

            for (int k = 0; k < 4; k++) {
                int ny = y + dy[k];
                int nx = x + dx[k];

                if(ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
                if(visited[ny][nx] == 1) continue;
                if(graph[ny][nx] == 0) continue;
                visited[ny][nx] = 1;
                queue.add(new int[]{ny,nx});
                record[ny][nx] = num;
            }
            ans++;
        }

        ans_list.add(ans);
    }

    public static void main(String[] args) throws IOException {

        String tmp = br.readLine();
        N = Integer.parseInt(tmp);

        graph = new int[N][N];
        queue = new LinkedList<>();
        visited = new int[N][N];
        record = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], 0);
            Arrays.fill(graph[i], 0);
            Arrays.fill(record[i], 0);
        }

        for(int i = 0; i<N; i++){
            String str = br.readLine();
            String[] li = str.split("");

            for(int k = 0; k<li.length; k++){
                graph[i][k] = Integer.parseInt(li[k]);
            }
        }

//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(graph[i][j] + " ");
//            }
//            System.out.println();
//        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(visited[i][j] == 0 && graph[i][j] == 1){ //방문 안했다면 bfs
                    num++;
                    bfs(i,j);
                }
            }
        }

        bw.write(num + "\n");
        bw.flush();


        Collections.sort(ans_list); //정렬할때는 Collections사용한다는 것
        //내림차순은 Collections.sort(ans_list,Collections.reverseOrder());
        
        for (Integer i : ans_list) {
            bw.write(i + "\n");
            bw.flush();
        }

    }
}
