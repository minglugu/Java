package reflectdemo1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Date: 2022/2/27
 * Description: Reflect
 */
public class ReflectClassDemo {

    /**
     * 通过Class类的newInstance方法 获取 学生实例
     */
    public static void reflectNewInstance() {
        try {
            Class<?> c1 = Class.forName("reflectdemo1.Student");

            Student student = (Student)c1.newInstance();

            System.out.println(student);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     */
    public static void reflectPrivateConstructor() {
        try {
            Class<?> c1 = Class.forName("reflectdemo1.Student");
            Constructor<?> constructor =  c1.getDeclaredConstructor(String.class,int.class);

            constructor.setAccessible(true);

            Student student = (Student)constructor.newInstance("GAOBO",18);

            System.out.println(student);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 反射属性 获取私有  或者公开的
     */
    public static void reflectPrivateField() {
        try {
            Class<?> c1 = Class.forName("reflectdemo1.Student");

            Student student = (Student)c1.newInstance();

            Field field = c1.getDeclaredField("name");
            field.setAccessible(true);

            field.set(student,"zhangsan");

            System.out.println(student);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public static void reflectPrivateMethod() {
        try {
            Class<?> c1 = Class.forName("reflectdemo1.Student");

            Student student = (Student)c1.newInstance();

            Method method = c1.getDeclaredMethod("function",String.class);
            method.setAccessible(true);

            method.invoke(student,"我是私有方法的参数");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //reflectNewInstance();
        //reflectPrivateConstructor();
        //reflectPrivateField();
        reflectPrivateMethod();
    }
}