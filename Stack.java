class StackType {
	int index = -1;
	int size;
	String[] stack;
	
	StackType(int l) {	// 생성자
		size = l;
		stack = new String[l];
	}
	
	boolean is_empty() {	// 스택이 비었나 확인
		if (index == -1)	return true;
		else return false;
	}
	
	boolean is_full() {	// 스택이 다 찼나 확인
		if (index == size-1)	return true;
		else return false;
	}
	
	void push(String e) {	// 스택에 원소 추가
		if(!is_full())	stack[++index] = e;
	}
	
	String pop() {	// 스택에서 맨 위 원소 꺼냄
		if(is_empty()) return "스택이 비어있음";
		else {
			String temp = stack[index];
			stack[index--] = null;
			return temp;
		}
	}
	
	String peek() {	// 스택에서 맨 위 원소 읽음
		if(is_empty()) return "스택이 비어있음";
		else return stack[index];
	}	
}

public class Stack {
	public static void main(String[] args) {
		StackType stack = new StackType(10);
		while(!stack.is_empty()) {
			System.out.println(stack.pop());	
		}
	}
}
