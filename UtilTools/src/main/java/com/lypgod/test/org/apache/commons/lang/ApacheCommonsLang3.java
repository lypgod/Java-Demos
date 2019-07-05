package com.lypgod.test.org.apache.commons.lang;

public class ApacheCommonsLang3 {
    public static void main(String[] args) {
//        System.out.println("isBlank(null)\t" + StringUtils.isBlank(null));
//        System.out.println("isBlank(\"\")\t\t" + StringUtils.isBlank(""));
//        System.out.println("isBlank(\"    \")\t" + StringUtils.isBlank("    "));
//        System.out.println("isEmpty(null)\t" + StringUtils.isEmpty(null));
//        System.out.println("isEmpty(\"\")\t\t" + StringUtils.isEmpty(""));
//        System.out.println("isEmpty(\"    \")\t" + StringUtils.isEmpty("    "));

//        System.out.println(StringUtils.trimToNull(" a"));
//        System.out.println(StringUtils.trimToNull("a "));
//        System.out.println(StringUtils.trimToNull(" a "));
//        System.out.println(StringUtils.trimToNull(" a a "));
//        System.out.println(StringUtils.trimToNull("  "));
//        System.out.println(StringUtils.trim(" a"));
//        System.out.println(StringUtils.trim("a "));
//        System.out.println(StringUtils.trim(" a "));
//        System.out.println(StringUtils.trim(" a a "));
//        System.out.println(StringUtils.trim("  "));

//        System.out.println(StringUtils.substringBetween(" abc", "a", "c"));
//        System.out.println(StringUtils.substringBetween(" a b c ", " ", " "));
//        System.out.println(StringUtils.substringBetween("acaaaa", "a", "a"));

//        String test = "This is a test of the abbreviation.";
//        String test2 = "Test";
//        System.out.println( StringUtils.abbreviate( test, 15 ) );
//        System.out.println( StringUtils.abbreviate( test, 5,15 ) );
//        System.out.println( StringUtils.abbreviate( test2, 10 ) );
//        System.out.println( StringUtils.abbreviate( test, 2 ) );

//        System.out.println(StringUtils.chomp(null));
//        System.out.println(StringUtils.chomp(""));
//        System.out.println(StringUtils.chomp("abc \r"));
//        System.out.println(StringUtils.chomp("abc\n"));
//        System.out.println(StringUtils.chomp("abc\r\n"));
//        System.out.println(StringUtils.chomp("abc\r\n\r\n"));
//        System.out.println(StringUtils.chomp("abc\n\r"));
//        System.out.println(StringUtils.chomp("abc\n\rabc"));
//        System.out.println(StringUtils.chomp("\r"));
//        System.out.println(StringUtils.chomp("\n"));
//        System.out.println(StringUtils.chomp("\r\n"));
//
//        System.out.println(StringUtils.chop(null));
//        System.out.println(StringUtils.chop(""));
//        System.out.println(StringUtils.chop("abc \r"));
//        System.out.println(StringUtils.chop("abc\n"));
//        System.out.println(StringUtils.chop("abc\r\n"));
//        System.out.println(StringUtils.chop("abc"));
//        System.out.println(StringUtils.chop("abc\nabc"));
//        System.out.println(StringUtils.chop("a"));
//        System.out.println(StringUtils.chop("\r"));
//        System.out.println(StringUtils.chop("\n"));
//        System.out.println(StringUtils.chop("\r\n"));

//        System.out.println( StringUtils.repeat( "*", 10));
//        System.out.println( StringUtils.repeat( "China ", 5));
//        System.out.println( StringUtils.repeat( "China ", ",", 5));

//        System.out.println( StringUtils.center( "China", 11,"*"));

//        System.out.println(StringUtils.reverse("ABCDE"));

//        System.out.println(StringUtils.countMatches( "Chinese People", 'e'));
//        System.out.println(StringUtils.countMatches( "Chinese People", "es"));

//        String formatted = " 25 * (30,40) [50,60] | 30";
//        System.out.print("N0: " + StringUtils.substringBeforeLast(formatted, "*"));
//        System.out.print(", N1: " + StringUtils.substringBetween(formatted, "(", ","));
//        System.out.print(", N2: " + StringUtils.substringBetween(formatted, ",", ")"));
//        System.out.print(", N3: " + StringUtils.substringBetween(formatted, "[", ","));
//        System.out.print(", N4: " + StringUtils.substringBetween(formatted, ",", "]"));
//        System.out.print(", N5: " + StringUtils.substringAfterLast(formatted, "|"));

//        System.out.println(StringUtils.swapCase("I am a-A*a"));

//        System.out.print(StringUtils.substringBetween("03\\d{4}", "\\d{", "}"));

        System.out.print("033\\d{5}hao".replaceAll("\\\\d\\{\\d*\\}", "-----"));
    }
}
