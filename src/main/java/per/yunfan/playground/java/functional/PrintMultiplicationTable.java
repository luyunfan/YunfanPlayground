package per.yunfan.playground.java.functional;

import java.util.function.Consumer;
import java.util.function.IntFunction;

import static java.util.stream.IntStream.rangeClosed;

/**
 * 用于包装int二元组
 */
final class IntTuple {
    /**
     * 第一个元素
     */
    final int first;

    /**
     * 第二个元素
     */
    final int second;

    /**
     * 二元组构造函数，初始化两个元素
     *
     * @param first  第一个元素
     * @param second 第二个元素
     */
    IntTuple(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

/**
 * 代表一个方法，入参是两个int值，返回任意类型对象
 *
 * @param <T> 返回值类型
 */
@FunctionalInterface
interface IntBiFunction<T> {
    T invoke(int a, int b);
}

/**
 * 使用函数式方法打印乘法表
 */
public class PrintMultiplicationTable {

    public static void main(String[] args) {

        IntBiFunction<String> eof = (a, b) -> a == b ? "\r\n" : "\t"; //代表乘法表是否换行的方法
        // ↓ Function type: Int => Int => String => void
        IntFunction<IntFunction<Consumer<Consumer<String>>>> printTable = //打印乘法表的柯里化函数
                min -> max -> action ->
                        rangeClosed(min, max).mapToObj(num -> rangeClosed(1, num).mapToObj(any -> new IntTuple(any, num))) //产生二维矩阵用来保存乘法表数字
                                .flatMap(a -> a) //类型是Stream<Stream<IntTuple>>
                                .map(tuple -> tuple.first + " x " + tuple.second + " = " + tuple.first * tuple.second + eof.invoke(tuple.first, tuple.second)) //实际计算并转换为字符串格式化换行
                                .forEach(action); //最后依次遍历执行最后的function，也可以map为StringBuilder然后reduce结合成字符串返回

        //测试代码，柯里化执行，产生1-10的乘法表并打印出来
        printTable.apply(1).apply(10).accept(System.out::print);
    }
}
