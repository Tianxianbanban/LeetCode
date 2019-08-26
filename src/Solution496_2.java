import java.util.HashMap;
import java.util.Stack;

public class Solution496_2 {
    /**
     * 下一个更大元素 I
     * 方法一：
     * 就是通常能够想到的双重循环的暴力解法,时间复杂度为O(n^2)。
     * 方法二：
     * 通过栈的使用，只遍历nums2一次就将下一个更大的元素确定，将时间复杂度降到O(n),
     * 再结合Hashmap的使用来查找元素。
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack=new Stack<>();
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty()&&nums2[i] > stack.peek()) {
                hashMap.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i]=hashMap.containsKey(nums1[i])?hashMap.get(nums1[i]):-1;
        }
        return nums1;
    }
    public static void main(String[] args) {
        Solution496_2 solution496_2=new Solution496_2();
        int[] num1={4,1,2};
        int[] num2={1,3,4,2};
        int[] num11={2,4};
        int[] num22={1,2,3,4};
        int[] num=solution496_2.nextGreaterElement(num1,num2);
        for (int i = 0; i < num.length; i++) {
            System.out.println(num[i]);
        }
        System.out.println();
        int[] numm=solution496_2.nextGreaterElement(num11,num22);
        for (int i = 0; i < numm.length; i++) {
            System.out.println(numm[i]);
        }
    }
}
