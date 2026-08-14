package utilities;

public class Util {

    private static int lastPosition = 0;

    public static void printSquareElements(int[][] square) {
        System.out.println("\nLos elementos en el cuadrado son:");
        for (int[] row : square) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static void generateRowSum(int[][] square, int[] result) {
        int rowSum = 0;

        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square[i].length; j++) {
                rowSum += square[i][j];
            }

            result[lastPosition++] = rowSum;
            rowSum = 0;
        }
    }

    public static void generateColSum(int[][] square, int[] result) {
        int colSum = 0;

        for (int i = 0; i < square[0].length; i++) {
            for (int j = 0; j < square.length; j++) {
                colSum += square[j][i];
            }

            result[lastPosition++] = colSum;
            colSum = 0;
        }
    }

    public static void generatePrincipalDiagonalSum(int[][] square, int[] result) {
        int principalDiagonalSum = 0;

        for (int i = 0; i < square.length; i++) {
            principalDiagonalSum += square[i][i];
        }

        result[lastPosition++] = principalDiagonalSum;
    }

    public static void generateSecondaryDiagonalSum(int[][] square, int[] result) {
        int secondaryDiagonalSum = 0;

        for (int i = 0; i < square.length; i++) {
            secondaryDiagonalSum += square[i][(square[i].length - 1) - i];
        }

        result[lastPosition] = secondaryDiagonalSum;
    }

    public static void validateHappySquare(int[] result) {
        boolean isHappySquare = false;

        for (int i = 0; i < result.length - 1; i++) {
            if (result[i] != result[i + 1]) {
                isHappySquare = false;
                break;
            } else {
                isHappySquare = true;
            }
        }

        printResult(isHappySquare, result);
    }

    public static void printResult(boolean isHappySquare, int[] result) {
        System.out.println("\nEl resultado de las sumas de las filas, las columnas y las diagonales son: ");
        for (int i : result)
            System.out.print(i + " ");

        System.out.println("\n\nEl resultado es: " + (isHappySquare ? "El cuadrado, es un cuadrado feliz :D" : "El cuadrado, no es un cuadrado feliz :("));
    }

}
