package com.rookie.bigdata.easy.A0007;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 *  示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * @author rookie
 * @version 1.0
 * @date 2020/6/21 21:40
 */
public class Solution {


    public static void main(String[] args) {

        myReverse(-123);

    }


    /**
     * @param x
     * @return
     */
    public static int myReverse(int x) {

        int temp = x;
        int a = x % 10;
        while (temp / 10 != 0) {
            temp = temp / 10;
            a = a * 10 + temp % 10;

            //直接在这里对a进行判断
            if (a > Integer.MAX_VALUE / 10 || a == Integer.MAX_VALUE / 10 && temp % 10 > 7) {
                return 0;
            }

            if (a < Integer.MIN_VALUE / 10 || a == Integer.MAX_VALUE / 10 && temp % 10 < -8) {
                return 0;
            }
        }
        //  temp=temp*10+
        System.out.println(a);
        return a;
        //return 0;
    }


    /**
     * 我们可以一次构建反转整数的一位数字。在这样做的时候，我们可以预先检查向原整数附加另一位数字是否会导致溢出。
     * <p>
     * 算法
     * <p>
     * 反转整数的方法可以与反转字符串进行类比。
     * <p>
     * 我们想重复“弹出” xx 的最后一位数字，并将它“推入”到 \text{rev}rev 的后面。最后，\text{rev}rev 将与 xx 相反。
     * <p>
     * 要在没有辅助堆栈 / 数组的帮助下 “弹出” 和 “推入” 数字，我们可以使用数学方法。
     * <p>
     * <p>
     * //pop operation:
     * pop = x % 10;
     * x /= 10;
     * <p>
     * //push operation:
     * temp = rev * 10 + pop;
     * rev = temp;
     * 但是，这种方法很危险，因为当 \text{temp} = \text{rev} \cdot 10 + \text{pop}temp=rev⋅10+pop 时会导致溢出。
     * <p>
     * 幸运的是，事先检查这个语句是否会导致溢出很容易。
     * <p>
     * 为了便于解释，我们假设 \text{rev}rev 是正数。
     * <p>
     * 如果 temp = \text{rev} \cdot 10 + \text{pop}temp=rev⋅10+pop 导致溢出，那么一定有 \text{rev} \geq \frac{INTMAX}{10}rev≥
     * 10
     * INTMAX
     * ​
     * 。
     * 如果 \text{rev} > \frac{INTMAX}{10}rev>
     * 10
     * INTMAX
     * ​
     * ，那么 temp = \text{rev} \cdot 10 + \text{pop}temp=rev⋅10+pop 一定会溢出。
     * 如果 \text{rev} == \frac{INTMAX}{10}rev==
     * 10
     * INTMAX
     * ​
     * ，那么只要 \text{pop} > 7pop>7，temp = \text{rev} \cdot 10 + \text{pop}temp=rev⋅10+pop 就会溢出。
     * 当 \text{rev}rev 为负时可以应用类似的逻辑。
     *
     *
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }


}
