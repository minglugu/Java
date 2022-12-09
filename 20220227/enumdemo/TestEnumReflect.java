package enumdemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created with IntelliJ IDEA.
 * Description: Reflect in Java
 */
public class TestEnumReflect {

    public static void reflectPrivateConstructor() {
        try {
            Class<?> classEnum = Class.forName("enumdemo.TestEnum");

            Constructor<?> dl =
                    classEnum.getDeclaredConstructor(String.class,int.class,String.class,int.class);
            dl.setAccessible(true);

            Object objectStudent = dl.newInstance("green",666,"bit",99);
            TestEnum testEnum = (TestEnum) objectStudent;
            System.out.println("获得枚举的私有构造函数："+testEnum);

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

    public static void main(String[] args) {
        reflectPrivateConstructor();
    }
}