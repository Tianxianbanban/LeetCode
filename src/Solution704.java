/**
 * 二分查找：
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 */
public class Solution704 {
    public static int search(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        int mid;
        while (low<=high){
            mid=(low+high)/2;
            if (nums[mid]==target){
                return mid;
            }else if (nums[mid]>target){
                high=mid-1;
            }else if (nums[mid]<target){
                low=mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1={-1,0,3,5,9,12};
        int target1=9;
        System.out.println(search(nums1,target1));
        int[] nums2={-1,0,3,5,9,12};
        int target2=2;
        System.out.println(search(nums2,target2));
    }
}
