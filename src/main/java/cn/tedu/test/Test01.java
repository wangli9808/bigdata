package cn.tedu.test;

import org.junit.Test;

public class Test01 {
    @Test
    public void Test01() {
        for (int i = 5; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    @Test
    public void sortTest01() {
        System.out.println('I' + 'T');
    }

}
