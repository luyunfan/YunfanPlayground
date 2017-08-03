package per.yunfan.playground.java.functional;

import java.util.function.Function;

/**
 * 代表为了能够自我调用而设计的函数
 *
 * @param <T> 需要递归的元素类型
 */
@FunctionalInterface
interface SelfApplicable<T> {
    T invoke(SelfApplicable<T> self);
}


/**
 * 一个Y-Combiner实现
 */
public class YCombiner {
    public static void main(String[] args) {
        //Y核心函数
        SelfApplicable<Function<Function<Function<Integer, Integer>, Function<Integer, Integer>>, Function<Integer, Integer>>> Y =
                y -> f -> x -> f.apply(y.invoke(y).apply(f)).apply(x);
        //上面Y函数的一部分，为了修复Java类型没有初始化定义的问题
        Function<Function<Function<Integer, Integer>, Function<Integer, Integer>>, Function<Integer, Integer>> fixY = Y.invoke(Y);

        //测试用计算斐波那契数列的函数
        Function<Integer, Integer> fibonacci = fixY.apply(fac -> x -> x == 0 ? 1 : x * fac.apply(x - 1));

        //打印计算结果
        int result = fibonacci.apply(5);
        System.out.println(result);
    }
}
