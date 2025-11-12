import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
  int floor;
  int row;
  int col;
  public Node(int floor,int row, int col){
    this.floor = floor;
    this.row = row;
    this.col = col;
  }
}
public class Main {
  public static String BFS(String[][] companyMap, int floors, int rows,int columns,int startFloor,int startRow,int startCol,int finishFloor,int finishRow,int finishCol){
    int[][][] counts = new int[floors][rows][columns];
    int num=1;
    int curFloor,curRow,curCol;
    Queue<Node> queue = new LinkedList<Node>();
    Node curNode;
    StringBuilder sb = new StringBuilder();
    counts[startFloor][startRow][startCol] = num;
    queue.add(new Node(startFloor,startRow,startCol));
    while(!queue.isEmpty()){
      curNode = queue.poll();
      curFloor = curNode.floor;
      curRow = curNode.row;
      curCol=curNode.col;
      num = counts[curFloor][curRow][curCol];
      if(finishFloor == curFloor && finishRow == curRow&& finishCol == curCol){
        sb.append("Escaped in ");
        sb.append(Integer.toString(num-1));
        sb.append(" minute(s).");
        return sb.toString();
      }
      if(curFloor+1<floors &&companyMap[curFloor+1][curRow].charAt(curCol)!='#' &&counts[curFloor+1][curRow][curCol]==0){
        queue.add(new Node(curFloor+1, curRow, curCol));
        counts[curFloor+1][curRow][curCol]=num+1;
      }
      if(curFloor-1>=0 && companyMap[curFloor-1][curRow].charAt(curCol)!='#' &&counts[curFloor-1][curRow][curCol]==0){
        queue.add(new Node(curFloor-1, curRow, curCol));
        counts[curFloor-1][curRow][curCol]=num+1;
      }
      if(curRow+1<rows && companyMap[curFloor][curRow+1].charAt(curCol)!='#' &&counts[curFloor][curRow+1][curCol]==0){
        queue.add(new Node(curFloor, curRow+1, curCol));
        counts[curFloor][curRow+1][curCol]=num+1;
      }
      if(curRow-1>=0 && companyMap[curFloor][curRow-1].charAt(curCol)!='#' &&counts[curFloor][curRow-1][curCol]==0){
        queue.add(new Node(curFloor, curRow-1, curCol));
        counts[curFloor][curRow-1][curCol]=num+1;
      }
      if(curCol+1<columns && companyMap[curFloor][curRow].charAt(curCol+1)!='#' &&counts[curFloor][curRow][curCol+1]==0){
        queue.add(new Node(curFloor, curRow, curCol+1));
        counts[curFloor][curRow][curCol+1]=num+1;
      }
      if(curCol-1>=0 && companyMap[curFloor][curRow].charAt(curCol-1)!='#' &&counts[curFloor][curRow][curCol-1]==0){
        queue.add(new Node(curFloor, curRow, curCol-1));
        counts[curFloor][curRow][curCol-1]=num+1;
      }
    }
    sb.append("Trapped!");
    return sb.toString();
  }
  public static void main(String[] args) throws IOException{
    BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int floors ;
    int rows ;
    int columns;
    String[][] companyMap;
    int startFloor=0;
    int startRow=0;
    int startCol=0;
    int finishFloor=0;
    int finishRow=0;
    int finishCol=0;
    int temS,temF;
    while(true){
      StringTokenizer st = new StringTokenizer(br.readLine());
      floors=Integer.parseInt(st.nextToken());
      rows=Integer.parseInt(st.nextToken());
      columns=Integer.parseInt(st.nextToken());
      if(floors==0 && rows==0 && columns==0){
        break;
      }
      companyMap = new String [floors][rows];
      for(int i=0;i<floors;i++){
        for(int j=0;j<rows;j++){
          companyMap[i][j] = br.readLine();
          temS =companyMap[i][j].indexOf("S");
          if(temS !=-1){
            startFloor = i;
            startRow=j;
            startCol = temS;
          }
          temF =companyMap[i][j].indexOf("E");
          if(temF!=-1){
            finishFloor = i;
            finishRow=j;
            finishCol = temF;
          }
        }
        br.readLine();
      }
      bw.write(BFS(companyMap,floors,rows,columns,startFloor,startRow,startCol,finishFloor,finishRow,finishCol));
      bw.flush();
      bw.newLine();
    }
    br.close();
    bw.flush();
    bw.close();
    
  }
}
