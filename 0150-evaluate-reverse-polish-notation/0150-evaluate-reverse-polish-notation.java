class Solution {

    private enum Op {
        ADD, SUB, DIV, MUL
    }

    public int evalRPN(String[] tokens) {
        int numTokens = tokens.length;
        Stack<String> unused = new Stack<>();
        for (int i = numTokens - 1; i >= 0; i--) {
            String curr = tokens[i];
            if (unused.empty() || isOperator(curr)) {
                unused.push(curr);
            } else {
                String prev = unused.peek();
                unused.push(curr);
                boolean canCompute = !isOperator(prev) && unused.size() >= 3;
                while (canCompute) {
                    String operand1String = unused.pop();
                    int operand1 = Integer.parseInt(operand1String);
                    String operand2String = unused.pop();
                    int operand2 = Integer.parseInt(operand2String);
                    String operator = unused.pop();
                    Op opType = getOperationType(operator);
                    int res;
                    if (opType == Op.ADD) {
                        res = operand1 + operand2;
                    } else if (opType == Op.SUB) {
                        res = operand1 - operand2;
                    } else if (opType == Op.MUL) {
                        res = operand1 * operand2;
                    } else {
                        res = operand1 / operand2;
                    }
                    if (unused.size() >= 2) {
                        prev = unused.peek();
                        canCompute = !isOperator(prev);
                    } else {
                        canCompute = false;
                    }
                    String resString = Integer.toString(res);
                    unused.push(resString);
                }
            }
        }

        String resString = unused.pop();
        int res = Integer.parseInt(resString);
        return res;
    }

    public Op getOperationType(String s) {
        if (s.compareTo("+") == 0) {
            return Op.ADD;
        } else if (s.compareTo("-") == 0) {
            return Op.SUB;
        } else if (s.compareTo("/") == 0) {
            return Op.DIV;
        } else {
            return Op.MUL;
        }
    }

    public boolean isOperator(String s) {
        String[] symbols = new String[]{"+", "-", "/", "*"};
        for (String symbol : symbols) {
            if (s.compareTo(symbol) == 0) {
                return true;
            }
        }
        return false;
    }
}