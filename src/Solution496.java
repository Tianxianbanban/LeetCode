public class Solution496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result=new int[nums1.length];
        int[] numBig=new int[nums2.length];
        for (int i = 0; i < nums2.length; i++) {
            numBig[i]=-1;
            for (int j = i+1; j < nums2.length; j++) {
                if (nums2[j]>nums2[i]){
                    numBig[i]=nums2[j];
                    break;
                }
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i]==nums2[j]){
                    result[i]=numBig[j];
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution496 solution496=new Solution496();
        Solution496_2 solution496_2=new Solution496_2();
        int[] num1={4,1,2};
        int[] num2={1,3,4,2};
        int[] num11={2,4};
        int[] num22={1,2,3,4};
        int[] num=solution496.nextGreaterElement(num1,num2);
        for (int i = 0; i < num.length; i++) {
            System.out.println(num[i]);
        }
        System.out.println();
        int[] numm=solution496.nextGreaterElement(num11,num22);
        for (int i = 0; i < numm.length; i++) {
            System.out.println(numm[i]);
        }
    }
}
