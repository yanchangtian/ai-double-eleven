package com.yan.study.leetcode;

public class Solution02 {

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
        System.out.println(process(root));
        return process(root).bSTMaxSum;
    }

    public static Info process(TreeNode root) {

        if (root == null) {
            return new Info(true, 0, 0, 0, null, null);
        }

        Info leftInfo = process(root.left);
        Info rightInfo = process(root.right);

        if (leftInfo.min == null && rightInfo.min == null) {
            return new Info(true, Math.max(0, root.val), root.val, Math.max(0, root.val), root.val, root.val);
        }

        int maxSum = Math.max(leftInfo.noBSTMaxSum, rightInfo.noBSTMaxSum);
        int bSTMaxSum = 0;
        int noBSTMaxSum = maxSum;
        boolean isBST = false;
        if (leftInfo.isBST && rightInfo.isBST
                && (leftInfo.max == null || root.val > leftInfo.max)
                && (rightInfo.min == null || root.val < rightInfo.min)) {
            isBST = true;
            bSTMaxSum = leftInfo.bSTMaxSum + rightInfo.bSTMaxSum + root.val;
            maxSum = Math.max(bSTMaxSum, maxSum);
        }

        int min = root.val;
        int max = root.val;

        min = leftInfo.min != null ? Math.min(leftInfo.min, min) : min;
        max = leftInfo.max != null ? Math.max(leftInfo.max, max) : max;

        min = rightInfo.min != null ? Math.min(rightInfo.min, min) : min;
        max = rightInfo.max != null ? Math.max(rightInfo.max, max) : max;

        return new Info(isBST, maxSum, bSTMaxSum, noBSTMaxSum, min, max);
    }

    public static class Info {
        public Boolean isBST;
        public Integer maxSum;
        public Integer bSTMaxSum;
        public Integer noBSTMaxSum;
        public Integer min;
        public Integer max;

        public Info(Boolean isBST, Integer maxSum, Integer bSTMaxSum, Integer noBSTMaxSum, Integer min, Integer max) {
            this.isBST = isBST;
            this.maxSum = maxSum;
            this.bSTMaxSum = bSTMaxSum;
            this.noBSTMaxSum = noBSTMaxSum;
            this.min = min;
            this.max = max;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "isBST=" + isBST +
                    ", maxSum=" + bSTMaxSum +
                    ", min=" + min +
                    ", max=" + max +
                    '}';
        }
    }

    public static void main(String[] args) {
        TreeNode n8 = new TreeNode(8);
        TreeNode n1 = new TreeNode(1);
        TreeNode n11 = new TreeNode(-1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n6 = new TreeNode(6);
        TreeNode n10 = new TreeNode(10);
        TreeNode n12 = new TreeNode(12);
        TreeNode n13 = new TreeNode(13);
        TreeNode n16 = new TreeNode(16);
        TreeNode n17 = new TreeNode(17);

        n8.left = n1;
        n1.left = n11;
        n1.right = n2;
        n2.right = n6;
        n8.right = n13;
        n13.left = n10;
        n10.right = n12;
        n13.right = n16;
        n16.right = n17;

        System.out.println(maxSumBST(n8));

    }

}
