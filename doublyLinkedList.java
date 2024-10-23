public class doublyLinkedList {
    
    Node head,tail;
    int length;
    public static class Node{
        Node prev;
        int data;
        Node next;

        Node(int val){
            this.data=val;
            this.prev=null;
            this.next=null;
        }
    }

    doublyLinkedList(){
        head=null;
        tail=null;
        length=0;
    }

    public static void main(String[] args) {
        doublyLinkedList obj = new doublyLinkedList();
        // obj.head=new Node(0);
        // obj.head.next=new Node(1);
        // obj.head.next.prev=obj.head;
        // obj.head.next.next=new Node(2);
        // obj.head.next.next.prev=obj.head.next;
        // obj.head.next.next.next=new Node(3);
        // obj.head.next.next.next.prev=obj.head.next.next;
        obj.insertAtFront(0);
        obj.insertAtEnd(1);
        obj.insertAtEnd(2);
        obj.insertAtEnd(3);
        obj.insertAtEnd(4);
        obj.deleteAtFront();
        obj.deleteAtEnd();
        obj.display();
        System.out.println("Length of List is "+obj.length);
    }

    public void display(){
        Node temp1=head;
        Node temp2=tail;
        while (temp1!=null) {
            System.out.print(temp1.data+"->");
            temp1=temp1.next;
        }
        System.out.println("NULL");
        while (temp2!=null) {
            System.out.print(temp2.data+"->");
            temp2=temp2.prev;
        }
        System.out.println("NULL");
    }

    boolean isEmpty(){
        return length==0;
    }

    public void insertAtFront(int val){
        Node newNode = new Node(val);
        if(isEmpty()){
            tail=newNode;
        }else{
            head.prev=newNode;
        }
        newNode.next=head;
        head=newNode;
        length++;
    }

    public void insertAtEnd(int val){
        Node newNode=new Node(val);
        if (isEmpty()) {
            head=newNode;  
        }else{
            tail.next=newNode;

        }
        newNode.prev=tail;
        tail=newNode;
        length++;
    }

    public void deleteAtFront(){
        Node temp=head;
        if(isEmpty()){
            System.out.println("List is Empty");
        }else if(length==1){
            head=null;
            tail=null;
        }else{
            head=head.next;
            temp.next=null;
            head.prev=null;
            length--;
        }
    }

    public void deleteAtEnd(){
        Node temp=tail;
        if (isEmpty()) {
            System.out.println("List is Empty");
        }else if (length==1) {
            head=null;
            tail=null;
        }else{
            tail=tail.prev;
            temp.prev=null;
            tail.next=null;
            length--;
        }
    }

}
