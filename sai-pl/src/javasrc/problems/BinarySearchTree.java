package javasrc.problems;
import java.util.*;
/**
 * Created by INSRSAI1 on 5/30/2016.
 */
public class BinarySearchTree {

    class TreeNode<T> {
        T val;
        TreeNode left;
        TreeNode right;
        TreeNode next;
        TreeNode() {
            val = null;
            left = null;
            right = null;
            next = null;
        }
        TreeNode(T v) {
            val = v;
            left = null;
            right = null;
            next = null;
        }

        TreeNode neighbor;
    }

    //Level order traversal variant.
    /*A variation of level-order traversal. Because something can only be a neighbor when it's on the same level, it means we should keep the current level and the next level separated. And because a Node only has knowledge of its immediate child, that means we really only need to know about two levels at any time. This algorithm runs in O(n) time, using O(n) space.

      * output will be

        A->NULL
        B->C->NULL
        D->E->NULL
*/

    public static void attachNeighbors(TreeNode root) {
        Queue<TreeNode> currentLevel = new LinkedList<TreeNode>();
        Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
        currentLevel.add(root);

        while (!currentLevel.isEmpty()) {
            final TreeNode currentNode = currentLevel.remove();

            //Hashtable<currentNode.val, >

            if (currentNode.left != null) {
                nextLevel.add(currentNode.left);
            }
            if (currentNode.right != null) {
                nextLevel.add(currentNode.right);
            }

            if (currentLevel.isEmpty()) {
                Queue<TreeNode> temp = currentLevel; //so we don't use more memory than needed
                currentLevel = nextLevel;
                nextLevel = temp;
            } else {
                currentNode.neighbor = currentLevel.peek();
            }


        }


    }

    //solution without queues.(without support from utils)

    public void connectNeighbor(TreeNode root) {

        if (root == null) return;

        TreeNode lastHead = root;//previous level's head
        TreeNode lastCurrent = null;//pointer
        TreeNode currentHead = null;//current level's head
        TreeNode current = null;//pointer

        while (lastHead != null) {

            lastCurrent = lastHead;

            while (lastCurrent != null) {
                if (lastCurrent.left != null) {
                    if (currentHead == null)
                        currentHead = lastCurrent.left;
                    current = lastCurrent.left;
                } else {

                    current.next = lastCurrent.left;
                    current = current.next;
                }

                if (lastCurrent.right != null) {

                    if (currentHead == null) {

                        currentHead = lastCurrent.right;
                        current = lastCurrent.right;
                    } else {

                        current.next = lastCurrent.right;
                        current = current.next;
                    }
                }
                lastCurrent = lastCurrent.next;

            }

            lastHead = currentHead;
            currentHead = null;
        }
    }
}
