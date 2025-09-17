import java.io.*;

public class Main{
  public static void main (String args[])throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  
    int score = Integer.parseInt(br.readLine());
    char answer;
    if(score>=90){
      answer = 'A';
    }else if(score>=80){
      answer='B';
    }else if(score>=70){
      answer ='C';
    }else if(score>=60){
      answer = 'D';
    }else{
      answer ='F';
    }
    bw.write(answer);
    br.close();
    bw.close();
  }

}
