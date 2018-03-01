public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        //keep two pointers with old node and even node
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
        	//seperate node
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        //set last odd node to even node's head
        odd.next = evenHead;
        return head;
    }
}