class RowCol {

    int row, col;

    RowCol(int r, int c) {
        row = r;
        col = c;
    }

    @Override
    public String toString() {
        return this.row+" "+this.col;
    }
}

public class SearchInRowWiseSortedAndColumnWiseSorted {
    public static void main(String[] args) {

        int[][] arr = {
                {10, 20, 30, 40},
                {13, 25, 34, 45},
                {15, 26, 37, 47},
                {18, 28, 38, 49}
        };

        System.out.println(searchInRowWiseSortedAndColWiseSortedMatrix(arr,26));

    }

    public static RowCol searchInRowWiseSortedAndColWiseSortedMatrix(int[][] arr, int x) {

        int row = arr.length, col = arr[0].length;

        int curCol = col - 1;
        int curRow = 0;
        while (curCol >= 0 && curRow < row) {
            if (arr[curRow][curCol] == x) {
                return new RowCol(curRow, curCol);
            } else if (x > arr[curRow][curCol]) {
                curRow++;
            } else curCol--;
        }
        return new RowCol(-1, -1);
    }
}
