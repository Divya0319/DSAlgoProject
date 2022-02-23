public class LinkedList {
    
        CLLNode head;
    
        static class CLLNode {
            int data;
            CLLNode next;
            
            public CLLNode(int d) {
            data = d;
            next = null;
          }
        }
        
        
    
    public void addNodeAtBegin(int data) {
        CLLNode newNode = new CLLNode(data);
        newNode.next = newNode;

        if(head == null) {
            head = newNode;
            newNode.next = newNode;
        }
        else {
            CLLNode last = head;
            while(last.next!=head) {
                last = last.next;
            }
            
            last.next = newNode;
            newNode.next = head;
            head = newNode;
        }
        
    }
    
    public void addNodeAtEnd(int data) {
        CLLNode newNode = new CLLNode(data);

        if(head == null) {
            head = newNode;
            newNode.next = newNode;
        }
        else {
            CLLNode last = head;
            while(last.next!=head) {
                last = last.next;
            }
            
            last.next = newNode;
            newNode.next = head;
        }
    }
    
    
    public void deleteNodeAtBegin() {
        
        CLLNode temp = head;
        
        if(head == null) System.out.println("Underflow");
        
        else if(temp.next == temp) {
            int deleted = head.data;
            head = null;
        }
        
        else {
            while(temp.next != head) {
                temp = temp.next;
            }
            
            CLLNode deleted = head;
            
            head = head.next;
            temp.next = head;
        }
        
    }
    
    public void deleteNodeAtEnd() {
        
        CLLNode temp = head;
        
        if(head == null) System.out.println("Underflow");
        
        else if(temp.next == temp) {
            int deleted = head.data;
            head = null;
        }
        
        else {
            while(temp.next.next!=head) {
                temp = temp.next;
            }
            
            CLLNode deleted = temp.next;
            
            temp.next = head;
            
        }
        
    }
    
    public  void displayList() {
        CLLNode currNode = head;
        
        if(head == null) 
        { System.out.println("Underflow!!");
          return;
        }
        while(currNode.next != head) {
            System.out.print(currNode.data + "->");
            currNode = currNode.next;
        }
        System.out.print(currNode.data + "->");

        System.out.println();
    }

    public static void main(String args[]) {
        
        LinkedList list = new LinkedList();
        list.addNodeAtEnd(5);
        list.displayList();
        list.addNodeAtEnd(6);
        list.displayList();
        list.addNodeAtEnd(7);
        list.displayList();
        list.addNodeAtEnd(8);
        list.displayList();
        list.addNodeAtEnd(90);
        list.displayList();
        
        list.addNodeAtBegin(21);
        list.displayList();
        list.addNodeAtBegin(40);
        list.displayList();
        
        list.deleteNodeAtBegin();
        list.displayList();
        
        list.deleteNodeAtEnd();
        list.displayList();
        list.deleteNodeAtEnd();
        list.displayList();
        
        list.deleteNodeAtBegin();
        list.displayList();
        list.deleteNodeAtBegin();
        list.displayList();
        list.deleteNodeAtBegin();
        list.displayList();
        list.deleteNodeAtBegin();
        list.displayList();

      
    }
    
}