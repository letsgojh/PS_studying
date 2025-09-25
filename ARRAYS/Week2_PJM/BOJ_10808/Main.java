import java.io.*;
public class Main {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String str = br.readLine();
    int[] arr = new int[26];
    for(int i=0;i<str.length();i++){
      arr[str.charAt(i)-'a']++;
    }
    for(int i =0;i<26;i++){
      bw.write(arr[i]+ " ");
    }


    br.close();
    bw.close();
  }
}
