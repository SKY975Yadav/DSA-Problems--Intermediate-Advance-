public class SumOfDigitsInGivenString {
    public static void main(String[] args) {

    }
    public static long findSum(String str)
    {
        // your code here
        Long temp = Long.valueOf(str);
        int n = str.length();
        long sum= 0;
        while (n>0){
            sum += n%10;
            n = n/10;
        }
        return sum;

    }
    public static long findSumContainsNormalCharacters(String s)
    {
        // your code here

        long totalSum = 0;
        StringBuilder numStr = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                numStr.append(c);
            } else {
                if (!numStr.isEmpty()) {
                    totalSum += Long.parseLong(numStr.toString());
                    numStr.setLength(0);
                }
            }
        }

        // If the last characters in the string were digits
        if (!numStr.isEmpty()) {
            totalSum += Long.parseLong(numStr.toString());
        }

        return totalSum;

    }

}
