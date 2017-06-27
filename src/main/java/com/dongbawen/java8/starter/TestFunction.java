package com.dongbawen.java8.starter;

/**
 * Created by blank on 2017/6/26.
 */
public class TestFunction {
    public static void main(String[] args) {
        TestFunction testFunction = new TestFunction();
        int compute = testFunction.compute(2, i -> i * i, i -> i * 10);
        System.out.println(compute);
        int compute2 = testFunction.compute2(2, i -> i * i, i -> i * 10);
        System.out.println(compute2);

        Object o = MyFunction.identify().apply(1);
        System.out.println(o);
    }

    public int compute(int i, MyFunction<Integer, Integer> fun1, MyFunction<Integer, Integer> func2){
        return fun1.andThen(func2).apply(i);
    }
    public int compute2(int i, MyFunction<Integer, Integer> fun1, MyFunction<Integer, Integer> func2){
        return fun1.compose(func2).apply(i);
    }

}
