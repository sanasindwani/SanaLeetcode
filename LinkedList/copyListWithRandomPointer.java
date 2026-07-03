/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

// In order to save an extra O(N) which was being used by the hashmap we will use the already exsisting linked list and store our new nodes in between them only 
// Then we'll assing the random pointers accordingly 
// Then we'll update the next and recover our prev list 
// Thus this will have a space complexicity of O(1)
// TC -> O(N)
// SC -> O(1)
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        Node temp = head;

// this will insert nodes in between the already exsisting nodes 
        while(temp != null){
            Node node = new Node(temp.val);
            node.next = temp.next;
            temp.next = node;
            temp = temp.next.next;
        }
// Now we'll assign random pointers 
        temp = head;

        /*while(temp != null){
            Node node = temp.random;
            if(node == null){
                temp.next.random = null;
            }
            else { 
                temp.next.random = node.next;
            }
            temp = temp.next.next;
        }*/
        // we can write the same more precisely as
        while(temp != null){
            temp.next.random = (temp.random == null) ? null : temp.random.next;
            temp = temp.next.next;
        }

// Now we'll try and fix the next of our linked lists such that both the list return to their original values

        temp = head;
        Node newHead = temp.next;
        Node curr = newHead;

// This will change the next to original LL's next 
        /*while(temp != null){
            temp.next = curr.next;
            if(temp.next == null){
                curr.next = null;
            } else {
            curr.next = temp.next.next;
            }
            temp = temp.next;
            curr = curr.next;
        }*/

        while(temp != null){
            temp.next = curr.next;
            // because now temp.next and curr.next are references for the same node at that instant
            curr.next = (temp.next == null) ? null : temp.next.next;
            // can either wrote curr.next,next
            temp = temp.next;
            curr = curr.next;
        }

        return newHead;
    }
}

// TC -> O(N)
// SC -> O(N)
/*class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        // so that we don't have to take dummy as a special case
        Node dummy = new Node(-1);
        Node curr = dummy;

        Node temp = head;
        HashMap<Node,Node> map = new HashMap<>();
        
        while(temp != null){
            Node newNode = new Node(temp.val);
            curr.next = newNode;
            map.put(temp, newNode);

            curr = newNode;
            temp = temp.next;
        }

        curr = dummy.next;
        temp = head;

        while(temp != null){
            Node ran = map.get(temp.random);
            curr.random = ran;

            curr = curr.next;
            temp = temp.next;
        }

        return dummy.next;
    }
}*/