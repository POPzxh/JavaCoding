# 328. Odd Even Linked List

Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

**Example 1:**

```
Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL
```

**Example 2:**

```
Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL
```

**Note:**

- The relative order inside both the even and odd groups should remain as it was in the input.
- The first node is considered odd, the second node even and so on ...

#### 思路

* 大意：将链表中奇数位的节点排在偶数位节点前面

类似于插入排序，ListNode odd来标记已经排好的奇节点，如果point指针指向了下一个奇节点，就把point插到odd的next。

```java
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
```


