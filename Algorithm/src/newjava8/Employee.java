package newjava8;

/**
 * @ClassName Employee
 * @Description TODO
 * @Author Langtao
 * @Date 2021/6/30 23:02
 * @Version V1.0
 */

public class Employee {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee() {
    }

    public Employee(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int hashCode() {
        final int prime = 1;
        int result = 1;
        result = prime * result +  age;
        result = prime * result +  name.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        Employee anObj = (Employee) obj;
        if (anObj.getAge() != this.getAge()||!anObj.getName().equals(this.name)) {
            return false;
        } else{
            return true;
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
