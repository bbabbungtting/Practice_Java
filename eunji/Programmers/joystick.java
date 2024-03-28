//조이스틱
// 알파벳은 26
// 알파벳이 14이상이면 27-i 아래로 일단 얘네의 합을 더하고 양옆 계산 따로 더해주기
// 1 0 1 0 0 1 0 0 0 0 0 1 0 1 0 연속된 0의 개수? 5 < 전체 14개
// 5 + 4 + 4 
// 1. 제일 긴 연속된 0 의 개수 (앞 덩어리 개수 -1)+ (전체 개수 - 연속된 0의 개수) 
// 2. 전체 개수 - 뒤에서 연속된 0의 개수
import java.util.Arrays;
class Solution {
    public int solution(String name) {
        int answer = 0;
        int move = name.length() - 1; // 오른쪽으로 쭉 간 횟수
        
        for(int i = 0; i < name.length(); i++) {
            answer += Math.min(name.charAt(i) - 'A', 26 - (name.charAt(i) - 'A')); //상,하 알파벳 맞추기
            if (i < name.length() - 1 && name.charAt(i + 1) == 'A') {
                int endA = i + 1;
                while(endA < name.length() && name.charAt(endA) == 'A')
                    endA++;
                move = Math.min(move, i * 2 + (name.length() - endA));// 오른쪽으로 갔다 다시 왼쪽으로 꺾기
                move = Math.min(move, i + (name.length() - endA) * 2);// 왼쪽으로 갔다 다시 오른쪽으로 꺾기
            }
        }
        return answer + move;
    }
}
