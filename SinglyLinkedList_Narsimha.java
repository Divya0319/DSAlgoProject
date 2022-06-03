package com.dsalgoproblems.javaproblems;

import java.util.Stack;

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
    
    public ListNode reverseInPair() {
        ListNode temp = head;
        while(temp != null && temp.next != null) {
            int k = temp.data;
            temp.data = temp.next.data;
            temp.next.data = k;
            
            temp = temp.next.next;
        }
        
        return head;
        
    }
    
    public ListNode reorderList() {
    	if(head == null) return null;
    	ListNode slowPtr = head;
    	ListNode origHead = head;
    	ListNode fastPtr = head.getNext();
    	while(fastPtr != null && fastPtr.getNext() != null) {
    		fastPtr = fastPtr.getNext().getNext();
    		slowPtr = slowPtr.getNext();
    	}
    	
    	ListNode head2 = slowPtr.getNext();
    	slowPtr.setNext(null);
    	Stack<ListNode> stack = new Stack<>();
    	while(head2 != null) {
    		ListNode temp = head2;
    		head2 = head2.getNext();
    		temp.setNext(null);
    		stack.push(temp);
    	}
    	
    	while(!stack.isEmpty()) {
    		ListNode temp = stack.pop();
    		temp.setNext(head.getNext());
    		head.setNext(temp);
    		if(temp.getNext() != null)
    		head = temp.getNext();
    	}
    	
    	return origHead;
    	
    }
    
    public ListNode reorderlistOptimised() {
    	if(head == null || head.getNext() == null) return head;
    	ListNode slow = head, fast = head;
    	ListNode origHead = head;
    	
    	while(fast != null && fast.getNext() != null) {
    		fast = fast.getNext().getNext();
    		slow = slow.getNext();
    	}
    	
    	ListNode prev = null, curr = slow, tmp;
    	
    	while(curr != null) {
    		tmp = curr.getNext();
    		curr.setNext(prev);
    		prev = curr;
    		curr = tmp;
    	}
    	
    	ListNode n1 = head, n2 = prev;
    	
    	while(n2.getNext() != null) {
    		tmp = n1.getNext();
    		n1.setNext(n2);
    		n1 = tmp;
    		
    		tmp = n2.getNext();
    		n2.setNext(n1);
    		n2 = tmp;
    	}
    	
    	return origHead;
    }
    
    public ListNode addTwoLists(ListNode l1, ListNode l2) {
    	ListNode dummy = new ListNode(-1);
    	ListNode temp = dummy;
    	int carry = 0;
    	while(l1 != null || l2 != null || carry != 0) {
    		int sum = 0;
    		if(l1 != null) {
    			sum += l1.data;
    			l1 = l1.next;
    		}
    		
    		if(l2 != null) {
    			sum += l2.data;
    			l2 = l2.next;
    		}
    		
    		sum += carry;
    		carry = sum / 10;
    		ListNode node = new ListNode(sum % 10);
    		temp.next = node;
    		temp = node;
    	}
    	
    	return dummy.next;
    }
     
    public ListNode findMiddle() {
        ListNode ptr1, ptr2;
        ptr1 = ptr2 = head;
        while(ptr1 != null && ptr1.next != null) {
        ptr1 = ptr1.next.next;
        ptr2 = ptr2.next;
        }
        
        return ptr2;
        
    }
    
    public ListNode insertionSortList() {
    	ListNode dummy = new ListNode(-1);
    	ListNode curr = head;
    	while(curr != null) {
    		ListNode temp = curr.next;
    		ListNode prev = dummy;
    		ListNode nxt = dummy.next;
    		while(nxt != null) {
    			if(nxt.data > curr.data) 
    				break;
    			prev = nxt;
    			nxt = nxt.next;
    			
    		}
    		
    		curr.next = nxt;
			prev.next = curr;
			
			curr = temp;
    	}
    	return dummy.next;
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
    
    public ListNode modularNodes(int k) {
    	ListNode modularNode = null;
    	int i = 0;
    	if(k <= 0) {
    		return null;
    	}
    	
    	for(;head != null; head = head.next) {
    		if(i % k == 0) {
    			modularNode = head;
    		}
    		i++;
    	}
    	
    	return modularNode;
    }
    
    public ListNode modularNodeReturns(int k) {
    	ListNode modularNode = null;
    	int i = 0;
    	if(k <= 0) return null;
    	for(i = 0; i <= k; i++) {
    		if(head != null) {
    			head = head.next;
    		}
    		else return null;
    	}
    	
    	while(head != null) {
    		modularNode = modularNode.next;
    		head = head.next;
    	}
    	
    	return modularNode;
    }
    
    public ListNode nkthNode(int k) {
    	if(k <= 0) return null;
    	if(head == null) return null;
    	
    	ListNode sp = null;
    	int i = 0;
    	for(;head != null; head = head.next) {
    		if(i % k == 0) {
    		if(sp == null) 
    			sp = head;
    		else 
    			sp = sp.next;
    		}
    		i++;
    	}
    	
    	return sp;
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
    
    public String toString(ListNode head) {
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
    
    public ListNode rotateList(int k) {
    	if(head == null || k < 1) return head;
    	
    	ListNode temp = head;
    	int n = 0;
    	while(temp.next != null) {
    		temp = temp.next;
    		n++;
    	}
    	
    	temp.next = head;
    	
    	k = k % (n+1);
    	
    	int j = n-k;
    	temp = head;
    	while(j > 0) {
    		temp = temp.next;
    		j--;
    	}
    	
    	ListNode newHead = temp.next;
    	temp.next = null;
    	return newHead;
    }
    
    public ListNode rotateListLeft(int k) {
    	if(k < 1 || head == null) return head;
    	ListNode curr = head;
    	
    	int n = 0;
    	while(curr != null) {
    		curr = curr.next;
    		n++;
    	}
    	k = k % n;
    	
    	int count = 1;
    	curr = head;
    	while(count < k && curr != null) {
    		curr = curr.next;
    		count++;
    	}
    	
    	ListNode kthNode = curr;
    	
    	while(curr.next != null) {
    		curr = curr.next;
    	}
    	
    	curr.next = head;
    	head = kthNode.next;
    	kthNode.next = null;
    	
    	return head;
    	
    }
    
    public ListNode partitionListUsingK(int k) {
    	ListNode left = new ListNode(0);
    	ListNode right = new ListNode(0);
    	ListNode l = left, r = right;
    	
    	while(head != null) {
    		
    		if(head.data < k) {
    			l.next = head;
    			l = l.next;
    		}
    		else {
    			r.next = head;
    			r = r.next;
    		}
    		head = head.next;
    	}
    	l.next = right.next;
    	r.next = null;
    	
    	return left.next;
    }
    
    public ListNode reverseKNodes(int k) {
    	if(head == null || k == 1) return head;
    	ListNode dummy = new ListNode(0);
    	dummy.setNext(head);
    	ListNode curr = dummy, nex = dummy, pre = dummy;
    	int count = 0;
    	while(curr.getNext() != null) {
    		curr = curr.getNext();
    		count++;
    	}
    	
    	while(count >= k) {
    		curr = pre.getNext();
    		nex = curr.getNext();
    		
    		for(int i = 1; i < k; i++) {
    			curr.setNext(nex.getNext());
    			nex.setNext(pre.getNext());
    			pre.setNext(nex);
    			nex = curr.getNext();
    		}
    		
    		pre = curr;
    		count -= k;
    	}
    	
    	return dummy.getNext();
    }
    
    
    /**
     * @param args
     */
    /**
     * @param args
     */
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ListNode ln1 = new ListNode(1);
        ll.insertAtBegin(ln1);
        System.out.println(ll.toString());
        ListNode ln2 = new ListNode(4);
        ll.insertAtEnd(ln2);
        System.out.println(ll.toString());
        ListNode ln3 = new ListNode(3);
        ll.insertAtEnd(ln3);
        System.out.println(ll.toString());
        ListNode ln4 = new ListNode(2);
        ll.insertAtEnd(ln4);
        System.out.println(ll.toString());
        ListNode ln5 = new ListNode(5);
        ll.insertAtEnd(ln5);
        System.out.println(ll.toString());
        ListNode ln6 = new ListNode(2);
        ll.insertAtEnd(ln6);
        System.out.println(ll.toString());
        
        
//        LinkedList l2 = new LinkedList();
//        ListNode lnn1 = new ListNode(6);
//        l2.insertAtBegin(lnn1);
//        System.out.println(l2.toString());
//        ListNode lnn2 = new ListNode(5);
//        l2.insertAtEnd(lnn2);
//        System.out.println(l2.toString());
//        ListNode lnn3 = new ListNode(4);
//        l2.insertAtEnd(lnn3);
//        System.out.println(l2.toString());
        
        ListNode partitioned = ll.partitionListUsingK(3);
        System.out.println(ll.toString(partitioned));
        
//        ListNode reverseKList = ll.reverseKNodes(2);
//        System.out.println(ll.toString(reverseKList));
//        
//        ListNode rotatedList = ll.rotateList(19);
//        System.out.println(ll.toString(rotatedList));
//       
//        ListNode sortedList = ll.insertionSortList();
//        System.out.println(ll.toString(sortedList));
        
        // ListNode ln9 = new ListNode(123);
        // ll.insertAtEnd(ln9);
        // System.out.println(ll.toString());
        
        // ListNode newHead = ll.reverseInPair();
        // System.out.println(ll.toString(newHead));

        
        // System.out.println(ll.getLength());
        // ll.deleteAtBegin();
        // System.out.println(ll.toString());
        // System.out.println(ll.getLength());
        // ll.deleteAtEnd();
        // System.out.println(ll.toString());
        // System.out.println(ll.getLength());
        // ll.delete(5);
        // System.out.println(ll.toString());
        // System.out.println(ll.getLength());
        
        // int ele = 16;
        // int found = ll.getPosition(ele);
        // if(found != -1) System.out.println("Element " + ele + " found at position " + found);
        
        // else System.out.println("Element " + ele + " not found");
        
//        ListNode middle = ll.findMiddle();
//        System.out.println(middle.data);
//        
//        
//        ListNode nkthNode = ll.nkthNode(2);
//        System.out.println(nkthNode.data);
        
//        ListNode ln10 = new ListNode(16);
//        ll.insert(ln10, 4);
//        System.out.println(ll.toString());
//        
//        ListNode reorderedList = ll.reorderlistOptimised();
//        System.out.println(ll.toString(reorderedList));


    }
}
