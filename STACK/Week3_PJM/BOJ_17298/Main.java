import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];
    int[] answer = new int[N];
    Stack<Integer> stack = new Stack<Integer>();
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=0;i<N;i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }
    stack.push(0);
    for(int i=1;i<N;i++){
      if(arr[stack.peek()]<arr[i]){
        while(!stack.isEmpty() && arr[stack.peek()]<arr[i]){
          answer[stack.pop()]= arr[i];
        }
        stack.push(i);
      }
      else{
        stack.push(i);
      }
    }
    while(!stack.isEmpty()){
      answer[stack.pop()]=-1;
    }
    for(int i=0;i<N;i++){
      bw.write(answer[i]+" ");
    }
    br.close();
    bw.flush();
    bw.close();
  }
}
