package BFS.WEEK3_CKW.BOJ_6593;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] zmove = {0, 0, 0, 0, 1, -1};
    static int[] ymove = {0, 1, 0, -1, 0, 0};
    static int[] xmove = {1, 0, -1, 0, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if(L==0 && R==0 && C==0) {
                System.out.println(sb.toString());
                return;
            }

            char[][][] map = new char[L+2][R+2][C+2];
            boolean[][][] visited = new boolean[L+2][R+2][C+2];

            Queue<int[]> q = new LinkedList<>();

            for(int i = 1; i <= L; i++){
                for(int j = 1; j <= R; j++){
                    String tmp = br.readLine();
                    for(int k = 1; k <= C; k++){
                        map[i][j][k] = tmp.charAt(k-1);
                        if(tmp.charAt(k-1)=='S') {
                            q.add(new int[]{i,j,k,0});
                            visited[i][j][k] = true;
                        }
                    }
                }
                br.readLine();
            }

            //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            boolean find = false;

            while(!q.isEmpty()) {
                int[] tmp = q.poll();
                int z = tmp[0]; int y = tmp[1]; int x = tmp[2];
                int cnt = tmp[3];

                if(map[z][y][x] == 'E') {
                    find = true;
                    sb.append("Escaped in " + cnt + " minute(s).\n");
                    break;
                }

                for (int i = 0; i < 6; i++) {
                    int zz = z + zmove[i];
                    int yy = y + ymove[i];
                    int xx = x + xmove[i];
                    if (map[zz][yy][xx] == '.' || map[zz][yy][xx] == 'E') {
                        if(!visited[zz][yy][xx]) {
                            q.add(new int[]{zz, yy, xx, cnt + 1});
                            visited[zz][yy][xx] = true;
                        }
                    }
                }
            }
            if(!find) {
                sb.append("Trapped!\n");
            }


        }



    }

}
