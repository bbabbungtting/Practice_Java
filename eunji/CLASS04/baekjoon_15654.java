//N과 M (5)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//N과 M (5)
public class baekjoon_15654 {
    static int N,M;
    static int[] nArr;
    static int[] answer;
    static boolean[] isVisited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nArr = new int[N];
        answer = new int[M];
        isVisited = new boolean[N];
        StringTokenizer st1 = new StringTokenizer(br.readLine()," ");
        for(int i = 0 ; i<N;i++){
            nArr[i] = Integer.parseInt(st1.nextToken());
        }
        Arrays.sort(nArr);
        dfs(0);
        System.out.println(sb);
    }
    static void dfs( int depth){
        if(depth==M){
            for(int val : answer){
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }
        for(int i= 0; i<N;i++){
            if(!isVisited[i]){
                isVisited[i]=true;
                answer[depth] = nArr[i];
                dfs(depth+1);
                isVisited[i]=false;
            }

        }
    }
}
