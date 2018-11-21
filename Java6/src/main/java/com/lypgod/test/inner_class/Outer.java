package com.lypgod.test.inner_class;

public class Outer {
    private String data = "outer data";

    private class Inner {
        private String data = "inner data";
        private void printData() {
            System.out.println(data);
            System.out.println(Outer.this.data);
        }
    }

    private void localInnerClassVoidMethod() {
        class Tt {
            private void print() {
                System.out.println("局部内部类void方法");
            }
        }

        new Tt().print();
    }

    /**
     * 外部无法访问局部内部类，只能通过接口或父类返回。
     * @return Runnable
     */
    private Runnable localInnerClassReturnMethod() {
        class Tt implements Runnable {
            @Override
            public void run() {
                System.out.println("局部内部类返回方法");
            }
        }
        return new Tt();
    }

    private void anonymousInnerClassMethod() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类");
            }
        }).start();
    }

    private static class StaticInnerClass {
        private void print() {
            System.out.println("静态内部类实例方法");
        }
        private static void staticPrint() {
            System.out.println("静态内部类静态方法");
        }
    }

    public static void main(String[] args) {
        Outer outer = new Outer();

        outer.new Inner().printData();

        outer.localInnerClassVoidMethod();

        outer.localInnerClassReturnMethod().run();

        outer.anonymousInnerClassMethod();

        Outer.StaticInnerClass.staticPrint();
        Outer.StaticInnerClass staticInnerClass = new Outer.StaticInnerClass();
        staticInnerClass.print();
    }
}
