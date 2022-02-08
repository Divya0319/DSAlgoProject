public class DoublyLinkedList {
    
    private DLLNode head;
    private int length;

    static class DLLNode {
        private int data;
        private DLLNode prev;
        private DLLNode next;
        
        public DLLNode(int data) {
            this.data  =data;
            this.prev = null;
            this.next = null;
        }
        
        public int getData() {
            return data;
        }
        
        public void setData(int data) {
            this.data = data;
        } 
        
        public DLLNode getNext() {
            return next;
        }
        
        public void setNext(DLLNode next) {
            this.next = next;
        }
        
        public DLLNode getPrev() {
            return prev;
        }
        
        public void setPrev(DLLNode prev) {
            this.prev = prev;
        }
     }
     
     public int getLength() {
         return length;
     }
     
     public DLLNode getHead() {
         return head;
     }
    
    public DoublyLinkedList() {
        length = 0;
    }
    
    public void insertAtBegin(int data) {
    DLLNode nNode = new DLLNode(data);
            if(head == null) {
                head = nNode;
                nNode.next = null;
                nNode.prev = null;
                length++;

                return;

            }

    nNode.setNext(head);
    head = nNode;
    nNode.setPrev(null);
    head.getNext().setPrev(head);
    length++;
        
    }
    
    public void insertAtEnd(int data) {
    DLLNode nNode = new DLLNode(data);
            if(head == null) {
                head = nNode;
                nNode.next = null;
                nNode.prev = null;
                length++;

                return;

            }

    DLLNode temp = head;
    while(temp.getNext() != null) {
        temp = temp.getNext();
    }
    
    temp.setNext(nNode);
    nNode.setPrev(temp);
    nNode.setNext(null);
    length++;
        
    }
    
    public void insertAtMiddle(int data, int position) {
        if(position < 0) position = 1;
        if(position > getLength()) position = length;
        
         DLLNode nNode = new DLLNode(data);
         if(position == 1){ 
            head = nNode;
            nNode.next = null;
            nNode.prev = null;
            length++;

            return;
         }
         
         DLLNode temp = head;
         
         for(int i = 2; i <= position-1; i++) {
             temp = temp.getNext();
         }
         
         nNode.setPrev(temp);
         nNode.setNext(temp.getNext());
         temp.setNext(nNode);
         length++;
        
    }
    
    public void deleteAtBegin(int data) {
    DLLNode nNode = new DLLNode(data);
            if(head == null) {
                head = nNode;
                nNode.next = null;
                nNode.prev = null;
                length++;

                return;

            }

    DLLNode temp = head;
    while(temp.getNext() != null) {
        temp = temp.getNext();
    }
    
    temp.setNext(nNode);
    nNode.setPrev(temp);
    nNode.setNext(null);
    length++;
        
    }
    
    public void deleteAtEnd(int data) {
    DLLNode nNode = new DLLNode(data);
            if(head == null) {
                head = nNode;
                nNode.next = null;
                nNode.prev = null;
                length++;

                return;

            }

    DLLNode temp = head;
    while(temp.getNext() != null) {
        temp = temp.getNext();
    }
    
    temp.setNext(nNode);
    nNode.setPrev(temp);
    nNode.setNext(null);
    length++;
        
    }
    
    public void deleteAtMiddle(int data, int position) {
    DLLNode nNode = new DLLNode(data);
            if(head == null) {
                head = nNode;
                nNode.next = null;
                nNode.prev = null;
                length++;

                return;

            }

    DLLNode temp = head;
    while(temp.getNext() != null) {
        temp = temp.getNext();
    }
    
    temp.setNext(nNode);
    nNode.setPrev(temp);
    nNode.setNext(null);
    length++;
        
    }
    
    public String toString() {
        String result = "[";
        if(head == null) {
            return result + "]";
        }
        result = result + head.getData();
        DLLNode temp = head.getNext();
        while(temp != null) {
           result = result + ", " + temp.getData();
           temp = temp.getNext();
        }
        
        return result + "]";
    }
    public static void main(String args[]) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertAtBegin(45);
        System.out.println(list.toString());
        System.out.println(list.getLength());
        list.insertAtBegin(5);
        System.out.println(list.toString());
        System.out.println(list.getLength());
        list.insertAtEnd(56);
        System.out.println(list.toString());
        System.out.println(list.getLength());
        list.insertAtEnd(23);
        System.out.println(list.toString());
        System.out.println(list.getLength());
        list.insertAtMiddle(6, 3);
        System.out.println(list.toString());
        System.out.println(list.getLength());


      
    }
}