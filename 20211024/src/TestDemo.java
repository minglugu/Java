import javax.crypto.spec.PSource;
import java.util.Arrays;
/**
 * @author Minglu Gu
 * @version 1.0
 * @since 2021-10-24
 */
public class TestDemo {
    // binary search is a better option if the arr is ascending or descending
    public static int binarySearch(int[] arr, int key) {
        int left = 0;
        int right = arr.length-1;
        while (left <= right) {
            // mid is inside of the while loop to be updated after l or r changes
            int mid = (left + right)/2;
            if (arr[mid] > key) {
                right = mid -1;
            } else if(arr[mid] < key) {
                left = mid + 1;
            } else {
                return left;
            }
        }
        return -1;
    }

    // find index of the key in the arr
    public static int findNum(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == key) {
                return i;
            }
        }
        return -1; // index will not be -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5}; // find 2
        // System.out.println(findNum(arr, 2));
        // only works for descending or ascending array
        System.out.println(Arrays.binarySearch(arr, 12));
        // System.out.println(binarySearch(arr, 5));
    }

    public static int maxNum(int[] array) {
        if(array == null) {
            return -1;
        }
        if(array.length == 0) {
            return 0;
        }
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }

    public static void main12(String[] args) {
        // if array is null, outOfIndexException
        int[] array = {212,8,1,2,10};
        System.out.println(maxNum(array));
    }

    public static String myToString(int[] array) {
        if (array == null) {
            return "null";
        }
        String str = "[";
        for (int i = 0; i < array.length - 1; i++) {
            str += array[i] + ", ";
        }
        str = str + array[array.length-1] + "]";
        System.out.println(str);
        return str;
    }
    public static void main11(String[] args) {
        int[] array = {1,2,3};
        myToString(array); // [1, 2, 3, 4, 5]
    }

    // times 2. method 1 on the original array
    public static void multiplyTwo(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] * 2;
        }
    }

    // times 2. method 2
    public static int[] transform(int[] array) {
        int[] ret = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            ret[i] = array[i] * 2;
        }
        return ret;
    }
    // double each element
    public static void main10(String[] args) {
        int[] array = {1,2,3,4,5};
        // multiplyTwo(array);
        System.out.println(Arrays.toString(array));
        int[] ret2 = transform(array);
        System.out.println(Arrays.toString(ret2));
    }

    public static void swap(int[] array) {
        int tmp = array[0];
        array[0] = array[1];
        array[1] = tmp;
    }
    // swapping
    public static void main9(String[] args) {
        int[] array = {10, 20};
        System.out.println("before " + array[0] + " " + array[1]);
        swap(array);
        System.out.println("after " + array[0] + " " + array[1]);
    }

    // reference variable might not always be in stack.
    public static void main8(String[] args) {
        // array1 and array2 are references
        int[] array1 = {1,2};
        int[] array2 = array1; // array2 point to the object that is also pointed by array1
    }

    public static void func1(int[] array) {
        array = new int[]{11,23,654,64,52,12};
        // System.out.println(Arrays.toString(array));
    }
    public static void func2(int[] array) {
        array[0] = 36544;
    }

    public static void main7(String[] args) {
        int[] array = {1,2,3,4,5,6};
        System.out.println(Arrays.toString(array));
        func1(array); // changed the reference
        System.out.println(Arrays.toString(array)); // [1, 2, 3, 4, 5, 6]
        func2(array); // change the value of an element
        System.out.println(Arrays.toString(array)); // [36544, 2, 3, 4, 5, 6]
    }

    public static void printf(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    public static void main6(String[] args) {
        int[] array = {1,2,3,4,5,6};
        printf(array); // pass by reference
    }

    public static void main5(String[] args) {
        int[] array = {1,2,3,4,5,6}; // object is stored in heap
        int[] array2 = null; // no reference to the object
        // System.out.println(array2.length); // NullPointerException

    }
     public static void main4(String[] args) {
         int[] array3 = {1,2,3,4,5,6}; // array3 (reference variable) stores the address of the array {1,2,3,4,5,6}
         System.out.println(array3.length); // array length
         System.out.println(array3[3]); // access element in the array

         // iteration: access to indices
         for (int i = 0; i < array3.length; i++) {
             System.out.print(array3[i] + " ");
         }
         System.out.println();

         // no access to indices
         for (int x: array3) {
             System.out.print(x + " ");
         }
         System.out.println();
         // 借助Java的操作数组的工具类

         String str = Arrays.toString(array3);
         System.out.println(str); // print as a string

     }

    // array
    public static void main2(String[] args) {
        // 3 ways of create an array
        int[] array = {1,2,2,3};
        int[] array2 = new int[3];// {0,0,0}
        int[] array3 = new int[]{1,2,3,4,5};
    }

    // Hanoi Tower
    /*
        1: A->C 1 time
        2: A->B, A->C, B->C 2 times
        3: A->C, A->B, C->B, A->C, B->A, B->C, A->C 7 times
        4: A->C, A->B, C->B, A->C, B->A, ...
        ...
        2^n - 1;
     */
    public static void move(char pos1, char pos2) {
        System.out.print(pos1 + " -> " + pos2 + " ");
    }

    /**
     * @param n how many plates of tower
     * @param pos1  plate's starting position
     * @param pos2  plate's transitional position
     * @param pos3  plate's final position
     */
    public static void hanoi(int n, char pos1, char pos2, char pos3) {
        if(n == 1) {
            move(pos1, pos3);
        } else {
            hanoi(n - 1, pos1, pos3, pos2); // move n-1 to the final position B which is pos2
            move(pos1, pos3);
            hanoi(n - 1, pos2, pos1, pos3);
        }
    }

    public static void main1(String[] args) {
        hanoi(1, 'A', 'B', 'C');
        System.out.println();
        hanoi(2, 'A', 'B', 'C');
        System.out.println();
        hanoi(3, 'A', 'B', 'C');
        System.out.println();
    }

}
