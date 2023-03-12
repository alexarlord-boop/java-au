# Java course at the Alferov University of the Russian Academy of Sciences

- This repo contains some algorithmic tasks from [leetcode](https://leetcode.com/).
- I have learned basic algorithms and data structures thanks to this course.
- Also, I created a Markdown generator to make results look beautiful 🥳


# Solution Example


# DESIGN

+ [Implement Stack using Queues](#implement-stack-using-queues)
+ [Min Stack](#min-stack)
+ [Implement Queue using Stacks](#implement-queue-using-stacks)
<!---->

## Implement Stack using Queues

https://leetcode.com/problems/implement-stack-using-queues/

<details>
    <summary> Test Cases </summary>

    ``` java
    
    ``` 
</details>

```java
class MyStack {
    Queue<Integer> q;

    public MyStack() {
        q = new ArrayDeque<>();
    }

    public void push(int x) {
        q.add(x);
        int n = q.size();

        while (n-- > 1) {
            q.add(q.poll());
        }
    }

    public int pop() {
        return q.poll();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}
```


## Min Stack

https://leetcode.com/problems/min-stack/

<details>
    <summary> Test Cases </summary>

    ``` java
    
    ``` 
</details>

```java
class MinStack {
    class Element {
        int val;
        int minn;
        Element next;

        public Element(int val, int minn) {
            this.val = val;
            this.minn = minn;
        }
    }

    Element top = null;

    public void push(int x) {
        if (top == null) {
            top = new Element(x, x);
        } else {
            Element e = new Element(x, Math.min(x, top.minn));
            e.next = top;
            top = e;
        }
    }

    public void pop() {
        if (top == null) {
            return;
        } else {
            Element temp = top.next;
            top = temp;
        }
    }

    public int top() {
        if (top == null) {
            return -1;
        } else {
            return top.val;
        }
    }

    public int getMin() {
        if (top == null) {
            return -1;
        } else {
            return top.minn;
        }
    }
}
```


## Implement Queue using Stacks

https://leetcode.com/problems/implement-queue-using-stacks/

<details>
    <summary> Test Cases </summary>

    ``` java
    
    ``` 
</details>

```java
class MyQueue {
    Deque<Integer> inStack;
    Deque<Integer> outStack;

    public MyQueue() {
        inStack = new ArrayDeque<>();
        outStack = new ArrayDeque<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        peek();
        return outStack.pop();
    }

    public int peek() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}
```
