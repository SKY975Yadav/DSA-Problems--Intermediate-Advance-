public class InterSectionOfTwoSortedArrays {
    public static void main(String[] args) {

    }
    public void printOfIntersectionOfTwoSortedArrays(int[]a,int[]b){ //O(m+n)using merge
        int m = a.length;
        int n = b.length;
        int i=0,j=0;
        while (i<m && j<n){
            if (i>0 && a[i]==a[i-1]){ i++; continue;}
            if (a[i]==b[j]){ System.out.println(a[i]); i++;j++;}
            else if (a[i]<b[j])i++;
            else j++;
        }
    }
}
