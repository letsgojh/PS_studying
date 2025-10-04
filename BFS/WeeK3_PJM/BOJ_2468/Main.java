import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

  public static int[]drow ={1,0,-1,0};
  public static int[]dcol ={0,1,0,-1};
  public static int BFS(int N, int[][] map){
    int count =0;
    int tem,temR,temC;
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    boolean[][] visited = new boolean[N][N];
    for(int i=0;i<N;i++){
      for(int j=0;j<N;j++){
        if(map[i][j]>0){
          visited[i][j] = true;
        }
      }
    }
    for(int i=0;i<N;i++){
      for(int j=0;j<N;j++){
        if(visited[i][j]){
          count++;
          queue.add(i*N+j);
          visited[i][j] = false;
          while(!queue.isEmpty()){
            tem=queue.poll();
            temR = tem/N;
            temC = tem%N;
            for(int d=0;d<4;d++){
              if(temR+drow[d]<0) continue;
              if(temR+drow[d]>=N) continue;
              if(temC+dcol[d]<0) continue;
              if(temC+dcol[d]>=N) continue;
              if(visited[temR+drow[d]][temC+dcol[d]]){
                visited[temR+drow[d]][temC+dcol[d]]=false;
                queue.add((temR+drow[d])*N+temC+dcol[d]);
              }
            }
          }
        }
      }
    }
    return count;
  }
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());
    int[][] map = new int[N][N];
    StringTokenizer st;
    int max = 1;
    int tem;
    for(int i=0;i<N;i++){
      st=new StringTokenizer(br.readLine());
      for(int j=0;j<N;j++){
        tem= Integer.parseInt(st.nextToken());
        map[i][j] = tem;
      }
    }
    for(int i=2;i<=100;i++){
      for(int row=0;row<N;row++){
        for(int col=0;col<N;col++){
          if(map[row][col]<i){
            map[row][col] =-1;
          }
        }
      }
      tem = BFS(N,map);
      if(tem>=max){
        max = tem;
      }
    }
    bw.write(max+"");
    bw.flush();

    br.close();
    bw.close();
    
  }
}
