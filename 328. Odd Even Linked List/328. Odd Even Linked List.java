class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head ==null) return head;
        ListNode odd = head;
        ListNode point = head.next;
        ListNode pre = head;
        int cnt = 1;
        while (point != null){
            cnt ++;
            if(cnt % 2 == 1){
                ListNode temp1 = odd.next;
                ListNode temp2 = point.next;
                odd.next = point;
                point.next = temp1;
                pre.next = temp2;
                odd = point;
                point = pre;
            }
            pre = point;
            point = point.next;
        }
        return head;  
    }
}
