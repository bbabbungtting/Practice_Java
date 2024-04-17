import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class baekjoon_15650 {
    //재귀로 풀어야할 것 같은데.... -> 재귀를 이용한 백트래캉
    // 백트래킹 재귀 공부해야할듯
    static int N,M;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = new int[M];
        dfs(1,0);
        System.out.println(sb);

    }
    public static void dfs(int at, int depth){

        if(depth==M){
            for(int val : answer){
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i= at; i <=N; i++){
            answer[depth] = i;
            dfs(i+1,depth+1);
        }
    }
}
