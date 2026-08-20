package utilities;

/**
 * <p>Clase utilitaria que nos permite contener todos los métodos de los cálculos e impresiones en consola</p>
 * @author Bryson Florez Estudiante de Ingeniería de Sistemas y Computación
 *
 */
public class Util {

    private static int lastPosition = 0;

    /**
     * Constructor privado para evitar la instaciación de esta clase, es una clase helper con métodos estaticos
     */
    private Util() {}

    /**
     * Este método nos permite realizar la impresión en consola de los valores de la matriz, esto con el fin de que el usuario pueda tener un acceso visual de lo que se construyó manual o automáticamente
     * @param square Matriz en el que se encuentran todos los valores y se mostrarán en consola
     */
    public static void printSquareElements(int[][] square) {
        System.out.println("\nLos elementos en el cuadrado son:");
        for (int[] row : square) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    /**
     * Este método nos permite generar la suma de cada fila y adicionalmente agregar a un arreglo el resultado de cada fila
     * @param square Matriz en el que se encuentran todos los valores con los que se realizará la suma de cada fila
     * @param result Arreglo en el que se guardará el resultado de las sumas de cada fila
     */
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

    /**
     * Este método nos permite generar la suma de cada columna y adicionalmente agregar a un arreglo el resultado de cada fila
     * @param square Matriz en el que se encuentran todos los valores con los que se realizará la suma de cada columna
     * @param result Arreglo en el que se guardará el resultado de las sumas de cada columna
     */
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

    /**
     * Este método nos permite generar la suma de la diagonal principal y adicionalmente agregar a un arreglo el resultado de cada fila
     * @param square Matriz en el que se encuentran todos los valores con los que se realizará la suma de la diagonal principal
     * @param result Arreglo en el que se guardará el resultado de la suma de la diagonal principal
     */
    public static void generatePrincipalDiagonalSum(int[][] square, int[] result) {
        int principalDiagonalSum = 0;

        for (int i = 0; i < square.length; i++) {
            principalDiagonalSum += square[i][i];
        }

        result[lastPosition++] = principalDiagonalSum;
    }

    /**
     * Este método nos permite generar la suma de la diagonal secundaria y adicionalmente agregar a un arreglo el resultado de cada fila
     * @param square Matriz en el que se encuentran todos los valores con los que se realizará la suma de la diagonal secundaria
     * @param result Arreglo en el que se guardará el resultado de la suma de la diagonal secundaria
     */
    public static void generateSecondaryDiagonalSum(int[][] square, int[] result) {
        int secondaryDiagonalSum = 0;

        for (int i = 0; i < square.length; i++) {
            secondaryDiagonalSum += square[i][(square[i].length - 1) - i];
        }

        result[lastPosition] = secondaryDiagonalSum;
    }

    /**
     * Permite validar que todos los valores generados en las sumas de las filas, columnas y diagonales sean iguales, si es así este será un cuadrado feliz, de lo contrario no lo será
     * @param result Arreglo en el que se encuentran todos los resultados de las sumas de las filas, columnas y diagonales, se usa para validar cada valor
     */
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

    /**
     * Permite imprimir en consola todos los valores contenidos en el arreglo de resultados y validamos si es un cuadrado feliz o no
     * @param isHappySquare Variable pasado como argumento para saber si todos los valores de el arreglo result son iguales o diferentes
     * @param result Arreglo en el que se encuentran todos los resultados de las sumas de las filas, columnas y diagonales
     */
    public static void printResult(boolean isHappySquare, int[] result) {
        System.out.println("\nEl resultado de las sumas de las filas, las columnas y las diagonales son: ");
        for (int i : result)
            System.out.print(i + " ");

        System.out.println("\n\nEl resultado es: " + (isHappySquare ? "El cuadrado, es un cuadrado feliz :D" : "El cuadrado, no es un cuadrado feliz :("));
    }

}
