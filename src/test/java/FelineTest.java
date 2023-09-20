import com.example.Feline;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FelineTest {

    @Test
    public void testEatMeat() {
        Feline feline = new Feline();

        try {
            assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetFamily() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @ParameterizedTest
    @CsvSource({ "1, 1", "2, 2", "3, 3" })
    public void testGetKittens(int input, int expected) {
        Feline feline = new Feline();
        int actual = feline.getKittens(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetKittensWithDefault() {
        Feline feline = new Feline();
        int actual = feline.getKittens();
        assertEquals(1, actual);
    }
}
