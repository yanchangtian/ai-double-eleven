package com.yan.study.leetcode;

/**
 * 反转链表
 */
public class Solution03 {

    public static LinkedNode reverse01(LinkedNode head) {
        LinkedNode pre = null;
        LinkedNode cur = head;
        LinkedNode nex = head.next;

        while (nex != null) {
            cur.next = pre;
            pre = cur;
            cur = nex;
            nex = nex.next;
        }

        cur.next = pre;

        return cur;
    }

    public static void print(LinkedNode head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {

        LinkedNode n1 = new LinkedNode(1);
        LinkedNode n2 = new LinkedNode(2);
        LinkedNode n3 = new LinkedNode(3);
        LinkedNode n4 = new LinkedNode(4);
        LinkedNode n5 = new LinkedNode(5);
        LinkedNode n6 = new LinkedNode(6);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        print(n1);

        LinkedNode linkedNode = reverse01(n1);

        System.out.println("///");

        print(linkedNode);

    }

}
class LinkedNode {

    public Integer value;
    public LinkedNode next;

    public LinkedNode(Integer value) {
        this.value = value;
    }

}
