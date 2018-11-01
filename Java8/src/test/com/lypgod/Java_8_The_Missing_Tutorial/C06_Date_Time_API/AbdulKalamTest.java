package com.lypgod.Java_8_The_Missing_Tutorial.C06_Date_Time_API;

import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class AbdulKalamTest {

    private AbdulKalam kalam = new AbdulKalam();

    @Test
    public void kalamWasBornOn15October1931() throws Exception {
        LocalDate dateOfBirth = kalam.dateOfBirth();
        assertThat(dateOfBirth.toString(), equalTo("1931-10-15"));
    }

}