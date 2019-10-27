package com.adarsh.googleOnlineAssessmentQuestions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author adarshbhattarai on 2019-10-27
 * @project untitled
 *
 * Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
 *
 * Return the smallest level X such that the sum of all the values of nodes at level X is maximal.
 *
 * https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
 */
public class MaximumLevelSumOfBST {

    public static void main(String[] args) {
        MaximumLevelSumOfBST mst = new MaximumLevelSumOfBST();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(-8);

        long startTime = System.currentTimeMillis();

        System.out.print(mst.maxLevelSum(root)+ " : ");
        System.out.println(System.currentTimeMillis()-startTime);
        startTime = System.currentTimeMillis();
        System.out.print(mst.maxLevelSumTopRatedLC(root) + " : ");
        System.out.print(System.currentTimeMillis()-startTime);

    }
    public int maxLevelSum(TreeNode root) {

        if(root == null)
            return 0;
        int maxLevel=1,maxSum=0,currentSum=0;
        int level =1;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr == null){
                if(!q.isEmpty()){
                    q.add(null);
                }
                if(currentSum>maxSum){
                    maxSum = currentSum;
                    maxLevel = level;
                }
                level++;
                currentSum=0;

                continue;
            }
            int currentVal = curr.val;
            currentSum+=currentVal;
            if(curr.left!=null){
                q.add(curr.left);
            }
            if(curr.right!=null){
                q.add(curr.right);
            }
        }

        return maxLevel;
    }

    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x) { val = x; }
    }

    public int maxLevelSumTopRatedLC(TreeNode root) {

         if (root == null) {
         return 0;
         }

                  //List<Integer> sums = new ArrayList<>();
         int[] sums = new int[1000];
         add(root, sums, 0);

         int max = sums[0];
         int index = 0;
         for (int i = 1; i < sums.length; i++) {
         if (sums[i] > max) {
         index = i;
         max = sums[i];
         }
         }
         return index + 1;
    }

    private void add(TreeNode node, int[] sums, int depth) {
          //System.out.println(sums);
            sums[depth] += node.val;
            if (node.left != null) {
            add(node.left, sums, depth + 1);
            }
            if (node.right != null) {
            add(node.right, sums, depth + 1);
            }
    }
}