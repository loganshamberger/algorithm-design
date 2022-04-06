import java.util.ArrayList;

/**
 * Problem Space: Design a stack S that support S.push(x), S.pop(), S.findmin() in constant time
 * 
 * Source: Algorithm Design Manual Stephen Skiena 3rd Edition
 */


class Stack<T extends Comparable<T>>{
    private ArrayList<T> minimums;
    private T currentMin;
    private ArrayList<T> stack;
    private int size;

    public Stack(){
        this.stack = new ArrayList<>();
        this.minimums = new ArrayList<>();
        this.currentMin = null;
        this.size = 0;
    }

    void push(T x){
        if(currentMin == null || currentMin.compareTo(x) > 0) {
            this.minimums.add(currentMin);
            currentMin = x;
        }
        stack.add(x);
        size += 1;
    }

    T pop(){
        
        T top = stack.get(size - 1);
        if(top.equals(currentMin)){
            minimums.remove(minimums.size()-1);
            currentMin = minimums.get(minimums.size()-1);
        }
        size -= 1;
        return top;
    }

    T findmin(){
        return currentMin;
    }

    public int getSize() {
        return this.size;
    }
}

 public class StackPriorityQueue{

    
    public static void main(String[] args){
        Stack<Integer> test = new Stack<>();
        test.push(1);
        test.push(2);
        System.out.println(test.findmin());
        test.push(-1);
        test.push(10);
        test.push(8);
        System.out.println(test.findmin());
        printStack(test);
    }

    static <T extends Comparable<T>> void printStack(Stack<T> s){
        while(s.getSize() != 0) {
            System.out.printf("Val: %s Min: %s %n", s.pop().toString(), s.findmin().toString());
        }
    }

 }