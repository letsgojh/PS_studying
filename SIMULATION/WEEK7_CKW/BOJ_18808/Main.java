package SIMULATION.WEEK7_CKW.BOJ_18808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K;
    static int[] R, C;
    static int[][][] sticker;
    static long max = 0;

    public static boolean check(int spin, int[][] note, int ystart, int xstart, int stiNum){
        if(spin==0) { // 0도
            for (int i = 0; i < R[stiNum]; i++) {
                for (int j = 0; j < C[stiNum]; j++) {
                    if (sticker[stiNum][i][j] == 1) {
                        if (note[ystart + i][xstart + j] == 1) {
                            return false;
                        }
                    }
                }
            }
        }
        else if(spin==1) { // 90도
            for(int i=0; i<C[stiNum]; i++) {
                for(int j=R[stiNum]-1; j>=0; j--) {
                    if(sticker[stiNum][j][i] == 1) {
                        if(note[ystart + i][xstart + R[stiNum]-1-j] == 1) {
                            return false;
                        }
                    }
                }
            }
        }
        else if(spin==2) { // 180도
            for(int i=R[stiNum]-1; i>=0; i--) {
                for(int j=C[stiNum]-1; j>=0; j--) {
                    if(sticker[stiNum][i][j] == 1) {
                        if(note[ystart + R[stiNum]-1-i][xstart + C[stiNum]-1-j] == 1) {
                            return false;
                        }
                    }
                }
            }
        }
        else if(spin==3) { // 270도
            for(int i=C[stiNum]-1; i>=0; i--) {
                for(int j=0; j<R[stiNum]; j++) {
                    if(sticker[stiNum][j][i] == 1) {
                        if(note[ystart + C[stiNum]-i-1][xstart + j] == 1) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void update(int spin, int[][] note, int ystart, int xstart, int stiNum){
        if(spin==0) {
            for(int i=0; i<R[stiNum]; i++){
                for(int j=0; j<C[stiNum]; j++){
                    if(note[ystart+i][xstart+j]==0)
                        note[ystart+i][xstart+j] = sticker[stiNum][i][j];
                }
            }
        }
        else if(spin==1) {
            for(int i=0; i<C[stiNum]; i++) {
                for(int j=R[stiNum]-1; j>=0; j--) {
                    if(note[ystart + i][xstart + R[stiNum]-1-j]==0)
                        note[ystart + i][xstart + R[stiNum]-1-j] = sticker[stiNum][j][i];
                }
            }
        }
        else if(spin==2) {
            for(int i=R[stiNum]-1; i>=0; i--) {
                for(int j=C[stiNum]-1; j>=0; j--) {
                    if(note[ystart + R[stiNum]-1-i][xstart + C[stiNum]-1-j]==0)
                        note[ystart + R[stiNum]-1-i][xstart + C[stiNum]-1-j] = sticker[stiNum][i][j];
                }
            }
        }
        else if(spin==3) {
            for(int i=C[stiNum]-1; i>=0; i--) {
                for(int j=0; j<R[stiNum]; j++) {
                    if(note[ystart+C[stiNum]-1-i][xstart + j]==0)
                        note[ystart+C[stiNum]-1-i][xstart + j] = sticker[stiNum][j][i];
                }
            }
        }

    }

    public static void search(int stiNum, int[][] note){

        if(stiNum==K){
            long count = Arrays.stream(note).flatMapToInt(Arrays::stream).filter(num -> num == 1).count();
            if(max<count){
                max = count;
            }
            //max = Math.max(max, count);
            return;
        }
        int[][] tmp = new int[note.length][note[0].length];

        for(int i=0; i<note.length; i++){
            tmp[i] = note[i].clone();
        }

        for(int i=0; i<4; i++) { // 0도 90도 180도 270도
            if(i%2==0) { // 0도 180도
                for (int ystart = 0; ystart <= N - R[stiNum]; ystart++) {
                    for (int xstart = 0; xstart <= M - C[stiNum]; xstart++) {
                        if (check(i, tmp, ystart, xstart, stiNum)) {
                            update(i, tmp, ystart, xstart, stiNum);
                            search(stiNum + 1, tmp);
                            return;
                        }
                    }
                }
            }
            else{ // 90도 270도
                for (int ystart = 0; ystart <= N - C[stiNum]; ystart++) {
                    for (int xstart = 0; xstart <= M - R[stiNum]; xstart++) {
                        if (check(i, tmp, ystart, xstart, stiNum)) {
                            update(i, tmp, ystart, xstart, stiNum);
                            search(stiNum + 1, tmp);
                            return;
                        }
                    }
                }
            }
        }
        search(stiNum + 1, note);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[][] note = new int[N][M];
        sticker = new int[K][10][10];
        R = new int[K]; C = new int[K];

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            R[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());

            for(int j = 0; j<R[i]; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k<C[i]; k++){
                    sticker[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        search(0, note);

        System.out.println(max);

    }

}
