package javaFoundation;

/**
 * Person
 *
 * @author Chen Langtao
 * @version 1.0 2022/5/16 10:16 ÏÂÎç
 **/
public class Person {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private String name;
    private Integer age;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;

        this.age = age;
    }

    public String publicMethod(String name) {
        return name;
    }

    private String privateMethod() {
        return "privateMethod";
    }

}
