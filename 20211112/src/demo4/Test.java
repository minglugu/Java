package demo4;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Minglu Gu
 * @version 1.0
 * @since 2021-11-12
 * @description: comparable vs comparator
 */
/*class Student implements Comparable<Student> {
    public int age;
    public String name;
    public double score;

    public Student(int age, String name, double score) {
        this.age = age;
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        // 谁调用compareTo 谁就是this
*//*        if (this.age > o.age) {
            return 1;
        } else if (this.age == o.age) {
            return 0;
        } else {
            return -1;
        }*//*
        // return this.age - o.age; // ascending
        // return o.age - this.age; // descending
        // return (int) (this.score - o.score);
        return this.name.compareTo(o.name);
    }
}*/

class Student {
    public int age;
    public String name;
    public double score;

    public Student(int age, String name, double score) {
        this.age = age;
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}

class AgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.age - o2.age;
    }
}

class ScoreComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return (int) (o1.score - o2.score);
    }
}

class NameComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.name.compareTo(o2.name);
    }
}

public class Test {
    public static void main3(String[] args) {

        Student student1 = new Student(12, "bit", 98.9);
        Student student2 = new Student(6, "ab", 88.9);
        Student student3 = new Student(18, "cd", 78.9);

        // student 1 is this object in compareTo function
/*        if (student1.compareTo(student2) > 0) {
            System.out.println(student1.name + " is older than " + student2.name);
        } else if (student1.compareTo(student2) < 0) {
            System.out.println(student2.name + " is older than " + student1.name);
        } else {
            System.out.println(student2.name + " and " + student1.name + " are at the same age.");
        }*/

        AgeComparator ageComparator = new AgeComparator();
        System.out.println(ageComparator.compare(student1, student2));


    }

    public static void main(String[] args) {
        Student[] students = new Student[3];
        students[0] = new Student(18, "A", 98.9);
        students[1] = new Student(14, "B", 97.9);
        students[2] = new Student(16, "C", 95.9);

        System.out.println(Arrays.toString(students));

        AgeComparator ageComparator = new AgeComparator();
        ScoreComparator scoreComparator = new ScoreComparator();
        NameComparator nameComparator = new NameComparator();

        Arrays.sort(students,ageComparator); // 默认从小到大
        System.out.println(Arrays.toString(students));

        Arrays.sort(students, scoreComparator);
        System.out.println(Arrays.toString(students));

        Arrays.sort(students, nameComparator);
        System.out.println(Arrays.toString(students));
    }

    public static void main1(String[] args) {
        int[] array = {1,21,3,14,5,16};
        System.out.println(Arrays.toString(array));

        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
