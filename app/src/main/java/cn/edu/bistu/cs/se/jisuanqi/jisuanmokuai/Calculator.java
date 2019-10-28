package cn.edu.bistu.cs.se.jisuanqi.jisuanmokuai;

import java.util.Collections;
import java.util.Stack;


public class Calculator {
    private Stack<String> postfixStack = new Stack<String>();
    private Stack<Character> opStack = new Stack<Character>();
    private int[] operatPriority = new int[] { 0, 3, 2, 1, -1, 1, 0, 2 };
    public static double conversion(String expression) {
        double result = 0;
        Calculator cal = new Calculator();
        try {
            expression = transform(expression);
            result = cal.calculate(expression);
        } catch (Exception e) {

            return 0.0 / 0.0;
        }

        return result;
    }


    private static String transform(String expression) {
        char[] arr = expression.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '-') {
                if (i == 0) {
                    arr[i] = '~';
                } else {
                    char c = arr[i - 1];
                    if (c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == 'E' || c == 'e') {
                        arr[i] = '~';
                    }
                }
            }
        }
        if(arr[0]=='~'||arr[1]=='('){
            arr[0]='-';
            return "0"+new String(arr);
        }else{
            return new String(arr);
        }
    }


    public double calculate(String expression) {
        Stack<String> resultStack = new Stack<String>();
        prepare(expression);
        Collections.reverse(postfixStack);
        String firstValue, secondValue, currentValue;
        while (!postfixStack.isEmpty()) {
            currentValue = postfixStack.pop();
            if (!isOperator(currentValue.charAt(0))) {// ����������������������ջ��
                currentValue = currentValue.replace("~", "-");
                resultStack.push(currentValue);
            } else {// ������������Ӳ�����ջ��ȡ����ֵ�͸���ֵһ���������
                secondValue = resultStack.pop();
                firstValue = resultStack.pop();

                // ��������Ƿ���Ϊ����
                firstValue = firstValue.replace("~", "-");
                secondValue = secondValue.replace("~", "-");

                String tempResult = calculate(firstValue, secondValue, currentValue.charAt(0));
                resultStack.push(tempResult);
            }
        }
            return Double.valueOf(resultStack.pop());
    }

    /**
     * ����׼���׶ν����ʽת����Ϊ��׺ʽջ
     * 
     * @param expression
     */
    private void prepare(String expression) {
        opStack.push(',');// ���������ջ��Ԫ�ض��ţ��˷������ȼ����
        char[] arr = expression.toCharArray();
        int currentIndex = 0;// ��ǰ�ַ���λ��
        int count = 0;// �ϴ����������������������������ַ��ĳ��ȱ��ڻ���֮�����ֵ
        char currentOp, peekOp;// ��ǰ��������ջ��������
        for (int i = 0; i < arr.length; i++) {
            currentOp = arr[i];
            if (isOperator(currentOp)) {// �����ǰ�ַ��������
                if (count > 0) {
                    postfixStack.push(new String(arr, currentIndex, count));// ȡ���������֮�������
                }
                peekOp = opStack.peek();
                if (currentOp == ')') {// �����������������ջ�е�Ԫ���Ƴ�����׺ʽջ��ֱ������������
                    while (opStack.peek() != '(') {
                        postfixStack.push(String.valueOf(opStack.pop()));
                    }
                    opStack.pop();
                } else {
                    while (currentOp != '(' && peekOp != ',' && compare(currentOp, peekOp)) {
                        postfixStack.push(String.valueOf(opStack.pop()));
                        peekOp = opStack.peek();
                    }
                    opStack.push(currentOp);
                }
                count = 0;
                currentIndex = i + 1;
            } else {
                count++;
            }
        }
        if (count > 1 || (count == 1 && !isOperator(arr[currentIndex]))) {// ���һ���ַ��������Ż��������������������׺ʽջ��
            postfixStack.push(new String(arr, currentIndex, count));
        }

        while (opStack.peek() != ',') {
            postfixStack.push(String.valueOf(opStack.pop()));// ��������ջ�е�ʣ���Ԫ����ӵ���׺ʽջ��
        }
    }

    /**
     * �ж��Ƿ�Ϊ��������
     *
     * @param c
     * @return
     */
    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')';
    }

    /**
     * ����ASCII��-40���±�ȥ�����������ȼ�
     *
     * @param cur
     * @param peek
     * @return
     */
    public boolean compare(char cur, char peek) {// �����peek���ȼ�����cur������true��Ĭ�϶���peek���ȼ�Ҫ��
        boolean result = false;
        if (operatPriority[(peek) - 40] >= operatPriority[(cur) - 40]) {
            result = true;
        }
        return result;
    }

    /**
     * ���ո��������������������
     *
     * @param firstValue
     * @param secondValue
     * @param currentOp
     * @return
     */
    private String calculate(String firstValue, String secondValue, char currentOp) {
        String result = "";
        switch (currentOp) {
        case '+':
            result = String.valueOf(ArithHelper.add(firstValue, secondValue));
            break;
        case '-':
            result = String.valueOf(ArithHelper.sub(firstValue, secondValue));
            break;
        case '*':
            result = String.valueOf(ArithHelper.mul(firstValue, secondValue));
            break;
        case '/':
            result = String.valueOf(ArithHelper.div(firstValue, secondValue));
            break;
        }
        return result;
    }
}