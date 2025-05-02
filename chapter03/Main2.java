public class Main2 {
    public static void main(String[] args) {

        System.out.println(1);
        try {
            System.out.println(2);
            try {
                foo();
            } catch (RuntimeException e) {
                System.out.println(3);
            } catch (ExA e) {
                System.out.println(4);
                throw new ExB();
            } finally {
                System.out.println(6);
            }
        } catch (ExB e) {
            System.out.println(7);
        } catch (Throwable e) {
            System.out.println(8);
        } finally {
            System.out.println(9);
        }
    }

    private static void foo() throws ExA {
        throw new ExA();
    }
}

class ExA extends Exception {

}

class ExB extends RuntimeException {

}