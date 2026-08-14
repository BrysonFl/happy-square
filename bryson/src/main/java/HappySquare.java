import static utilities.Util.*;

void main() {
    boolean completedSuccessfully = false;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    while (!completedSuccessfully) {
        try {
            System.out.print("Por favor, ingresa el tamaño de la matriz: ");
            int size = Integer.parseInt(reader.readLine());
            int[] result = new int[(2 * size) + 2];
            int[][] square = new int[size][size];

            System.out.println("\nAhora, elige cómo te gustaría llenar la matriz: \t1. Manera manual \t2. Manera automática");
            System.out.print("Ingresa una opción: ");

            switch (Integer.parseInt(reader.readLine())) {
                case 1 -> {
                    System.out.println("\nElegiste llenar la matriz de manera manual.");
                    for (int i = 0; i < size; i++) {
                        for (int j = 0; j < size; j++) {
                            System.out.println("Ingrese un valor para la fila " + (i + 1) + " y la columna " + (j + 1));
                            square[i][j] = Integer.parseInt(reader.readLine());
                        }
                    }
                }
                case 2 -> {
                    int minimumValue;
                    int maximumValue;
                    Random random = new Random();

                    do {
                        System.out.println();
                        System.out.println("Para llenar la matriz de manera automática, por favor, ingresa el valor mínimo y el valor máximo permitido (Recuerda que el primer número ingresado debe ser menor al segundo ingresado): ");
                        System.out.print("Valor minímo: ");
                        minimumValue = Integer.parseInt(reader.readLine());
                        System.out.print("Valor máximo: ");
                        maximumValue = Integer.parseInt(reader.readLine());
                    } while (minimumValue > maximumValue);

                    for (int i = 0; i < square.length; i++) {
                        for (int j = 0; j < square[i].length; j++) {
                            square[i][j] = random.nextInt(minimumValue, maximumValue + 1);
                        }
                    }
                }
                default -> throw new NumberFormatException("Opción no válida. Ingresa 1 o 2.");
            }

            printSquareElements(square);
            generateRowSum(square, result);
            generateColSum(square, result);
            generatePrincipalDiagonalSum(square, result);
            generateSecondaryDiagonalSum(square, result);
            validateHappySquare(result);
            completedSuccessfully = true;
        } catch (IOException | NumberFormatException e) {
            System.out.println("Ocurrió el error " + e.getLocalizedMessage() + ". Se iniciará el flujo nuevamente.\n");
        }
    }

}