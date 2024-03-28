// 공원 산책
class Solution {
    static int x, y;
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        
        // 'S'의 초기 위치 찾기
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[0].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        
        for (String route : routes) {
            int nowX = x;
            int nowY = y;
            char d = route.charAt(0);
            int l = route.charAt(2) - '0';
            
            // 이동 방향에 따라 이동
            loop :
            for (int j = 0; j < l; j++) {
                switch (d) {
                    case 'N':
                        if (x > 0 && park[x - 1].charAt(y) != 'X') {
                            x--;
                        } else {
                            x = nowX;
                            y = nowY;
                            break loop;
                        }
                        break;
                    case 'S':
                        if (x < park.length - 1 && park[x + 1].charAt(y) != 'X') {
                            x++;
                        } else {
                            x = nowX;
                            y = nowY;
                            break loop;
                        }
                        break;
                    case 'W':
                        if (y > 0 && park[x].charAt(y - 1) != 'X') {
                            y--;
                        } else {
                            x = nowX;
                            y = nowY;
                            break loop;
                        }
                        break;
                    case 'E':
                        if (y < park[0].length() - 1 && park[x].charAt(y + 1) != 'X') {
                            y++;
                        } else {
                            x = nowX;
                            y = nowY;
                            break loop;
                        }
                        break;
                }
            }
        }
        
        answer[0] = x;
        answer[1] = y;
        return answer;
    }
}
