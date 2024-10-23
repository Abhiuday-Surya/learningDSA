public class circularSinglyLinedList {
    
    Node last;int length;
    public static class Node {
        int data;
        Node next;
        Node(int val){
            this.data=val;
            this.next=null;
        }
    }

    circularSinglyLinedList(){
        last=null;
        length=0;
    }

    public void addNodeFront(int value){
		
		Node node = new Node(value);
		if(last==null){
            last=node;
		}else{
            node.next=last.next;
        }
		last.next=node;
        length++;
	}

    public void addNodeRear(int value){
		
		Node node = new Node(value);
		if(last==null){
            last=node;
		}else{
            node.next=last.next;
        }
		last.next=node;
        last=node;
        length++;
	}

    public void deleteAtEnd(){

    }

    public void deleteAtFront(){
        
    }

    public void traversing(){
        if (last==null) {
            return;
        }
        Node first = last.next;
        while(first!=last){
            System.out.print(first.data+"->");
            first=first.next;
        }
        System.out.println(first.data+"->NULL");
    }

    public boolean detectLoop(){
		Node fastPtr = last;
		Node slowPtr = last;
		while(fastPtr!=null&&fastPtr.next!=null){
			fastPtr=fastPtr.next.next;
			slowPtr=slowPtr.next;
			if(fastPtr==slowPtr)
				return true;

		}
		return false;
	}

    public static void main(String[] args) {
        circularSinglyLinedList obj = new circularSinglyLinedList();
        obj.addNodeRear(1);
        obj.addNodeRear(2);
        obj.addNodeRear(3);
        obj.addNodeRear(4);
        obj.addNodeRear(5);
        System.out.println(obj.detectLoop());
        obj.traversing();

    }

}
