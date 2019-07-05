package com.lypgod.test.g02.structural.patterns.p09.composite.pattern;

/**
 * @author richard
 */
public class CompositePatternDemo {
    public static void main(String[] args) {
        Employee ceo = new Employee("John", "CEO", 30000);

        Employee headSales = new Employee("Robert", "Head Sales", 20000);

        Employee headMarketing = new Employee("Michel", "Head Marketing", 20000);

        Employee clerk1 = new Employee("Laura", "Marketing", 10000);
        Employee clerk2 = new Employee("Bob", "Marketing", 10000);

        Employee salesExecutive1 = new Employee("Richard", "Sales", 10000);
        Employee salesExecutive2 = new Employee("Rob", "Sales", 10000);

        ceo.addSubordinate(headSales);
        ceo.addSubordinate(headMarketing);

        headSales.addSubordinate(salesExecutive1);
        headSales.addSubordinate(salesExecutive2);

        headMarketing.addSubordinate(clerk1);
        headMarketing.addSubordinate(clerk2);

        //打印该组织的所有员工
        System.out.println(ceo);
    }
}