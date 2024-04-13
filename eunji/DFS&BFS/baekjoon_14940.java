// 쉬운 최단거리 - 실버 1
// N과 M을 입력받고
// 지도로 0,1,2로 입력받는데 2위치로부터 나머지 좌표들의 거리를 다 출력
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//BFS 이용하기
//2 위치를 시작으로 방문안한 지점 (상하좌우) 거리 +1씩 하며 다 돌때까지 움직이기
public class baekjoon_14940 {
    static int N,M;
    static int[][] map,answer;
    static boolean [][] visited;
    static Point start = new Point();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map= new int[N][M];
        answer = new int[N][M];
        visited = new boolean[N][M];
        //map 입력받기
        for(int i =0; i<N;i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<M;j++){
                map[i][j] = Integer.parseInt(st1.nextToken());
                if(map[i][j]==2){
                    start.x = i;
                    start.y = j;
                }else if(map[i][j]==0){
                    visited[i][j] = true;
                }
            }
        }
        bfs(start.x,start.y);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N;i++){
            for(int j=0; j<M-1; j++){
                sb.append(answer[i][j]).append(" ");
            }
            sb.append(answer[i][M-1]).append("\n");
        }
        System.out.print(sb);
    }
    static void bfs(int x,int y){
        int[] dx ={-1,0,1,0};
        int[] dy = {0,-1,0,1};
        Queue<Point> q = new LinkedList<>();
        visited[x][y] =true;
        answer[x][y] = 0;
        q.add(new Point(x,y));
        while (!q.isEmpty()){
            Point now = q.poll();
            for(int i=0; i<4; i++){
                int nx = now.x+dx[i];
                int ny = now.y+dy[i];
                if(nx<0||ny<0||nx>=N||ny>=M)
                    continue;
                if(!visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.add(new Point(nx,ny));
                    answer[nx][ny] = answer[now.x][now.y]+1;
                }
            }
        }
        // 도달 못한애들 찾기 -> 방문 false인 애들
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!visited[i][j]){
                    answer[i][j] = -1;
                }
            }
        }
    }
}
