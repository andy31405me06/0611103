import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.PriorityQueue;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PriorityQueueTest {
    static Stream<Arguments> stringIntAndListProvider(){
        return Stream.of(
                Arguments.of(new int[]{0}, new int[]{0}),
                Arguments.of(new int[]{0, 1}, new int[]{0, 1}),
                Arguments.of(new int[]{1, 0}, new int[]{0, 1}),
                Arguments.of(new int[]{2, 1, 0}, new int[]{0, 1, 2}),
                Arguments.of(new int[]{1, 2, 0}, new int[]{0, 1, 2})
        );
    }
    @ParameterizedTest
    @MethodSource("stringIntAndListProvider")
    public void PriorityQueue_RunTest(int[] random_array, int[] correct_array){
        PriorityQueue<Integer> test=new PriorityQueue<Integer>();
        for(int i=0;i<random_array.length;i++){
            test.add(random_array[i]);
        }
        int[] result=new int[random_array.length];
        for(int i=0;i<random_array.length;i++){
            result[i]=test.poll();
        }
        assertArrayEquals(correct_array, result);
    }
}