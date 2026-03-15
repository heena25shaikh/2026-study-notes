package datastructures;

import jdk.jshell.spi.SPIResolutionException;

import java.security.PublicKey;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    //inner class̄ of LinkedList class
    class Node {
        int value;
        Node next;

        Node(int value) {

            this.value = value;
        }
    }

    //Constructor
    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }


    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    //append element to linkedList (add element)
    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    //Prepend node
    public void prependNode(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
           /* Node temp = head;
            head =newNode;
            head.next = temp;*/
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    //Remove last node
    public Node removeLastNode() {
        if (length == 0) {
            return null;
        }
        Node temp = head;
        Node pre = head;
        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        //after decrementing length(1-1 = 0) if there is no element left in linkedList
        if (length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }



    //Remove FirstNode
    public Node removeFirstNode() {
        Node temp = head;
        if (length == 0) {
            return null;
        } else {
            head = head.next;
            temp.next=null;
            length--;

            //after decrementing length if there is no element left in linkedList
            if(length==0){
                temp = head;
                temp.next=null;
                head=null;
                tail=null;
                length--;
            }
        }
        return temp;
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }
}

