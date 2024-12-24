public class MaximumFrequencyOf1s {
    public static void main(String[] args) {
        int [] ar = {1,1,1,0,0,1,1,0};
        System.out.println(maxFrequenciesOf1(ar));
    }
    public static int maxFrequenciesOf1(int [] ar){
        int maxFreq = 0;
        int curFreq = 0;
        for (int i : ar ){
            if (i==1) curFreq++;
            else {
                maxFreq = Math.max(curFreq,maxFreq);
                curFreq = 0;
            }
        }
        return Math.max(maxFreq,curFreq);
    }
}
