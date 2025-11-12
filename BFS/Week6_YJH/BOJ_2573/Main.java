package BFS.Week6_YJH.BOJ_2573;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, M;
    static int[][] graph;
    static boolean[][] visited;
    static Queue<int[]> queue;
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {-1, 0, 1, 0};


    public static void bfs(int y, int x) {
        queue.add(new int[]{y, x});
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int y1 = current[0];
            int x1 = current[1];

            for (int i = 0; i < 4; i++) {
                int ny = y1 + dy[i];
                int nx = x1 + dx[i];

                if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
                if (visited[ny][nx] || graph[ny][nx] == 0) continue;
                visited[ny][nx] = true;
                queue.add(new int[]{ny, nx});
            }
        }
    }

    public static void melting() {

        int[][] new_graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] != 0) {
                    int tmp = graph[i][j]; //graph값 임시저장 -> graph값에 direct하게 증감한다면 melting 반영 x될 수도 있다.

                    for (int k = 0; k < 4; k++) {
                        int move_y = i + dy[k];
                        int move_x = j + dx[k];

                        if (tmp == 0) continue;
                        if (move_y < 0 || move_x < 0 || move_y >= N || move_x >= M) continue;
                        if (graph[move_y][move_x] == 0) {
                            tmp -= 1;
                        }
                    }

                    new_graph[i][j] = tmp;
                }
            }
        }
        graph = new_graph; //shallow copy를 이용하면 새로운 배열을 만들지 않아도 된다.
    }

    public static int check_segment() { //2개 이상 분리되었는지 확인하는 함수
        queue = new LinkedList<>();

        for (int i = 0; i < N; i++) { //visited 초기화
            Arrays.fill(visited[i], false);
        }

        int tmp = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && graph[i][j] != 0) { //방문 안했다면
                    bfs(i, j);
                    tmp++;
                }
            }
        }

        return tmp;
    }

    public static boolean checkAllZero() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] != 0)
                    return false;
            }
        }
        return true;
    }


    public static void main(String[] args) throws IOException {
        int ans = 0; //정답 기록
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        graph = new int[N][M]; //0초기화
        visited = new boolean[N][M]; //false 초기화

        for (int i = 0; i < N; i++) {
            String[] tmp = br.readLine().split(" ");

            for (int j = 0; j < tmp.length; j++) {
                graph[i][j] = Integer.parseInt(tmp[j]);
            }
        }


        if (check_segment() > 1) { //처음부터 빙산 분리된 경우
            bw.write(Integer.toString(ans));
            bw.flush();
        } else {
            while (check_segment() <= 1) {
                if (checkAllZero()) {
                    bw.write(Integer.toString(0));
                    bw.flush();
                    return;
                }
                melting();
                ans++;
            }
            bw.write(Integer.toString(ans));
            bw.flush();
        }
    }
}

