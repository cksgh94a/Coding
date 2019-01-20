class QueueType {
	int front = 0;
	int rear = 0;
	int size;
	String[] queue;
	
	QueueType(int l) {
		size = ++l;
		queue = new String[size];
	}
	
	boolean empty() {
		return front == rear;
	}
	
	boolean full() {
		return front%size == (rear+1)%size;
	}
	
	void enqueue(String e) {
		if(full()); // System.out.println("Queue is full");
		else {
			rear = (rear+1)%size;
			queue[rear] = e;
		}
	}
	
	String dequeue() {
		if(empty()) {
//			System.out.println("Queue is empty");
			return null;
		}
		
		else {
			front = (front+1)%size;
			return queue[front];
		}
	}
	
	String peek() {
		return queue[front+1];
	}
}

public class Queue {

	public static void main(String[] args) {
		QueueType q = new QueueType(10);
		q.enqueue("1");
		q.enqueue("2");
		q.enqueue("3");
		q.enqueue("4");
		q.enqueue("5");
		q.enqueue("6");
		q.enqueue("7");
		q.enqueue("8");
		q.enqueue("9");
		q.enqueue("0");
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		q.enqueue("8");
		q.enqueue("9");
		q.enqueue("0");
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
	}

}
