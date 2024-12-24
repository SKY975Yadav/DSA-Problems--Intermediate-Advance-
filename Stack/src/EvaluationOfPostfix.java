import java.util.Stack;

public class EvaluationOfPostfix {

    public  double evaluate(String str){

        String[] strArr = str.split(" ");
        Stack<Double> stack = new Stack<>();

        double x, y, result ;
        try {
            for (String s : strArr) {
                if (s.length() == 1 && isOperator(s.charAt(0))) {
                    if (stack.size() < 2) {
                        throw new IllegalArgumentException("Invalid postfix expression");
                    }
                    y = stack.pop();
                    x = stack.pop();
                    result = opr(s.charAt(0), x, y);
                    stack.push(result);
                } else {
                    try {
                        double num = Double.parseDouble(s);
                        stack.push(num);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Invalid number in postfix expression: " + s);
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
        EvaluationOfPostfix evf = new EvaluationOfPostfix();
        String str = "2 5 1 / + 3 9 * +";
        System.out.println(evf.evaluate(str));
    }
}
