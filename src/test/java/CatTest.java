import com.example.Cat;
import com.example.Feline;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CatTest {
    private Cat cat;
    private Feline feline;

    @BeforeEach
    void setUp() {
        // Создаем мок-объект Feline для тестирования
        feline = Mockito.mock(Feline.class);
        cat = new Cat(feline);
    }

    @Test
    void testGetSound() {
        // Проверяем, что метод getSound возвращает ожидаемый звук
        String expectedSound = "Мяу";
        String actualSound = cat.getSound();
        assertEquals(expectedSound, actualSound);
    }

    @Test
    void testGetFood() throws Exception {
        // Устанавливаем ожидаемое поведение для eatMeat метода Feline
        List<String> expectedFood = Arrays.asList("Мясо", "Рыба");
        when(feline.eatMeat()).thenReturn(expectedFood);

        // Вызываем метод getFood и проверяем, что он возвращает ожидаемый список еды
        List<String> actualFood = cat.getFood();
        assertEquals(expectedFood, actualFood);
    }
}
