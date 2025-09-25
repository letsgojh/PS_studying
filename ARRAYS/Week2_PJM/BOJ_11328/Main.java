import java.io.*;
import java.util.StringTokenizer;
public class Main {

  public static boolean check(String a, String b){
    int aSize = a.length(), bSize=b.length();
    int[] ArrA = new int[26];
    int[] ArrB = new int[26];
    if(aSize!=bSize){
      return false;
    }
    for(int i=0;i<aSize;i++){
      ArrA[a.charAt(i)-'a']++;
      ArrB[b.charAt(i)-'a']++;
    }
    for(int i=0;i<26;i++){
      if(ArrA[i]!=ArrB[i]){
        return false;
      }
    }
    return true;
  }
  public static void main(String[] args) throws Exception{
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());
    for(int i=0;i<N;i++){
      st = new StringTokenizer(br.readLine());
      if(check(st.nextToken(),st.nextToken())){
        bw.write("Possible\n");
      }else{
        bw.write("Impossible\n");
      }
    }




    bw.close();
    br.close();
  }
}
