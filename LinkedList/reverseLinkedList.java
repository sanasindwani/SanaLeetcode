package LinkedList;


// Definition for singly-linked list.
     class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
public class reverseLinkedList {
     public ListNode reverseList(ListNode head) {
        /*Stack<Integer> stack = new Stack<>();
        ListNode temp = head;
        while(temp != null){
            stack.push(temp.val);
            temp = temp.next;
        }
        temp = head;
        while(temp != null){
            temp.val = stack.pop();
            temp = temp.next;
        }
        return head;
        */

       ListNode prev = null;
       ListNode temp = head;
       ListNode front = null;

       while(temp != null){
        front = temp.next;
        temp.next = prev;
        prev = temp;
        temp = front;
       } 

       return prev;
    }
}
