public class RotationsInString {
    public static void main(String[] args) {


    }
    public static boolean areRotations(String s1, String s2 )
    {
        if (s1.length() != s2.length()) {
            return false; // Strings must be of equal length for rotation
        }

        return ((s1 + s1).lastIndexOf(s2) >= 0);
    }

    public static boolean isRotated(String str1, String str2)
    {
        // Your code here
        // Check if both strings have the same length
        if (str1.length() != str2.length()) return false;

        // Check if the strings have length less than 2
        if (str1.length() < 2) return str1.equals(str2);

        // Create rotated versions of str1
        String clockwiseRotation = str1.substring(2) + str1.substring(0, 2);
        String counterClockwiseRotation = str1.substring(str1.length() - 2) + str1.substring(0, str1.length() - 2);

        // Check if str2 matches either of the rotated versions
        return str2.equals(clockwiseRotation) || str2.equals(counterClockwiseRotation);
    }
}
