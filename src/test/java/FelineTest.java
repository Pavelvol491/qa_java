import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.stream.Stream;

import com.example.Feline;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

public class FelineTest {

    @ParameterizedTest
    @MethodSource("provideKittenCounts")
    public void testGetKittens(int kittensCount) {
        Feline feline = new Feline();
        int actualKittens = feline.getKittens(kittensCount);

        assertEquals(kittensCount, actualKittens);
    }

    @ParameterizedTest
    @MethodSource("provideFoodTestData")
    public void testEatMeat(List<String> expectedFood) throws Exception {
       Feline felineMock = Mockito.mock(Feline.class);

        when(felineMock.eatMeat()).thenReturn(expectedFood);

        List<String> actualFood = felineMock.eatMeat();


        assertEquals(expectedFood, actualFood);
    }

    static Stream<Integer> provideKittenCounts() {
        return Stream.of(0, 1, 2, 3);
    }


    static Stream<Arguments> provideFoodTestData() {
        return Stream.of(
                Arguments.of(List.of("Мясо", "Кровь")),
                Arguments.of(List.of("Рыба", "Птицы")),
                Arguments.of(List.of("Трава", "Различные растения"))

        );
    }
}
