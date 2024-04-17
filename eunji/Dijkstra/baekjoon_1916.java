import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baekjoon_1916 {
    static final int INF = Integer.MAX_VALUE;
    static int N,M,start,end;
    static int[] distance;
    static boolean[] visited;
    static PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
    static ArrayList<Edge>[] graph;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        distance = new int[N+1];
        visited = new boolean[N+1];
        graph = new ArrayList[N+1];
        Arrays.fill(distance, INF);
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v,w));
        }

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st1.nextToken());
        end = Integer.parseInt(st1.nextToken());
        distance[start] = 0;
        pq.add(new Edge(start, 0));
        while (!pq.isEmpty()){
            Edge now = pq.poll();
            if(visited[now.x]){
                continue;
            }
            visited[now.x] = true;
            for(int j = 0; j<graph[now.x].size(); j++){
                Edge target = graph[now.x].get(j);
                if(distance[target.x] > (distance[now.x]+target.y)){
                    distance[target.x] = distance[now.x]+target.y;
                    pq.add(new Edge(target.x,distance[target.x]));
                }
            }
        }
        System.out.println(distance[end]);
    }
     static class Edge implements Comparable<Edge>{

        private int x,y;

         public Edge(int x, int y) {
             this.x = x;
             this.y = y;
         }

         @Override
         public int compareTo(Edge e){
            return (y>e.y)? 1 : -1;
        }
     }
}
