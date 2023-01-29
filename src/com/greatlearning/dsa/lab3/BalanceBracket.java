package com.greatlearning.dsa.lab3;

import java.util.Stack;

public class BalanceBracket {

	public static boolean isBalanced(String input) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < input.length(); i++) {
			char current = input.charAt(i);
			if (current == '(' || current == '[' || current == '{') {
				stack.push(current);
			} else if (current == ')' || current == ']' || current == '}') {
				if (stack.isEmpty()) {
					return false;
				}
				char last = stack.peek();
				if ((current == ')' && last == '(') || (current == ']' && last == '[') || (current == '}' && last == '{')) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		String input1 = "( [ [ { } ] ] )";
		String input2 = "( [ [ { } ] ] ) )";
		if (isBalanced(input1)) {
			System.out.println("The entered String has Balanced Brackets");
		} else {
			System.out.println("The entered String do not contain Balanced Brackets");
		}
		if (isBalanced(input2)) {
			System.out.println("The entered String has Balanced Brackets");
		} else {
			System.out.println("The entered String do not contain Balanced Brackets");
		}
	}
}
