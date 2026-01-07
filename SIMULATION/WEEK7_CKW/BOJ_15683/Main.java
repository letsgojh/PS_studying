package SIMULATION.WEEK7_CKW.BOJ_15683;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static long min = Long.MAX_VALUE;

    public static void rightcheck(int y, int x, int[][] sim){
        int ytmp = y; int xtmp = x;
        while(xtmp+1<M  && sim[ytmp][xtmp+1] != 6){
            xtmp++;
            if(sim[ytmp][xtmp]==0)
                sim[ytmp][xtmp] = 7;
        }
    }
    public static void leftcheck(int y, int x, int[][] sim){
        int ytmp = y; int xtmp = x;
        while(xtmp-1>=0 && sim[ytmp][xtmp-1] != 6){
            xtmp--;
            if(sim[ytmp][xtmp]==0)
                sim[ytmp][xtmp] = 7;
        }
    }

    public static void upcheck(int y, int x, int[][] sim){
        int ytmp = y; int xtmp = x;
        while(ytmp-1>=0 && sim[ytmp-1][xtmp] != 6){
            ytmp--;
            if(sim[ytmp][xtmp]==0)
                sim[ytmp][xtmp] = 7;
        }
    }

    public static void downcheck(int y, int x, int[][] sim){
        int ytmp = y; int xtmp = x;
        while(ytmp+1<N && sim[ytmp+1][xtmp] != 6){
            ytmp++;
            if(sim[ytmp][xtmp]==0)
                sim[ytmp][xtmp] = 7;
        }
    }

    public static void cctvcheck(int y, int x, int cctv, int[][] sim){
        if(sim[y][x] == 1){
            if(cctv == 0){ // 오른쪽 감시
                rightcheck(y, x, sim);
            }
            else if(cctv == 1){ // 아래 감시
                downcheck(y, x, sim);
            }
            else if(cctv == 2){ // 왼쪽 감시
                leftcheck(y, x, sim);
            }
            else if(cctv == 3){ // 위 감시
                upcheck(y, x, sim);
            }
        }
        else if(sim[y][x] == 2){
            if(cctv % 2== 0){ // 오른쪽 왼쪽 감시
                rightcheck(y, x, sim);
                leftcheck(y, x, sim);
            }
            else if(cctv % 2 == 1){ // 위 아래 감시
                upcheck(y, x, sim);
                downcheck(y, x, sim);
            }

        }
        else if(sim[y][x] == 3){
            if(cctv == 0){ // 위 오른쪽 감시
                upcheck(y, x, sim);
                rightcheck(y, x, sim);
            }
            else if(cctv == 1){ // 오른족 아래 감시
                rightcheck(y, x, sim);
                downcheck(y, x, sim);
            }
            else if(cctv == 2){ // 아래 왼쪽 감시
                downcheck(y, x, sim);
                leftcheck(y, x, sim);
            }
            else if(cctv == 3){ // 왼족 위 감시
                leftcheck(y, x, sim);
                upcheck(y, x, sim);
            }
        }
        else if(sim[y][x] == 4){
            if(cctv == 0){ // 왼쪽 위 오른쪽 감시
                leftcheck(y, x, sim);
                upcheck(y, x, sim);
                rightcheck(y, x, sim);
            }
            else if(cctv == 1){ // 위 오른쪽 아래 감시
                upcheck(y, x, sim);
                rightcheck(y, x, sim);
                downcheck(y, x, sim);
            }
            else if(cctv == 2){ // 오른쪽 아래 왼쪽 감시
                rightcheck(y, x, sim);
                downcheck(y, x, sim);
                leftcheck(y, x, sim);
            }
            else if(cctv == 3){ // 아래 왼쪽 위 감시
                downcheck(y, x, sim);
                leftcheck(y, x, sim);
                upcheck(y, x, sim);
            }
        }
        else if(sim[y][x] == 5){
            upcheck(y, x, sim);
            downcheck(y, x, sim);
            leftcheck(y, x, sim);
            rightcheck(y, x, sim);
        }

    }

    public static void mapcheck(int[] cctv, int[][] sim, Queue<int[]> q){
        for(int i=0; i<q.size(); i++){
            int[] tmp = q.poll();
            q.add(tmp);
            cctvcheck(tmp[0], tmp[1], cctv[i], sim);
        }
        long count = Arrays.stream(sim).flatMapToInt(Arrays::stream).filter(num -> num == 0).count();
        if(min > count){
            min = count;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        int[][] sim;
        Queue<int[]> q = new LinkedList<>();
        int[] cctv = new int[8];


        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] > 0 && map[i][j] < 6) {
                    q.add(new int[]{i, j});
                }
            }
        }

        int cctvCount = q.size();

        for(int i=0; i<Math.pow(4,cctvCount); i++){
            int tmp = i;
            for(int j=0; j<cctvCount; j++){
                cctv[j] = tmp%4;
                tmp /= 4;
            }
            sim = new int[N][M];
            for(int j=0; j<N; j++){
                for(int k=0; k<M; k++){
                    sim[j][k] = map[j][k];
                }
            }
            mapcheck(cctv, sim, q);
        }

        System.out.println(min);

    }

}
