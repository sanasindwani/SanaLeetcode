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
    ListNode findKnode(ListNode temp, int k){
        k -= 1;
        while(temp != null && k > 0){
            k--;
            temp = temp.next;
        }
        return temp;
    }

    ListNode reverse(ListNode temp){
        ListNode prev = null;

        while(temp != null){
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }

        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevNode = null;

        while(temp != null){

            ListNode kNode = findKnode(temp, k);

            if(kNode == null){
                if(prevNode != null) prevNode.next = temp;
                break;
            }

            ListNode frontNode = kNode.next;
            kNode.next = null;

            reverse(temp);

            if(temp == head){
                head = kNode;
            } else {
                prevNode.next = kNode;
            }

            prevNode = temp;
            temp = frontNode;
        }
        return head;
    }
}