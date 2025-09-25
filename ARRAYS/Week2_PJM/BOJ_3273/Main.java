import java.io.*;
import java.util.Arrays;
public class Main {
  public static void main(String[] args) throws Exception{
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int N = Integer.parseInt(br.readLine());
    String[] arr = (br.readLine()).split(" ");
    int X = Integer.parseInt(br.readLine());
    int[] intArr= new int[N];
    int answer =0;
    int i=0,j=N-1;
    for(i=0;i<N;i++){
      intArr[i] = Integer.parseInt(arr[i]);
    }
    Arrays.sort(intArr);
    i=0;
    while(i<j){
      if(intArr[i]+intArr[j]==X){
        answer++;
        i++;
        j--;
      }else if(intArr[i]+intArr[j]<X){
        i++;
      }else{
        j--;
      }
    }
    bw.write(answer+"");


    bw.close();
    br.close();
  }
}
