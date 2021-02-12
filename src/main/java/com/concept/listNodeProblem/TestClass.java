package com.concept.listNodeProblem;

public class TestClass {

	public static void main(String[] args) {

		TestClass test = new TestClass();
		
		// [2,4,3]
		ListNode l1 = new ListNode(0);
		//l1 = new ListNode(4, l1);
		//l1 = new ListNode(2, l1);
		
		// [5,6,4]
		ListNode l2 = new ListNode(0);
		//l2 = new ListNode(6, l2);
		//l2 = new ListNode(5, l2);
		
		ListNode result = test.addTwoNumbers(l1, l2);
		System.out.println(result);
	}
	

    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        
        ListNode tempNode = l1;
        int sum1 = 0;
        
        while(tempNode.next != null) {
            sum1 = sum1 * 10 + tempNode.val;
            tempNode = tempNode.next;
        }
        sum1 = sum1 * 10 + tempNode.val;
   
        
        tempNode = l2;
        int sum2 = 0;
        while(tempNode.next != null) {
            sum2 = sum2 * 10 + tempNode.val;
            tempNode = tempNode.next;
        }
        sum2 = sum2 * 10 + tempNode.val;
        
        String sum = String.valueOf(sum1 + sum2);
        ListNode result = null;
    
     
        
        for(int k = 0; k < sum.length(); k++) {
            ListNode node = null;
            int INT_MAX = (int) Math.pow(31, 2);
            
            if (k == 0) {
            	int val = Integer.parseInt(String.valueOf(sum.charAt(k)));
                node = new ListNode(val);
                result = node;
            } else {
                node = result;
            }
            if (k+1 != sum.length() ) {
            	int val = Integer.parseInt(String.valueOf(sum.charAt(k+1)));
            	result = new ListNode(val, node);
            }
            
        }
        return result;
    }

}
