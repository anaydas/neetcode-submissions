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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode curr = head;

        while(curr!=null){
            count++;
            curr=curr.next;
        }


        int check = count-n+1;

        if(check==1)
            return null;

        count = 1;
        curr=head;

        while(count<check-1){
            curr=curr.next;
            count++;
        }

        curr.next=curr.next.next;
        curr.next.next=null;

        return head;
    }
}
