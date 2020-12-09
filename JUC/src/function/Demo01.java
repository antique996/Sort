package function;

import java.util.function.Function;

/**
 * Function函数式接口
 */
public class Demo01 {
    public static void main(String[] args) {
        /*Function function = new Function<String, String>() {
            @Override
            public String apply(String str) {
                return str;
            }
        };*/

        Function function = (str) -> {
            return str;
        };

        System.out.println(function.apply("asd"));
    }

}
