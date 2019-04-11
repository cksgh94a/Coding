// 코딩테스트 연습 - 해시 - 완주하지 못한 선수

package Programmers;

import java.util.HashMap;

public class Hash {
// public class Solution {

	public static String main(String[] participant, String[] completion) {
                String answer = "";

                HashMap<String, Integer> map = new HashMap<String, Integer>();
                int count;

                for (int i = 0; i < participant.length; i++) {
                        count = 1;
                        if(map.containsKey(participant[i]))     count += map.get(participant[i]);
                        map.put(participant[i], count);
                }
                for (int i = 0; i < completion.length; i++) {
                        count = map.get(completion[i]) - 1;
                        map.put(completion[i], count);
                }
                for (int i = 0; i < participant.length; i++) {
                        if(map.get(participant[i]) != 0) answer = participant[i];
                }
                return answer;
	}
}