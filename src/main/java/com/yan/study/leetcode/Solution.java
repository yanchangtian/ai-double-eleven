package com.yan.study.leetcode;

public class Solution {

    public class TreeNode {
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

    public int maxSumBST(TreeNode root) {
        return maxSumBST1(root).maxSumBST;
    }

    public Info maxSumBST1(TreeNode root) {

        if (root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        Info leftInfo = maxSumBST1(root.left);
        Info rightInfo = maxSumBST1(root.right);

        int maxSumBST = Math.max(leftInfo.maxSumBST, rightInfo.maxSumBST);
        boolean isBST = false;
        if (leftInfo.isBST && rightInfo.isBST && root.val > leftInfo.max && root.val < rightInfo.max) {
            maxSumBST = Math.max(leftInfo.height + rightInfo.height + 1, maxSumBST);
            isBST = true;
        }

        int min = Math.min(leftInfo.min, rightInfo.min);
        int max = Math.max(leftInfo.max, rightInfo.max);

        min = Math.min(root.val, min);
        max = Math.max(root.val, max);

        return new Info(isBST, maxSumBST, min, max, Math.max(leftInfo.height, rightInfo.height) + 1);
    }

    public static class Info {
        public boolean isBST;
        public int maxSumBST;
        public int min;
        public int max;
        public int height;

        public Info(boolean isBST, int maxSumBST, int min, int max, int height) {
            this.isBST = isBST;
            this.maxSumBST = maxSumBST;
            this.min = min;
            this.max = max;
            this.height = height;
        }
    }

}
