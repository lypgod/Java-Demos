package com.lypgod.test.g04.j2ee.patterns.p28.composite.entity.pattern;

/**
 * @author richard
 */
class CoarseGrainedObject {
    private DependentObject1 do1 = new DependentObject1();
    private DependentObject2 do2 = new DependentObject2();

    void setData(String data1, String data2) {
        do1.setData(data1);
        do2.setData(data2);
    }

    String[] getData() {
        return new String[]{do1.getData(), do2.getData()};
    }
}