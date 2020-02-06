/*
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
