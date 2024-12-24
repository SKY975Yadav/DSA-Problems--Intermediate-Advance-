import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class ConcatenatedString {
    public static void main(String[] args) {

    }
    public static String concatenatedString(String s1,String s2)
    {
        // Your code here
        Set<Character> commonChars = new HashSet<>();
        for (char ch : s1.toCharArray()) {
            if (s2.indexOf(ch) != -1) {
                commonChars.add(ch);
            }
        }

        // Step 2: Remove common characters from both strings
        String result = getString(s1, s2, commonChars);

        // Step 4: Check if the result is empty
        if (result.isEmpty()) {
            return "-1";
        } else {
            return result;
        }

    }

    private static String getString(String s1, String s2, Set<Character> commonChars) {
        StringBuilder s1Modified = new StringBuilder();
        for (char ch : s1.toCharArray()) {
            if (!commonChars.contains(ch)) {
                s1Modified.append(ch);
            }
        }

        StringBuilder s2Modified = new StringBuilder();
        for (char ch : s2.toCharArray()) {
            if (!commonChars.contains(ch)) {
                s2Modified.append(ch);
            }
        }

        // Step 3: Concatenate remaining characters
        return s1Modified.toString() + s2Modified.toString();
    }
}
