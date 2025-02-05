import java.util.function.Function;

class Main {

    private int funA(int x, String y) {
        System.out.println(x + " " + y);
        return x;
    }

    private int funB(int x, Function<Object[], Object> callback) {
        System.out.println("funA");
        Object cbReturnValue = callback.apply(new Object[]{1, "String"});
        return 0;
    }

    public static void main(String...args) {
        Main obj = new Main();
        
    }
}