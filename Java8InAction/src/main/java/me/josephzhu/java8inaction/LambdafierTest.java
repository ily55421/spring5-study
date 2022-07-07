package me.josephzhu.java8inaction;

import java.util.function.IntConsumer;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class LambdafierTest
{

  public static void main(String[] args) throws Exception {
    System.out.println("Testing ASM");
    test(new ASMLambdafier());
    System.out.println("Testing Jite");
    test(new JiteLambdafier());
    //Testing ASM
    //1
    //2
    //3
    //4
    //5
    //Constructor test: me.josephzhu.java8inaction.LambdafierTest@3d646c37
    //Time in millis:1657099943034
    //Testing Jite
    //1
    //2
    //3
    //4
    //5
    //Constructor test: me.josephzhu.java8inaction.LambdafierTest@4534b60d
    //Time in millis:1657099943048
  }

  public static void test(Lambdafier lamdafier) throws Exception {
    // IntConsumer is "void(int)", the passed Method is "void(Object)"
    IntStream.rangeClosed(1, 5).forEach(lamdafier.lambdafyVirtual(IntConsumer.class, System.out.getClass().getMethod("println", Object.class), System.out));
    System.out.println("Constructor test: " + lamdafier.lambdafyConstructor(Supplier.class, LambdafierTest.class.getConstructor()).get());
    System.out.println("Time in millis:" + lamdafier.lambdafyStatic(Supplier.class, System.class.getDeclaredMethod("currentTimeMillis")).get());

  }

}
