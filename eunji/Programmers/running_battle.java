// 달리기 경주
// indexOf를반복적으로 찾으면 시간 초과가 날 수 있다
// -> hashmap으로 index 접근
import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        for (String calling : callings) {
            int nowIndex = map.get(calling);
            String nowValue = players[nowIndex];
            players[nowIndex] = players[nowIndex - 1];
            players[nowIndex - 1] = nowValue;
            map.put(players[nowIndex], nowIndex);
            map.put(players[nowIndex - 1], nowIndex - 1);
        }

        return players;
    }
}
