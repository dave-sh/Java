package com.thealgorithms.datastructures.lists;

import java.util.StringJoiner;

/**
 * https://en.wikipedia.org/wiki/Linked_list
 */
public class SinglyLinkedList {

    /**
     * Head refer to the front of the list
     */
    private Node head;

    /**
     * Size of SinglyLinkedList
     */
    private int size;

    /**
     * Init SinglyLinkedList
     */
    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    /**
     * Init SinglyLinkedList with specified head node and size
     *
     * @param head the head node of list
     * @param size the size of list
     */
    public SinglyLinkedList(Node head, int size) {
        this.head = head;
        this.size = size;
    }

    /**
     * Inserts an element at the head of the list
     *
     * @param x element to be added
     */
    public void insertHead(int x) {
        insertNth(x, 0);
    }

    /**
     * Insert an element at the tail of the list
     *
     * @param data element to be added
     */
    public void insert(int data) {
        insertNth(data, size);
    }

    /**
     * Sort the list in ascending order using bubble sort
     */

    public void sortAsc(){
        Node curr = head, next = null;

        if(head = null){
            /* the list is empty */
            return;
        }else{
            while (current != null) {
                /* Node next will point to node next to
                 current */
                next = current.next;
 
                while (index != null) {
                    // If current node's data is greater
                    // than next's node data, swap the data
                    // between them
                    if (current.data > next.data) {
                        int temp = current.data;
                        current.data = next.data;
                        next.data = temp;
                    }
 
                    next = next.next;
                }
                current = current.next;
            }
        }
    }

    /**
     * Inserts a new node at a specified position of the list
     *
     * @param data data to be stored in a new node
     * @param position position at which a new node is to be inserted
     */
    public void insertNth(int data, int position) {
        checkBounds(position, 0, size);
        Node newNode = new Node(data);
        if (head == null) {
            /* the list is empty */
            head = newNode;
            size++;
            return;
        } else if (position == 0) {
            /* insert at the head of the list */
            newNode.next = head;
            head = newNode;
            size++;
            return;
        }
        Node cur = head;
        for (int i = 0; i < position - 1; ++i) {
            cur = cur.next;
        }
        newNode.next = cur.next;
        cur.next = newNode;
        size++;
    }

    /**
     * Detects if there is a loop in the singly linked list using floy'd turtle
     * and hare algorithm.
  *
     */
    public boolean detectLoop() {
        Node currentNodeFast = head;
        Node currentNodeSlow = head;
        boolean flag = false;
        while (currentNodeFast != null && currentNodeFast.next != null && currentNodeSlow != null && currentNodeSlow.next != null) {
            currentNodeFast = currentNodeFast.next.next;
            currentNodeSlow = currentNodeSlow.next;
            if (currentNodeFast == currentNodeSlow) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    /**
     * Swaps nodes of two given values a and b.
  *
     */
    public void swapNodes(int a, int b) {
        Node currentNode = head;
        Node temp = null;
        while (currentNode != null) {
            if (currentNode.next.value == a) {
                temp = currentNode.next;
            }
            if (currentNode.next.value == b) {
                currentNode.next = temp;
            }
            currentNode = currentNode.next;
        }
    }

    /**
     * Reverse a singly linked list from a given node till the end
  *
     */
    Node reverseList(Node node) {
        Node prev = null, curr = node, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        node = prev;
        return node;
    }

    /**
     * Deletes a node at the head
     */
    public void deleteHead() {
        deleteNth(0);
    }

    /**
     * Deletes an element at the tail
     */
    public void delete() {
        deleteNth(size - 1);
    }

    /**
     * Deletes an element at Nth position
     */
    public void deleteNth(int position) {
        checkBounds(position, 0, size - 1);
        if (position == 0) {
            Node destroy = head;
            head = head.next;
            destroy = null;
            /* clear to let GC do its work */
            size--;
            return;
        }
        Node cur = head;
        for (int i = 0; i < position - 1; ++i) {
            cur = cur.next;
        }

        Node destroy = cur.next;
        cur.next = cur.next.next;
        destroy = null; // clear to let GC do its work

        size--;
    }

    /**
     * @param position to check position
     * @param low low index
     * @param high high index
     * @throws IndexOutOfBoundsException if {@code position} not in range
     * {@code low} to {@code high}
     */
    public void checkBounds(int position, int low, int high) {
        if (position > high || position < low) {
            throw new IndexOutOfBoundsException(position + "");
        }
    }

    /**
     * Clear all nodes in the list
     */
    public void clear() {
        Node cur = head;
        while (cur != null) {
            Node prev = cur;
            cur = cur.next;
            prev = null; // clear to let GC do its work
        }
        head = null;
        size = 0;
    }

    /**
     * Checks if the list is empty
     *
     * @return {@code true} if list is empty, otherwise {@code false}.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the size of the linked list.
     *
     * @return the size of the list.
     */
    public int size() {
        return size;
    }

    /**
     * Get head of the list.
     *
     * @return head of the list.
     */
    public Node getHead() {
        return head;
    }

    /**
     * Calculate the count of the list manually
     *
     * @return count of the list
     */
    public int count() {
        int count = 0;
        Node cur = head;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }

    /**
     * Test if the value key is present in the list.
     *
     * @param key the value to be searched.
     * @return {@code true} if key is present in the list, otherwise
     * {@code false}.
     */
    public boolean search(int key) {
        Node cur = head;
        while (cur != null) {
            if (cur.value == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * Return element at special index.
     *
     * @param index given index of element
     * @return element at special index.
     */
    public int getNth(int index) {
        checkBounds(index, 0, size - 1);
        Node cur = head;
        for (int i = 0; i < index; ++i) {
            cur = cur.next;
        }
        return cur.value;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("->");
        Node cur = head;
        while (cur != null) {
            joiner.add(cur.value + "");
            cur = cur.next;
        }
        return joiner.toString();
    }

    /**
     * Driver Code
     */
    public static void main(String[] arg) {
        SinglyLinkedList list = new SinglyLinkedList();
        assert list.isEmpty();
        assert list.size() == 0 && list.count() == 0;
        assert list.toString().equals("");

        /* Test insert function */
        list.insertHead(5);
        list.insertHead(7);
        list.insertHead(10);
        list.insert(3);
        list.insertNth(1, 4);
        assert list.toString().equals("10->7->5->3->1");

        /* Test search function */
        assert list.search(10) && list.search(5) && list.search(1) && !list.search(100);

        /* Test get function */
        assert list.getNth(0) == 10 && list.getNth(2) == 5 && list.getNth(4) == 1;

        /* Test delete function */
        list.deleteHead();
        list.deleteNth(1);
        list.delete();
        assert list.toString().equals("7->3");

        assert list.size == 2 && list.size() == list.count();

        list.clear();
        assert list.isEmpty();

        try {
            list.delete();
            assert false;
            /* this should not happen */
        } catch (Exception e) {
            assert true;
            /* this should happen */
        }
    }
}

/**
 * This class is the nodes of the SinglyLinked List. They consist of a value and
 * a pointer to the node after them.
 */
class Node {

    /**
     * The value of the node
     */
    int value;

    /**
     * Point to the next node
     */
    Node next;

    Node() {
    }

    /**
     * Constructor
     *
     * @param value Value to be put in the node
     */
    Node(int value) {
        this(value, null);
    }

    /**
     * Constructor
     *
     * @param value Value to be put in the node
     * @param next Reference to the next node
     */
    Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}
