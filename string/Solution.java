package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

class Solution {
	public int calculate(String s) {
	    char[] array = s.toCharArray();
	    int n = array.length;
	    Stack<Integer> num = new Stack<>();
	    Stack<Character> op = new Stack<>();
	    int temp = -1;
	    for (int i = 0; i < n; i++) {
	        if (array[i] == ' ') {
	            continue;
	        }
	        // ���ֽ����ۼ�
	        if (isNumber(array[i])) {
	            if (temp == -1) {
	                temp = array[i] - '0';
	            } else {
	                temp = temp * 10 + array[i] - '0';
	            }
	        } else {
	            //��������ջ
	            if (temp != -1) {
	                num.push(temp);
	                temp = -1;
	            }
	            //����������
	            if (isOperation(array[i] + "")) {
	                while (!op.isEmpty()) {
	                    if (op.peek() == '(') {
	                        break;
	                    }
	                    //��ͣ�ĳ�ջ���������㣬��������ٴ�ѹ��ջ��
	                    int num1 = num.pop();
	                    int num2 = num.pop();
	                    if (op.pop() == '+') {
	                        num.push(num1 + num2);
	                    } else {
	                        num.push(num2 - num1);
	                    }

	                }
	                //��ǰ�������ջ
	                op.push(array[i]);
	            } else {
	                //���������ţ�ֱ����ջ
	                if (array[i] == '(') {
	                    op.push(array[i]);
	                }
	                //���������ţ���ͣ�Ľ������㣬ֱ������������
	                if (array[i] == ')') {
	                    while (op.peek() != '(') {
	                        int num1 = num.pop();
	                        int num2 = num.pop();
	                        if (op.pop() == '+') {
	                            num.push(num1 + num2);
	                        } else {
	                            num.push(num2 - num1);
	                        }
	                    }
	                    op.pop();
	                }

	            }
	        }
	    }
	    if (temp != -1) {
	        num.push(temp);
	    }
	    //��ջ�е�����Ԫ�ؼ�������
	    while (!op.isEmpty()) {
	        int num1 = num.pop();
	        int num2 = num.pop();
	        if (op.pop() == '+') {
	            num.push(num1 + num2);
	        } else {
	            num.push(num2 - num1);
	        }
	    }
	    return num.pop();
	}

	private boolean isNumber(char c) {
	    return c >= '0' && c <= '9';
	}

	private boolean isOperation(String t) {
	    return t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/");
	}

    
}
