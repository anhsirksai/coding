package javasrc.problems;

import java.util.*;

public class LinkedList
{
    Node head;

    static class Node
    {
        int item;
        Node next;
        Node(int d) { item = d; next = null;}

    }

    void insertNode(Node head,int item)
    {
        Node newNode = createNode(item);
        // insert at beginning

        // insert at end

        // insert at a given position( if previous node is given)
        //
        // insert at a given position (if previous node is not given)

    }


    Node createNode(int item)
    {
        Node newNode = new Node(item);
        return newNode;
    }

    void deleteNode(Node delNode, int item)
    {
        // delete node at a given position
        //  if(nead to be removed) : head = temp.next
        //  end and any other position is the same.
        //
        // delete node if the item value is given.
        //
        // Logic :
        // 1. find the previous node
        // 2. attach the prev.next -> curr.next
        // 3. free current.
    }

    //search : iterative and recursive solutions
    //
    //given a key, search for the same in linked list, return true if found, else false.
    //
    //iterative :
    // initialize current pointer to head
    // if curr.item == key, return curr;
    // else curr = curr.next;
    // if not found : return false.
    //
    boolean searchList(Node searchNode, int item)
    {

        return true;
    }

    //recursive solution:
    //if(head  == null) return false;
    //if(head->item == key) return true;
    //return search(head->next,key)
    boolean search(Node node, int key){

        return true;
    }

    
    // Length of list : iterative and recursive solution. - write your own.


    // Swap Nodes :
    //
    // cases : x,y may not be adjacent
    //       : x or y may be a head node
    //       : x or y may be a last node
    //       : x and/or y may not be in the list.
    //
    // Optimation : The swap can be performed in a single traversal using two loops
    public void swapNodes(int x, int y)
    {
    
    }



    void printList()
    {
        Node n = head;
        while(n != null)
        {
            System.out.println(n.item + " ");
            n = n.next;
        }
    }

    public static void main(String[] args)
    {
        LinkedList ll = new LinkedList();
        ll.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);

        ll.head.next = second;
        second.next = third;

        ll.printList();
    }


}
