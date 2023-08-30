package LeetCode150.주차2_1.MinStack;

class MinStack {
    int[] stack;
    int[] stackForMin;
    int pointer = -1;

    public MinStack() {
        stack = new int[30001];
        stackForMin = new int[30001];
    }

    public void push(int val) {
        pointer++;
        stack[pointer] = val;

        if(pointer==0){
            stackForMin[pointer] = val;
        }else{
            stackForMin[pointer] = Math.min(stackForMin[pointer-1],val);
        }

    }

    public void pop() {
        pointer--;
    }

    public int top() {
        return stack[pointer];
    }

    public int getMin() {
        return stackForMin[pointer];
    }
}