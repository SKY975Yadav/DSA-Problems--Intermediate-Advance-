public class UnderModuloProblems {
    public static void main(String[] args) {

    }
    static long sumUnderModulo(long a, long b){
        // code here
        long modulo = 1000000007;

        // Calculate the sum of a and b modulo

        return (a % modulo + b % modulo) % modulo;
    }
    static long multiplicationUnderModulo(long a, long b)
    {
        // add your code here
        long modulo = 1000000007;

        // Calculate a modulo modulo
        a %= modulo;

        // Calculate b modulo modulo
        b %= modulo;

        // Calculate (a * b) modulo modulo
        long result = (a * b) % modulo;

        return result >= 0 ? result : result + modulo;
    }
    static public int modInverse(int a, int m) {
        for (int x = 1; x < m; x++) {
            if ((a * x) % m == 1) {
                return x; // Found the modular inverse
            }
        }
        return -1; // Modular inverse doesn't exist
    }
}
