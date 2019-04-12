// 코딩테스트 연습 - 완전탐색 - 타겟 넘버

package Programmers;

public class DFS {
	static int[] n;
	static int t, r;
	
	static int count;
	
	static void sum(int sum, int index) {
		if (index == n.length && sum == t) r++;
		else if (index < n.length) {
			sum(sum + n[index], index+1);
			sum(sum - n[index], index+1);			
		}	
	}
	
	public static void main(String[] args) {
		int answer = 0;
		int[] numbers = {1,1,1,1,1};
		int target = 3;
		
		n = numbers;
		t = target;

		sum(0, 0);
		
		System.out.println(r);
	}
}
