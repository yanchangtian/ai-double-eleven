package com.yan.study.example.class10_test;

import java.util.HashMap;
import java.util.Map;

/**
 * 并查集
 *
 * 1) 有若干个样本 a、b、c、d、… 类型假设是V
 * 2) 在并查集中一开始认为每个样本都在单独的集合里
 * 3) 用户可以在任何时候调用如下两个方法
 * boolean isSameSet(V x, V y) : 查询样本x和样本y是否属于一个集合
 * void union(V x, V y) : 把x和y各自所在集合的所有样本合并成一个集合
 * 4) isSameSet和union方法的代价越低越好
 */
public class Code01_UnionFind_Test {

	private static class Node<V> {
		V value;
		public Node(V value) {
			this.value = value;
		}
	}

	public static class UnionSet<V> {

		public Map<V, Node<V>> nodes;
		public Map<Node<V>, Node<V>> parents;
		public Map<Node<V>, Integer> sizeMap;

		public UnionSet() {
			nodes = new HashMap<>();
			parents = new HashMap<>();
			sizeMap = new HashMap<>();
		}

		public void add(V v) {
			if (!nodes.containsKey(v)) {
				nodes.put(v, new Node<>(v));
				parents.put(nodes.get(v), nodes.get(v));
				sizeMap.put(nodes.get(v), 1);
			}
		}

		/**
		 * 是否处在同一集合
		 *
		 * 寻找头节点, 如果头节点相等则处于同一集合
		 *
		 * @param x
		 * @param y
		 * @return
		 */
		public boolean isSameSet(V x, V y) {
			if (!nodes.containsKey(x) || !nodes.containsKey(y)) {
				return false;
			}
			return findFather(nodes.get(x)) == findFather(nodes.get(y));
		}

		public Node<V> findFather(Node<V> node) {
			if (node == null) {
				return null;
			}
			Node<V> parent = parents.get(node);
			while (parent != null && parent != node) {
				node = parent;
				parent = parents.get(node);
			}
			return parent;
		}

		public void union(V x, V y) {
			if (!nodes.containsKey(x) || !nodes.containsKey(y)) {
				return;
			}
			Node<V> xNode = nodes.get(x);
			Node<V> yNode = nodes.get(y);
			Integer xSize = sizeMap.get(xNode);
			Integer ySize = sizeMap.get(yNode);
			if (xSize >= ySize) {
				parents.put(yNode, xNode);
				sizeMap.put(xNode, xSize + ySize);
				sizeMap.remove(yNode);
			} else {
				parents.put(xNode, yNode);
				sizeMap.put(yNode, xSize + ySize);
				sizeMap.remove(xNode);
			}

		}

	}



}
