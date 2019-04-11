// 코딩테스트 연습 - 완전탐색 - 모의고사

package Programmers;

import java.util.Arrays;

public class FullSearch {
// public class Solution {

	public static int[] main(String[] args) {
		int[] answers = {1,3,2,4,2};
		int[] answer;
		
		int[][] rule = {{1,2,3,4,5}, {2,1,2,3,2,4,2,5},{3,3,1,1,2,2,4,4,5,5}};
		
		int collect[] = {0,0,0}; 
		
		for (int i = 0; i < answers.length; i++) {
			if (rule[0][i%5] == answers[i]) collect[0]++;
			if (rule[1][i%8] == answers[i]) collect[1]++;
			if (rule[2][i%10] == answers[i]) collect[2]++;
		}
		
		int[] sorted = collect.clone();
		Arrays.sort(sorted);
		
		if (sorted[2] == sorted[0]) answer = new int[3];
		else if (sorted[2] == sorted[1]) answer = new int[2];
		else answer = new int[1];
		
		int j = 0;
		for (int i = 0; i < 3; i++) {
			if (collect[i] == sorted[2]) answer[j++] = i+1;
		}
                return answer;
	}
}