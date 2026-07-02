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
// TC -> O(N)
// SC -> O(N) recursive stack space
class Solution {
    ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;

        ListNode newHead = reverse(head.next);

        ListNode front = head.next;
        front.next = head;
        head.next = null;

        return newHead;
    }
    public ListNode reverseList(ListNode head) {
        return reverse(head);
    }
}
// Iterative version
// TC -> O(N)
// SC -> O(1)
/*class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;

        while(temp != null){
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }
}*/