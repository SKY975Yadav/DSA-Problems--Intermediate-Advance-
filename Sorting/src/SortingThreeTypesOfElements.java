public class SortingThreeTypesOfElements {
    public static void main(String[] args) {

    }
    //Best Solution : 1 Traversal
    /*
    Case 1 : given 0s1s2s it is  simple 1st == 0 else if == 1 else(i.e 2)
    Case 2 :If three types of elements are like in this way that is we given a pivot  we have sort the array as elements less
    than pivot first then all pivot elements then elements greater than elements have to sort
    ex:         [1,4,2,6,12,6,35,2,3,6,21], pivot = 6
    then ans = [1,3,2,4,2,6,6,6,12,35,21]
    in this case conditions are
     if ar[mid] < pivot,then swap(mid,low),l++,mid++ else if ar[mid] == pivot mid++; else swap(mid,high),high--;
    Case 3 : given a range(i,j) we have to sort the element in way that first all the elements lesser than i
    then between range of i and j then elements greater than j
     */
    public void sortingThreeTypesOfElements(int[]ar) {
        int low=0,mid=0,high=ar.length-1;
        while (mid<=high){
            if (ar[mid]==0){
                Swap.swapArray(ar,mid,low);
                low++;
                mid++;
            } else if (ar[mid]==1) {
                mid++;
            }
            else {
                Swap.swapArray(ar,mid,high);
                high--;
            }
        }
    }
}
