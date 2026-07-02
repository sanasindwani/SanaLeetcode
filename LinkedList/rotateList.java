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
// SC -> O(1)
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode temp = head;
        int len = 0;

        ListNode tail = null;
        while(temp != null){
            tail = temp;
            temp = temp.next;
            len++;
        }

        temp = head;
        k %= len;
        if(k == 0) return head;

        k = len - k - 1;
        while(k > 0){
            temp = temp.next;
            k--;
        }
        ListNode newHead = temp.next;
        tail.next = head;
        head = newHead;
        temp.next = null;

        return head;
    }
}