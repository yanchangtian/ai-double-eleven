package com.yan.study.example.class07;

/**
 * 后继节点
 *
 *           o
 *         /   \
 *        /     \
 *       o       o
 *     /   \   /   \
 *    o     o o     o
 *
 */
public class Code07_SuccessorNode {

	public static class Node {
		public int value;
		public Node left;
		public Node right;
		public Node parent;

		public Node(int data) {
			this.value = data;
		}
	}

	public static void main(String[] args) {
		Node head = new Node(6);
		head.parent = null;
		head.left = new Node(3);
		head.left.parent = head;
		head.left.left = new Node(1);
		head.left.left.parent = head.left;
		head.left.left.right = new Node(2);
		head.left.left.right.parent = head.left.left;
		head.left.right = new Node(4);
		head.left.right.parent = head.left;
		head.left.right.right = new Node(5);
		head.left.right.right.parent = head.left.right;
		head.right = new Node(9);
		head.right.parent = head;
		head.right.left = new Node(8);
		head.right.left.parent = head.right;
		head.right.left.left = new Node(7);
		head.right.left.left.parent = head.right.left;
		head.right.right = new Node(10);
		head.right.right.parent = head.right;

		Node test = head.left.left;
		System.out.println(test.value + " next: " + getSuccessorNode01(test).value);
		test = head.left.left.right;
		System.out.println(test.value + " next: " + getSuccessorNode01(test).value);
		test = head.left;
		System.out.println(test.value + " next: " + getSuccessorNode01(test).value);
		test = head.left.right;
		System.out.println(test.value + " next: " + getSuccessorNode01(test).value);
		test = head.left.right.right;
		System.out.println(test.value + " next: " + getSuccessorNode01(test).value);
		test = head;
		System.out.println(test.value + " next: " + getSuccessorNode01(test).value);
		test = head.right.left.left;
		System.out.println(test.value + " next: " + getSuccessorNode01(test).value);
		test = head.right.left;
		System.out.println(test.value + " next: " + getSuccessorNode01(test).value);
		test = head.right;
		System.out.println(test.value + " next: " + getSuccessorNode01(test).value);
		test = head.right.right; // 10's next is null
		System.out.println(test.value + " next: " + getSuccessorNode01(test));

		System.out.println("-----------------------------------------------------");

		test = head.left.left;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.left.left.right;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.left;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.left.right;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.left.right.right;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.right.left.left;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.right.left;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.right;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.right.right; // 10's next is null
		System.out.println(test.value + " next: " + getSuccessorNode(test));
	}

	public static Node getSuccessorNode01(Node node) {
		if (node == null) {
			return null;
		}
		if (node.right != null) {
			return getLeftMost01(node.right);
		} else {
			return getRightMost01(node);
		}
	}

	private static Node getRightMost01(Node node) {
		while (node.parent != null) {
			if (node == node.parent.left) {
				return node.parent;
			} else {
				node = node.parent;
			}
		}
		return null;
	}

	private static Node getLeftMost01(Node right) {
		while (right.left != null) {
			right = right.left;
		}
		return right;
	}

	public static Node getSuccessorNode(Node node) {
		if (node == null) {
			return node;
		}
		if (node.right != null) {
			return getLeftMost(node.right);
		} else { // 无右子树
			Node parent = node.parent;
			while (parent != null && parent.left != node) { // 当前节点是其父亲节点右孩子
				node = parent;
				parent = node.parent;
			}
			return parent;
		}
	}

	public static Node getLeftMost(Node node) {
		if (node == null) {
			return node;
		}
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}

}
