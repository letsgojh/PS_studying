import java.io.*;
public class Main {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    long answer=1;
    int[] arr= new int [10];
    answer *= Integer.parseInt(br.readLine());
    answer *= Integer.parseInt(br.readLine());
    answer *= Integer.parseInt(br.readLine());
    while(answer !=0){
      arr[ (int) (answer%10) ]++;
      answer/=10;
    }
    for(int i=0;i<10;i++){
      bw.write(arr[i] + "\n");
    }


    br.close();
    bw.close();

  }
}
