import java.io.*;
import java.util.StringTokenizer;
public class Main {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N =Integer.parseInt(st.nextToken());
    int K =Integer.parseInt(st.nextToken());
    int[] arr = new int[12];
    int a, b,answer=0;
    for(int i=0;i<N;i++){
      st=new StringTokenizer(br.readLine());
      a=Integer.parseInt(st.nextToken()); // 성별
      b=Integer.parseInt(st.nextToken()); // 학년
      arr[6*a+(b-1)]++; //0~5 여성 6~11 남성
    }
    for(int i=0;i<12;i++){
      answer+= (arr[i]/K)+(arr[i]%K==0?0:1); // 나머지가 있을 경우 방 1개를 더함
    }
    bw.write(answer+"");
    br.close();
    bw.close();
  

  }
}
