import java.util.LinkedList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Queue;

public class Main {
    
    static int R,C;
    static char[][] graph_string;
    static int[][] graph_F;
    static int[][] graph_J;
    static int[][] visited_F;
    static int[][] visited_J;
    static Queue<int[]> queue_F = new LinkedList<>();
    static Queue<int[]> queue_J = new LinkedList<>();
    static int[] dy = new int[]{0,-1,0,1};
    static int[] dx = new int[]{-1,0,1,0};
    

    public static void bfs_F(){
        while(!queue_F.isEmpty()){
            int[] tmp = queue_F.poll();
            int y1 = tmp[0];
            int x1 = tmp[1];

            for(int i = 0; i<4; i++){
                int ny = y1 + dy[i];
                int nx = x1 + dx[i];

                if(ny <0 || nx <0 || ny >= R || nx >= C) continue;
                if(visited_F[ny][nx] == 1 || graph_F[ny][nx] != 0) continue;
                visited_F[ny][nx] = 1;
                graph_F[ny][nx] = graph_F[y1][x1] + 1;
                queue_F.add(new int[]{ny,nx});
            }
        }
    }

    public static int bfs_J(){
        while(!queue_J.isEmpty()){
            int[] tmp = queue_J.poll();
            int y1 = tmp[0];
            int x1 = tmp[1];

            for(int i = 0; i<4; i++){
                int ny = y1 + dy[i];
                int nx = x1 + dx[i];

                if(ny <0 || nx <0 || ny >= R || nx >= C){ //가장자리 벗어나면 탈출
                    //System.out.println("ans  = 1");
                    return graph_J[y1][x1]+1;
                }
                if(visited_J[ny][nx] == 1 || graph_J[ny][nx] == -1 || graph_J[ny][nx] == -2){ //벽이거나 갈 수 없다면 continue;
                    //System.out.println("ans  = 2");    
                    continue;
                } 
                if(graph_F[ny][nx] != 0){
                    if(graph_J[y1][x1] + 1 >= graph_F[ny][nx]) {
                        //System.out.println("ans  = 3");
                        continue;
                    }
                }
                //System.out.println("ans  = 4");
                visited_J[ny][nx] = 1;
                graph_J[ny][nx] = graph_J[y1][x1] + 1;
                queue_J.add(new int[]{ny,nx});
            }
        }

        return -1;
    }

    public static void main(String[] args) throws Exception {
    
        Scanner keyboard = new Scanner(System.in);

        R = keyboard.nextInt();
        C = keyboard.nextInt();
        keyboard.nextLine();


        graph_string = new char[R][C];
        graph_J = new int[R][C];
        graph_F = new int[R][C];        
        visited_J = new int[R][C];
        visited_F = new int[R][C];

        for(int i = 0; i<R; i++){
            Arrays.fill(graph_J[i], 0);
            Arrays.fill(graph_F[i], 0);
            Arrays.fill(visited_F[i], 0);
            Arrays.fill(visited_J[i], 0);
        }


        for(int i = 0; i<R; i++){
            String tmp = keyboard.nextLine();
            char[] li = tmp.toCharArray();

            for (int k = 0; k<C; k++) {
                    graph_string[i][k] = li[k];
            }
        }


        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(graph_string[i][j] == '#'){ //벽 기록
                    graph_F[i][j] = -1;
                    graph_J[i][j] = -1;
                }else if(graph_string[i][j] == 'F'){ //불 위치 기록 => 불은 여러개가 될 수도, 0개가 될 수도 있다.
                    queue_F.add(new int[]{i,j});
                    visited_F[i][j] = 1;
                    graph_J[i][j] = -2;
                }else if(graph_string[i][j] == 'J'){ //지훈 위치 기록
                    queue_J.add(new int[]{i,j});
                    visited_J[i][j] = 1;
                }
            }
        }


        bfs_F();

        int ans = bfs_J();

        if(ans == -1){
            System.out.print("IMPOSSIBLE");
        }else{
            System.out.print(ans);
        }
        keyboard.close();
    }
}