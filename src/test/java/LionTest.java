import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class LionTest {

    private Feline feline;

    @BeforeEach
    public void setUp() {
        feline = Mockito.mock(Feline.class);
    }

    @Test
    public void testGetKittens() {
        try {
            when(feline.getKittens()).thenReturn(3);

            Lion lion = new Lion("Самец", feline);

            int actualKittens = lion.getKittens();

            assertEquals(3, actualKittens);
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
    }

    @Test
    public void testDoesHaveManeForMale() {
        try {
            Lion lion = new Lion("Самец", feline);

            boolean hasMane = lion.doesHaveMane();

            assertEquals(true, hasMane);
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
    }

    @Test
    public void testDoesHaveManeForFemale() {
        try {
            Lion lion = new Lion("Самка", feline);

            boolean hasMane = lion.doesHaveMane();

            assertEquals(false, hasMane);
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
    }

    @Test
    public void testGetFood() {
        try {
            when(feline.getFood(anyString())).thenReturn(Arrays.asList("Мясо", "Рыба"));

            Lion lion = new Lion("Самец", feline);

            List<String> food = lion.getFood();

            assertEquals(Arrays.asList("Мясо", "Рыба"), food);
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
    }

    @Test
    public void testInvalidSexInConstructor() {
        // Test that an exception is thrown when an invalid sex is provided
        assertThrows(Exception.class, () -> {
            new Lion("InvalidSex", feline);
        });
    }
}
