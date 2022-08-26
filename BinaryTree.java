package com.dsalgoproblems.javaproblems;

public class BinaryTree {
	static class BinaryTreeNode {
		private int data;
		private BinaryTreeNode left, right;
		
		public BinaryTreeNode(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public BinaryTreeNode getLeft() {
			return left;
		}

		public void setLeft(BinaryTreeNode left) {
			this.left = left;
		}

		public BinaryTreeNode getRight() {
			return right;
		}

		public void setRight(BinaryTreeNode right) {
			this.right = right;
		}
		
		
	}
	
	private void PreOrder(BinaryTreeNode root) {
		if(root != null) {
			System.out.print(root.data + " ");
			PreOrder(root.left);
			PreOrder(root.right);
		}
	}
	
	private ArrayList<Integer> preOrderIterative(BinaryTreeNode root) {
		ArrayList<Integer> res = new ArrayList<>();
		if(root == null)
			return res;
		Stack<BinaryTreeNode> s = new Stack<>();
		s.push(root);
		while(!s.isEmpty()) {
			BinaryTreeNode tmp = s.pop();
			res.add(tmp.data);
			if(tmp.getRight() != null) {
				s.push(tmp.getRight());
			}
			if(tmp.getLeft() != null) {
				s.push(tmp.getLeft());
			}
		}
		
		return res;
	}
	
	private ArrayList<Integer> inorderIterative(BinaryTreeNode root) {
		ArrayList<Integer> res = new ArrayList<>();
		if(root == null)
			return res;
		Stack<BinaryTreeNode> s = new Stack<>();
		BinaryTreeNode currentNode = root;
		boolean done = false;
		while(!done) {
			if(currentNode != null) {
				s.push(currentNode);
				currentNode = currentNode.left;
			} else {
				if(s.isEmpty()) {
					done = true;
				} else {
					currentNode = s.pop();
					res.add(currentNode.data);
					currentNode = currentNode.right;
				}
			}
		}
		
		return res;
	}
	
	private void inOrder(BinaryTreeNode root) {
		if(root != null) {
			inOrder(root.left);
			System.out.print(root.data + " ");
			inOrder(root.right);
		}
	}
	
	private void PostOrder(BinaryTreeNode root) {
		if(root != null) {
			PostOrder(root.left);
			PostOrder(root.right);
			System.out.print(root.data + " ");

		}
	}

	public static void main(String[] args) {
		
		BinaryTree bt = new BinaryTree();
		
		BinaryTreeNode btn = new BinaryTreeNode(1);
		btn.left = new BinaryTreeNode(2);
		btn.right = new BinaryTreeNode(3);
		btn.left.left = new BinaryTreeNode(4);
		btn.left.right = new BinaryTreeNode(5);
		btn.right.left = new BinaryTreeNode(6);
		btn.right.right = new BinaryTreeNode(7);
		
		bt.PreOrder(btn);
		System.out.println();
		ArrayList<Integer> res = bt.preOrderIterative(btn);
		System.out.println(res.toString());
		bt.inOrder(btn);
		System.out.println();
		ArrayList<Integer> res2 = bt.inorderIterative(btn);
		System.out.println(res2.toString());
		bt.PostOrder(btn);

	}

}
