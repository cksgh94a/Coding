package DataStructure;

// 각각의 노드 클래스 (객체)
class Leaf {
	private Leaf leftChild;
	private Leaf rightChild;
	private int data;

	Leaf(int d) { data = d; }

	public void set_data(int d) { this.data = d; }
	public void set_left(Leaf l) { this.leftChild = l; }
	public void set_right(Leaf r) { this.rightChild = r; }
	public int get_data() { return data; }
	public Leaf get_left() { return leftChild; }
	public Leaf get_right() { return rightChild; }
}

// 트리 클래스 (객체), 서브 트리도 표현 가능
class BinarySearchTreeType {
	private Leaf root;

	public Leaf get_root() { return root; }

	// 삽입 연산
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

	// 삭제 연산
	public void delete_leaf(int d) {

		Leaf del, prev = root;
		Leaf present = root;
		Leaf next = root;
		
		int hasChild;	// 0 : 삭제 노드의 자식 없음, 1 : 왼쪽 자식, 2 : 오른쪽 자식, 3 : 탐색 불가

		// 삭제할 노드 탐색
		while (present.get_data() != d) {
			if (d <= present.get_data()) next = present.get_left();
			else next = present.get_right();
			prev = present;
			present = next;
			if (present == null) {
				hasChild = 3;
				System.out.println("삭제할 노드를 찾을 수 없습니다.");
				break;
			}
		}
		del = present;

		// 대체할 노드 탐색
		if (del.get_left() == null && del.get_right() == null) hasChild = 0;
		else if (del.get_left() == null) hasChild = 2;
		else hasChild = 1;

		if (hasChild == 0) {
			if (prev.get_left() == del) prev.set_left(null);
			else prev.set_right(null);
		}
		else if (hasChild == 1) {
			next = del.get_left();
			while (next != null) {
				prev = present;
				present = next;
				next = present.get_right();
			}
			del.set_data(present.get_data());

			if (present == del.get_left()) prev.set_left(null);
			else prev.set_right(present.get_left());
		}
		else if (hasChild == 2) {
			next = del.get_right();
			while (next != null) {
				prev = present;
				present = next;
				next = present.get_right();
			}
			del.set_data(present.get_data());

			if (present == del.get_right()) prev.set_left(present.get_right());
			else prev.set_left(present.get_right());
		}
	}

	// 탐색 연산
	public boolean find_leaf(int d, Leaf t) {
		if (t.get_data() == d) return true;
		else {
			if (t.get_left() != null) if (find_leaf(d, t.get_left())) return true;
			if (t.get_right() != null) if (find_leaf(d, t.get_right())) return true;
		}

		return false;
	}

	// 전위 순회
	public void preorder_traversal(Leaf t) {
		System.out.print(t.get_data() + " ");
		if(t.get_left() != null) preorder_traversal(t.get_left());
		if(t.get_right() != null) preorder_traversal(t.get_right());
	}

	// 중위 순회
	public void inorder_traversal(Leaf t) {
		if(t.get_left() != null) inorder_traversal(t.get_left());
		System.out.print(t.get_data() + " ");
		if(t.get_right() != null) inorder_traversal(t.get_right());
	}

	// 후위 순회
	public void postorder_traversal(Leaf t) {
		if(t.get_left() != null) postorder_traversal(t.get_left());
		if(t.get_right() != null) postorder_traversal(t.get_right());
		System.out.print(t.get_data() + " ");
	}

	// 높이
	public int height(Leaf l) {
		int lH, lR;
		if (l.get_left() == null) lH = 0;
		else lH = height(l.get_left());
		
		if (l.get_right() == null) lR = 0;
		else lR = height(l.get_right());
		
		if(lH >= lR) return 1 + lH;
		else return 1 + lR;

	}
}

public class BinarySearchTree {

	public static void main(String[] args) {

		BinarySearchTreeType test = new BinarySearchTreeType();
		test.insert_leaf(50);
		test.insert_leaf(25);
		test.insert_leaf(75);
		test.insert_leaf(12);
		test.insert_leaf(37);
		test.insert_leaf(62);
		test.insert_leaf(87);
		test.insert_leaf(6);
		test.insert_leaf(18);
		test.insert_leaf(31);
		test.insert_leaf(44);
		test.insert_leaf(57);
		test.insert_leaf(68);
		test.insert_leaf(81);
		test.insert_leaf(94);
		test.insert_leaf(3);
		test.insert_leaf(10);
		test.insert_leaf(40);
		test.insert_leaf(48);
		test.insert_leaf(78);
		test.insert_leaf(85);

		test.delete_leaf(3);		

		System.out.println("전위");
		test.preorder_traversal(test.get_root());
		System.out.println("\n중위");
		test.inorder_traversal(test.get_root());
		System.out.println("\n후위");
		test.postorder_traversal(test.get_root());

		System.out.println("\n탐색");
		System.out.println(test.find_leaf(85, test.get_root()));
		System.out.println(test.find_leaf(561, test.get_root()));


		// test.insert_leaf(1);
		// test.insert_leaf(2);
		// test.insert_leaf(3);
		// test.insert_leaf(4);
		// test.insert_leaf(5);
		// test.insert_leaf(6);
		// test.insert_leaf(7);
		// test.insert_leaf(8);
		// test.insert_leaf(9);
		// test.insert_leaf(10);
		// test.insert_leaf(11);

		// System.out.println("높이 : " + test.height(test.get_root()));
	}

}
