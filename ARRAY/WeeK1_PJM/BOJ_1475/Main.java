import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int tem = 0;
    int[] arr = new int [10];
    int N = Integer.parseInt(br.readLine());
    int answer = 0;
    while(N!=0){
      tem = N%10;
      if(tem ==6){
        arr[9]++;
      }
      else{
        arr[tem]++;
      }
      N/=10;
    }
    arr[9]+=1;
    arr[9]/=2;
    for(int i=0;i<=9;i++){
      if(arr[i]>answer){
        answer = arr[i];
      }
      
    }

    bw.write(answer+"\n");
    bw.flush();
    br.close();
    bw.close();
  }
}
