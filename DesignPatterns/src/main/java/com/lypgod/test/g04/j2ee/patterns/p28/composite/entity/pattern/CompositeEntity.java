package com.lypgod.test.g04.j2ee.patterns.p28.composite.entity.pattern;

/**
 * @author richard
 */
class CompositeEntity {
    private CoarseGrainedObject cgo = new CoarseGrainedObject();

    void setData(String data1, String data2) {
        cgo.setData(data1, data2);
    }

    String[] getData() {
        return cgo.getData();
    }
}