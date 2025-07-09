package org.example.DSA.Graph.Tree.Binary;

import org.example.DS.Graph.Tree.TreeNode;
import org.example.DSA.Graph.Tree.Binary.Traverse;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.example.DS.Graph.Tree.TreeNode.fromArray;
import static org.junit.jupiter.api.Assertions.*;

class TraverseTest {
    final Traverse OBJ = new Traverse();

    public static Stream<Arguments> preorderTraversal() {
        return Stream.of(
                Arguments.of(fromArray(new Integer[]{1,null,2,3}), List.of(1,2,3)),
                Arguments.of(fromArray(new Integer[]{1,2,3,4,5,null,8,null,null,6,7,9}), List.of(1,2,4,5,6,7,3,8,9)),
                Arguments.of(fromArray(new Integer[]{}), List.of()),
                Arguments.of(fromArray(new Integer[]{1}), List.of(1))
        );
    }

    @ParameterizedTest
    @MethodSource
    void preorderTraversal(TreeNode root, List<Integer> expected) {
        assertEquals(expected, OBJ.preorderTraversal(root));
    }

    public static Stream<Arguments> inorderTraversal() {
        return Stream.of(
                Arguments.of(fromArray(new Integer[]{1,null,2,3}), List.of(1,3,2)),
                Arguments.of(fromArray(new Integer[]{1,2,3,4,5,null,8,null,null,6,7,9}), List.of(4,2,6,5,7,1,3,9,8)),
                Arguments.of(fromArray(new Integer[]{}), List.of()),
                Arguments.of(fromArray(new Integer[]{1}), List.of(1))
        );
    }

    @ParameterizedTest
    @MethodSource
    void inorderTraversal(TreeNode root, List<Integer> expected) {
        assertEquals(expected, OBJ.inorderTraversal(root));
    }

    public static Stream<Arguments> postorderTraversal() {
        return Stream.of(
                Arguments.of(fromArray(new Integer[]{1,null,2,3}), List.of(3,2,1)),
                Arguments.of(fromArray(new Integer[]{1,2,3,4,5,null,8,null,null,6,7,9}), List.of(4,6,7,5,2,9,8,3,1)),
                Arguments.of(fromArray(new Integer[]{}), List.of()),
                Arguments.of(fromArray(new Integer[]{1}), List.of(1))
        );
    }

    @ParameterizedTest
    @MethodSource
    void postorderTraversal(TreeNode root, List<Integer> expected) {
        assertEquals(expected, OBJ.postorderTraversal(root));
    }

    public static Stream<Arguments> levelOrder() {
        return Stream.of(
                Arguments.of(fromArray(new Integer[]{3,9,20,null,null,15,7}), List.of(List.of(3), List.of(9,20), List.of(15,7))),
                Arguments.of(fromArray(new Integer[]{1}), List.of(List.of(1))),
                Arguments.of(fromArray(new Integer[]{}), List.of())
        );
    }

    @ParameterizedTest
    @MethodSource
    void levelOrder(TreeNode root, List<List<Integer>> expected) {
        assertEquals(expected, OBJ.levelOrder(root));
    }
}
