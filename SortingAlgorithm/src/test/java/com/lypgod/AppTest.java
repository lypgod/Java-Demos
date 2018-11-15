package com.lypgod;

import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Unit test for simple App.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AppTest {
    private static List<Integer> collect;
    private List<Integer> origin;
    private static int ROOF = 10000;
    private static int LIMIT = 30000;

    @Rule
    public TestName name = new TestName();

    @BeforeClass
    public static void beforeClass() {
        collect = Stream.generate(Math::random).mapToInt(e -> (int) (e * ROOF)).limit(LIMIT).boxed().collect(Collectors.toList());
    }

    @Before
    public void before() {
//        System.out.println("----- " + processMethodName(name.getMethodName()) + "---------------------");
        origin = new ArrayList<>(collect);
//        System.out.println(origin);
    }

    @After
    public void after() {
//        System.out.println(origin);
//        System.out.println();
    }

    @Test
    public void bubbleSortTest() {
        App.bubbleSort(origin);
    }

    @Test
    public void cocktailSortTest() {
        App.cocktailSort(origin);
    }

    @Test
    public void quickSortTest() {
        App.quickSort(origin);
    }

    @Test
    public void insertSortTest() {
        App.insertSort(origin);
    }

    @Test
    public void binaryInsertSortTest() {
        App.binaryInsertSort(origin);
    }

    @Test
    public void shellSortTest() {
        App.shellSort(origin);
    }

    @Test
    public void selectionSortTest() {
        App.selectionSort(origin);
    }

    @Test
    public void heapSortTest() {
        App.heapSort(origin);
    }

    @Test
    public void mergeSortTest() {
        App.mergeSort(origin);
    }

    @Test
    public void countSort1Test() {
        App.countSort1(origin, ROOF);
    }

    @Test
    public void countSort2Test() {
        App.countSort2(origin, ROOF);
    }

    @Test
    public void bucketSortTest() {
        App.bucketSort(origin, ROOF);
    }

    @Test
    public void radixSortTest() {
        App.radixSort(origin);
    }

    private String processMethodName(String originName) {
        originName = originName.substring(0, originName.length() - 4);
        char[] chars = originName.toCharArray();
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(chars[0]).toUpperCase());
        for (int i = 1; i < chars.length; i++) {
            if (Character.isUpperCase(chars[i])) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(chars[i]);
        }
        return stringBuilder.toString();
    }
}
