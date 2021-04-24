package com.yan.study.leetcode;

import com.yan.study.example.class08.Code04_MaxSubBSTSize;

public class Solution01 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int maxSumBST(TreeNode root) {
        return process(root).maxSumBST;
    }

    public static Info process(TreeNode head) {

        if (head == null) {
            return null;
        }
        Info leftInfo = process(head.left);
        Info rightInfo = process(head.right);
        int min = head.val;
        int max = head.val;
        Integer maxSubBST = null;
        if (leftInfo != null) {
            min = Math.min(min, leftInfo.min);
            max = Math.max(max, leftInfo.max);
            maxSubBST = maxSubBST == null ? leftInfo.maxSumBST : Math.max(maxSubBST, leftInfo.maxSumBST);
        }
        if (rightInfo != null) {
            min = Math.min(min, rightInfo.min);
            max = Math.max(max, rightInfo.max);
            maxSubBST = maxSubBST == null ? rightInfo.maxSumBST : Math.max(maxSubBST, rightInfo.maxSumBST);
        }
        boolean isBST = false;
        if ((leftInfo == null ? true : (leftInfo.isBST && leftInfo.max < head.val))
                && (rightInfo == null ? true : (rightInfo.isBST && rightInfo.min > head.val))) {
            isBST = true;
            if (leftInfo != null && rightInfo == null) {
                maxSubBST = maxSubBST == null ? leftInfo.maxSumBST + head.val : Math.max(maxSubBST, leftInfo.maxSumBST + head.val);
            } else if (leftInfo == null && rightInfo != null) {
                maxSubBST = maxSubBST == null ? rightInfo.maxSumBST + head.val : Math.max(maxSubBST, rightInfo.maxSumBST + head.val);
            } else if (leftInfo != null && rightInfo != null) {
                maxSubBST = Math.max(maxSubBST, rightInfo.maxSumBST + leftInfo.maxSumBST + head.val);
            } else {
                maxSubBST = head.val;
            }
        }
        return new Info(isBST, maxSubBST, min, max);
    }

    public static class Info {
        public boolean isBST;
        public int maxSumBST;
        public int min;
        public int max;

        public Info(boolean isBST, int maxSumBST, int min, int max) {
            this.isBST = isBST;
            this.maxSumBST = maxSumBST;
            this.min = min;
            this.max = max;
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);

        n4.left = n3;
        n3.left = n1;
        n3.right = n2;

        maxSumBST(n4);

    }

}
