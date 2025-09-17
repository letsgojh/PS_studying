import java.io.*;

public class Main {
  public static void main(String args[]) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    String[] arr = br.readLine().split(" ");
    int a = Integer.parseInt(arr[0]);
    int b = Integer.parseInt(arr[1]);
    System.out.println(a+b);
    System.out.println(a-b);
    System.out.println(a*b);
    System.out.println(a/b);
    System.out.println(a%b);
    
  }
}
