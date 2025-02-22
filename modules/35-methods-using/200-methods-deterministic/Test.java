import java.util.stream.IntStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class Test {
    public static void main(String[] args) {
        IntStream.range(0, 10).forEach(i -> {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));

            App.main(null);
            var actual = Integer.parseInt(out.toString().trim());
            assertThat(actual).isBetween(0, 10);
        });
    }
}
