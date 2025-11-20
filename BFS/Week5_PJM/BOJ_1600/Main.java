package BFS.Week5_PJM.BOJ_1600;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public static final int MAX = 1000001;
  public static class Node{
    int horse;
    int y;
    int x;
    int num;
    public Node(int x, int y, int horse, int num){
      this.y = y;
      this.x = x;
      this.horse = horse;
      this.num = num;
    }
  }
  public static int BFS(int K, int W, int H, boolean[][] maps){
    int min =MAX;
    Node start = new Node(0,0,0,0);
    boolean[][][] visited = new boolean[K+1][H][W];
    int[] dx = {1,0,-1,0};
    int[] dy={0,1,0,-1};
    int[] hx={2,2,-2,-2,1,1,-1,-1};
    int[] hy={1,-1,1,-1,2,-2,2,-2};
    Queue<Node> queue = new LinkedList<>();
    Node prevnode;
    for(int k =0;k<=K;k++){
      for(int i=0;i<H;i++){
        for(int j=0;j<W;j++){
          visited[k][i][j] = maps[i][j];
        }
      }
    }
    int prevX,prevY;
    queue.add(start);

    while(!queue.isEmpty()){
      prevnode = queue.poll();
      prevX = prevnode.x;
      prevY =prevnode.y;
      if(prevX == W-1 && prevY == H-1){
        if(min>prevnode.num){
          min = prevnode.num;
        }
      }
      if(prevnode.horse<K){
        for(int h=0;h<8;h++){
          if(isInMap(W, H, prevX+hx[h], prevY+hy[h]) && visited[prevnode.horse+1][prevY+hy[h]][prevX+hx[h]]){
            queue.add(new Node(prevX+hx[h],prevY+hy[h],prevnode.horse+1,prevnode.num+1));
            visited[prevnode.horse+1][prevY+hy[h]][prevX+hx[h]] = false;
          }
        }
      }
      for(int d=0;d<4;d++){
        if(isInMap(W, H, prevX+dx[d], prevY+dy[d]) && visited[prevnode.horse][prevY+dy[d]][prevX+dx[d]]){
          queue.add(new Node(prevX+dx[d],prevY+dy[d],prevnode.horse,prevnode.num+1));
          visited[prevnode.horse][prevY+dy[d]][prevX+dx[d]] = false;
        }
      }
    }

    return min;
  }

  public static boolean isInMap(int X, int Y, int prevX,int prevY){
    if(prevX<0) {
      return false;
    }
    if(prevY<0){
      return false;
    }
    if(prevX>=X) {
      return false;
    }
    if(prevY>=Y) {
      return false;
    }
    return true;
  }
  public static void main(String[] args) throws IOException {
    BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int Min = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    int W = Integer.parseInt(st.nextToken());
    int H = Integer.parseInt(st.nextToken());
    boolean[][] maps = new boolean[H][W];
    int answer;
    for(int i=0;i<H;i++){
      st= new StringTokenizer(br.readLine());
      for(int j=0;j<W;j++){
        if(Integer.parseInt(st.nextToken())==1){
          maps[i][j] = false;
        }
        else{
          maps[i][j] = true;
        }
      }
    }
  
    answer = BFS(Min,W,H,maps);
    if(answer==MAX){
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
