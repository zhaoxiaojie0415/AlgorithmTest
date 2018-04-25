package com.zxj.qs;

/**
 * Created by qs on 2018/3/21.
 */
public class TreeTravel {


    public static void main(String[] args) {
        Node n = new Node();
        n.setValue(0);
        Node n1 = new Node();
        n.setLeft(n1);
        n1.setValue(1);
        Node n2 = new Node();
        n2.setValue(2);
        n.setRight(n2);
        Node n3 = new Node();
        n3.setValue(5);
        n1.setLeft(n3);
        preOrderTravel(n);

    }

    private static void preOrderTravel(Node n) {
        if (n == null) {
            return;
        }
        System.out.println(n.getValue());
        Node right = n.getRight();
        Node left = n.getLeft();
        preOrderTravel(left);
        preOrderTravel(right);
    }

    static class Node<T> {
        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }


        Node left;
        Node right;

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        T value;
    }


    private static Node split(String[] preorder, String[] inorder, int prebegin, int preend, int inbegin, int inend) {
        Node root = new Node();
        String rootvalue = preorder[prebegin];
        int startindex = inbegin;
        if (prebegin == preend) {
            root.setValue(preorder[prebegin]);
        }
        while (startindex < inend && !inorder[startindex].equals(rootvalue)) {
            startindex ++;
        }
        int leftlenth = startindex - inbegin;
        int rightlenth = (preend - prebegin) - leftlenth;
        if (leftlenth > 0) {
            root.setLeft(split(preorder, inorder, prebegin + 1, prebegin + leftlenth, inbegin, startindex -1));
        }
        if (rightlenth > 0) {
            root.setRight(split(preorder, inorder, prebegin + 1 + leftlenth, preend, startindex + 1, inend));
        }

        return root;
    }

    private static int split(String root, String[] inorder) {
        if (inorder.length == 1) {

            return 0;
        }
        for (int i =0; i < inorder.length; i++) {
            if (root.equals(inorder[i])) {
                return i;
            }
        }
        return -1;
    }
}
