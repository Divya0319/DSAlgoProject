public class LinkedList {
    public LinkedList() {
        length = 0;
    }
    static class ListNode {
        private int data;
        private ListNode next;
        public ListNode(int data) {
            this.data = data;
        }
        
        public void setData(int data) {
            this.data = data;
        }
        
        public int getData() {
            return data;
        }
        
        public void setNext(ListNode next) {
            this.next = next;
        }
        
        public ListNode getNext() {
            return next;
        }
    }
    
    ListNode head;
    private int length = 0;
    
    public synchronized ListNode getHead() {
        return head;
    }
    
    public synchronized void insertAtBegin(ListNode node) {
        node.setNext(head);
        head = node;
        length++;
    }
    
    public synchronized void insertAtEnd(ListNode node) {
        ListNode temp = head;
        while(temp.getNext() != null) {
            temp = temp.getNext();
        }
        
        temp.setNext(node);
        node.setNext(null);
        
        length++;
    }
    
    public synchronized void insert(ListNode node, int position) {
        ListNode temp = head;
        int pos = 1;
        while(pos != position-1) {
            temp = temp.getNext();
            pos++;
        }
        
        node.setNext(temp.getNext());
        temp.setNext(node);
        length++;
    }
    
    public synchronized void deleteAtBegin() {
        if(head == null) {
            System.out.println("List is empty");
        }
        else {
            
        ListNode temp = head;
        head = head.next;
        temp = null;
        length--;
        
        }
    }
    
    public synchronized void deleteAtEnd() {
        if(head == null) {
            System.out.println("List is empty");
        }
        else {
            
        ListNode temp = head;
        while(temp.getNext().getNext() != null) {
            temp = temp.getNext();
        }
        ListNode nodeToDelete = temp.getNext();
        temp.setNext(null);
        length--;
        
        }
    }
    
    public synchronized void delete(int position) {
        if(head == null) {
            System.out.println("List is empty");
        } 
        else {
            ListNode temp = head;
        
        if(position < 0) 
            position = 1;
        if(position > getLength()) 
            position = getLength();
        
        if(position == 0) {
            head = head.getNext();
            temp = null;
        } 
        else {
            for(int i = 2; i <= position-1; i++) {
                temp = temp.getNext();
            }
            
            ListNode nodeToDelete = temp;
            temp.setNext(temp.getNext().getNext());
            
            nodeToDelete = null;
            
            
            
        }
        length--;
        }    
    }
    
    public int getLength() {
        return length;
    }
    
    public int getPosition(int data) {
        ListNode temp = head;
        int pos = 1;
        while(temp != null) {
            if(temp.getData() == data) {
                return pos;
            }
            
            pos++;
            temp = temp.getNext();
        }
        
        return -1;
    }
    
    public String toString() {
        String result = "[";
        if(head == null) {
            return result + "]";
        }
        result = result + head.getData();
        ListNode temp = head.getNext();
        while(temp != null) {
           result = result + ", " + temp.getData();
           temp = temp.getNext();
        }
        
        return result + "]";
    }
    
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ListNode ln1 = new ListNode(56);
        ll.insertAtBegin(ln1);
        System.out.println(ll.toString());
        ListNode ln2 = new ListNode(92);
        ll.insertAtBegin(ln2);
        System.out.println(ll.toString());
        ListNode ln3 = new ListNode(9);
        ll.insertAtBegin(ln3);
        System.out.println(ll.toString());
        ListNode ln4 = new ListNode(2);
        ll.insertAtBegin(ln4);
        System.out.println(ll.toString());
        ListNode ln5 = new ListNode(3);
        ll.insertAtBegin(ln5);
        System.out.println(ll.toString());
        ListNode ln6 = new ListNode(23);
        ll.insertAtBegin(ln6);
        System.out.println(ll.toString());
        ListNode ln7 = new ListNode(5);
        ll.insertAtBegin(ln7);
        System.out.println(ll.toString());
        ListNode ln8 = new ListNode(7565);
        ll.insertAtBegin(ln8);
        System.out.println(ll.toString());
        ListNode ln9 = new ListNode(123);
        ll.insertAtEnd(ln9);
        System.out.println(ll.toString());
        ListNode ln10 = new ListNode(16);
        ll.insert(ln10, 4);
        System.out.println(ll.toString());
        System.out.println(ll.getLength());
        ll.deleteAtBegin();
        System.out.println(ll.toString());
        System.out.println(ll.getLength());
        ll.deleteAtEnd();
        System.out.println(ll.toString());
        System.out.println(ll.getLength());
        ll.delete(5);
        System.out.println(ll.toString());
        System.out.println(ll.getLength());
        
        int ele = 16;
        int found = ll.getPosition(ele);
        if(found != -1) System.out.println("Element " + ele + " found at position " + found);
        
        else System.out.println("Element " + ele + " not found");


    }
}