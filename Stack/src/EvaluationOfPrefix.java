import java.util.Stack;

public class EvaluationOfPrefix {
    public double evaluate(String str){
        String [] strArr = str.split(" ");
        Stack<Double> stack  = new Stack<>();
        double x, y, result ;
        try {
            for (int i = strArr.length - 1; i >= 0; i--) {
                String st = strArr[i];

                if (st.length() == 1 && isOperator(st.charAt(0))) {
                    if (stack.size() < 2) {
                        throw new IllegalArgumentException("Invalid postfix expression");
                    }
                    x = stack.pop();
                    y = stack.pop();
                    result = opr(st.charAt(0), x, y);
                    stack.push(result);
                } else {
                    try {
                        double num = Double.parseDouble(st);
                        stack.push(num);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Invalid number in postfix expression: " + st);
                    }
                }
            }
            if (stack.size() != 1) {
                throw new IllegalArgumentException("Invalid postfix expression");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return stack.pop();
    }

    private static double opr(char ch, double num1, double num2) { // TC : (1)
        return switch (ch) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> num1 / num2;
            case '%' -> num1 % num2;
            default -> -1;
        };
    }

    private static boolean isOperator(char ch) { // TC : O(1)
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' ||  ch == '%';
    }

    public static void main(String[] args) {
        String str = "+ 8 * 3 - 2 1";
        EvaluationOfPrefix evp = new EvaluationOfPrefix();
        System.out.println(evp.evaluate(str));
    }
}
