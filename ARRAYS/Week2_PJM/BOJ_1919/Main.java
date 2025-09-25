import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception{
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int[] arrA = new int[26];
    int[] arrB = new int[26];
    int answer = 0;
    String a = br.readLine();
    for(int i=0;i<a.length();i++){
      arrA[a.charAt(i)-'a']++;
    }
    a=br.readLine();
    for(int i=0;i<a.length();i++){
      arrB[a.charAt(i)-'a']++;
    }
    for(int i=0;i<26;i++){
      answer += Math.abs(arrA[i]-arrB[i]);
    }
    bw.write(answer+"");

    

    br.close();
    bw.close();
  }
}
