public class adding {

    Node num1, num2;

    public static class Node {
        int data;
        Node next;

        Node(int val) {
            this.data = val;
            this.next = null;
        }
    }

    public void add() {
        Node buf = new Node(0);
        Node res = buf;
        Node temp1 = num1, temp2 = num2;
        int sum, carry = 0;
        
        while (temp1 != null || temp2 != null || carry != 0) { // include carry check
            int x = (temp1 != null) ? temp1.data : 0;
            int y = (temp2 != null) ? temp2.data : 0;
            sum = carry + x + y;  // add carry to x and y
            carry = sum / 10;      // update carry (corrected here)
            sum = sum % 10;        // digit to store in the current node
            res.next = new Node(sum); // store the result
            res = res.next;

            if (temp1 != null) temp1 = temp1.next;
            if (temp2 != null) temp2 = temp2.next;
        }
        display(buf.next); // Display result list
    }

    public static void main(String[] args) {
        adding obj = new adding();
        obj.num1 = new Node(3);
        obj.num1.next = new Node(7);
        obj.num1.next.next = new Node(2);

        // Second list: 9 -> 2 -> NULL
        obj.num2 = new Node(9);
        obj.num2.next = new Node(2);
        
        obj.display();
        obj.add();
    }

    // Method to display both linked lists
    private void display() {
        Node temp1 = num1;
        Node temp2 = num2;

        // Display num1 list
        System.out.print("List 1: ");
        while (temp1 != null) {
            System.out.print(temp1.data + " -> ");
            temp1 = temp1.next;
        }
        System.out.println("NULL");

        // Display num2 list
        System.out.print("List 2: ");
        while (temp2 != null) {
            System.out.print(temp2.data + " -> ");
            temp2 = temp2.next;
        }
        System.out.println("NULL");
    }

    // Display result linked list
    private void display(Node node) {
        Node temp1 = node;
        System.out.print("Result: ");
        while (temp1 != null) {
            System.out.print(temp1.data + " -> ");
            temp1 = temp1.next;
        }
        System.out.println("NULL");
    }
}
