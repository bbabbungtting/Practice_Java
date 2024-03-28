import java.util.*;
// 1279
// 1. 0~k 중에서 최댓값고르기
// 2. 최댓값 기준으로 그 뒤에꺼만 저장
// 3. k--;
// 4. 최댓값 index+1 ~K중에서 최댓값 고르기
// 5. k가 0이 될때까지 반복
class Solution {
    public String solution(String number, int k) {
        int length = number.length();
        int m = length - k;
        StringBuilder answer = new StringBuilder();
        int start = 0;
        
        for (int i = 0; i < m; i++) {
            int maxIndex = start;
            char maxDigit = number.charAt(start);

            for (int j = start; j <= k + i; j++) {
                if (number.charAt(j) > maxDigit) {
                    maxDigit = number.charAt(j);
                    maxIndex = j;
                }
            }
            
            answer.append(maxDigit);
            start = maxIndex + 1;
        }
        
        return answer.toString();
    }
}
