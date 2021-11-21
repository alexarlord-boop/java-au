# LINKED LIST

+ [Reverse linked list](#reverse-linked-list)
+ [Middle of the Linked List](#middle-of-the-linked-list)
+ [Palindrome Linked List](#palindrome-linked-list)
+ [Merge Two Sorted Lists](#merge-two-sorted-lists)
+ [Intersection of Two Linked Lists](#intersection-of-two-linked-lists)
+ [Sort List](#sort-list)
<!---->

## Reverse linked list

https://leetcode.com/problems/reverse-linked-list/

<details>
    <summary> Test Cases </summary>

    ``` java

    ``` 
</details>

```java

public ListNode reverseList(ListNode head) {
    if (head == null) {
        return null;
    }

    ListNode node = head,
            prev = null,
            reversed = null;

    while (node != null) {
        final ListNode next = node.next;

        if (node.next == null) {
            reversed = node;
        }
        node.next = prev;
        prev = node;
        node = next;
    }

    return reversed;
}
```


## Middle of the Linked List

https://leetcode.com/problems/middle-of-the-linked-list/

<details>
    <summary> Test Cases </summary>

    ``` java

    ``` 
</details>

```java

public ListNode middleNode(ListNode head) {

        ListNode s = head;
        ListNode f = head;
        while(f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
        }
        return s;
    }
```


## Palindrome Linked List

https://leetcode.com/problems/palindrome-linked-list/

<details>
    <summary> Test Cases </summary>

    ``` java

    ``` 
</details>

```java

public boolean isPalindrome(ListNode head) {

        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;

        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
}
```


## Merge Two Sorted Lists

https://leetcode.com/problems/merge-two-sorted-lists/

<details>
    <summary> Test Cases </summary>

    ``` java

    ``` 
</details>

```java

public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode res = new ListNode(0);
    ListNode tail = res, p1 = l1, p2 = l2;
    while (p1 != null && p2 != null) {
        tail.next = new ListNode(p1.val < p2.val ? p1.val : p2.val);
        tail = tail.next;
        if (p1.val < p2.val) p1 = p1.next;
        else p2 = p2.next;
    }
    tail.next = p1 == null ? p2 : p1;
    return res.next;
}

```


## Intersection of Two Linked Lists

https://leetcode.com/problems/intersection-of-two-linked-lists/

<details>
    <summary> Test Cases </summary>

    ``` java

    ``` 
</details>

```java

public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;

        Set<ListNode> nodes = new HashSet<>();

        while(headA != null)
        {
            nodes.add(headA);
            headA = headA.next;
        }

        while(headB != null)
        {
            if(nodes.contains(headB))
            {
                return headB;
            }

            headB = headB.next;
        }

        return null;
}
```


## Sort List

https://leetcode.com/problems/sort-list/

<details>
    <summary> Test Cases </summary>

    ``` java

    ``` 
</details>

```java

public ListNode sortList(ListNode head) {
    if (head == null || head.next == null)
      return head;

    ListNode prev = null, slow = head, fast = head;

    while (fast != null && fast.next != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }

    prev.next = null;

    ListNode l1 = sortList(head);
    ListNode l2 = sortList(slow);

    return merge(l1, l2);
  }

  ListNode merge(ListNode l1, ListNode l2) {
    ListNode l = new ListNode(0), p = l;

    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        p.next = l1;
        l1 = l1.next;
      } else {
        p.next = l2;
        l2 = l2.next;
      }
      p = p.next;
    }

    if (l1 != null)
      p.next = l1;

    if (l2 != null)
      p.next = l2;

    return l.next;
}
```
