public class MaximumOccuredChar {
    public static void main(String[] args) {
        String line = "saikrishnayadav";
        System.out.println(getMaxOccuringChar(line));
    }
    public static char getMaxOccuringChar(String line)
    {
        int [] chars = new int [26];

        for(int i=0;i<line.length();i++){
            chars[line.charAt(i)-'a']++;
        }
        int max = chars[0];
        int ind = 0;
        for(int i=1;i<26;i++){
            if(chars[i]>max){
                max = chars[i];
                ind = i;
            }
        }

        return (char) (ind + 'a');
    }
}
