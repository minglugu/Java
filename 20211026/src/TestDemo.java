import java.util.Arrays;

/**
 * @author Minglu Gu
 * @version 1.0
 * @since 2021-10-26
 * @description Class, object, array, sort, etc
 */

// Object Person
class Person {
    //attributes
    public String name;
    public int age;

    //method
    public void eat() {
        /*int a;
        System.out.println(a);*/
        System.out.println(name+" is eating");
    }

    public void sleep() {
        System.out.println(name+" is sleeping");
    }
}

public class TestDemo {

    public static void main(String[] args) {
        Person person = new Person();
        person.name = "bit";
        person.age = 10;

        person.eat();
        person.sleep();
    }

    public static void main10(String[] args) {
        Person person = new Person();
        person.name = "bit";
        person.age = 10;

        System.out.println(person.name);
        System.out.println(person.age);
        System.out.println("======================");
        Person person2 = new Person();
        person2.name = "gaobo";
        person2.age = 18;
        System.out.println(person2.name);
        System.out.println(person2.age);
    }

    public static void main9(String[] args) {
        //Person person = null;
        Person person1 = new Person();
        Person person2 = new Person();
        Person person3 = new Person();
        Person person4 = new Person();
        Person person5 = new Person();
        //int a = 10;
    }

    public static void main8(String[] args) {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i+1;
        }
        System.out.println(Arrays.toString(array));
    }

    public static void main7(String[] args) {
       /* int[][] array = {{1,2},{4,5,6}};
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] +" ");
            }
            System.out.println();
        }
        System.out.println("=============");*/
        /*int[][] array2 = new int[2][];
        for (int i = 0; i < array2.length; i++) {
            for (int j = 0; j < array2[i].length; j++) {
                System.out.print(array2[i][j] +" ");
            }
            System.out.println();
        }*/
        int[][] array2 = new int[2][];
        array2[0] = new int[3];
        array2[1] = new int[2];

        for (int i = 0; i < array2.length; i++) {
            for (int j = 0; j < array2[i].length; j++) {
                System.out.print(array2[i][j] +" ");
            }
            System.out.println();
        }
    }

    public static void main6(String[] args) {
        int[][] array = {{1,2,3},{4,5,6}};
        /*System.out.println(array.length);
        System.out.println(array[0].length);*/
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] +" ");
            }
            System.out.println();
        }
        System.out.println("================");
        for (int[] ret : array) {
            for (int x :ret) {
                System.out.print(x +" ");
            }
            System.out.println();
        }
        System.out.println("================");
        System.out.println(Arrays.deepToString(array));
    }

    public static void main5(String[] args) {
        int[][] array = {{1,2,3},{4,5,6}};
        int[][] array2 = new int[][]{{1,2,3},{4,5,6}};
        int[][] array3 = new int[2][3];
    }

    public static boolean isUp(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            if(array[i] > array[i+1]) {
                return false;
            }
        }
        return true;
    }

    // bubble sort
    public static void bubbleSort(int[] array) {
        //i表示趟数
        for (int i = 0; i < array.length-1; i++) {
            boolean flg = false;
            for (int j = 0; j < array.length-1-i; j++) {
                if(array[j] > array[j+1]) {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    flg = true;
                }
            }
            if(flg == false) {
                return;
            }
        }
    }

    public static void reverse(int[] array) {
        int i = 0;
        int j = array.length-1;
        while (i < j) {
            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
            i++;
            j--;
        }
    }

    public static void func(int[] array) {
        int i = 0;
        int j = array.length-1;
        while (i < j) {
            while (i < j && array[i] % 2 == 0) {
                i++;
            }//i下标一定是奇数

            while (i < j && array[j] % 2 != 0) {
                j--;
            }//j遇到了偶数
            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
    }

    public static int[] copyArray(int[] array) {
        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        return copy;
    }

    public static void main4(String[] args) {
        int[] array = {1,2,3,4,5,6};
        int[] copy = array.clone();
        System.out.println(Arrays.toString(copy));

        /*int[] copy = new int[array.length];
        System.arraycopy(array,0,copy,0,array.length);
        System.out.println(Arrays.toString(copy));*/

        //int[] ret = Arrays.copyOf(array,array.length*2);
        //int[] ret = Arrays.copyOfRange(array,1,3);
        //System.out.println(Arrays.toString(ret));

        //int[] ret = copyArray(array);
        //System.out.println(Arrays.toString(ret));
    }

    public static void main3(String[] args) {
        int[] array = {1,2,3,4,5,6};
        func(array);
        System.out.println(Arrays.toString(array));
    }

    public static void main2(String[] args) {
        int[] array = new int[10];
        Arrays.fill(array,2,6,1999);//[2,6)
        System.out.println(Arrays.toString(array));
    }

    public static void main1(String[] args) {
        int[] array = {11,2,3,14,15};
        Arrays.sort(array);
        //bubbleSort(array);
        System.out.println(Arrays.toString(array));
        /*boolean flg = isUp(array);
        System.out.println(flg);*/
    }
}
