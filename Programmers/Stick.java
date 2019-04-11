// 코딩테스트 연습 - 스택/큐 - 쇠막대기

package Programmers;

import java.util.Stack;

public class Stick {
	public static void main(String args[]) {
                String arrangement = "()(((()())(())()))(())";

                int answer = 0;

                int stick = 0;
                char prev = ')', c;

                Stack<Character> stack = new Stack<Character>();

                for (int i = 0; i < arrangement.length(); i++) {
                          stack.push(arrangement.charAt(i));
                }

                while (!stack.isEmpty()) {
                        c = stack.pop();
                        if (c == ')') {
                                stick++;
                        }
                        else {
                                if (prev == ')') {
                                        stick--;
                                        answer += stick;
                                } else {
                                        stick--;
                                        answer++;
                                }
                        }
                        prev = c;
                }


                System.out.println(answer);
	}
}