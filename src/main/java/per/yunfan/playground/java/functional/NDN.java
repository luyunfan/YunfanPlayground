package per.yunfan.playground.java.functional;


import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;


public class NDN {
    public static void main(String[] args) {
        IntUnaryOperator calcFunc = n -> (int) ((n + "").chars() //数字按位转换成Stream
                .parallel() //并行
                .map(num -> Character.digit(num, Character.MAX_RADIX)) //将char换成int
                .mapToDouble(num -> Math.pow(num, ("" + n).length()))) //每位求次方
                .sum(); //求和

        IntStream.iterate(100, n -> n + 1) //构造100开始的无限序列
                .filter(i -> (i == calcFunc.applyAsInt(i))) //是否和上面计算函数计算结果相等（即定义的计算后还等于自己）
                .limit(4) //Java缺失停止迭代API，应该有个takeWhile(i -> i < 999)设定停止位置
                .forEach(System.out::println); //打印

    }
}
