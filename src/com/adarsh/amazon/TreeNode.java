package com.adarsh.amazon;

/**
 * @author adarshbhattarai on 2020-08-31
 * @project untitled
 */
public class TreeNode {

    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(int val){
        this.val=val;
    }

    void insert(int value){
        TreeNode root = this;
        TreeNode findParent = findInsertionNode(this,value, null);
        if(findParent == null) return;
        if(findParent.val < value){
            findParent.right = new TreeNode(value);
        }else{
            findParent.left = new TreeNode(value);
        }
    }

    TreeNode findInsertionNode(TreeNode root, int value, TreeNode parent){
        if(root==null)
            return parent;
        if(root.val>value){
            return findInsertionNode(root.left,value,root);
        }
        return findInsertionNode(root.right,value, root);
    }

    int distanceTo(int node1){

        if(this.val==node1) return 0;
        TreeNode nextNode=null;
        if(node1<this.val){
            nextNode=this.left;
        }else{
            nextNode=this.right;
        }

        return 1+ nextNode.distanceTo(node1);
    }

}
