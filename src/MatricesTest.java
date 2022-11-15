import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class MatricesTest {
@Test
void transpTest() {
	int[][] matrix = {
			{1, 2},
			{3, 4},
			{4, 5}
	};
	int expected[][] = {
			{1, 3, 4},
			{2, 4, 5}
	};
	assertArrayEquals(expected, Matrices.transp(matrix));
}
}
