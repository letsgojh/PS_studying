package BFS.Week6_PJM.BOJ_13549;
import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static final int MAX = 100000;
  public static final int PLUS =0;
  public static final int MINUS = 1;
  public static final int MULT = 2;
  
  public static int BFS(int N, int K){
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    int[] number=new int[MAX+1];
    int[] positionArr = new int[3];
    int position;
    int min = MAX;
    Arrays.fill(number,MAX);

    queue.add(N);
    number[N] = 0;
    while(!queue.isEmpty()){
      position = queue.poll();
      if(position==K){
        if(number[position]<min){
          min = number[position];
        }
      }
      positionArr[PLUS] = position+1;
      positionArr[MINUS]= position-1;
      positionArr[MULT] = position*2;
      
      if(number[position]<positionArr[MULT] && positionArr[MULT]<=MAX){
        queue.add(positionArr[MULT]);
        number[positionArr[MULT]]=number[position];
      }
      for(int i=PLUS;i<=MINUS;i++){
        if(positionArr[i]<0){
          continue;
        }
        if(positionArr[i]>MAX){
          continue;
        }
        if(number[positionArr[i]]>number[position]+1){
          queue.add(positionArr[i]);
          number[positionArr[i]]= number[position]+1;
        }
      }
    }
    return min;
  }
  public static void main(String[] args) throws IOException {
    BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    bw.write(BFS(N,K)+"");

    bw.flush();
    bw.close();
    br.close();
  }
}
