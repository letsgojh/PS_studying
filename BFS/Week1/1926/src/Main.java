import java.util.Scanner;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static int pictureNum; //그림의 개수
    public static int maxPictureSize;
    public static int[][] graph;
    public static int[][] visited;
    public static Queue<int[]> queue = new LinkedList<>();

    public static int[] dy = {0,-1,0,1};
    public static int[] dx = {-1,0,1,0};
    public static int w;
    public static int h;

    public static int bfs(int y, int x, int[][] visited){
        int[] ele = {y,x};
        queue.add(ele);
        int pictureSize = 0;
        visited[y][x] = 1;

        while(!queue.isEmpty()){
            int[] yx = queue.poll();
            int y1 = yx[0];
            int x1 = yx[1];

            for(int i = 0 ;i <4;i ++){
                int ny = y1 + dy[i];
                int nx = x1 + dx[i];

                if(ny < 0 || nx <0 || ny >= h || nx >= w) continue;
                if(visited[ny][nx] == 1 || graph[ny][nx] == 0) continue;

                visited[ny][nx] = 1;
                queue.add(new int[]{ny,nx});

            }

            pictureSize++;

        }

        pictureNum++;

        return pictureSize;

    }
    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);

        h = keyboard.nextInt();
        w = keyboard.nextInt();
        keyboard.nextLine();

        graph = new int[h][w];
        visited = new int[h][w];


        for(int i = 0; i<h; i++){
            Arrays.fill(graph[i], 0); // graph 0으로 초기화
            Arrays.fill(visited[i],0); // visited 0으로 초기화
        }

        for(int i = 0; i<h; i++){
            String tmp = keyboard.nextLine();

            String[] li = tmp.split(" ");

            for (int k = 0; k < li.length; k++) {
                graph[i][k] = Integer.parseInt(li[k]);
            }
        }



         for(int i = 0 ; i<graph.length; i++){
            for(int k = 0 ; k<graph[i].length; k++){
                if(visited[i][k] != 1 && graph[i][k] == 1){
                    //System.out.println("y = " + i + "x = " + k);
                    int pictureSize = bfs(i,k,visited);
                    //System.out.println(pictureSize);
                    if(maxPictureSize <= pictureSize){
                        maxPictureSize = pictureSize;
                    }
                }
                //System.out.print(graph[i][k] + " ");
            }
            //System.out.println();
        }

        System.out.println(pictureNum);
        System.out.println(maxPictureSize);

        keyboard.close();
    }

}