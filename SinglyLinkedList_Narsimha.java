package com.dsalgoproblems.javaproblems;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import com.dsalgoproblems.javaproblems.LinkedList.ListNode;

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
    
    public ListNode removeDuplicates() {
    	Map<Integer, Integer> map = new HashMap<>();
    	if(head == null) return null;
    	ListNode curr = head;
    	ListNode prev = curr;
    	map.put(curr.data, 1);
    	curr = curr.next;
    	while(curr != null) {
    		if(map.containsKey(curr.data)) {
    			prev.next = curr.next;
    		} else {
    			map.put(curr.data, 1);
    			prev = curr;
    		}
    		
    		curr = prev.next;
    	}
    	
    	return head;
    }
    
    public ListNode removeDupBruteForce() {
    	ListNode curr = head;
    	if(curr == null || curr.next == null) {
    		return curr;
    	}
    	
    	ListNode curr2;
    	ListNode prev;
    	while(curr != null) {
    		curr2 = curr.next;
    		prev = curr;
    		while(curr2 != null) {
    			if(curr.data == curr2.data) {
    				prev.next = curr2.next;
    			} 
    			
    			prev = curr2;
    			curr2 = curr2.next;
    		}
    		
    		curr = curr.next;
    	}
    	
    	return head;
    }
    
    public ListNode rearrangeEvenOdd() {
    	ListNode even = null, odd = null;
    	ListNode e = null, o = null;
    	while(head != null) {
    		if(head.data % 2 == 0) {
    			if(even == null) {
    				even = head;
    				e = head;
    			} else {
    				e.next = head;
    				e = e.next;
    			}
    		} else {
    			if(odd == null) {
    				odd = head;
    				o = head;
    			} else {
    				o.next = head;
    				o = o.next;
    			}
    		}
    		head = head.next;
    	}
    	
    	if(e != null) e.next = odd;
    	if(o != null) o.next = null;
    	
    	if(even != null) return even;
    	return odd;
    }
    
    public ListNode commonElement(ListNode l1, ListNode l2) {
    	ListNode temp = new ListNode(0);
    	ListNode head = temp;
    	while(l1 != null && l2 != null) {
    		if(l1.data == l2.data) {
    			head.next = new ListNode(l1.data);
    			l1 = l1.next;
    			l2 = l2.next;
    			head = head.next;
    		} else if(l1.data > l2.data) {
    			l2 = l2.next;
    		} else {
    			l1 = l1.next;
    		}
    	}
    	
    	return temp.next;
    }
    
    public boolean isPalindromeList(ListNode head) {
    	
    	if(head == null || head.next == null) return true;
    	
    	ListNode slow = head;
    	ListNode fast = head;
    	
    	while(fast != null && fast.next != null) {
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	
    	slow.next = reverseLL(slow.next);
    	slow = slow.next;
    	
    	ListNode dummy = head;
    	
    	while(slow != null) {
    		if(dummy.data != slow.data) return false;
    		dummy = dummy.next;
    		slow = slow.next;
    	}
    	
    	return true;
    }
    
    public ListNode reverseLL(ListNode head) {
    	ListNode pre = null;
    	ListNode next = null;
    	while(head != null) {
    		next = head.next;
    		head.next = pre;
    		pre = head;
    		head = next;
    	}
    	
    	return pre;
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
        ListNode ln2 = new ListNode(3);
        ll.insertAtEnd(ln2);
        System.out.println(ll.toString());
        ListNode ln3 = new ListNode(4);
        ll.insertAtEnd(ln3);
        System.out.println(ll.toString());
        ListNode ln4 = new ListNode(4);
        ll.insertAtEnd(ln4);
        System.out.println(ll.toString());
        ListNode ln5 = new ListNode(3);
        ll.insertAtEnd(ln5);
        System.out.println(ll.toString());
        ListNode ln6 = new ListNode(9);
        ll.insertAtEnd(ln6);
        System.out.println(ll.toString());
        
        System.out.println(ll.isPalindromeList(ll.head));
        
        
        LinkedList l2 = new LinkedList();
        ListNode lnn1 = new ListNode(4);
        l2.insertAtBegin(lnn1);
        System.out.println(l2.toString());
        ListNode lnn2 = new ListNode(5);
        l2.insertAtEnd(lnn2);
        System.out.println(l2.toString());
        ListNode lnn3 = new ListNode(6);
        l2.insertAtEnd(lnn3);
        System.out.println(l2.toString());
        
        ListNode noDupList = ll.commonElement(ll.head, l2.head);
        System.out.println(ll.toString(noDupList));
        
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

class LinkedQueue {
	private int length;
	private ListNode front, rear;
	
	//Creates an empty queue
	public LinkedQueue() {
		length = 0;
		front = rear = null;
	}
	
	//Adds the specified data to rear of the queue
	public void enQueue(int data) {
		ListNode node = new ListNode(data);
		if(isEmpty()) 
			front = node;
		else 
			rear.setNext(node);
		rear = node;
		length++;
		
	}
	public ListNode getFront() {
		return front;
	}
	
	//Removes the data at the front of the queue and returns a reference to it. Throws an Exception if 
	// queue is empty
	public int deQueue() throws Exception {
		if(isEmpty()) {
			throw new Exception("Queue is empty. Underflow");
		}
		int result = front.getData();
		front = front.getNext();
		length--;
		if(isEmpty()) {
			rear = null;
		}
		return result;
	}
	
	//Returns a reference to the data at the front of the queue.
	//The data is not removed from the queue. Throws an exception if the queue is empty.
	public int first() throws Exception {
		if(isEmpty()) {
			throw new Exception("Queue is empty.");
		}
		return front.getData();
	}
	
	//Returns true if this queue is empty and false otherwise
	public boolean isEmpty() {
		return (length == 0);
	}
	
	public int size() {
		return length;
	}
	
	public String toString() {
		String result = "[";
		ListNode current = front;
		while(current != null) {
			result = result + current.getData();
			if(current.getNext() != null) {
				result += ", ";
			}
			current = current.getNext();
		}
		
		return result + "]";
	}
	
	public LinkedQueue reverseQueueUsingStack(LinkedQueue queue) throws Exception {
		Stack<Integer> stk = new Stack<>();
		while(!queue.isEmpty()) {
			stk.push(queue.deQueue());
		}
		
		while(!stk.isEmpty()) {
			queue.enQueue(stk.pop());
		}
		
		return queue;
	}
	
	public static void main(String[] args) {
		try {
		LinkedQueue lq = new LinkedQueue();
		lq.enQueue(5);
		System.out.println(lq.toString());
		lq.enQueue(6);
		System.out.println(lq.toString());
		lq.enQueue(7);
		System.out.println(lq.toString());
		lq.enQueue(8);
		System.out.println(lq.toString());
		lq.enQueue(9);
		System.out.println(lq.toString());
		lq.enQueue(10);
		System.out.println(lq.toString());
//		lq.deQueue();
//		System.out.println(lq.toString());
//		lq.deQueue();
//		System.out.println(lq.toString());
//		lq.deQueue();
//		System.out.println(lq.toString());
		
		System.out.println(lq.reverseQueueUsingStack(lq).toString());
		
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	static class StackWithTwoQueues {
		private LinkedQueue q1 = new LinkedQueue();
		private LinkedQueue q2 = new LinkedQueue();
		public void push(int data) {
			if(q1.isEmpty()) {
				q2.enQueue(data);
			} else {
				q1.enQueue(data);
			}
		}
		
		public int pop() throws Exception {
			int i = 0, size;
			if(q2.isEmpty()) {
				size = q1.size();
				while(i < size - 1) {
					q2.enQueue(q1.deQueue());
					i++;
				}
				return q1.deQueue();
			} else {
				size = q2.size();
				while(i < size - 1) {
					q1.enQueue(q2.deQueue());
					i++;
				}
				return q2.deQueue();
			}
		}
		
		public String toString() {
			String result = "[";
			ListNode front;
			try {
			if(q1.isEmpty()) 
				front = q2.getFront();
			 else 
				front = q1.getFront();
				
			 while(front != null) {
				result += front.getData() + " ";
				front = front.getNext();
			 }
			} catch(Exception ex) {
				ex.printStackTrace();
			}
			return result + "]";
		}
		
		public static void main(String[] args) {
			StackWithTwoQueues swtq = new StackWithTwoQueues();
			try {
			swtq.push(5);
			System.out.println(swtq.toString());
			swtq.push(6);
			System.out.println(swtq.toString());
			swtq.push(7);
			System.out.println(swtq.toString());
			swtq.push(8);
			System.out.println(swtq.toString());
			swtq.push(9);
			System.out.println(swtq.toString());
			swtq.push(10);
			System.out.println(swtq.toString());
			swtq.push(11);
			System.out.println(swtq.toString());
			swtq.pop();
			System.out.println(swtq.toString());
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
