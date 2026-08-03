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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        
        for(int i=1;i<lists.length;i++){
            lists[i] =  mergeTwoList(lists[i-1],lists[i]);
        }
        return lists[lists.length-1];
    }

    private ListNode mergeTwoList(ListNode list1,ListNode list2){
        ListNode node = new ListNode(0);
        ListNode curr = node;

        while(list1 !=null && list2 != null){
            if(list1.val < list2.val){
                curr.next = list1;
                list1 = list1.next;
            }else{
                curr.next = list2;
                list2 = list2.next;
            }
            curr=curr.next;
        }

        if(list1!=null)
            curr.next = list1;
        if(list2!=null)
            curr.next = list2;
        return node.next;        
    }
}
