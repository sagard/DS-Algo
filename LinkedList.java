
class LinkedList{
	int data;
	LinkedList next;

	static LinkedList head;

	LinkedList(){

	}

	LinkedList(int data){
		this.data = data;
		this.next = null;
	}

	public void insert(int data){
		// insert first node
		if(head == null)
		{ 
			LinkedList l = new LinkedList(data);
			head=l;
		}
		else{
			LinkedList curr=head;
			while(curr.next!=null){
				curr = curr.next;
			}

			LinkedList l = new LinkedList(data);
			curr.next = l;
		}
	}

	public void remove(int data){
		LinkedList curr = head;
		LinkedList prev=curr;

		//search for data or till last node
		while(curr.next!=null && curr.data!= data){
			prev = curr;
			curr = curr.next;
		}

		if(curr!=null && curr.data == data){
			//first node
			if(curr == head){
				head = curr.next;
			}
			else{
				prev.next= curr.next;
			}
		}
	}


	//print the nodes
	public void print(){
		LinkedList curr = head;
		System.out.print("start: ");
		while(curr!=null)
		{
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
	}	

	//reverse iteratively
	public void reverse(){
		LinkedList prev=head;
		LinkedList curr=head.next;
		
		LinkedList temp;
		//make first node as last by poiting to null
		head.next =null;

		while(curr!=null){
			temp=curr.next;
			curr.next=prev;
			prev=curr;
			curr=temp;
		}
		
		head=prev;
	}
	
	public void reverse_recurse(LinkedList curr){
		  if(curr.next == null) {
	            head = curr;
	            return;
	       }
	      reverse_recurse(curr.next);
	      curr.next.next = curr;
	      curr.next = null;
		
	}

	
     public boolean hasCycle(LinkedList head) {
        if(head == null) return false;
        LinkedList slow = head;
        LinkedList fast = head;
       
        //if one noce pointing to itself
        if(slow.next == slow ) return true;
        //if only one or two nodes and no loop
        if(slow.next == null || slow.next.next == null) return false;
        //2 nodes and 2nd pointing to first
        if((slow.next == slow) || (slow.next.next==slow)) return true;

        
        boolean hasCycle = false;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                hasCycle = true;
                return hasCycle;
            }
            
        }
        return hasCycle;
    }
    
     LinkedList slow;
     LinkedList fast;
     //Detect loop node
    public LinkedList detectCycle(LinkedList head) {
        if(head == null) return null;
        int count = 1;
        boolean cyle = hasCycle(head);
        if(cyle == false) return null;
        else{
            if((slow.next == slow) || (slow.next.next==slow)) return slow;

            fast = fast.next;
            //move the fast pointer till it meets slow pointer
            while(slow != fast){
                count++;
                fast = fast.next;
            }
            
            slow = head;
            fast = head;
            //move fast count number of nodes ahead and increment , they meet at node start
            while(count>0){
                fast = fast.next;
                count--;
            }
            
            while(slow!=fast){
                slow=slow.next;
                fast=fast.next;
            }
            return slow;
            
        }
    }



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList l = new LinkedList();
		l.insert(2); 
		l.insert(5); 
		l.insert(1);           
		l.insert(9);
		l.insert(11);
		l.insert(4);
		l.reverse();
		l.print();
		l.reverse_recurse(head);
		l.print();



	}

}
