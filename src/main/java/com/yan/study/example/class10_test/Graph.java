package com.yan.study.example.class10_test;

import java.util.*;

/**
 * 图
 */
public class Graph<V> {

    private Map<V, Node<V>> nodeList = new HashMap<>();

    // ? 边是否需要使用Set去重
    private List<Edge<V>> edgeList = new ArrayList<>();

    public void addNode(V nodeValue) {
        this.nodeList.put(nodeValue, new Node<>(nodeValue));
    }

    public void addEdge(Edge<V> edge) {
        this.edgeList.add(edge);
    }

    /**
     * [from节点上面的值, to节点上面的值, weight]
     */
    public Graph(V[][] matrix) {
        for (V[] line : matrix) {

            V fromValue = line[0];
            V toValue = line[1];
            Integer weight = (Integer) line[2];

            if (!nodeList.containsKey(fromValue)) {
                nodeList.put(fromValue, new Node<>(fromValue));
            }
            if (!nodeList.containsKey(toValue)) {
                nodeList.put(toValue, new Node<>(toValue));
            }
            Node<V> fromNode = nodeList.get(fromValue);
            Node<V> toNode = nodeList.get(toValue);

            Edge<V> edge = new Edge<>(weight, fromNode, toNode);
            edgeList.add(edge);

            fromNode.addNextNode(toNode);
            fromNode.addOutEdge(edge);
            fromNode.incrOut();

            toNode.incrIn();

        }
    }

    /**
     * 宽度优先遍历, 使用queue和set
     */
    public void bfs(V nodeValue) {
        if (!nodeList.containsKey(nodeValue)) {
            return;
        }
        Node<V> startNode = nodeList.get(nodeValue);
        Queue<Node<V>> queue = new LinkedList<>();
        Set<Node<V>> set = new HashSet<>();

        queue.add(startNode);
        set.add(startNode);

        while (!queue.isEmpty()) {
            Node<V> curNode = queue.poll();
            System.out.println(curNode.getValue());

            for (Node<V> nextNode : curNode.getNextNodeList()) {
                if (!set.contains(nextNode)) {
                    queue.add(nextNode);
                    set.add(nextNode);
                }
            }
        }
    }

    /**
     * 深度优先遍历, 使用stack和set
     */
    public void dfs(V nodeValue) {
        if (!nodeList.containsKey(nodeValue)) {
            return;
        }
        Node<V> startNode = nodeList.get(nodeValue);
        Stack<Node<V>> stack = new Stack<>();
        Set<Node<V>> set = new HashSet<>();

        stack.add(startNode);
        set.add(startNode);
        System.out.println(startNode.getValue());

        while (!stack.isEmpty()) {
            Node<V> curNode = stack.pop();
            for (Node<V> nextNode : curNode.getNextNodeList()) {
                if (set.contains(nextNode)) {
                    stack.add(curNode);
                    stack.add(nextNode);
                    set.add(nextNode);
                    System.out.println(nextNode.getValue());
                    break;
                }
            }
        }
    }

    /**
     * 拓扑排序(仅限 有向无环图)
     */
    public List<V> sortedTopology() {
        Map<Node<V>, Integer> inMap = new HashMap<>();
        Queue<Node<V>> queue = new LinkedList<>();

        // 找出入度为0的点放入队列中
        for (Node<V> vNode : nodeList.values()) {
            inMap.put(vNode, vNode.getIn());
            if (vNode.getIn() == 0) {
                queue.add(vNode);
            }
        }

        List<V> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            Node<V> curNode = queue.poll();
            result.add(curNode.getValue());
            for (Node<V> nextNode : curNode.getNextNodeList()) {
                inMap.put(nextNode, inMap.get(nextNode) - 1);
                if (inMap.get(nextNode) == 0) {
                    queue.add(nextNode);
                }
            }

        }

        return result;
    }

    /**
     * 最小生成树之K算法
     */
    public Set<Edge<V>> kruskalMST() {
        // 1. 将所有边按权重从小到大排序
        List<Edge<V>> tempEdgeList = new ArrayList<>();
        Collections.copy(tempEdgeList, edgeList);
        tempEdgeList.sort(Comparator.comparingInt(Edge::getWeight));
        for (Edge<V> edge : tempEdgeList) {
            System.out.print(edge.getWeight() + " ");
        }
        // 1.1 将所有节点放入并查集中
        Code01_UnionFind_Test.UnionSet<V> unionFind = new Code01_UnionFind_Test.UnionSet<>();
        for (Node<V> node : nodeList.values()) {
            unionFind.add(node.getValue());
        }

        Set<Edge<V>> result = new HashSet<>();

        for (Edge<V> edge : edgeList) {
            // 2. 取权重最小的边判断边两端节点是否连通在一起
            if (!unionFind.isSameSet(edge.getFromNode().getValue(), edge.getToNode().getValue())) {
                // 3. 如果连通则要该边
                result.add(edge);
                unionFind.union(edge.getFromNode().getValue(), edge.getToNode().getValue());
            }
            // 4. 否则舍弃
        }
        return result;
    }

    /**
     * 最小生成树之P算法
     */
    public Set<Edge<V>> primMST() {
        return null;
    }

    public static class EdgeComparator<V> implements Comparator<Edge<V>> {

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.getWeight() - o2.getWeight();
        }

    }

}
