package com.greatlearning.dsa.lab3;
import java.util.*;
public class SumPairApp {
	static class Node {
		int data;
		Node leftNode, rightNode;

		public Node(int data) {
			this.data=data;
			leftNode = rightNode = null;
		}
	}
	static Node createNode(int nodeData) {
		Node newNode = new Node(nodeData);
		return newNode;
	}
	public Node insert(Node root,int key) {
		if(root==null) 
			return createNode(key);
		if(key<root.data)
			root.leftNode= insert(root.leftNode,key);
		else
			root.rightNode = insert(root.rightNode,key);
		return root;
	}

	public static void main(String args[]) {
		Node root = null;
		SumPairApp SPA = new SumPairApp();
		root = SPA.insert(root, 40);
		root = SPA.insert(root, 20);
		root = SPA.insert(root, 60);
		root = SPA.insert(root, 10);
		root = SPA.insert(root, 30);
		root = SPA.insert(root, 50);
		root = SPA.insert(root, 70);
		int sum = 130;
		SPA.findPairWithSum(root,sum);
		//		System.out.println("In Order Traversal Data: ");
		//		SPA.inOrder(root);
	}
	//	private void inOrder(Node root) {
	//		// TODO Auto-generated method stub
	//		if(root==null) {
	//			return;
	//		}
	//		else
	//			inOrder(root.leftNode);
	//		System.out.print(root.data+" ");
	//		inOrder(root.rightNode);
	//	}
	private void findPairWithSum(Node root, int sum) {
		// TODO Auto-generated method stub
		Set<Integer> set = new HashSet<Integer>();
		if(!PairUtility(root,sum,set))
			System.out.println("Pairs not found");
	}
	private boolean PairUtility(Node root, int sum, Set<Integer> set) {
		// TODO Auto-generated method stub
		if(root==null)
			return false;
		if(PairUtility(root.leftNode,sum,set))
			return true;
		if(set.contains(sum - root.data)) {
			System.out.println("Pair is found ("+(sum - root.data)+","+root.data+")");
			return true;
		}else
			set.add(root.data);
		return PairUtility(root.rightNode,sum,set);
	}
}