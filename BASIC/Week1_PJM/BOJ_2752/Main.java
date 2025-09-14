import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;
public class Main {
  static final int SIZE = 3;
  public static void main(String args[]) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] arr = new int[3];
    for(int i=0;i<SIZE;i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr);
    for(int i=0;i<SIZE;i++){
      bw.write(arr[i]+" ");
    }

    br.close();
    bw.close();
  }
}
