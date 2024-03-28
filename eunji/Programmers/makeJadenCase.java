//프로그래머스 JadenCase 문자열 만들기
import java.util.*;

class Solution {
    public String solution(String s) {
        String answer;
        int count = 0;
        String[] words = s.split(" ");
        if(s.charAt(s.length()-1)==' '){
            for(int i=s.length()-1; i>=0; i--){
                if(s.charAt(i)!=' ')
                    break;
                count++;
            }
        }
        StringJoiner sj = new StringJoiner(" ");
        for(String word : words){ 
            if(!word.equals("")){
                String first = word.substring(0,1).toUpperCase();
                String remain = word.substring(1).toLowerCase();
                String jaden = first+remain;
                sj.add(jaden);
            }else{
                sj.add("");
            }
            
        } 

        answer = sj.toString();
        for(int i=0; i<count; i++){
            answer+=" ";
        }
        return answer;
    }
}
