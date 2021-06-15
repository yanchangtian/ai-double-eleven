package com.yan.study.example.class04_test;

public class Code02_Heap01<V> {

    private V[] heap;
    private Integer limit;
    private Integer heapSize;

    public void add(V v) {
        if (heapSize < limit) {
            heapInsert(heapSize - 1);
        }
    }

    private void heapInsert(Integer index) {

    }

}
