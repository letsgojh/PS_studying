import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    long[] arr = new long[N];
    long[] answer = new long[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    Stack<Integer> indexBuffer = new Stack<Integer>();
    indexBuffer.push(N-1); // (2)
    for(int i=0;i<N;i++){
      arr[i] = Long.parseLong(st.nextToken());
    }
    for(int i=N-2;i>=0;i--){
      if(arr[indexBuffer.peek()]>arr[i]){// (3)
        indexBuffer.push(i);
        continue;
      }else{
        while(!indexBuffer.isEmpty()&&arr[indexBuffer.peek()]<=arr[i]){ // (4)
          answer[indexBuffer.pop()] = i+1;
        }
        indexBuffer.push(i);
      }
    }
    for(int i=0;i<N;i++){
      bw.write(answer[i]+" ");
    }

    bw.flush();
    br.close();
    bw.close();
  }
}
