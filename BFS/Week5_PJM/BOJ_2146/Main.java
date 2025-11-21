package BFS.Week5_PJM.BOJ_2146;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 섬과 섬을 잇는 길 찾는 알고리즘
public class Main {
  public static final int MAX = 100001;
  public static class Node{
    int X;
    int Y;
    int num;
    public Node(int X, int Y){
      this.X = X;
      this.Y = Y;
    }
    public Node(int X, int Y, int num){
      this.X = X;
      this.Y = Y;
      this.num = num;
    }
  }
  public static boolean isInMap(int N, int prevX,int prevY){
    if(prevX<0) {
      return false;
    }
    if(prevY<0){
      return false;
    }
    if(prevX>=N) {
      return false;
    }
    if(prevY>=N) {
      return false;
    }
    return true;
  }
  public static int Numbering(int maps[][],int N){
    Queue<Node> queue = new LinkedList<>();
    boolean[][] visited = new boolean[N][N];
    Node start;
    Node prevNode;
    int number=1,prevX,prevY,sumX,sumY;
    int[] dx={0,0,1,-1};
    int[] dy={1,-1,0,0};
    
    for(int i=0;i<N;i++){
      for(int j=0;j<N;j++){
        if(!visited[i][j] && (maps[i][j] ==1)){
          queue.clear();
          number++;
          start=new Node(j,i);
          queue.add(start);
          visited[i][j] = true;
          while(!queue.isEmpty()){
            prevNode = queue.poll();
            prevX = prevNode.X;
            prevY= prevNode.Y;
            maps[prevY][prevX]= number;
            for(int d=0;d<4;d++){
              sumX = prevX+dx[d];
              sumY = prevY+dy[d];
              if((isInMap(N, sumX, sumY) && !visited[sumY][sumX]) && (maps[sumY][sumX]==1)){
                queue.add(new Node(sumX, sumY));
                visited[sumY][sumX] = true;
              }
            }
          }
        }
      }
    }
    return number;
  }
  public static int searchRoad(int N,int[][] maps,int MAXINDEX){
    boolean[][] visited ;
    Queue<Node> queue = new LinkedList<>();
    int prevX,prevY;
    Node prevNode;
    int min = MAX;
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    int nx,ny;
    for(int index = 2;index<=MAXINDEX;index++){
      visited= new boolean[N][N];
      for(int i=0;i<N;i++){
        for(int j=0;j<N;j++){
          if(maps[i][j]==index){
            visited[i][j] = true;
            queue.add(new Node(j, i,0));
          }
        }
      }

      while(!queue.isEmpty()){
        prevNode= queue.poll();
        prevX = prevNode.X;
        prevY = prevNode.Y;
        if(prevNode.num>=min){
          continue;
        }
        for(int d=0;d<4;d++){
          nx = prevX+dx[d];
          ny = prevY+ dy[d];
          if(isInMap(N, nx, ny) && !visited[ny][nx]){
            if(maps[ny][nx]==0){
              visited[ny][nx] = true;
              queue.add(new Node(nx, ny,prevNode.num+1));
            }
            else if(maps[ny][nx] == index){
              visited[ny][nx] = true;
              queue.add(new Node(nx, ny, prevNode.num));
            }
            else{
              if(min>prevNode.num){
                min=prevNode.num;
              }
            }
          }
        }
      }
    }
    return min;
  }

  public static void main(String[] args) throws IOException {
    BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());
    int answer=0;
    int[][] maps = new int[N][N];
    for(int i=0;i<N;i++){
      st = new StringTokenizer(br.readLine());
      for(int j=0;j<N;j++){
        maps[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    int MAXINDEX= Numbering(maps,N);
    answer = searchRoad(N,maps,MAXINDEX);

    if(answer == MAX){
      bw.write(-1+"");
    }
    else{
      bw.write(answer+"");
    }



    bw.flush();
    bw.close();
    br.close();
  }
}
