import java.util.Arrays;

public class TupleWithSameProduct {

    public static int tupleProduct(int[] nums){
        Arrays.sort(nums);

        int i = 0;
        int j = nums.length-1;
        int counter = 0;
        int p = i+1;
        int q = j-1;

        while (i < nums.length-3){

            int product1 = nums[i]*nums[j];
            int product2 = nums[p]*nums[q];

            if (product2 == product1){
                   counter++;
                   p++;
                   q--;
            }else if (product2 > product1){
                q--;
            }else {
                p++;
            }
            if (p >= q){
                if (j-i > 3){
                    j--;
                }else {
                    i++;
                    j = nums.length-1;
                }
                p = i+1;
                q = j-1;
            }
            if (i > j){
                i++;
            }
        }
        return counter*8;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,4,6,8,12};
        // 2 12 8 3
        // 2 12 6 4
        // 3  8 6 4
        // 3 4 6 2
        // 8 6 12 4


        System.out.println(tupleProduct(nums));
    }
}
