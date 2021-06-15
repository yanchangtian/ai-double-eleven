package com.yan.study.example.class10_test;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 图 -> 节点
 */
@Data
public class Node<V> {

    private V value;

    private Integer in;

    private Integer out;

    private List<Node<V>> nextNodeList = new ArrayList<>();

    private List<Edge<V>> outEdgeList = new ArrayList<>();

    public Node(V v) {
        this.value = v;
    }

    public void addNextNode(Node<V> node) {
        nextNodeList.add(node);
    }

    public void addOutEdge(Edge<V> edge) {
        outEdgeList.add(edge);
    }

    public void incrIn() {
        in++;
    }

    public void incrOut() {
        out++;
    }

}
