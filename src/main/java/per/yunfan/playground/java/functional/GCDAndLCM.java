package per.yunfan.playground.java.functional;

public class GCDAndLCM {
    public static void main(String... args)  {


        System.out.println(gcd(9, 27));
        System.out.println(lcm(2, 5));
    }

    /**
     * 计算最大公约数
     *
     * @param m 第一个数字
     * @param n 第二个数字
     * @return 最大公约数
     */
    private static int gcd(int m, int n) {
        return n == 0 ? m : gcd(n, m % n);
    }

    /**
     * 求最小公倍数
     *
     * @param m 第一个数字
     * @param n 第二个数字
     * @return 最小公倍数
     */
    private static int lcm(int m, int n) {
        return m * (n / gcd(m, n));
    }
}
