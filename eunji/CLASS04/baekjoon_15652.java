//N과 M 4
// 1부터 N까지 자연수 중에서 M개를 고른 수열
// 같은 수를 여러 번 골라도 된다.
// 고른 수열은 비내림차순이어야 한다.= 같거나 오름차순
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_15652 {
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
            dfs(i,depth+1);
        }
    }
}
