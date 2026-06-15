package LinkedList;

public class deleteTheMiddleNodeofLL {
    /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

 class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head.next==null){
            return null;
        }
        ListNode fast=head;
        ListNode slow=new ListNode(-1);
        slow.next=head;
        while(fast!=null && fast.next!=null ){
            fast=fast.next.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return head;
        
        
    
}
/*class Solution {
    public ListNode deleteMiddle(ListNode head) {

        if (head.next == null) return null;
          
        ListNode fast = head;
        ListNode slow = head;

        ListNode prev = head;

        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        //if (prev == slow) return null;
        prev.next = slow.next;
        slow.next = null;

        return head;
        
    }
}*/
}
