import java.util.ArrayList;

public class RootsOfQuadraticEquation {
    public static void main(String[] args) {
        System.out.println(quadraticRoots(752,904,962)); // 817216
    }
    public  static ArrayList<Integer> quadraticRoots(int a, int b, int c) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        double discriminant = (b * b) - (4.0 * a * c);
        if(discriminant>0){
            int root1 = (int) ((-b + Math.sqrt(discriminant)) / (2 * a));
            int root2 = (int) ((-b - Math.sqrt(discriminant)) / (2 * a));
            res.add(root1);
            res.add(root2);
        }
        else if (discriminant==0){
            int root = (int) ( (-b ) / (2.0 * a));
            res.add(root);
            res.add(root);
        }
        else if (discriminant<0){
            res.add(-1);
            res.add(-1);
        }
        return res;
    }

}
