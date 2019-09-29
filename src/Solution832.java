/**
 * 翻转图像:
 *
 * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。
 * 例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
 * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。
 * 例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
 */
public class Solution832 {
    public static int[][] flipAndInvertImage(int[][] A) {
        System.out.println(A.length);
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j <= A[i].length/2-1; j++) {
                int temp=A[i][j];
                A[i][j]=A[i][A[i].length-1-j];
                A[i][A[i].length-1-j]=temp;
            }
            for (int j = 0; j < A[i].length; j++) {
                if (A[i][j]==0){
                   A[i][j]=1;
                }else {
                    A[i][j]=0;
                }
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[][] A={{1,1,0},{1,0,1},{0,0,0}};
        int[][] B=flipAndInvertImage(A);
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B[i].length; j++) {
                System.out.print(B[i][j]);
            }
            System.out.println();
        }
    }
}
