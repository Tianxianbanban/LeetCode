import java.util.*;

/**
 *  两个数组的交集:
 *  两个数组分别排序，然后取公共部分，
 *  Set去重。
 */
public class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        //分别进行一次排序
        insertSort(nums1);
        insertSort(nums2);

        int index1=0;
        int index2=0;
        Set<Integer> set=new TreeSet<>();

        while (index1<nums1.length&&index2<nums2.length){
            if (nums1[index1]<nums2[index2]){
                index1++;
            }else if (nums1[index1]==nums2[index2]){
                set.add(nums1[index1]);
                index1++;
                index2++;
            }else {
                index2++;
            }
        }

        List<Integer> list=new ArrayList<>(set);
        int[] result=new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i]=list.get(i);
        }
        return result;
    }

    /**
     * 插入排序
     * @param arr
     */
    public void insertSort(int[] arr){

        for (int i = 1; i < arr.length; i++) {
            if (arr[i]<arr[i-1]){
                int temp=arr[i-1];
                arr[i-1]=arr[i];
                arr[i]=temp;
                for (int j = i; j >0; j--) {
                    if (arr[j]<arr[j-1]){
                        temp=arr[j];
                        arr[j]=arr[j-1];
                        arr[j-1]=temp;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution349 solution349=new Solution349();
        SortCompareNum sortCompareNum=new SortCompareNum(solution349);
//        sortCompareNum.repeatedlyCompare(10);

        int[] arrayOne= sortCompareNum.generateRandomArray(20,30);
        int[] arrayTwo=sortCompareNum.generateRandomArray(20,30);

        for (int i = 0; i < arrayOne.length; i++) {
            System.out.print(arrayOne[i]+" ");
        }
        System.out.println();
        System.out.println();
        for (int i = 0; i < arrayTwo.length; i++) {
            System.out.print(arrayTwo[i]+" ");
        }
        System.out.println();
        System.out.println();
        for (int num:solution349.intersection(arrayOne,arrayTwo)) {
            System.out.print(num+" ");
        }
    }


}
