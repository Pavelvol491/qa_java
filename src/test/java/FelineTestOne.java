import com.example.Feline;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class FelineTestOne {

    @ParameterizedTest
    @MethodSource("provideFelineTestData")
    public void testEatMeat(String animalType, List<String> expectedFood) throws Exception {
        Feline felineMock = Mockito.mock(Feline.class);
        when(felineMock.getFood(anyString())).thenReturn(expectedFood);

        List<String> food = felineMock.getFood(animalType);
        assertEquals(expectedFood, food);
    }

    @ParameterizedTest
    @ArgumentsSource(KittensArgumentsProvider.class)
    public void testGetKittens(int kittensCount, int expectedKittens) {
        Feline felineMock = Mockito.mock(Feline.class);
        when(felineMock.getKittens(anyInt())).thenReturn(expectedKittens);

        int actualKittens = felineMock.getKittens(kittensCount);
        assertEquals(expectedKittens, actualKittens);
    }

    static Stream<Arguments> provideFelineTestData() {
        return Stream.of(
                Arguments.of("Хищник", List.of("Животные", "Птицы", "Рыба")),
                Arguments.of("Травоядное", List.of("Трава", "Различные растения"))
        );
    }

    static class KittensArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of(1, 1),
                    Arguments.of(3, 3),
                    Arguments.of(0, 0)
            );
        }
    }
}
