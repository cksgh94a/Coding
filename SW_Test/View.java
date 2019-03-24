// 1206. [S/W 문제해결 기본] 1일차 - View

package SW_Test;

import java.util.Scanner;

class vQueue {
        private int[] queue = {0, 0, 0, 0, 0, 0};
        private int front = 0 , rear = 0;
        
        public boolean isEmpty() {
                if (front == rear) return true;
                else return false;
        }

        public boolean isFull() {
                if (((rear+1) % 6) == front) return true;
                else return false;
        }

        public void enq(int e) {
                if (isFull());
                else if (isEmpty()) {
                        queue[rear+1] = e;
                        rear = (rear+1)%6;
                }
                else {
                        queue[rear] = e;
                        rear = (rear+1)%6;
                }
        }

        public int deq() {
                if (isEmpty()) return -1;
                else {
                        int value = queue[front];
                        front = (front+1)%6;
                        
                        return value;
                }
        }
}

public class View {
// public class Solution {
	public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int bCount = Integer.valueOf(sc.nextLine());
                String[] bLine = sc.nextLine().split(" ");
                for (String building : bLine ){
                        System.out.println(building);
                }            

                sc.close();
	}
}
