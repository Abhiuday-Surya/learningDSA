class singlylinkedlist{
	
	Node head;

	public static class Node{
		int data;
		Node next;
		Node(int value){
			this.data=value;
			this.next=null;
		}
	}

	public void display(){
		Node current = head;
		while(current!=null){
			System.out.print(current.data+"-->");
			current=current.next;
		}
		System.out.print("Null\n");
	}

	public void addNodeFront(int value){

		Node node = new Node(value);
		node.next=head;
		head=node;

	}

	public void addNodePos(int value,int pos){

		Node node = new Node(value);
		if(pos==1){
			node.next=head;
			head=node;
			return;
		}
		int counter =1;
		Node current = head;
		while(counter<pos-1){
			current=current.next;
			counter++;
		}
		node.next=current.next;
		current.next=node;

	}

	public void addNodeRear(int value){
		
		Node node = new Node(value);
		if(head==null){
			head=node;
			return;
		}
		Node current = head;
		while(current.next!=null){
			current=current.next;
		}
		current.next=node;
	}

	public int search(int value){
		Node current = head;
		int counter=1;
		while(current!=null){
			if(current.data==value)
				return counter;
			counter++;
			current=current.next;
		}
		return 0;
	}

	public void reverse(){
		
		Node current = head;
		Node previous = null;
		Node next = null;

		while(current!=null){
			next=current.next;
			current.next=previous;
			previous=current;
			current=next;
		}
		
		head=previous;
	}

	public Node getNthNodeFromEnd(int n){

		if(head==null)
			return null;
		if(n<=0)
			throw new IllegalArgumentException("Invalid value of n "+n);

		Node refNode = head;
		Node mainNode = head;
		int counter = 0;
		while(counter<n){
			if(refNode==null)
				throw new IllegalArgumentException("The value of N i greater than the no of nodes in the list");
			refNode=refNode.next;
			counter++;
		}
		while(refNode!=null){
			refNode=refNode.next;
			mainNode=mainNode.next;
		}
		return mainNode;

	}

	public void removeDuplicate(){
		if(head==null)
			return;
		Node current =head;
		while(current!=null&&current.next!=null){
			if(current.data==current.next.data)
				current.next=current.next.next;
			else
				current=current.next;
		}
	}

	public void insertInSortedList(int value){

		Node node=new Node(value);

		if(head == null||head.data>=value){
			node.next=head;
			head=node;
			return;
		}
		Node current = head;
		while(current.next!=null&&current.next.data<=value){
			current=current.next;
		}
		node.next=current.next;
		current.next=node;
	}

	public void removeKey(int value){
		Node current = head;
		if(current!=null&&current.data==value){
			head=current.next;
			return;
		}
		while(current.next!=null&&current.next.data!=value){
			current=current.next;
		}
		current.next=current.next.next;

	}

	public boolean detectLoop(){
		Node fastPtr = head;
		Node slowPtr = head;
		while(fastPtr!=null&&fastPtr.next!=null){
			fastPtr=fastPtr.next.next;
			slowPtr=slowPtr.next;
			if(fastPtr==slowPtr)
				return true;

		}
		return false;
	}

	public Node getStsrtingNodeOfLoop(){
		Node fastPtr = head;
		Node slowPtr = head;
		while(fastPtr!=null&&fastPtr.next!=null){
			fastPtr=fastPtr.next.next;
			slowPtr=slowPtr.next;
			if(fastPtr==slowPtr)
				return getStart(slowPtr);

		}
		return null;
	}

	private Node getStart(Node slowPtr) {
		Node buffer = head;
		Node buffer2 = slowPtr;
		while(buffer!=buffer2){
			buffer=buffer.next;
			buffer2=buffer2.next;
		}
		return buffer;
	}

	public static void main(String[] args){
		
		singlylinkedlist sll = new singlylinkedlist();

		sll.head=new Node(1);
		Node second=new Node(2);
		Node third=new Node(3);
		Node fourth = new Node(4);

		sll.head.next=second;
		second.next=third;
		third.next=fourth;
		
		/*sll.addNodeFront(1);
		sll.addNodeRear(5);
		sll.addNodePos(1,1);

		System.out.println(sll.search(17));
		sll.display();

		sll.reverse();
		System.out.println();
		sll.display();


	
		System.out.println();
		System.out.println(sll.getNthNodeFromEnd(5).data);

		*/
		sll.display();
		//sll.removeDuplicate();
		sll.insertInSortedList(5);
		sll.insertInSortedList(6);
		sll.insertInSortedList(7);
		sll.removeKey(6);
		sll.removeKey(7);
		System.out.println(sll.detectLoop());
		fourth.next=second;
		System.out.println(sll.detectLoop());
		System.out.println(sll.getStsrtingNodeOfLoop().data);
	}
}
