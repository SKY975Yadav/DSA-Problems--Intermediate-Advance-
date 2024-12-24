import java.util.Arrays;

public class MultiDimensionalArray {
    public static void main(String[] args) {
        int [] temp = {10,20,30,40,50};
        int [][] mulArr = {{10,20,13,14,50},temp,{43,62,99,78,34}};;

        int [] [] mulArr2 = new int[10][5];
//        System.out.println(Arrays.deepToString(mulArr));
//
//        for (int i = 0; i < mulArr.length; i++) {
//            for (int j = 0; j < mulArr[i].length; j++) {
//                System.out.print(mulArr[i][j]+" ");
//            }
//            System.out.println();
//        }
        int num = 1;
        for (int i = 0; i < mulArr2.length; i++) {
            for (int j = 0; j < mulArr2[i].length; j++) {
                mulArr2[i][j] = num++;
            }
        }
        for (int i = 0; i < mulArr2.length; i++) {
            for (int j = 0; j < mulArr2[i].length; j++) {
                System.out.print(mulArr2[i][j]+" ");
            }
            System.out.println();
        }

        int [] [] [] []  fatalArr = {
                                    {
                                        {   {1,2,3,4},
                                            {5,6,7,8}
                                        },
                                        {   {1,2,3,4},
                                            {1,2,3,4}
                                        },
                                        {   {1,2,3,4},
                                            {1,2,3,4}
                                        }
                                    },
                                    {
                                        {
                                            {1,2,3,4},
                                            {5,6,7,8}
                                        },
                                        {
                                            {1,2,3,4},
                                            {1,2,3,4}
                                        },
                                        {   {1,2,3,4},
                                            {1,2,3,4}
                                        }
                                    }
        };
    }
}
