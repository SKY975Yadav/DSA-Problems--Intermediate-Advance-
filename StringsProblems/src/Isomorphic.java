import java.util.HashMap;

public class Isomorphic {
    public static void main(String[] args) {
/*
Given two strings 'str1' and 'str2', check if these two strings are isomorphic to each other.

If the characters in str1 can be changed to get str2, then two strings, str1 and str2, are isomorphic. A character must
be completely swapped out for another character while maintaining the order of the characters. A character may map to itself,
 but no two characters may map to the same character
 */
        String str1 = "paper";
        String str2 = "title";
        System.out.println(areIsomorphic(str1, str2));
        System.out.println(isIsomorphic(str1,str2));
    }
    public static boolean isIsomorphic(String s, String t) { // Using Map
        HashMap<Character,Character> map=new HashMap<>();

        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            char ch2=t.charAt(i);

            if(!map.containsKey(ch))
            {
                if(map.containsValue(ch2))
                {
                    return false;
                }
                map.put(ch,ch2);
            }
            else if(map.get(ch)!=ch2)
            {
                return false;
            }
        }

        return true;
    }

    public static boolean areIsomorphic(String str1, String str2) {
        // Step 1: Check if lengths are different
        if (str1.length() != str2.length()) {
            return false;
        }

        // Step 2: Initialize arrays to store mappings
        int[] mappingStr1ToStr2 = new int[256]; // Assuming ASCII characters
        int[] mappingStr2ToStr1 = new int[256]; // Assuming ASCII characters

        // Initialize mapping arrays with -1
        for (int i = 0; i < 256; i++) {
            mappingStr1ToStr2[i] = -1;
            mappingStr2ToStr1[i] = -1;
        }

        // Step 3: Iterate through both strings and update mappings
        for (int i = 0; i < str1.length(); i++) {
            char char1 = str1.charAt(i);
            char char2 = str2.charAt(i);

            // Check if there is a mismatch in mappings
            if (mappingStr1ToStr2[char1] == -1 && mappingStr2ToStr1[char2] == -1) {
                // Update mappings
                mappingStr1ToStr2[char1] = char2;
                mappingStr2ToStr1[char2] = char1;
            } else if (mappingStr1ToStr2[char1] != char2 || mappingStr2ToStr1[char2] != char1) {
                return false;
            }
        }

        // Step 4: If we pass through all characters without mismatch, they are isomorphic
        return true;
    }
}
