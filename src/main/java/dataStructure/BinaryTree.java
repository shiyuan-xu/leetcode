package dataStructure;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            data = x;
        }
    }

    /**
     * 先序遍历非递归实现
     *
     * @param p
     */
    public void nPreOrder(TreeNode p) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = p;

        while (node != null || stack.size() > 0) {// 将所有左孩子压栈
            if (node != null) {
                System.out.print(node.data + " ");// 压栈前先访问
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                node = node.right;
            }
        }
    }

    /**
     * 前序遍历递归实现
     *
     * @param subTree
     */
    public void preOrder(TreeNode subTree) {
        if (subTree != null) {
            System.out.print(subTree.data + " ");
            preOrder(subTree.left);
            preOrder(subTree.right);
        }
    }

    /**
     * 中序遍历的非递归实现
     *
     * @param p
     */
    public void nInOrder(TreeNode p) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = p;

        while (node != null || stack.size() > 0) {
            if (node != null) {
                stack.push(node);// 直接压栈
                node = node.left;
            } else {
                node = stack.pop();// 出栈并访问
                System.out.print(node.data + " ");
                node = node.right;
            }
        }
    }

    /**
     * 中序遍历递归实现
     *
     * @param subTree
     */
    public void inOrder(TreeNode subTree) {
        if (subTree != null) {
            inOrder(subTree.left);
            System.out.print(subTree.data + " ");
            inOrder(subTree.right);
        }
    }

    /**
     * 后序遍历的非递归实现
     *
     * @param p
     */
    public void nPostOrder(TreeNode p) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<TreeNode> output = new Stack<TreeNode>();// 构造中间栈来存储逆后序遍历的结果
        TreeNode node = p;

        while (node != null || stack.size() > 0) {
            if (node != null) {
                output.push(node);
                stack.push(node);
                node = node.right;
            } else {
                node = stack.pop();
                node = node.left;
            }
        }
        while (output.size() > 0) {
            System.out.print(output.pop().data + " ");
        }
    }

    /**
     * 后序遍历递归实现
     *
     * @param subTree
     */
    public void postOrder(TreeNode subTree) {
        if (subTree != null) {
            postOrder(subTree.left);
            postOrder(subTree.right);
            System.out.print(subTree.data + " ");
        }
    }

    /**
     * 层次遍历
     *
     * @param p
     */
    public static void levelOrder(TreeNode p) {
        if (p == null)
            return;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(p);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            System.out.print(node.data + " ");
            if (node.left != null)
                q.offer(node.left);
            if (node.right != null)
                q.offer(node.right);
        }
    }
}
