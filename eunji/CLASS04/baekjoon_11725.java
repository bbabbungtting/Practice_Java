package baekjoon11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//트리의 부모 찾기
public class baekjoon_11725 {
    private static int N;
    private static int[] parent;
    private static boolean[] visited;
    private static List<List<Integer>> nodeList = new ArrayList<>();
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        for(int i = 0; i<=N; i++){
            nodeList.add(new ArrayList<Integer>());
        }
        visited = new boolean[N+1];
        for(int i = 0; i<N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            // 인접리스트로 구현 후 1 찾기
            nodeList.get(node1).add(node2);
            nodeList.get(node2).add(node1);
        }
        bfs(1);
        for(int i = 2; i<=N; i++){
            System.out.println(parent[i]);
        }
    }
    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        visited[1] = true;
        q.add(1);
        while (!q.isEmpty()){
            int pNode = q.poll();
            List<Integer> childList = nodeList.get(pNode);
            for(Integer child:childList){
                if(!visited[child]){
                    visited[child] = true;
                    parent[child] = pNode;
                    q.add(child);
                }
            }
        }
    }

}
