package BFS.Week6_YJH.BOJ_9466;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static int[] graph; //학생이 선택한 학생 번호(입력 받은 값)
    static int[] state; //학생의 현재 상태

    public static void search(int index){
        int cur = index;
        while(true){
            state[cur] = index; //몇번cycle인지 현재 탐색 index로 표시 ex)1번사이클
            cur = graph[cur]; //이동

            if(state[cur] == index){ //cycle 발견
                while(state[cur] != -1){ //cycle 형성 -1로 표시
                    state[cur] = -1;
                    cur = graph[cur];
                }
                return;
            }else if(state[cur] != 0) return;//이전 탐색에서 방문한 노드 or 처리된 노드
        }
    }

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());
            int ans = 0;

            graph = new int[number+1]; //1번 인덱스부터 시작
            state = new int[number+1];

            String[] li = br.readLine().split(" ");

            for (int j = 1; j <= number; j++) {
                graph[j] = Integer.parseInt(li[j-1]);
            }

            for (int j = 1; j <= number ; j++) {
                if(state[j] == 0) search(j); //방문안했다면 search
            }

            for (int j = 1; j <= number; j++) {
                if(state[j] != -1) ans++;
            }

            bw.write(Integer.toString(ans)+"\n");
            bw.flush();
        }
    }

}
