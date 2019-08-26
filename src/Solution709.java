public class Solution709 {
    /**
     * 转换成小写字母
     * @param str
     * @return
     */
    public String toLowerCase(String str) {
        String result=str.toLowerCase();
        return result;
    }
    public static void main(String[] args) {
        Solution709 solution=new Solution709();
        String a="Hello";
        String b="here";
        String c="LOVELY";
        System.out.println(solution.toLowerCase(a));
        System.out.println(solution.toLowerCase(b));
        System.out.println(solution.toLowerCase(c));
    }
}
