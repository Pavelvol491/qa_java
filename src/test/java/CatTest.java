import com.example.Cat;
import com.example.Feline;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CatTest {

    @ParameterizedTest
    @MethodSource("provideCatTestData")
    public void testGetSound(Cat catMock, String expectedSound) throws Exception {
        String sound = catMock.getSound();
        assertEquals(expectedSound, sound);
    }

    static Stream<Arguments> provideCatTestData() throws Exception {
        Cat cat1 = Mockito.mock(Cat.class);
        when(cat1.getSound()).thenReturn("Мяу");

        return Stream.of(
                Arguments.of(cat1, "Мяу")
        );
    }
}
