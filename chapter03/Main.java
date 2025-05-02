class Foo {
    public void foo() {
        System.out.println("foo");
    }
}

public class Main {
    public static void main(String[] args) {
        Foo f = new Foo();

        try {
            f.foo();
        } catch (ArrayIndexOutOfBoundsException e) {
            f = new Foo();
        } finally {
            f.foo();
        }
    }
}