# LINKED LIST

+ [Reverse linked list](#reverse-linked-list)
+ [Middle of the Linked List](#middle-of-the-linked-list)
+ [Palindrome Linked List](#palindrome-linked-list)
+ [Merge Two Sorted Lists](#merge-two-sorted-lists)
+ [Intersection of Two Linked Lists](#intersection-of-two-linked-lists)
+ [Merge sort](#merge-sort)
+ [Reorder List](#reorder-list)
+ [Linked List Cycle II](#linked-list-cycle-ii)
<!---->

## Reverse linked list

https://leetcode.com/problems/reverse-linked-list/

<details>
    <summary> Test Cases </summary>

``` java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class LeetcodeSolutionTest {
    private LeetcodeSolution solution;

    @BeforeEach
    void setSolution() {
        solution = new LeetcodeSolution();
    }

    @Test
    void testReverseList() {
        ListNode expected = ListNodeHandler.buildList(List.of(1, 2, 2, 2, 3));
        assertEquals(expected, solution.reverseList(ListNodeHandler.buildList(List.of(3, 2, 2, 2, 1))));
    }

    @Test
    void testNullHead() {
        assertNull(solution.reverseList(null));
    }
```

```java
class ListNodeHandler{
    static ListNode buildList(List<Integer> src) {
        ListNode prev = null;
        ListNode node = null;
        int d = src.size() - 1;
        for (int i = d; i >= 0; i--) {
            node = new ListNode(src.get(i), prev);
            prev = node;
        }
        return node;
    }
}
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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class LeetcodeSolutionTest {
    private LeetcodeSolution solution;

    @BeforeEach
    void setSolution() {
        solution = new LeetcodeSolution();
    }

    @Test
    void testMiddleNode() {
        ListNode expect = buildList(List.of(2, 3));
        assertEquals(expect, solution.middleNode(ListNodeHandler.buildList(List.of(1, 2, 3))));
    }

    @Test
    void testTwoMiddleNodes() {
        ListNode expect = buildList(List.of(4, 5, 6));
        assertEquals(expect, solution.middleNode(ListNodeHandler.buildList(List.of(1, 2, 3, 4, 5, 6))));
    }

    @Test
    void testNullHead() {
        assertNull(solution.middleNode(null));
    }
```

```java
class ListNodeHandler{
    static ListNode buildList(List<Integer> src) {
        ListNode prev = null;
        ListNode node = null;
        int d = src.size() - 1;
        for (int i = d; i >= 0; i--) {
            node = new ListNode(src.get(i), prev);
            prev = node;
        }
        return node;
    }
}
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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class LeetcodeSolutionTest {
    private LeetcodeSolution solution;

    @BeforeEach
    void setSolution() {
        solution = new LeetcodeSolution();
    }

    @Test
    void testIsPalindrome() {
        assertTrue(solution.isPalindrome(ListNodeHandler.buildList(List.of(1, 2, 3, 2, 1))));
    }

    @Test
    void testIsNotPalindrome(){
        assertFalse(solution.isPalindrome(ListNodeHandler.buildList(List.of(1, 2, 3, 4))));
    }

    @Test
    void testNullList(){
        assertTrue(solution.isPalindrome(ListNodeHandler.buildList(List.of())));
    }
    
}
```
```java
class ListNodeHandler{
    static ListNode buildList(List<Integer> src) {
        ListNode prev = null;
        ListNode node = null;
        int d = src.size() - 1;
        for (int i = d; i >= 0; i--) {
            node = new ListNode(src.get(i), prev);
            prev = node;
        }
        return node;
    }
}
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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class LeetcodeSolutionTest {
    private LeetcodeSolution solution;

    @BeforeEach
    void setSolution() {
        solution = new LeetcodeSolution();
    }

    @Test
    void testMergeTwoLists() {
        ListNode l1 = ListNodeHandler.buildList(List.of(1, 2));
        ListNode l2 = ListNodeHandler.buildList(List.of(3, 4));
        ListNode res = ListNodeHandler.buildList(List.of(1, 2, 3, 4));
        assertEquals(res, solution.mergeTwoLists(l1, l2));
    }

    @Test
    void testMergeOneList() {
        ListNode l2 = ListNodeHandler.buildList(List.of(3, 4));
        ListNode res = ListNodeHandler.buildList(List.of(3, 4));
        assertEquals(res, solution.mergeTwoLists(null, l2));
    }

    @Test
    void testMergeEqualLists() {
        ListNode l1 = ListNodeHandler.buildList(List.of(1, 2, 3));
        ListNode res = ListNodeHandler.buildList(List.of(1, 1, 2, 2, 3, 3));
        assertEquals(res, solution.mergeTwoLists(l1, l1));
    }

}

```
```java
class ListNodeHandler {
    static ListNode buildList(List<Integer> src) {
        ListNode prev = null;
        ListNode node = null;
        int d = src.size() - 1;
        for (int i = d; i >= 0; i--) {
            node = new ListNode(src.get(i), prev);
            prev = node;
        }
        return node;
    }
}
``` 
</details>

```java

public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode res = new ListNode(0);
    ListNode tail = res, p1 = l1, p2 = l2;
    while (p1 != null && p2 != null) {
        tail.next = new ListNode(Math.min(p1.val, p2.val));
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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class LeetcodeSolutionTest {
    private LeetcodeSolution solution;

    @BeforeEach
    void setSolution() {
        solution = new LeetcodeSolution();
    }

    @Test
    void testGetIntersectionNode() {
        ListNode l1 = ListNodeHandler.buildList(List.of(2, 6, 4));
        ListNode l2 = ListNodeHandler.buildList(List.of(1, 5));
        assertEquals(null, solution.getIntersectionNode(l1, l2));
    }

    @Test
    void testGetIntersectionNode2() {
        ListNode l1 = ListNodeHandler.buildList(List.of(2, 6, 4));
        ListNode l2 = ListNodeHandler.buildList(List.of(1, 2, 6, 4));
        assertEquals(2, solution.getIntersectionNode(l1, l2));
    }

}
```
```java

class ListNodeHandler {
    static ListNode buildList(List<Integer> src) {
        ListNode prev = null;
        ListNode node = null;
        int d = src.size() - 1;
        for (int i = d; i >= 0; i--) {
            node = new ListNode(src.get(i), prev);
            prev = node;
        }
        return node;
    }
}
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


## Merge Sort 

https://leetcode.com/problems/sort-list/

<details>
    <summary> Test Cases </summary>

``` java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class LeetcodeSolutionTest {
    private LeetcodeSolution solution;

    @BeforeEach
    void setSolution() {
        solution = new LeetcodeSolution();
    }

    @Test
    void testSortList() {
        ListNode l1 = ListNodeHandler.buildList(List.of(1, 4, 3, 2));
        ListNode res = ListNodeHandler.buildList(List.of(1, 2, 3, 4));
        assertEquals(res, solution.sortList(l1));
    }

    @Test
    void testSortNullList() {
        assertNull(solution.sortList(null));
    }

    @Test
    void testSortEqList() {
        ListNode res = ListNodeHandler.buildList(List.of(1, 1, 1, 1));
        ListNode l1 = ListNodeHandler.buildList(List.of(1, 1, 1, 1));
        assertEquals(res, solution.sortList(l1));
    }

}
```
```java

class ListNodeHandler {
    static ListNode buildList(List<Integer> src) {
        ListNode prev = null;
        ListNode node = null;
        int d = src.size() - 1;
        for (int i = d; i >= 0; i--) {
            node = new ListNode(src.get(i), prev);
            prev = node;
        }
        return node;
    }
}
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



## Reorder List

https://leetcode.com/problems/reorder-list/

<details>
    <summary> Test Cases </summary>

``` java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class LeetcodeSolutionTest {
    private LeetcodeSolution solution;

    @BeforeEach
    void setSolution() {
        solution = new LeetcodeSolution();
    }

    @Test
    void testFirstReorderList() {
        ListNode expect = ListNodeHandler.buildList(List.of(1, 4, 2, 3));
        ListNode testList = ListNodeHandler.buildList(List.of(1, 2, 3, 4));
        solution.reorderList(testList);
        assertEquals(expect, testList);
    }

    @Test
    void testSecondReorderList() {
        ListNode expect = ListNodeHandler.buildList(List.of(1, 5, 2, 4, 3));
        ListNode testList = ListNodeHandler.buildList(List.of(1, 2, 3, 4, 5));
        solution.reorderList(testList);
        assertEquals(expect, testList);
    }
}
``` 
```java
class ListNodeHandler {
    static ListNode buildList(List<Integer> src) {
        ListNode prev = null;
        ListNode node = null;
        int d = src.size() - 1;
        for (int i = d; i >= 0; i--) {
            node = new ListNode(src.get(i), prev);
            prev = node;
        }
        return node;
    }
}
```
</details>

```java


public void reorderList(ListNode head) {
        if (head==null||head.next==null) return;
        Deque<ListNode> stack = new ArrayDeque<ListNode>();
        ListNode p=head;
        while (p!=null) {
            stack.push(p); p=p.next;
        }
        int cnt=(stack.size()-1)/2;
        p=head;
        while (cnt-->0) {
            ListNode top = stack.pop();
            ListNode tmp = p.next;
            p.next=top;
            top.next=tmp;
            p=tmp;
        }
        stack.pop().next=null;
}
```



## Linked List Cycle II

https://leetcode.com/problems/linked-list-cycle-ii/

<details>
    <summary> Test Cases </summary>

    ``` java
    
    ``` 
</details>

```java
public ListNode detectCycle(ListNode head) {
    if (head == null || head.next == null) {
        return null;   // no circle
    }

    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
        if (fast == slow) { 
            while (head != fast) {
                fast = fast.next;
                head = head.next;
            }
            return head;
        }
    }
    return null;
}
```