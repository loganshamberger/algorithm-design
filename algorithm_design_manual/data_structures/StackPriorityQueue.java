import java.util.ArrayList;

/**
 * Problem Space: Design a stack S that support S.push(x), S.pop(), S.findmin() in constant time
 * 
 * Source: Algorithm Design Manual Stephen Skiena 3rd Edition
 */


class Stack<T extends Comparable<T>>{
    private StackNode<T> stack;

    private class StackNode<T> {
        T val;
        T currMin;
        StackNode<T> next;
        StackNode<T> previous;
    }
    public Stack(){
        this.stack = new StackNode<>();
    }

    void push(T x){
        StackNode<T> newNode = new StackNode<>();
        newNode.val= x;
        if(this.stack.currMin == null || this.stack.currMin.compareTo(x) > 0) {
            newNode.currMin = x;
        } else {
            newNode.currMin = this.stack.currMin;
        }
        this.stack.next = newNode;
        newNode.previous = stack;
        this.stack = newNode;

    }

    T pop(){
        
        T top = stack.val;
        this.stack = this.stack.previous;
        this.stack.next = null;
        return top;
    }

    T findmin(){
        return this.stack.currMin;
    }

    boolean isEmpty(){
        return this.stack.previous == null;
    }

    
}

 public class StackPriorityQueue{

    
    public static void main(String[] args){
        Stack<Integer> test = new Stack<>();
        test.push(1);
        test.push(2);
        test.push(-1);
        test.push(10);
        test.push(8);
        printStack(test);
    }

    static <T extends Comparable<T>> void printStack(Stack<T> s){
        while(!s.isEmpty()) {
            T min = s.findmin();
            T val = s.pop();
            System.out.printf("Val: %s Min: %s %n", val, min);
        }
    }

 }