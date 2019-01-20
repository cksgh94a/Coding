class Node {
	private Node before;
	private Node next;
	private String data;

	Node(Node b, Node n, String d) {
		before = b;
		next = n;
		data = d;
	}

	void set_front(Node b)	{ before = b; }
	void set_rear(Node n)	{ next = n; }
	String get_data() { return data; }
	Node get_before() { return before; }
	Node get_next() { return next; }
}

class DequeType {
	int size, amount;
	Node front, rear;

	DequeType(int size){
		this.size = size;
	}
	
	boolean empty() { return amount == 0; }

	boolean full() { return amount == size; }

	void add_front(String e) {
		if(!full()){
			Node frontTemp = new Node(null, front, e);
			if(rear == null)	rear = frontTemp;
			if(front != null)	front.set_front(frontTemp);
			front = frontTemp;
			amount++;
		}
	}

	void add_rear(String e) {		
		if(!full()){
			Node rearTemp = new Node(rear, null, e);
			if(front == null)	front = rearTemp;
			if(rear != null)	rear.set_rear(rearTemp);
			rear = rearTemp;
			amount++;
		}
	}
	
	Node del_front() {
		if(!empty()){
			Node ft = front;
			if(front.get_next() != null)	front.get_next().set_front(null);
			front = front.get_next();			
			amount--;
			return ft;
		}
		else return null;
	}

	Node del_rear() {
		if(!empty()){
			Node rt = rear;
			if(rear.get_before() != null)	rear.get_before().set_rear(null);
			rear = rear.get_before();			
			amount--;
			return rt;
		}
		else return null;
	}

	Node get_front() {
		if(!empty())	return front;
		else return null;
	}

	Node get_rear() {
		if(!empty())	return rear;
		else return null;
	}

	
}

public class Deque {

	public static void main(String[] args) {
		DequeType dT = new DequeType(10);
		System.out.println(dT.empty());
		System.out.println(dT.full());
		System.out.println(dT.amount);
		dT.add_front(Integer.toString(1));
		dT.add_rear(Integer.toString(2));
		dT.add_front(Integer.toString(3));
		dT.add_rear(Integer.toString(4));
		System.out.println(dT.empty());
		System.out.println(dT.full());
		System.out.println(dT.amount);
		dT.add_front(Integer.toString(5));
		dT.add_rear(Integer.toString(6));
		dT.add_front(Integer.toString(7));
		dT.add_rear(Integer.toString(8));
		dT.add_front(Integer.toString(9));
		dT.add_rear(Integer.toString(10));
		System.out.println(dT.empty());
		System.out.println(dT.full());
		System.out.println(dT.amount);
	
		System.out.format(dT.del_front().get_data());
		System.out.format(dT.del_rear().get_data());
		System.out.format(dT.del_front().get_data());
		System.out.format(dT.del_rear().get_data());
		System.out.format(dT.del_front().get_data());
		System.out.println(dT.empty());
		System.out.println(dT.full());
		System.out.println(dT.amount);
		System.out.format(dT.del_rear().get_data());
		System.out.format(dT.del_front().get_data());
		System.out.format(dT.del_rear().get_data());
		System.out.format(dT.del_front().get_data());
		System.out.format(dT.del_rear().get_data());
	}

}
