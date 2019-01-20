
class Node {
	private Node leftChild;
	private Node rightChild;
	private int data;

	Node(int d) { data = d; }

	public void set_left(Node l) { leftChild = l; }
	public void set_right(Node r) { rightChild = r; }
	public int get_data() { return data; }
	public Node get_left() { return leftChild; }
	public Node get_right() { return rightChild; }
}

class BinarySearchTreeType {
	private Node root;

	public void insert_node(int d)	{
		if(root == null) root = new Node(d);
		else {
			Node temp = root;
			do {
				if (d <= temp.get_data()) temp = temp.get_left();
				else temp = temp.get_right();
			} while (temp != null);
			temp = new Node(d);
		}
	}

	public Node get_root() { return root; }

	public void preorder_traversal(Node r) {
		while (r != null) {
			System.out.println(r.get_data());
			preorder_traversal(r.get_left());
			preorder_traversal(r.get_right());
		}
	}

	public void inorder_traversal(Node r) {
		while (r != null) {
			preorder_traversal(r.get_left());
			System.out.println(r.get_data());
			preorder_traversal(r.get_right());
		}		
	}

	public void postorder_traversal(Node r) {
		while (r != null) {
			preorder_traversal(r.get_left());
			preorder_traversal(r.get_right());
			System.out.println(r.get_data());
		}		
	}
}

public class BinarySearchTree {

	public static void main(String[] args) {

		Node test = new Node(4);
		System.out.println(test.get_data());
		// BinarySearchTreeType test = new BinarySearchTreeType();
		// test.insert_node(3);
		// test.insert_node(4);
		// test.insert_node(5);
		// test.insert_node(6);
		// test.insert_node(7);
		// test.insert_node(8);
		// test.insert_node(9);

		// test.inorder_traversal(test.get_root());
	}

}
