package com.yan.study.example.class08;

public class Code02_IsFull {

	public static boolean isFull1(Node head) {
		if (head == null) {
			return true;
		}
		int height = h(head);
		int nodes = n(head);
		return (1 << height) - 1 == nodes;
	}

	public static int h(Node head) {
		if (head == null) {
			return 0;
		}
		return Math.max(h(head.left), h(head.right)) + 1;
	}

	public static int n(Node head) {
		if (head == null) {
			return 0;
		}
		return n(head.left) + n(head.right) + 1;
	}

	// 二叉树递归套路
	public static boolean isFull2(Node head) {
		if (head == null) {
			return true;
		}
		Info all = process(head);
		return (1 << all.height) - 1 == all.nodes;
	}

	public static Info process(Node head) {
		if (head == null) {
			return new Info(0, 0);
		}
		Info leftInfo = process(head.left);
		Info rightInfo = process(head.right);
		int height = Math.max(leftInfo.height, rightInfo.height) + 1;
		int nodes = leftInfo.nodes + rightInfo.nodes + 1;
		return new Info(height, nodes);
	}

	public static void main(String[] args) {
		int maxLevel = 5;
		int maxValue = 100;
		int testTimes = 1000000;
		for (int i = 0; i < testTimes; i++) {
			Node head = generateRandomBST(maxLevel, maxValue);
			if (isFull1(head) != isFullTree(head)) {
				System.out.println("Oops!");
			}
		}
		System.out.println("finish!");
	}

	public static class Info {
		public int height;
		public int nodes;
		public Info(int h, int n) {
			height = h;
			nodes = n;
		}
	}

	// for test
	public static Node generateRandomBST(int maxLevel, int maxValue) {
		return generate(1, maxLevel, maxValue);
	}

	// for test
	public static Node generate(int level, int maxLevel, int maxValue) {
		if (level > maxLevel || Math.random() < 0.5) {
			return null;
		}
		Node head = new Node((int) (Math.random() * maxValue));
		head.left = generate(level + 1, maxLevel, maxValue);
		head.right = generate(level + 1, maxLevel, maxValue);
		return head;
	}

	public static class Node {
		public int value;
		public Node left;
		public Node right;
		public Node(int data) {
			this.value = data;
		}
	}

	public static boolean isFullTree(Node node) {
		Info treeInfo = getTreeInfo(node);
		return (1 << treeInfo.height) - 1 == treeInfo.nodes;
	}

	public static Info getTreeInfo(Node node) {
		if (node == null) {
			return new Info(0, 0);
		}
		Info leftInfo = getTreeInfo(node.left);
		Info rightInfo = getTreeInfo(node.right);

		int nodes = leftInfo.nodes + rightInfo.nodes + 1;
		int height = Math.max(leftInfo.height, rightInfo.height) + 1;

		return new Info(height, nodes);
	}

}
