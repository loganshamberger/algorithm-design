import java.util.ArrayList;

/**
 * Problem Space: Design a stack S that support S.push(x), S.pop(), S.findmin() in constant time
 * 
 * Source: Algorithm Design Manual Stephen Skiena 3rd Edition
 */


class Stack{
    private ArrayList<Integer> minimums;
    private int currentMin;
    private ArrayList<Integer> stack;
    private int size;

    public Stack(){
        this.stack = new ArrayList<>();
        this.minimums = new ArrayList<>();
        this.currentMin = Integer.MAX_VALUE;
        this.size = 0;
    }

    void push(int x){
        if(x<currentMin){
            minimums.add(currentMin);
            currentMin = x;
        }
        stack.add(x);
        size += 1;
    }

    int pop(){
        
        int top = stack.get(size - 1);
        if(top == currentMin){
            minimums.remove(minimums.size()-1);
            currentMin = minimums.get(minimums.size() - 1);
        }
        size -= 1;
        return top;
    }

    int findmin(){
        return currentMin;
    }
}

 public class StackPriorityQueue{

    
    public static void main(String[] args){
        Stack test = new Stack();
        test.push(1);
        test.push(2);
        System.out.println(test.findmin());
        test.push(-1);
        test.push(10);
        test.push(8);
        System.out.println(test.findmin());
    }

  
 }