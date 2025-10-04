package BFS.Week4_PJM.BOJ_9466;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
  static final int NOVISIT = 0;
  static final int GROUPED=-1;

  public static int BFS(int num, int[] select){
    int prev;
    int answer = 0;
    int[] visited = new int[num+1]; // 방문되지 않은 경우 NOVISIT(0), 그룹되어 있을 경우 (-1)

    for(int i=1;i<=num;i++){
      if(visited[i] != NOVISIT){ // 0이 아닐 경우에는 이미 확인 했기 때문에 넘어가기
        continue;
      }
      prev = i; // i가 시작점
      while(true){
        if(visited[prev]!=NOVISIT){ // 방문했던 경우일 경우에는 확인 해봐야 함.
          while(visited[prev]!= GROUPED && visited[prev]==i){ // 그룹되어 있지 않고, 방문한 곳이 i 경로일 경우에만
            visited[prev] = GROUPED; // 싸이클 확정 시키고
            prev = select[prev]; // 사이클을 따라 회전
          }
          break;
        }
        visited[prev] = i;
        prev = select[prev];
      }
    }

    for(int i=1;i<=num;i++){ // 그룹되어 있지 않은 인원수 세는 로직
      if(visited[i]!=GROUPED){
        answer++;
      }
    }
    return answer;
  }
  public static void main(String[] args) throws IOException{
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int Testcase = Integer.parseInt(br.readLine());
    int num;
    int[] select;
    int[] answerArr = new int[Testcase];

    for(int t=0;t<Testcase;t++){
      num = Integer.parseInt(br.readLine());
      select = new int[num+1];
      st=new StringTokenizer(br.readLine());
      for(int i=1;i<=num;i++){
        select[i] = Integer.parseInt(st.nextToken());
      }
      answerArr[t] = BFS(num,select);
    }
    for(int t=0;t<Testcase;t++){
      bw.write(answerArr[t]+"\n");
    }

    bw.flush();
    bw.close();
    br.close();
  }
}
