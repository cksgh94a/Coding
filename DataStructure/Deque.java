// 배열 이용 Deque

package DataStructure;

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

public class Deque {
	public static void main(String[] args) {
                vQueue v = new vQueue();
                for (int i = 0; i < 6; i++) {
                        v.enq(i);
                }
                for (int i = 0; i < 3; i++) {
                        System.out.println(v.deq());
                }
                v.enq(10);
                v.enq(51);
                v.enq(62);
                for (int i = 0; i < 6; i++) {
                        System.out.println(v.deq());
                }
	}
}
