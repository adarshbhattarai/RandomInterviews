package com.adarsh;

import java.util.*;

/**
 * Created by adarshbhattarai on 12/4/18.
 */

class Tree{
    Node root;
}
class Node{
    Node left;
    Node right;
    int value;
    Node(int value){
        this.value = value;
    }
}

class ListNode{
    ListNode next;
    int value;
    ListNode(int value){
        this.value=value;
    }
}


public class RamiroQuestions {

    public static void main(String[] args){

        List[] l = new List[3];
        for(int i=0;i<3;i++) l[i] = new ArrayList<>();

        int [] array = {1,2,3,4,5,6,7,8};
        Tree t = createTree(array);

        getOrders(t.root,l);

        System.out.println("All Orders Are");

        System.out.println("Inorder   ==> " + l[0]);

        System.out.println("PreOrder  ==> " + l[1]);

        System.out.println("PostOrder ==> " + l[2]);

        List<Integer> postOrder = constructPostOrder(l[0].stream().mapToInt(i->(int)i).toArray(),l[1].stream().mapToInt(i->(int)i).toArray());

        int postOrderIndex=0;
        for(int i:postOrder) if(i!=(int)l[2].get(postOrderIndex++)) System.out.println("Not correct");

        System.out.println("Constructed Post Order ==> " + postOrder);


        ListNode linkedList = createLinkedList(array);
        ListNode cur = linkedList;
        while(cur!=null){ System.out.print(cur.value+" -> " ); cur=cur.next;};
        System.out.print("null");
        System.out.println("");

        cur = reverseLinkedList(linkedList);;
        while(cur!=null){ System.out.print(cur.value+" -> " ); cur=cur.next;};
        System.out.print("null");



    }

    private static ListNode reverseLinkedList(ListNode linkedList) {
        if(linkedList == null) return null;
        if(linkedList.next == null) return  linkedList;
        ListNode next = linkedList.next;
        linkedList.next = null;
        ListNode reverse = reverseLinkedList(next);
        next.next = linkedList;
        return reverse;
    }

    private static ListNode createLinkedList(int[] array) {

        ListNode current = new ListNode(0);
        ListNode dummy = current;
        for(int i : array){
            ListNode l = new ListNode(i);
            dummy.next =l;
            dummy = dummy.next;
        }
        return current.next;
    }

    //It will be more easier if we see the list,
    // What we can observe is the first value in preorder is root and all the elements
    // in the inorder that are left to the given index are the root's left and
    //all the elements in the right of the pre[rootIndex] is the right of tree
    private static List constructPostOrder(int[] inorder, int[] preorder) {
        List<Integer> returnList = new ArrayList();
        Map m = new HashMap<>();
        int j=0;
        for(int i : inorder) m.put(i,j++);
        constructPostOrder(inorder,preorder,0,inorder.length-1,m,returnList);
        return returnList;
    }

    static int preorderInd;
    private static void constructPostOrder(int[] inorder, int[] preorder, int start, int end, Map map, List l) {

        //to get postorder, go left, right then add to list and do this recursively
        if(start<=end){
            int inOrderIndex = (int)map.get(preorder[preorderInd++]);
            //left Tree is in left of inOrderIndex.
            constructPostOrder(inorder,preorder,start,inOrderIndex-1,map,l);
            //Right of tree will be right to inOrderIndex;
            constructPostOrder(inorder,preorder,inOrderIndex+1,end,map,l);
            //add the value once traversed left, right, this will be in postorder;
            l.add(inorder[inOrderIndex]);
        }
    }

    private static void getOrders(Node t,List[] l) {

        if(t!=null){
            l[1].add(t.value);    //PreOrder
            getOrders(t.left,l);
            l[0].add(t.value);    //Inorder
            getOrders(t.right,l);
            l[2].add(t.value);    //Inorder
        }
    }

    private static Tree createTree(int[] array) {

        Tree t = new Tree();
        t.root = insertInTree(array,t.root,0);
        return t;
    }

    private static Node insertInTree(int[] array, Node root,int index) {

        if(index>=array.length) return root;
        Node curr = new Node(array[index]);
        root = curr;
        root.left = insertInTree(array,root.left,2*index+1);
        root.right = insertInTree(array,root.right,2*index+2);
        return root;
    }

}

