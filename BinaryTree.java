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
		bt.inOrder(btn);
		System.out.println();
		bt.PostOrder(btn);

	}

}
