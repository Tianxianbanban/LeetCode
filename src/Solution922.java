/**
 * 按奇偶排序数组 II
 * 循环遍历一遍，确认奇数或者偶数，填入新的数组的相应位置。
 */
public class Solution922 {
    public int[] sortArrayByParityII(int[] A) {
        int[] result=new int[A.length];
        int indexDouble=0;
        int indexSingle=1;
        for (int i = 0; i < A.length; i++) {
            if (A[i]%2==0){//如果为偶数
                result[indexDouble]=A[i];
                indexDouble+=2;
            }else {
                result[indexSingle]=A[i];
                indexSingle+=2;
            }
        }
        return result;
    }
}
