package dataStructureAlgorithm.operationOfLinkedList;

public class LinkedListManual {
    public static class Node{
        public int data;
        public Node next;
    }
    Node head;

    public void insertAtStart(int data){
        Node node = new Node();
        node.data = data;
        node.next = head;
        head = node;
    }

    public void insertAtEnd(int data){
        Node node = new Node();
        node.data = data;
        node.next = null; // this is the last node, so the next node is null
        // if the linked list is empty, then the new node is the head node
        if (head == null){
            insertAtStart(data);
        }else{ // if the linked list is not empty, then find the last node and add the new node to the last node
            Node n = head;
            while(n.next != null){
                n = n.next;
            }
            n.next = node;
        }
    }

    public void insertAt(int index, int data){
        Node node = new Node();
        node.data = data;
        node.next = null;
        if (index == 0){
            insertAtStart(data);
        }else if(head == null){
            insertAtStart(data);
        }else{
            Node n = head;
            for (int i=0; i < index - 1; i++){ // find the node before the index
                n = n.next;
            }
            node.next = n.next; // the new node's next node is the node of the index
            n.next = node; // the node of the index's next node is the new node
        }
    }

    public void deleteAtStart(){
        if(head == null){
            System.out.println("The linked list is empty, nothing to delete.");
        }else{
            Node temp = head;
            head = head.next;
            temp = null;
        }
    }

    public void deleteAtEnd(){
        if (head == null){
            System.out.println("The linked list is empty, nothing to delete.");
        }else{
            Node n = head;
            while(n.next != null){
                n = n.next;
            }
            n = null;
        }
    }

    public void deleteAt(int index){
        if (head == null){
            System.out.println("The linked list is empty, nothing to delete.");
        }else if(index == 0){
            deleteAtStart();
        }else{
            Node n = head;
            for (int i = 0; i < index -1 ; i++){
                n = n.next;
            }
            Node temp = n.next;
            n.next = n.next.next;
            temp = null;
        }
    }

    public void show(){
        Node n = head;
        while(n.next != null){
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.print(n.data);
        System.out.println();
    }

    public void reverseList(){
        Node prevNode = null;
        Node currentNode = head;
        while (currentNode != null){
            Node nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }
        head = prevNode;
    }
}
