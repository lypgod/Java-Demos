package com.lypgod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author richard
 */
public class App {
    static void bubbleSort(List<Integer> origin) {
        int temp;
        for (int i = 0; i < origin.size() - 1; i++) {
            for (int j = 0; j < origin.size() - 1 - i; j++) {
                temp = origin.get(j);
                if (temp > origin.get(j + 1)) {
                    origin.set(j, origin.get(j + 1));
                    origin.set(j + 1, temp);
                }
            }
        }
    }

    static void cocktailSort(List<Integer> origin) {
        // 初始化边界
        int left = 0, right = origin.size() - 1;
        int temp;
        while (left < right) {
            // 前半轮,将最大元素放到后面
            for (int i = left; i < right; i++) {
                temp = origin.get(i);
                if (temp > origin.get(i + 1)) {
                    origin.set(i, origin.get(i + 1));
                    origin.set(i + 1, temp);
                }
            }
            right--;
            // 后半轮,将最小元素放到前面
            for (int i = right; i > left; i--) {
                temp = origin.get(i - 1);
                if (temp > origin.get(i)) {
                    origin.set(i - 1, origin.get(i));
                    origin.set(i, temp);
                }
            }
            left++;
        }
    }

    static void quickSort(List<Integer> origin) {
        quickSort(origin, 0, origin.size() - 1);
    }

    private static void quickSort(List<Integer> origin, int low, int high) {
        if (low < high) {
            //将表一分为二
            int privotLoc = quickSortPartition(origin, low, high);
            //递归对低子表递归排序
            quickSort(origin, low, privotLoc - 1);
            //递归对高子表递归排序
            quickSort(origin, privotLoc + 1, high);
        }
    }

    private static int quickSortPartition(List<Integer> origin, int low, int high) {
        //基准元素
        int privotKey = origin.get(low);
        //从表的两端交替地向中间扫描
        while (low < high) {
            //从high 所指位置向前搜索，至多到low+1 位置。将比基准元素小的交换到低端
            while (low < high && origin.get(high) >= privotKey) {
                //从右找比基准元小的
                --high;
            }
            //如果比基准元素小，交换
            origin.set(low, origin.get(high));
            origin.set(high, privotKey);

            //从右找比基准元大的
            while (low < high && origin.get(low) <= privotKey) {
                ++low;
            }
            //如果比基准元素，交换
            origin.set(high, origin.get(low));
            origin.set(low, privotKey);
        }

        return low;
    }

    static void insertSort(List<Integer> origin) {
        //外层向右的index，即作为比较对象的数据的index
        for (int index = 1; index < origin.size(); index++) {
            //用作比较的数据
            int temp = origin.get(index);
            int leftindex = index - 1;
            //当比到最左边或者遇到比temp小的数据时，结束循环
            while (leftindex >= 0 && origin.get(leftindex) > temp) {
                origin.set(leftindex + 1, origin.get(leftindex));
                leftindex--;
            }
            //把temp放到空位上
            origin.set(leftindex + 1, temp);
        }
    }

    static void binaryInsertSort(List<Integer> origin) {
        int i, j, high, low, mid;
        int temp;
        for (i = 1; i < origin.size(); i++) {
            // 查找区上界
            low = 0;
            // 查找区下界
            high = i - 1;
            //将当前待插入记录保存在临时变量中
            temp = origin.get(i);
            while (low <= high) {
                // 找出中间值 mid = (low + high) / 2;
                mid = (low + high) >> 1;
                //如果待插入记录比中间记录小
                if (temp < origin.get(mid)) {
                    // 插入点在低半区
                    high = mid - 1;
                } else {
                    // 插入点在高半区
                    low = mid + 1;
                }
            }
            //将前面所有大于当前待插入记录的记录后移
            for (j = i - 1; j >= low; j--) {
                origin.set(j + 1, origin.get(j));
            }
            //将待插入记录回填到正确位置.
            origin.set(low, temp);
        }
    }

    static void shellSort(List<Integer> origin) {
        int n = origin.size();
        int d = n / 2;
        while (d > 0) {
            for (int i = d; i < n; i++) {
                int j = i - d;
                while (j >= 0 && origin.get(j) > origin.get(j + d)) {
                    int tmp = origin.get(j);
                    origin.set(j, origin.get(j + d));
                    origin.set(j + d, tmp);
                    j = j - d;
                }
            }
            d = d / 2;
        }
    }

    static void selectionSort(List<Integer> origin) {
        int length = origin.size(),
                i,
                j,
                minIndex,
                minValue,
                temp;
        for (i = 0; i < length - 1; i++) {
            minIndex = i;
            minValue = origin.get(minIndex);
            for (j = i + 1; j < length; j++) {
                if (origin.get(j) < minValue) {
                    minIndex = j;
                    minValue = origin.get(minIndex);
                }
            }

            // 交换位置
            temp = origin.get(i);
            origin.set(i, minValue);
            origin.set(minIndex, temp);
        }
    }

    static void heapSort(List<Integer> origin) {
        //初始建堆，origin.get(0)为第一趟值最大的元素
        buildMaxHeap(origin);
        for (int i = origin.size() - 1; i > 1; i--) {
            //将堆顶元素和堆低元素交换，即得到当前最大元素正确的排序位置
            int temp = origin.get(0);
            origin.set(0, origin.get(i));
            origin.set(i, temp);
            //整理，将剩余的元素整理成堆
            adjustDownToUp(origin, 0, i);
        }
    }

    /**
     * 构建大根堆：将array看成完全二叉树的顺序存储结构
     */
    static private void buildMaxHeap(List<Integer> origin) {
        //从最后一个节点array.length-1的父节点（array.length-1-1）/2开始，直到根节点0，反复调整堆
        for (int i = (origin.size() - 2) / 2; i >= 0; i--) {
            adjustDownToUp(origin, i, origin.size());
        }
    }

    /**
     * 将元素origin.get(k)自下往上逐步调整树形结构
     */
    static private void adjustDownToUp(List<Integer> origin, int k, int length) {
        int temp = origin.get(k);
        //i为初始化为节点k的左孩子，沿节点较大的子节点向下调整
        for (int i = 2 * k + 1; i < length - 1; i = 2 * i + 1) {
            //取节点较大的子节点的下标
            if (i < length && origin.get(i) < origin.get(i + 1)) {
                //如果节点的右孩子>左孩子，则取右孩子节点的下标
                i++;
            }
            //根节点 >=左右子女中关键字较大者，调整结束
            if (temp >= origin.get(i)) {
                break;
            } else {
                //根节点 <左右子女中关键字较大者
                //将左右子结点中较大值origin.get(i)调整到双亲节点上
                origin.set(k, origin.get(i));
                //【关键】修改k值，以便继续向下调整
                k = i;
            }
        }
        //被调整的结点的值放人最终位置
        origin.set(k, temp);
    }

    /**
     * 删除堆顶元素操作
     */
    static private void deleteMax(List<Integer> origin) {
        //将堆的最后一个元素与堆顶元素交换，堆底元素值设为-99999
        origin.set(0, origin.get(origin.size() - 1));
        origin.set(origin.size() - 1, -99999);

        //对此时的根节点进行向下调整
        adjustDownToUp(origin, 0, origin.size());
    }

    /**
     * 插入操作:向大根堆array中插入数据data
     */
    static private void insertData(List<Integer> origin, int data) {
        //将新节点放在堆的末端
        origin.set(origin.size() - 1, data);
        //需要调整的节点
        int k = origin.size() - 1;
        //双亲节点
        int parent = (k - 1) / 2;
        while (parent >= 0 && data > origin.get(parent)) {
            //双亲节点下调
            origin.set(k, origin.get(parent));
            k = parent;
            if (parent != 0) {
                //继续向上比较
                parent = (parent - 1) / 2;
            } else {
                //根节点已调整完毕，跳出循环
                break;
            }
        }
        //将插入的结点放到正确的位置
        origin.set(k, data);
    }


    static void mergeSort(List<Integer> origin) {
        //在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        List<Integer> temp = new ArrayList<>(origin);
        mergeSort(origin, 0, origin.size() - 1, temp);
    }

    private static void mergeSort(List<Integer> origin, int left, int right, List<Integer> temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            //左边归并排序，使得左子序列有序
            mergeSort(origin, left, mid, temp);
            //右边归并排序，使得右子序列有序
            mergeSort(origin, mid + 1, right, temp);
            //将两个有序子数组合并操作
            merge(origin, left, mid, right, temp);
        }
    }

    private static void merge(List<Integer> origin, int left, int mid, int right, List<Integer> temp) {
        //左序列指针
        int i = left;
        //右序列指针
        int j = mid + 1;
        //临时数组指针
        int t = 0;

        while (i <= mid && j <= right) {
            if (origin.get(i) <= origin.get(j)) {
                temp.set(t++, origin.get(i++));
            } else {
                temp.set(t++, origin.get(j++));
            }
        }
        //将左边剩余元素填充进temp中
        while (i <= mid) {
            temp.set(t++, origin.get(i++));
        }
        //将右序列剩余元素填充进temp中
        while (j <= right) {
            temp.set(t++, origin.get(j++));
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while (left <= right) {
            origin.set(left++, temp.get(t++));
        }
    }

    static void countSort1(List<Integer> origin, int roof) {
        int max = 0;
        int min = roof;

        //找出数组中的最大最小值
        for (Integer i : origin) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }

        int[] help = new int[max - min + 1];

        //找出每个数字出现的次数
        for (Integer i : origin) {
            help[i - min]++;
        }

        int index = 0;
        for (int i = 0; i < help.length; i++) {
            while (help[i]-- > 0) {
                origin.set(index++, i + min);
            }
        }
    }

    static void countSort2(List<Integer> origin, int roof) {
        int max = 0;
        int min = roof;

        //找出数组中的最大最小值
        for (Integer i : origin) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }

        int[] help = new int[max - min + 1];

        //找出每个数字出现的次数
        for (Integer i : origin) {
            help[i - min]++;
        }

        //计算每个数字应该在排序后数组中应该处于的位置
        for (int i = 1; i < help.length; i++) {
            help[i] = help[i - 1] + help[i];
        }

        //根据help数组进行排序
        int[] res = new int[origin.size()];
        for (Integer i : origin) {
            int post = --help[i - min];
            res[post] = i;
        }

        for (int i = 0; i < origin.size(); i++) {
            origin.set(i, res[i]);
        }
    }

    static void bucketSort(List<Integer> origin, int roof) {
        int max = 0;
        int min = roof;

        //找出数组中的最大最小值
        for (Integer i : origin) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }

        //桶数
        int bucketNum = (max - min) / origin.size() + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketArr.add(new ArrayList<>());
        }

        //将每个元素放入桶
        for (int i = 0; i < origin.size(); i++) {
            int num = (origin.get(i) - min) / (origin.size());
            bucketArr.get(num).add(origin.get(i));
        }

        //对每个桶进行排序
        for (ArrayList<Integer> aBucketArr : bucketArr) {
            Collections.sort(aBucketArr);
        }
    }

    /**
     * 基数排序函数
     * a表示要排序的数组
     */
    static void radixSort(List<Integer> origin) {
        //n用来表示当前排序的是第几位
        int n = 1;
        //表示每一位数字的范围（这里是10进制数，有0~9一共10种情况）
        int buckets = 10;
        //hasNum用来表示数组中是否有至少一个数字存在第n位
        boolean hasNum = false;
        //二维数组temp用来保存当前排序的数字
        //第一维d表示一共有d个桶
        //第二维origin.size()表示每个桶最多可能存放origin.size()个数字
        int[][] temp = new int[buckets][origin.size()];
        int[] order = new int[buckets];
        while (n == 1 || hasNum) {
            //判断是否所有元素均无比更高位，因为第一遍一定要先排序一次，所以有n!=1的判断
            hasNum = false;
            //遍历要排序的数组，将其存入temp数组中（按照第n位上的数字将数字放入桶中）
            for (Integer i : origin) {
                int x = i / (n * 10);
                if (x != 0) {
                    hasNum = true;
                }
                int lsd = (x % 10);
                temp[lsd][order[lsd]] = i;
                order[lsd]++;
            }
            //k用来将排序好的temp数组存入data数组（将桶中的数字倒出）
            int k = 0;
            for (int i = 0; i < buckets; i++) {
                if (order[i] != 0) {
                    for (int j = 0; j < order[i]; j++) {
                        origin.set(k, temp[i][j]);
                        k++;
                    }
                }
                order[i] = 0;
            }
            n++;
        }
    }
}
