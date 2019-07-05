package com.lypgod.test.g04.j2ee.patterns.p28.composite.entity.pattern;

/**
 * @author richard
 */
class Client {
    private CompositeEntity compositeEntity = new CompositeEntity();

    void setData(String data1, String data2) {
        compositeEntity.setData(data1, data2);
    }

    void printData() {
        for (String s : compositeEntity.getData()) {
            System.out.println("Data: " + s);
        }
    }
}