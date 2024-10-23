public class stack {
    Node top;
    int length;
    public class Node{
        int data;
        Node next;

        Node(int val){
            this.data=val;
            this.next=null;
        }
    }

    public void push(int val){
        Node newNode = new Node(val);
        newNode.next=top;
        top=newNode;
        length++;
    }

    public void pop(){
        if (isEmpty()) {
            System.out.println("Underflow");
            return;
        }
        top=top.next;
        length--;
    }

    public void display(){
        Node temp = top;
        while (temp!=null) {
            System.out.println(temp.data);
            temp=temp.next;
        }
        System.out.println("\n---------------\n");
    }

    public boolean isEmpty(){
        return length==0;
    }

    public static void main(String []args){
        stack obj= new stack();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        obj.push(5);
        obj.display();
        obj.pop();
        obj.display();
        obj.pop();
        obj.display();
        
        obj.pop();
        obj.display();
        obj.pop();
        obj.display();
        obj.pop();
        obj.pop();
        obj.display();

    }
}
