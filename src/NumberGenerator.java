import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public interface NumberGenerator<T extends Number> {
    boolean cond(T arg);

    public static NumberGenerator<? super Number> getGenerator() {
        NumberGenerator<Number> num = (x) -> x.intValue() > 0;

        return num;

    }
    public static void main(String[] args) {
        NumberGenerator<? super Number> numGen = getGenerator();
        System.out.println( getGenerator().cond(5));
        System.out.println(numGen.cond(123456L));
        System.out.println(numGen.cond(123456.56));
        System.out.println(numGen.cond(132));
        System.out.println(numGen.cond(Byte.MAX_VALUE));
        System.out.println(numGen.cond(-5.5));
        System.out.println(numGen.cond(-1253523525L));
        System.out.println(numGen.cond(0));
        System.out.println(numGen.cond(-2));
        System.out.println(numGen.cond(Byte.MIN_VALUE));
    }
}
class Function<T, U> {

    public Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        Function<T, U> to = (s) -> condition.test(s) ? ifTrue.apply(s) : ifFalse.apply(s);
        return to;
    }



    public static void main(String[] args) {
        Predicate<Object> condition = Objects::isNull;
        Function<Object, Integer> ifTrue = obj -> 0;
        Function<CharSequence, Integer> ifFalse = CharSequence::length;
        Function<String, Integer> safeStringLength = ternaryOperator(condition, ifTrue, ifFalse);

        System.out.println(safeStringLength);
    }

}
