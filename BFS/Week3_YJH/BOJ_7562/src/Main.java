import java.util.Scanner;
import java.util.Queue;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    //queue를 매 실행마다 비워줄 것 !!!
    static Queue<int[]> queue;
    static int[][] graph;
    static int[][] visited;
    static int testCase;
    static int graphLength;
    static int start_y,start_x;
    static int end_y,end_x;

    static int[] dy = new int[]{-1,-2,-2,-1,1,2,2,1};
    static int[] dx = new int[]{-2,-1,1,2,2,1,-1,-2};
    

    public static void bfs(){
        
        //아예 같은 위치일경우 그냥 0출력
        if(start_y == end_y && start_x == end_x) return;
        
        queue.add(new int[]{start_y,start_x});
        visited[start_y][start_x] = 1;

        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int y1 = tmp[0];
            int x1 = tmp[1];

            if(y1 == end_y && x1 == end_x) return;

            for(int i = 0; i<8; i++){
                int ny = y1 + dy[i];
                int nx = x1 + dx[i];

                if(ny < 0 || nx <0 || ny >=graphLength || nx >=graphLength) continue;
                if(visited[ny][nx] == 1 || graph[ny][nx] != 0) continue;

                graph[ny][nx] = graph[y1][x1] +1;
                visited[ny][nx] = 1;
                queue.add(new int[]{ny,nx});

            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);


        testCase = keyboard.nextInt();
        keyboard.nextLine();

        for (int i = 0; i < testCase; i++) {
            graphLength = keyboard.nextInt();
            keyboard.nextLine();

            queue = new LinkedList<>();
            graph = new int[graphLength][graphLength];
            visited = new int[graphLength][graphLength];

            for (int j = 0; j < graphLength; j++) { //초기화
                Arrays.fill(graph[j], 0);
                Arrays.fill(visited[j], 0);
            }

            start_y = keyboard.nextInt();
            start_x = keyboard.nextInt();
            keyboard.nextLine();

            end_y = keyboard.nextInt();
            end_x = keyboard.nextInt();
            keyboard.nextLine();


            bfs();

            // for (int j = 0; j < graphLength; j++) {
            //     for(int k =0; k<graphLength; k++){
            //         System.out.print(graph[j][k] + " ");
            //     }
            //     System.out.println();
            // }

            System.out.println(graph[end_y][end_x]);


        }

        keyboard.close();
    }
}
