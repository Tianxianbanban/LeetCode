import java.util.Arrays;

/**
 * 用于验证排序算法正确性的对数器
 */
public class SortCompareNum {

    Solution349 sorting;

    public SortCompareNum(Solution349 sorting) {
        this.sorting = sorting;
    }


    /**
     * 产生一个随机数数组
     * @param length 数组长度
     * @param maxNum 产生随机数的最大值
     * @return
     */
    public int[] generateRandomArray(int length,int maxNum){
        int[] randomArray=new int[(int)(Math.random()*length)];
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i]=(int)(Math.random()*maxNum);
        }
        return randomArray;
    }

    /**
     * 一个绝对正确的排序算法，将数组进行一次排序
     * @param arr 需要被排序的数组
     */
    public void correctSort(int[] arr){
        Arrays.sort(arr);
    }

    /**
     * 对自己的编写的算法的排序结果与正确的排序结果进行比较
     * @param arr 绝对正确的排序结果的数组
     * @param arrB 自己编写的排序算法的结果
     * @return
     */
    public boolean isArrEqual(int[] arr,int[] arrB){
        //两个数组应该是一样长度的
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]!=arrB[i]){
                return false;
            }
        }
        return true;
    }


    public void repeatedlyCompare(int times){
        for (int i = 0; i < times; i++) {
            int arrayLength=15;
            int maxNum=30;
            //产生一个随机数组用于测试
            int[] randomArray=generateRandomArray(arrayLength,maxNum);
            //将原始数组拷贝
            int[] arrayOne=Arrays.copyOf(randomArray,randomArray.length);
            int[] arrayTwo=Arrays.copyOf(randomArray,randomArray.length);
            //正确排序与自己编写的算法排序
            correctSort(arrayOne);
            sorting.insertSort(arrayTwo);

            boolean isEqual=isArrEqual(arrayOne,arrayTwo);
            if (isEqual){
                System.out.print(true+" ");
                for (int a:arrayTwo) {
                    System.out.print(a+" ");
                }
                System.out.println();
            }else{
                System.out.println(false);
                for (int a:arrayOne) {
                    System.out.print(a+" ");
                }
                System.out.println();
                for (int a:arrayTwo) {
                    System.out.print(a+" ");
                }
                System.out.println();
            }
        }
    }

}
