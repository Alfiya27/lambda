import java.util.stream.IntStream;

public class Stream {
    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, x -> (x * x) / 10 % 1000);
    }
    public static void main(String[] args) {
        IntStream res = pseudoRandomStream(13);
        res.limit(10).forEach(x -> System.out.print(x +  " "));
    }
}
