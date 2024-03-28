import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 11650번 좌표 정렬하기
public class silver5_11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int dotCount = Integer.parseInt(br.readLine());
        int[][] coordinate = new int[dotCount][2];
        for (int i = 0; i < dotCount; i++) {
            st = new StringTokenizer(br.readLine());
            coordinate[i][0] = Integer.parseInt(st.nextToken());
            coordinate[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(coordinate, (coordinate_1, coordinate_2) -> {
            if(coordinate_1[0] == coordinate_2[0]){
                return coordinate_1[1] - coordinate_2[1];
            }else{
                return coordinate_1[0] - coordinate_2[0];
            }
        });

//        for(int i = 0; i < coordinate.length; i++){
//            System.out.println(coordinate[i][0] + " " + coordinate[i][1]);
//        }
        for(int i = 0; i < coordinate.length; i++){
            sb.append(coordinate[i][0]).append(" ").append(coordinate[i][1]).append("\n");
        }
        System.out.println(sb);
    }
}
