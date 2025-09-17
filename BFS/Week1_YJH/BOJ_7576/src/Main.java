package BFS.Week1_YJH.BOJ_7576.src;

import java.util.Scanner;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Main {
   
    static Queue<int[]> queue = new LinkedList<>();
    static Queue<int[]> tomatoLocation = new LinkedList<>();
    static int h,w,ans = 0;
    static int[][] graph;
    static int[][] visited;
    static int[] dy = {0,-1,0,1};
    static int[] dx = {-1,0,1,0};

    public static void bfs(){
        for (int[] ary : tomatoLocation) { //토마토 위치 저장한 것 넣기
            queue.add(ary);
        }


        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int y1 = tmp[0];
            int x1 = tmp[1];
            visited[y1][x1] = 1;

            for(int i = 0;i <4; i++){
                int ny = y1 + dy[i];
                int nx = x1 + dx[i];

                if(ny <0 || nx <0 || ny >= h || nx >= w) continue;
                if(visited[ny][nx] == 1 || graph[ny][nx] != 0)continue;
            
                visited[ny][nx] = 1;
                graph[ny][nx] = graph[y1][x1] + 1;
                queue.add(new int[]{ny,nx});
            }
        }
    }
   
    public static void main(String[] args) throws Exception {
    
        Scanner keyboard = new Scanner(System.in);

        w = keyboard.nextInt();
        h = keyboard.nextInt();
        keyboard.nextLine();

        graph = new int[h][w];
        visited = new int[h][w];
        

        for(int i =0; i<h; i++){
            Arrays.fill(graph[i], 0);
            Arrays.fill(visited[i], 0);            
        }

        for(int i = 0; i<h; i++){
            String tmp = keyboard.nextLine();

            String[] li = tmp.split(" ");

            for(int k = 0; k<li.length; k++){
                if(li[k].equals("1")){
                    tomatoLocation.add(new int[]{i,k}); //입력중 토마토 위치 저장
                }
                graph[i][k] = Integer.parseInt(li[k]);
            }
        }

        bfs();

        //bfs로 전체 거리 기록
        //graph 순회하며 0이 하나라도 있을 시 -1 출력
        //0이 하나라도 없다면 가장 큰 값 -1 출력(시작값이 1이었으므로)
        for(int i = 0; i<h; i++){
            for(int k = 0; k<w; k++){
                if(graph[i][k] == 0){
                    System.out.print(-1);
                    return;
                }

                if(ans <= graph[i][k] && graph[i][k] != -1){
                    ans = graph[i][k];
                }

            }
        }

        System.out.print(ans-1);

        keyboard.close();
    
    }
}