public class CheckAndUnchecked{
    public static void main(String[] args) {
        CheckAndUnchecked example = new CheckAndUnchecked();
        //try catch가 필요함
        example.checkedException();

        //try catch가 필요없음
        example.uncheckedException();
    }

    public void checkedException() {
        try {
            throw new MyException("Checked Exception");
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }

    public void uncheckedException() {
        throw new MyRuntimeException("Unchecked Exception");
    }
}

class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}

class MyRuntimeException extends RuntimeException {
    public MyRuntimeException(String message) {
        super(message);
    }
}