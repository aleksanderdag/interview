package org.example.DSA.Graph.Tree.Binary;

import org.example.DS.Graph.Tree.TreeNode;

import java.util.*;

public class Traverse {
    // TODO: implement List
    // TODO: possible promotion to treenode class
    // node -> list.add
    // recurse(left) -> curr = left [follow left]
    // recurse(right) -> stack.add [pop right]
    public List<Integer> preorderTraversal(TreeNode root) {
        var list = new ArrayList<Integer>();
        var stack = new Stack<TreeNode>();

        stack.add(root);
        while(!stack.isEmpty()) {
            var curr = stack.pop();

            // get all lefts
            while (curr != null) {
                list.add(curr.val);
                stack.add(curr.right);
                curr = curr.left;
            }
        }

        return list;
    }

    // TODO: why doesn't empty fail?
    // TODO: clean up
    // recurse(left) -> list.add [follow left]
    // node -> stack.add [pop parent]
    // recurse(right) -> curr = parent.right
    public List<Integer> inorderTraversal(TreeNode root) {
        var list = new ArrayList<Integer>();
        var stack = new Stack<TreeNode>();

        var curr = root;
//        if(root == null) return list;

        // get left most
        while(curr != null) {
            stack.add(curr);
            curr = curr.left;
        }

        while (!stack.isEmpty()) {
            curr = stack.pop();
            list.add(curr.val);
            curr = curr.right;

            // get left most
            while(curr != null) {
                stack.add(curr);
                curr = curr.left;
            }
        }

        return list;
    }

    // recurse(left)
    // recurse(right)
    // node
    public List<Integer> postorderTraversal(TreeNode root) {
        var list = new ArrayList<Integer>();
        var stack = new Stack<Stack<TreeNode>>();

        if(root == null) return list;

        var curr = root;

        do {
            var leftStack = new Stack<TreeNode>();

            // fill stack with left
            while (curr != null) {
                leftStack.add(curr);
                curr = curr.left;
            }

//            stack.add(leftStack);
            curr = leftStack.pop();

            // get curr with right
            while (curr.right == null) {
                list.add(curr.val);
//                System.out.println(list);
//                if (leftStack.empty() && stack.empty()) return list;
                while (leftStack.empty()) {
                    if (stack.empty()) return list;
                    leftStack = stack.pop();
                    list.add(leftStack.pop().val);
//                    System.out.println(list);
                }
                curr = leftStack.pop();
            }

            leftStack.add(curr);
//            if(!leftStack.empty()) stack.add(leftStack);
            stack.add(leftStack);
            curr = curr.right;
            // curr is ready for processing - add left to stack and cut right
        } while (!stack.empty());

//        System.out.println(stack);

        return list;
    }

    private static void levelOrder(TreeNode root, int level, List<List<Integer>> list) {
        if (root != null) {
            if (list.size() == level) list.add(new ArrayList<>());
            list.get(level).add(root.val);
            levelOrder(root.left, level+1, list);
            levelOrder(root.right, level+1, list);
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        levelOrder(root, 0, list);
        return list;

//        ArrayList<List<Integer>> list = new ArrayList<>();
//        if(root == null) return list;
//        var q = new ArrayDeque<TreeNode>();
//        q.add(root);
//
//        while (!q.isEmpty()) {
//            int size = q.size();
//            var currList = new ArrayList<Integer>();
//            for (int i = 0; i < size; i++) {
//                TreeNode curr = q.poll();
//                currList.add(curr.val);
//                if (curr.left != null) q.add(curr.left);
//                if (curr.right != null) q.add(curr.right);
//            }
//            list.add(currList);
//        }
//
//        return list;
    }
}
