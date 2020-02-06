/*
Given a linked list and a positive integer k, 
rotate the list to the right by k places.

For example, given the linked list 7 -> 7 -> 3 -> 5 and k = 2, 
it should become 3 -> 5 -> 7 -> 7.

Given the linked list 1 -> 2 -> 3 -> 4 -> 5 and k = 3, 
it should become 3 -> 4 -> 5 -> 1 -> 2.

Time:   O(N)
Space:  O(1)
*/

public class HelloWorld{
    static class Node{
        int data;
        Node next;
        Node(int val){
            data = val;
        }
    }
    public static void main(String []args){
        Node list = getList();
        
        printList(list);
        
        list = rotateList(list, 2);
        
         printList(list);
    }
    
    private static Node rotateList(Node node, int k){
        if(node == null) return null;
        
        
        Node head = node;
        Node behindHead = null;
        
        Node currentNode = node;
        while(currentNode.next != null){
            currentNode = currentNode.next;
        }
        
        currentNode.next = head;
        
        for(int i = 0; i < k; i++){
            behindHead = head;
            head = head.next;
        }
        
        behindHead.next = null;
        
        return head;
        
    }
    
    private static void printList(Node node){
        while(node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
    
    private static Node getList(){
        //7 -> 7 -> 3 -> 5
        Node lt = new Node(7);
        lt.next = new Node(7);
        lt.next.next = new Node(3);
        lt.next.next.next = new Node(5);
        
        return lt;
    }
}
