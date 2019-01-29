
class Leaf {
	private Leaf leftChild;
	private Leaf rightChild;
	private int data;

	Leaf(int d) { data = d; }

	public void set_left(Leaf l) { leftChild = l; }
	public void set_right(Leaf r) { rightChild = r; }
	public int get_data() { return data; }
	public Leaf get_left() { return leftChild; }
	public Leaf get_right() { return rightChild; }
}

class BinarySearchTreeType {
	private Leaf root;

	public Leaf get_root() { return root; }

	public void insert_leaf(int d)	{
		if(root == null) root = new Leaf(d);
		else {
			Leaf parent = root;
			Leaf child = root;
			while (child != null) {
				if (d <= parent.get_data()) {
					child = parent.get_left();
					if (child == null) parent.set_left(new Leaf(d));
				}
				else {
					child = parent.get_right();
					if (child == null) parent.set_right(new Leaf(d));
				}
				parent = child; 
			}			
		}
	}

	public void delete_leaf(int d) {
		Leaf parent = root;
		Leaf child = root;
		
		while (parent.get_data() != d) {
			if (d <= parent.get_data()) child = parent.get_left();
			else child = parent.get_right();
			parent = child;
		}

		do {
			Leaf temp;
			if (child.get_left() == null) {
				temp = child.get_right();
				parent.set_left(child.get_right());
			} else {
				temp = child.get_left();
				parent.set_left(child.get_left());
			}
			root.set_right(temp);
		} while ((child.get_left() != null) || (child.get_right() != null));
	}

	public void preorder_traversal(Leaf t) {
		System.out.println(t.get_data());
		if(t.get_left() != null) preorder_traversal(t.get_left());
		if(t.get_right() != null) preorder_traversal(t.get_right());
	}

	public void inorder_traversal(Leaf t) {
		if(t.get_left() != null) inorder_traversal(t.get_left());
		System.out.println(t.get_data());
		if(t.get_right() != null) inorder_traversal(t.get_right());
	}

	public void postorder_traversal(Leaf t) {
		if(t.get_left() != null) postorder_traversal(t.get_left());
		if(t.get_right() != null) postorder_traversal(t.get_right());
		System.out.println(t.get_data());
	}
}

public class BinarySearchTree {

	public static void main(String[] args) {

		BinarySearchTreeType test = new BinarySearchTreeType();
		test.insert_leaf(9);
		test.insert_leaf(5);
		test.insert_leaf(4);
		test.insert_leaf(3);
		test.insert_leaf(8);
		test.insert_leaf(7);
		test.insert_leaf(6);

		test.preorder_traversal(test.get_root());
		System.out.println("\\");
		test.inorder_traversal(test.get_root());
		System.out.println("\\");
		test.postorder_traversal(test.get_root());
	}

}
