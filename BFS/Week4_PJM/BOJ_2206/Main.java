import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public static final int MAX = 1000001;
  /**
   * Queue에 집어 넣을 구조
   * x: x좌표
   * y: y좌표
   * crack: 부순 적 있는지 없는지 확인(0: 부순적없음, 1: 부순적있음)
   * num: 이동거리
   */
  public static class node{
    int crack;
    int y;
    int x;
    int num;
    public node(int y, int x, int crack, int num){
      this.y = y;
      this.x = x;
      this.crack = crack;
      this.num = num;
    }
  }
  /**
   * 해당 인덱스 확인 하는 함수
   */
  public static boolean isInMap(int row, int col, int prevX,int prevY){
    if(prevX<0) {
      return false;
    }
    if(prevY<0){
      return false;
    }
    if(prevX>=col) {
      return false;
    }
    if(prevY>=row) {
      return false;
    }
    return true;
  }
  /*
   * 실제 알고리즘 논리
   */
  public static int BFS(int row, int col, String[] maps){
    node start = new node(0, 0, 0,1);
    boolean[][][] visited = new boolean[row][col][2];
    Queue<node> queue = new LinkedList<>();
    int[] dx = {1,0,-1,0};
    int[] dy={0,1,0,-1};
    node prevnode;
    int prevX,prevY;
    int isCracked;
    int min =MAX;
    queue.add(start);
    
    while(!queue.isEmpty()){
      prevnode = queue.poll();
      if(prevnode.x==col-1 && prevnode.y==row-1){ // 도착시 최소값인지 확인하는 코드
        if(min>prevnode.num){
          min = prevnode.num;
          continue;
        }
      }

      for(int i=0;i<4;i++){
        prevX=prevnode.x+dx[i];
        prevY=prevnode.y+dy[i];
        isCracked = prevnode.crack;
        if(isInMap(row,col,prevX,prevY) && !visited[prevY][prevX][isCracked]){
          if(maps[prevY].charAt(prevX)=='1' && isCracked==0){
            visited[prevY][prevX][isCracked] = true;
            queue.add(new node(prevY,prevX,1,prevnode.num+1));
          }
          if(maps[prevY].charAt(prevX)=='0'){
            visited[prevY][prevX][isCracked] = true;
            queue.add(new node(prevY,prevX,isCracked,prevnode.num+1));
          }
        }
      }
    }
    return min;
  }
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int row = Integer.parseInt(st.nextToken());
    int col = Integer.parseInt(st.nextToken());
    String[] maps= new String[row+1];
    int answer =0;

    for(int i=0;i<row;i++){
      maps[i]=br.readLine();
    }
    answer=  BFS(row,col,maps);
    if(answer==MAX){ // 도착 못 할시에 MAX값 출력되게 되어 있음.
      bw.write("-1");
    }else{
      bw.write(answer+"");
    }
    bw.flush();
    br.close();
    bw.close();

  }
}
