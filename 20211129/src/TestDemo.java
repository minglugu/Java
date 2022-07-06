import java.util.*;

/**
 * @author Minglu Gu
 * @version 1.0
 * @since 2021-11-29
 * 匿名内部类（anonymous class）
 */
class Student {
    private String name;
    private String classes;
    private double score;

    public Student(String name, String classes, double score) {
        this.name = name;
        this.classes = classes;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", classes='" + classes + '\'' +
                ", score=" + score +
                '}';
    }
}

public class TestDemo {
    // 1. 比特科技有若干学生，对象放在一个List中，每个学生有一个姓名(String),班级(String)和考试成绩(double)这三个属性.
    // 考试结束后，每个学生会获得一个考试成绩。历遍list集合，并把学生对象的属性打印出来。

    public static void main2(String[] args) {
        // <Student>，可以放自定义的类型
        ArrayList<Student> st = new ArrayList<>();
        st.add(new Student("bit", "201-1", 98.7));
        st.add(new Student("ddo", "201-2", 92.7));
        st.add(new Student("joy", "201-1", 96.7));

        System.out.println(st);

    }

    // 2. 删除一个字符串当中出现的第二个字符串中的字符。e.g. "welcome", "come", 输出wl
    public static void main(String[] args) {
        // 1. 申请一个arraylist，遍历welcome to bit，定义一个i，看第一个字符串里面的字符，是否在第二个字符串里面
        ArrayList<Character> characters = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            if (!str2.contains(ch+"")) {
                characters.add(ch);
            }
        }
        for (char charater:characters) {
            System.out.print(charater);
        }
    }

    // 3. 有一个list当中，存放的是整型的数据，要求使用Collections.sort对List进行排序
    public static void main3(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(12);
        integers.add(65);
        integers.add(68);
        Collections.sort(integers);
        System.out.println(integers);
    }

    public static void main1(String[] args) {
        ArrayList<String> list = new ArrayList<>(); // ArrayList 可以使用的方法比List多，因为ArrayList继承了List这个interface
        List<String> list2 = new ArrayList<>(34); //
    }
}

