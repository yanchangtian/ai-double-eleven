package com.yan.study.example.class07;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Code06_TreeMaxWidth_Test {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	public static int maxWidthUseMap(Node head) {
		if (head == null) {

		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(head);
		Map<Node, Integer> levelMap = new HashMap<>();
		levelMap.put(head, 1);
		int curLevel = 1;
		int curLevelSize = 0;
		int maxLevelSize = 0;
		while (!queue.isEmpty()) {
			Node poll = queue.poll();
			Integer level = levelMap.get(poll);
			if (poll.left != null) {
				queue.add(poll.left);
				levelMap.put(poll.left, level + 1);
			}
			if (poll.right != null) {
				queue.add(poll.right);
				levelMap.put(poll.right, level + 1);
			}

			if (level == curLevel) {
				curLevelSize++;
			} else {
				curLevel = level;
				maxLevelSize = Math.max(maxLevelSize, curLevelSize);
				curLevelSize = 0;
			}

		}
		maxLevelSize = Math.max(maxLevelSize, curLevelSize);
		return maxLevelSize;

	}

	public static int maxWidthNoMap(Node head) {

		Queue<Node> queue = new LinkedList<>();
		queue.add(head);

		Node curEndNode = head;
		Node nextEndNode = null;
		int curLevelSize = 0;
		int maxLevelSize = 0;

		while (!queue.isEmpty()) {
			Node poll = queue.poll();

			if (poll.left != null) {
				queue.add(poll.left);
				nextEndNode = poll.left;
			}

			if (poll.right != null) {
				queue.add(poll.right);
				nextEndNode = poll.right;
			}

			curLevelSize++;
			if (poll == curEndNode) {
				maxLevelSize = Math.max(maxLevelSize, curLevelSize);
				curLevelSize = 0;
				curEndNode = nextEndNode;
			}

		}
		return maxLevelSize;
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

	public static void main(String[] args) {
		int maxLevel = 10;
		int maxValue = 100;
		int testTimes = 1000000;
		for (int i = 0; i < testTimes; i++) {
			Node head = generateRandomBST(maxLevel, maxValue);
			if (maxWidthUseMap(head) != maxWidthNoMap(head)) {
				System.out.println("Oops!");
			}
		}
		System.out.println("finish!");

	}

}
