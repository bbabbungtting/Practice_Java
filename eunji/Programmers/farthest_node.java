//가장 먼 노드
// 인접리스트로 변환 후 bfs 탐색하기
import java.util.*;
import java.awt.*;

class Solution {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] count;
    static int max = 0;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        count = new int[n+1];
        for(int i=0; i<=n; i++)
            graph.add(new ArrayList<>());
        for(int i=0; i< edge.length; i++){
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }
        bfs(1,1);
        for(int i=1; i<=n; i++){
            if(max == count[i]){
                answer +=1;
            }
        }
        return answer;
    }
    public static void bfs(int start, int cnt){
        Queue<Point> q = new LinkedList();
        count[start] = cnt;
        q.add(new Point(start,cnt));
        while(!q.isEmpty()){
            Point p = q.poll();
            int node = p.x;
            int n = p.y;
            if(max < n) max = n;
            for(int i=0; i<graph.get(node).size();i++){
                int next = graph.get(node).get(i);
                if(count[next]!=0) continue; //방문했으면 pass
                count[next] = n+1;
                q.add(new Point(next,n+1));
            }
        }
    }
}
