package com.dsalgoproblems.javaproblems;

public class BinaryTreeTraversals {
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
		if (root == null)
			return res;
		Stack<BinaryTreeNode> s = new Stack<>();
		BinaryTreeNode currentNode = root;
		while (true) {
			while (currentNode != null) {
				res.add(currentNode.data);
				s.push(currentNode);
				currentNode = currentNode.left;
			}
			if (s.isEmpty())
				break;

			currentNode = s.pop();
			currentNode = currentNode.right;

		}

		return res;
	}
	
	private ArrayList<Integer> inorderIterative(BinaryTreeNode root) {
		ArrayList<Integer> res = new ArrayList<>();
		if (root == null)
			return res;
		Stack<BinaryTreeNode> s = new Stack<>();
		BinaryTreeNode currentNode = root;
		while (true) {
			while (currentNode != null) {
				s.push(currentNode);
				currentNode = currentNode.left;
			}
			if (s.isEmpty())
				break;

			currentNode = s.pop();
			res.add(currentNode.data);
			currentNode = currentNode.right;

		}

		return res;
	}
	
	private ArrayList<Integer> postOrderIterative(BinaryTreeNode root) {
		ArrayList<Integer> res = new ArrayList<>();
		if (root == null)
			return res;
		Stack<BinaryTreeNode> s = new Stack<>();
		BinaryTreeNode previous = null;
		BinaryTreeNode current = root;
		while(true) {
			while(current != null) {
				s.push(current);
				current = current.left;
			}
			if(s.isEmpty()) break;
			while(current == null && !s.isEmpty()) {
				current = s.peek();
				if(current.right == null || current.right == previous) {
					res.add(current.data);
					s.pop();
					previous = current;
					current = null;
				} else {
					current = current.right;
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
	
	private ArrayList<Integer> levelOrderTraversal(BinaryTreeNode root) {
		ArrayList<Integer> res = new ArrayList<>();
		if (root == null) {
			return null;
		}

		Queue<BinaryTreeNode> q = new java.util.LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size();
			while(size-- > 0) {
			BinaryTreeNode current = q.remove();
			res.add(current.data);
			
			if (current.left != null)
				q.add(current.left);
			if (current.right != null)
				q.add(current.right);
			
			}
		}

		return res;
	}
	
	private int maxElementRecursive(BinaryTreeNode root) {
		int maxValue = Integer.MIN_VALUE;
		if(root != null) {
			int leftMax = maxElementRecursive(root.left);
			int rightMax = maxElementRecursive(root.right);
			if(leftMax > rightMax) 
				maxValue = leftMax;
			else
				maxValue = rightMax;
			if(root.data > maxValue) 
				maxValue = root.data;
		}
		
		return maxValue;
	}
	
	private int maxElementIterative(BinaryTreeNode root) {
		if(root == null) {
			return Integer.MIN_VALUE;
		}
		
		int max = Integer.MIN_VALUE;
		Queue<BinaryTreeNode> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			BinaryTreeNode tmp = q.remove();
			if(tmp.getData() > max) {
				max = tmp.getData();
			}
			if(tmp.left != null) {
				q.add(tmp.left);
			}
			if(tmp.right != null) {
				q.add(tmp.right);
			}
		}
		
		return max;
	}
	
	private boolean searchInBinaryTree(BinaryTreeNode root, int target) {
		if(root == null) 
			return false;
		if(root.getData() == target) {
			return true;
		}
		return searchInBinaryTree(root.left, target) || searchInBinaryTree(root.right, target);
	}
	
	private boolean searchInBinaryTreeIterative(BinaryTreeNode root, int target) {
		if(root == null)
			return false;
		Queue<BinaryTreeNode> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			BinaryTreeNode tmp = q.remove();
			if(tmp.getData() == target) 
				return true;
			if(tmp.left != null) 
				q.add(tmp.left);
			if(tmp.right != null) 
				q.add(tmp.right);
		}
		
		return false;
		
	}

	public static void main(String[] args) {
		
		BinaryTreeTraversals bt = new BinaryTreeTraversals();
		
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
		ArrayList<Integer> res3 = bt.postOrderIterative(btn);
		System.out.println(res3.toString());
		
		System.out.println(bt.levelOrderTraversal(btn).toString());
		
		System.out.println(bt.maxElementRecursive(btn));
	
		System.out.println(bt.maxElementIterative(btn));
		
		System.out.println(bt.searchInBinaryTree(btn, 9));
		
		System.out.println(bt.searchInBinaryTreeIterative(btn, 9));

	}

}
