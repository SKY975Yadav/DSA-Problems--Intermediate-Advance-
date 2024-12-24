import java.util.Scanner;

public class SolvingExpression {
    public static void main(String[] args)  throws Exception{
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println("Using PostFix : ");
        InfixToPostfix ipt = new InfixToPostfix();
        String psf = ipt.infixToPostfix(str);
        System.out.println(psf);
        EvaluationOfPostfix evf = new EvaluationOfPostfix();
        System.out.println(evf.evaluate(psf));
        System.out.println();


        System.out.println("Using PreFix : ");
        InfixToPrefix ipf = new InfixToPrefix();
        String prf = ipf.infixToPrefix(str);
        System.out.println(prf);
        EvaluationOfPrefix evp = new EvaluationOfPrefix();
        System.out.println(evp.evaluate(prf));
    }
}
