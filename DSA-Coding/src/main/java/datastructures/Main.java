package datastructures;

import datastructures.LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList myLinkedList = new LinkedList(4);
        //myLinkedList.printAll();
        //myLinkedList.append(5);
        myLinkedList.prependNode(3);

        //myLinkedList.append(6);
        myLinkedList.printList();

        System.out.println("removed last node " + myLinkedList.removeLastNode().value);
        System.out.println("removed last node " + myLinkedList.removeLastNode().value);

        myLinkedList.prependNode(88);
        //System.out.println("removed last node " + myLinkedList.removeLastNode());

        System.out.println("============");

        myLinkedList.printList();

    }
}