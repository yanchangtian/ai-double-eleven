package com.yan.study.example.class10_test;

import lombok.Data;

/**
 * 图 -> 边
 */
@Data
public class Edge<V> {

    private Integer weight;

    private Node<V> fromNode;

    private Node<V> toNode;

    public Edge(Integer weight, Node<V> fromNode, Node<V> toNode) {
        this.weight = weight;
        this.fromNode = fromNode;
        this.toNode = toNode;
    }

}
