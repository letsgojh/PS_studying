package BFS.Week4_PJM.BOJ_2573;
import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

  static int[] dx={0,1,0,-1};
  static int[] dy={1,0,-1,0};

  public static boolean checkMap(int x,int y, int N,int M){
    if(x<0){
      return false;
    }
    if(x>=M){
      return false;
    }
    if(y<0){
      return false;
    }
    if(y>=N){
      return false;
    }
    return true;
  }

  public static void meltIce(int[][]maps,int N,int M){
    int prevX,prevY;
    int count;
    int[][] minus = new int[N][M];
    for(int i=0;i<N;i++){
      for(int j=0;j<M;j++){
        if(maps[i][j]<1){
          continue;
        }
        count=0;
        for(int position = 0;position<4;position++){
          prevX = j+dx[position];
          prevY= i+dy[position];
          if(checkMap(prevX, prevY, N, M)&&maps[prevY][prevX]<1){
            count++;
          }
        }
        minus[i][j] =count;
      }
    }
    for(int i=0;i<N;i++){
      for(int j=0;j<M;j++){
        if(minus[i][j]==0){
          continue;
        }
        if(maps[i][j]-minus[i][j]<0){
          maps[i][j] = 0;
        }
        else{
          maps[i][j] -= minus[i][j];
        }
      }
    }
  }
  public static int BFS(int[][]maps,int N,int M){
    int count =0;
    int prev,prevX=0,prevY=0,nextX,nextY;
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    boolean[][] visited = new boolean[N][M];

    for(int i=0;i<N;i++){
      for(int j=0;j<M;j++){
        if(maps[i][j]==0|| visited[i][j]){
          continue;
        }
        count++;
        visited[i][j] = true;
        queue.add(i*M+j);
        while(!queue.isEmpty()){
          prev = queue.poll();
          prevY = prev/M;
          prevX = prev%M;
          for(int position=0;position<4;position++){
            nextX =prevX+dx[position];
            nextY =prevY+dy[position];
            if(checkMap(nextX,nextY,N,M) && !visited[nextY][nextX] && maps[nextY][nextX]!=0){
              queue.add(nextY*M+nextX);
              visited[nextY][nextX]= true;
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
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[][] maps = new int[N][M];
    int year =0;
    int answer=0;
    int bfsCount =0;
    for(int i=0;i<N;i++){
      st= new StringTokenizer(br.readLine());
      for(int j=0;j<M;j++){
        maps[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    while(true){
      year++;
      meltIce(maps, N, M);
      bfsCount=BFS(maps,N,M);
      if(bfsCount==0){
        answer=0;
        break;
      }
      if(bfsCount>1){
        answer = year;
        break;
      }
    }
    

    bw.write(answer+"");


    bw.flush();
    br.close();
    bw.close();
    
  }
}
