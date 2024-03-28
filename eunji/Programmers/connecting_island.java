// 섬 연결하기 
import java.util.*;

class Solution {
    static PriorityQueue<Node> q = new PriorityQueue<>();
    static int[] parent;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        for(int[] cost : costs){
            parent[cost[0]] = cost[0];
            parent[cost[1]] = cost[1];
            q.add(new Node(cost[0],cost[1],cost[2]));
        }
        List<Node> nodeList = new ArrayList<>();
        while(!q.isEmpty()){
            Node node = q.poll();
            int root1 = find(node.edge1);
            int root2 = find(node.edge2);
            
            if (root1 != root2) {
                union(root1,root2);
                answer += node.distance;
            }
        }
        return answer;
    }
    private void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x != y) {
            parent[y] = x;
        }
    }
    private int find(int x){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    
    static class Node implements Comparable<Node>{
        private int edge1,edge2,distance;
        public Node(int edge1,int edge2, int distance){
            this.edge1 = edge1;
            this.edge2 = edge2;
            this.distance = distance;
        }
        @Override
        public int compareTo(Node e){
            return (this.distance>e.distance)?1:-1;
        }
    }
}
