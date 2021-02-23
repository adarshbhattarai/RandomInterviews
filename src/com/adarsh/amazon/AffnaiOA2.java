package com.adarsh.amazon;

import java.util.List;

/**
 * @author adarshbhattarai on 2020-08-31
 * @project untitled
 */
public class AffnaiOA2 {

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public int bstDistance(int num, List<Integer>values,
                           int node1, int node2)
    {
        // WRITE YOUR CODE HERE

        TreeNode tree = bst(values, node1, node2);
        if(tree==null) return -1;

        return findDistanceBetweenTwoNodes(tree, node1, node2);

    }

    private int findDistanceBetweenTwoNodes(TreeNode constructTree, int node1, int node2) {

        TreeNode commonAncestor = ancestor(constructTree, node1, node2);

        return commonAncestor.distanceTo(node1) + commonAncestor.distanceTo(node2);
    }

    public TreeNode ancestor(TreeNode root, int node1, int node2){

        for(;1>0;){
            if(root.val>node1 && root.val > node2){
                root=root.left;
            }else if(root.val<node1 && root.val < node2){
                root = root.right;
            }else{
                return root;
            }
        }
    }
    TreeNode bst(List<Integer> values, int node1, int node2){
        TreeNode root = null;
        boolean foundNode1=false;
        boolean foundNode2=false;
        for(Integer value : values){
            if(value==node1){
                foundNode1=true;
            }
            if(value==node2){
                foundNode2=true;
            }
            if(root==null){
                root=new TreeNode(value);
            }else{
                root.insert(value);
            }
        }

        return  foundNode1&&foundNode2 ? root : null;
    }
}
