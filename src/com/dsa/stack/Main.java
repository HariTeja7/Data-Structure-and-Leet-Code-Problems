package com.dsa.stack;

public class Main {

	public static Stack sortStack(Stack stack) {
		Stack tmpStack = new Stack();
		while (!stack.isEmpty()) {
			int temp = stack.pop();
			while (temp <= tmpStack.peek()) {
				stack.push(tmpStack.pop());
				if (!tmpStack.isEmpty())
					temp = tmpStack.pop();
				else break;
			}
			tmpStack.push(temp);
		}
		return tmpStack;
	}

	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(3);
		stack.push(4);
		stack.push(1);
		stack.push(6);
		stack.push(5);
		stack.printStack();
		sortStack(stack).printStack();
	}

}
