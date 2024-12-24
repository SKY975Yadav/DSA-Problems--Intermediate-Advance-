import java.util.Stack;
public class InfixToPrefix {

    public String infixToPrefix(String str){

        str = str.replaceAll("\\s","");
        int  n = str.length();

        Stack<Character> stack = new Stack<>();
        StringBuilder stb = new StringBuilder();

        int i = n-1;
        try {
            while (i >= 0) {
                char ch = str.charAt(i);
                if (Character.isLetterOrDigit(ch) || ch == '.') {
                    i = handleIsLetterOrDigit(stb, str, i);
                } else if (isParenthesis(ch)) {
                    handleParenthesis(stb, stack, ch);
                } else if (isOperator(ch)) {
                    handleOperator(stb, stack, ch);
                } else {
                    throw new IllegalArgumentException("Invalid character in expression: " + ch);
                }
                i--;
            }
            while (!stack.isEmpty()) {
                char top = stack.pop();
                if (isParenthesis(top)) {
                    throw new IllegalArgumentException("Mismatched parentheses");
                }
                stb.append(top).append(' ');
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return stb.reverse().toString().trim();
    }

    private int handleIsLetterOrDigit(StringBuilder stb, String str,int i){
        while (i>=0 && (Character.isLetterOrDigit(str.charAt(i)) || str.charAt(i)=='.') ){
            stb.append(str.charAt(i));
            i--;
        }
        stb.append(' ');
        return ++i;
    }
    private void handleOperator(StringBuilder stb, Stack<Character> stack, char ch) {
        while (!stack.isEmpty() && precedence(stack.peek()) > precedence(ch)) {
            stb.append(stack.pop()).append(' ');
        }
        stack.push(ch);
    }

    private void handleParenthesis(StringBuilder stb,Stack<Character> stack,char ch){
        if (ch == ')') {
            stack.push(ch);
        } else { // ch == '('
            while (!stack.isEmpty() && stack.peek() != ')') {
                stb.append(stack.pop()).append(' ');
            }
            if (stack.isEmpty()) {
                throw new IllegalArgumentException("Mismatched parentheses");
            }
            stack.pop(); // Remove the ')' from the stack
        }
    }

    private boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '%';
    }
    private boolean isParenthesis(char ch) {
        return ch == '(' || ch == ')';
    }
    private int precedence(char ch) {
        return switch (ch) {
            case '(', ')' -> 0; // Parentheses precedence is considered as 0
            case '+', '-' -> 1;
            case '*', '/', '%' -> 2;
            default -> -1;
        };
    }

    public static void main(String[] args) {
        InfixToPrefix itp = new InfixToPrefix();
        String str = "8+3*(2-1)";
        System.out.println(itp.infixToPrefix(str));
    }
}