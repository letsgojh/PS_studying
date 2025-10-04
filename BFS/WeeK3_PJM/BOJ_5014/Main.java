import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public static String BFS(int F, int start, int finish, int up, int down,int[] count){
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(start);
    int num;
    int now;
    count[start] = 0;
    while(!queue.isEmpty()){
      now = queue.poll();
      if(now == finish){
        return new String(count[finish] + "");
      }
      num = count[now];
      if(now+up<=F && count[now+up]==-1){
        queue.offer(now+up);
        count[now+up] = num+1;
      }
      if(now-down>=1 && count[now-down]==-1) {
        queue.offer(now-down);
        count[now-down] = num+1;;
      }
    }

    return new String("use the stairs");
  }
  
  public static void main(String[] args) throws IOException{
    BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int F = Integer.parseInt(st.nextToken());
    int start= Integer.parseInt(st.nextToken());
    int finish = Integer.parseInt(st.nextToken());
    int up = Integer.parseInt(st.nextToken());
    int down = Integer.parseInt(st.nextToken());

    int count[] = new int[F+1];
    Arrays.fill(count,-1);
    count[0] = 0;

    bw.write(BFS(F,start,finish,up,down,count));

    br.close();
    bw.flush();
    bw.close();
  }
}
