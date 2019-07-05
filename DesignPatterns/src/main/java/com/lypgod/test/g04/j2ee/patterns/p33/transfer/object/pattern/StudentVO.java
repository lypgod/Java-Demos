package com.lypgod.test.g04.j2ee.patterns.p33.transfer.object.pattern;

/**
 * @author richard
 */
public class StudentVO {
   private String name;
   private Integer rollNo;

   StudentVO(String name, Integer rollNo) {
      this.name = name;
      this.rollNo = rollNo;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   Integer getRollNo() {
      return rollNo;
   }

   public void setRollNo(Integer rollNo) {
      this.rollNo = rollNo;
   }

   @Override
   public String toString() {
      return "StudentVO{" +
              "name='" + name + '\'' +
              ", rollNo=" + rollNo +
              '}';
   }
}