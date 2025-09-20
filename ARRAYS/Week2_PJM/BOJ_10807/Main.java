import java.io.*;
import java.util.StringTokenizer;
public class Main {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int V = Integer.parseInt(br.readLine());
    int answer =0;
    while(st.hasMoreTokens()){
      if(Integer.parseInt(st.nextToken())==V){
        answer++;
      }
    }
    bw.write(answer+"");

    br.close();
    bw.close();
  }
}
