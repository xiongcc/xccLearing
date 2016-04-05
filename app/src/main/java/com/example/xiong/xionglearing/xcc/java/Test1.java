package com.example.xiong.xionglearing.xcc.java;

/**
 * Created by Administrator on 2016/3/30.
 */
public class Test1 {
    public static void main(String[] args) {
        // 实例化泛型类
        Point<Integer, Integer> p1 = new Point<Integer, Integer>();
        p1.setX(10);
        p1.setY(20);
        int x = p1.getX();
        int y = p1.getY();
        System.out.println("This point is：" + x + ", " + y);

        Point<Double, String> p2 = new Point<Double, String>();
        p2.setX(25.4);
        p2.setY("东京180度");
        double m = p2.getX();
        String n = p2.getY();
        System.out.println("This point is：" + m + ", " + n);
    }

}
/*
*与普通类的定义相比，上面的代码在类名后面多出了 <T1, T2>，T1, T2 是自定义的标识符，也是参数，
* 用来传递数据的类型，而不是数据的值，我们称之为类型参数。在泛型中，
* 不但数据的值可以通过参数传递，数据的类型也可以通过参数传递。T1, T2 只是数据类型的占位符，运行时会被替换为真正的数据类型。
* 类型参数需要在类名后面给出。一旦给出了类型参数，就可以在类中使用了。类型参数必须是一个合法的标识符，习惯上使用单个大写字母，
* 通常情况下，K 表示键，V 表示值，E 表示异常或错误，T 表示一般意义上的数据类型
 */

// 定义泛型类
class Point<T1, T2> {
    T1 x;
    T2 y;

    public T1 getX() {
        return x;
    }

    public void setX(T1 x) {
        this.x = x;
    }

    public T2 getY() {
        return y;
    }

    public void setY(T2 y) {
        this.y = y;
    }
}
