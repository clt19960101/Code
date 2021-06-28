package Spring;

/**
 * @ClassName CircularReference
 * @Description TODO
 * @Author Langtao
 * @Date 2021/6/3 0:00
 * @Version V1.0
 */

public class CircularReference {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        System.out.println(a.getB()==b);
        System.out.println(b.getA()==a);

    }
    public static class A{
        private B b;

        public B getB() {
            return b;
        }

        public void setB(B b) {
            this.b = b;
        }
    }

    public static class B{
        private A a;

        public A getA() {
            return a;
        }

        public void setA(A a) {
            this.a = a;
        }
    }
}
