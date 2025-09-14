package BFS.Week2_YJH.BOJ_1697.src;

import java.util.Scanner;
import java.util.Queue;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {


    static Queue<Integer> queue = new LinkedList<>();
    static int location_old;
    static int location_young;
    static int[] location = new int[100001];

    static void bfs(){

        while(!queue.isEmpty()){
            int tmp = queue.poll();
            //System.out.println(tmp);

            if(tmp > 100000 || tmp < 0) continue;
            if(tmp == location_old){
                return;
            }

            if(tmp-1 >=0&&location[tmp-1] == 0){
                location[tmp-1] = location[tmp]+1;
                queue.add(tmp-1);

            }
            if(tmp+1<=100000&&location[tmp+1] == 0){
            location[tmp+1] = location[tmp]+1;
            queue.add(tmp+1);

            }

            if(tmp*2<=100000&&location[tmp*2] == 0){
            location[tmp*2] = location[tmp]+1;
            queue.add(tmp*2);

            }
        }
    }
    

    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);

        Arrays.fill(location, 0); //전부 0으로 초기화
        
        location_young = keyboard.nextInt();
        location_old = keyboard.nextInt();

        
        queue.add(location_young);

        bfs();

        System.out.print(location[location_old]);

    }
}
