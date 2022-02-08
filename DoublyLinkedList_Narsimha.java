public class DoublyLinkedList {
    
    private DLLNode head;

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
    
    public DoublyLinkedList() {
        head = new DLLNode(Integer.MIN_VALUE);
    } 
    public static void main(String args[]) {
      
    }
}