import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_2630 {
    static int N;
    static int[][] map;
    static  int white=0;
    static int blue=0;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i = 0; i< N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        partition(0,0,N);
        System.out.println(white);
        System.out.println(blue);
    }

    public static void partition(int row, int col, int size) {

        // 종료 조건
        if(colorCheck(row, col, size)) {
            if(map[row][col] == 0) {
                white++;
            }
            else {
                blue++;
            }
            return;
        }

        int newSize = size / 2;
        // 재귀 호출
        partition(row, col, newSize);
        partition(row, col + newSize, newSize);
        partition(row + newSize, col, newSize);
        partition(row + newSize, col + newSize, newSize);
    }


    // 구간에서 컬러들이 같은지 체크
    public static boolean colorCheck(int row, int col, int size) {

        int color = map[row][col];	// 첫 번째 원소 기준

        for(int i = row; i < row + size; i++) {
            for(int j = col; j < col + size; j++) {
                if(map[i][j] != color) {
                    return false;
                }
            }
        }
        // 검사 모두 통과시 true
        return true;
    }
}
