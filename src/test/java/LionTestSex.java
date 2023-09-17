import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class LionTestSex {

    @ParameterizedTest
    @MethodSource("provideTestData")
    public void testDoesHaveMane(String sex, boolean expectedHasMane) throws Exception {
        Feline felineMock1 = mock(Feline.class);
        Feline felineMock2 = mock(Feline.class);

        when(felineMock1.getFood(anyString())).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        when(felineMock2.getFood(anyString())).thenReturn(List.of("Трава", "Различные растения"));

        Lion lion = new Lion(sex, felineMock1);

        boolean actualHasMane = lion.doesHaveMane();

        assertEquals(expectedHasMane, actualHasMane);
    }

    private static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of("Самец", false),
                Arguments.of("Самка", false)
               );
    }
}
