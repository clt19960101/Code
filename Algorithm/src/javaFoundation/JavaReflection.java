package javaFoundation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * JavaReflection
 *
 * @author Chen Langtao
 * @version 1.0 2022/5/16 9:58 下午
 **/
public class JavaReflection {

    public static void main(String[] args)
            throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        /**
         * 获取Class对象的四种方式
         */
        //1.Person.class;
        Class<Person> personClass = Person.class;

        //2.实例.getClass();
        Person person = new Person();
        Class<? extends Person> aClass = person.getClass();
        //3.Class.forName()
        Class<?> aClass1 = Class.forName("javaFoundation.Person");

        //4.类加载器 xxxClassLoader.loadClass("类路径");
        Class<?> clazz = ClassLoader.getSystemClassLoader().loadClass("javaFoundation.Person");

        Person person1 = (Person) clazz.newInstance();
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }

        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }

        Method publicMethod = clazz.getDeclaredMethod("publicMethod", String.class);
        System.out.println(publicMethod.invoke(person1, "publicMethod"));


        Method privateMethod = clazz.getDeclaredMethod("privateMethod");
        privateMethod.setAccessible(true);
        System.out.println(privateMethod.invoke(person1));



    }

}
