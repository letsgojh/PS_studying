package BFS.Week5_YJH.BOJ_5014;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int F,S,G,U,D;
    static Queue<Integer> queue = new LinkedList<>();
    static int[] visited = new int[10000001]; //방문여부 기록
    static int[] move = new int[2];

    public static void bfs(){
        if(S == G) {
            System.out.print(0);
            return;
        }
        while(!queue.isEmpty()){
            Integer tmp = queue.poll();

            for (int i = 0; i < 2; i++) {
                int moving = tmp + move[i];

                if(moving == G){
                    System.out.print(visited[tmp] + 1);
                    return;
                }

                if(moving <= 0 || moving >F) continue;
                if(visited[moving] != -1) continue;
                visited[moving] = visited[tmp] + 1;
                queue.add(moving);
            }
        }
        System.out.print("use the stairs");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] tmp = br.readLine().split(" ");
        F = Integer.parseInt(tmp[0]);
        S = Integer.parseInt(tmp[1]);
        G = Integer.parseInt(tmp[2]);
        U = Integer.parseInt(tmp[3]);
        D = Integer.parseInt(tmp[4]);

        move[0] = U;
        move[1] = D*-1;

        Arrays.fill(visited,-1);

        visited[S] = 0; //처음위치 방문
        queue.add(S);

        //S == G 일때를 고려하지 않아서 틀림
        bfs();

        br.close();
        bw.close();
    }
}
