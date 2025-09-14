import java.io.*;
public class Main {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int year = Integer.parseInt(br.readLine());
    if(year%400==0){
      bw.write("1");
    }
    else if((year%100!=0) && (year%4==0)){
      bw.write("1");
    }
    else{
      bw.write("0");
    }
    br.close();
    bw.close();
  }
}
