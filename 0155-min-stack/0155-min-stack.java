class MinStack {

    Stack<int[]> stack;

    public MinStack() {
        stack = new Stack<>();    
    }
    
    public void push(int val) {
        int[] arr;
        if (stack.empty()) {
            arr = new int[]{val, val};
        } else {
            int[] prevArr = stack.peek();
            int prevMin = prevArr[1];
            int currMin = Math.min(prevMin, val);
            arr = new int[]{val, currMin};
        }
        stack.push(arr);
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        int[] topArr = stack.peek();
        int topVal = topArr[0];
        return topVal;
    }
    
    public int getMin() {
        int[] topArr = stack.peek();
        int min = topArr[1];
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */