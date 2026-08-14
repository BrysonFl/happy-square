void main() {

    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
        System.out.print("Por favor, ingrese el tamaño de la matriz: ");
        int size = Integer.parseInt(reader.readLine());
        int[] result = new int[(2 * size) + 2];
        int[][] square = new int[size][size];

        System.out.println("Cómo quiere llenar la matriz:");
        System.out.println("1. Manual");
        System.out.println("2. Automático");

        switch (Integer.parseInt(reader.readLine())) {
            case 1 -> {
                System.out.println("Se llenará la matriz de manera manual -> ");
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        System.out.println("Ingrese un valor para la posición " + (i + 1) + ":" + (j + 1));
                        square[i][j] = Integer.parseInt(reader.readLine());
                    }
                }
            }
            case 2 -> {
                int minimumValue;
                int maximumValue;
                int rowSum = 0;
                int colSum = 0;
                int principalDiagonalSum = 0;
                int secondaryDiagonalSum = 0;
                int lastPosition = 0;
                boolean isHappySquare = false;
                Random random = new Random();

                do {
                    System.out.println("Para llenar la matriz de manera automática, por favor, ingresa el valor mínimo y el valor máximo (Recuerda que el primer número debe ser menor al segundo ingresado): ");
                    minimumValue = Integer.parseInt(reader.readLine());
                    maximumValue = Integer.parseInt(reader.readLine());
                } while (minimumValue > maximumValue);

                for (int i = 0; i < square.length; i++) {
                    for (int j = 0; j < square[i].length; j++) {
                        square[i][j] = random.nextInt(minimumValue, maximumValue + 1);
                    }
                }

                //Se muestran los elementos generados en la matriz
                for (int[] row : square) {
                    for (int element : row) {
                        System.out.print(element + " ");
                    }
                    System.out.println();
                }

                //Suma de filas
                for (int i = 0; i < square.length; i++) {
                    for (int j = 0; j < square[i].length; j++) {
                        rowSum += square[i][j];
                    }

                    result[lastPosition++] = rowSum;
                    rowSum = 0;
                }

                for (int i = 0; i < square[0].length; i++) {
                    for (int j = 0; j < square.length; j++) {
                        colSum += square[j][i];
                    }

                    result[lastPosition++] = colSum;
                    colSum = 0;
                }

                //Suma de la diagonal principal
                for (int i = 0; i < square.length; i++) {
                    principalDiagonalSum += square[i][i];
                }

                result[lastPosition++] = principalDiagonalSum;

                //Suma de la diagonal secundaria
                for (int i = square.length - 1; i > 0; i--) {
                    secondaryDiagonalSum += square[i][i];
                }

                result[lastPosition] = secondaryDiagonalSum;

                for (int i = 0; i < result.length - 1; i++) {
                    if (result[i] != result[i + 1]) {
                        isHappySquare = false;
                        break;
                    } else {
                        isHappySquare = true;
                    }
                }

                System.out.println(isHappySquare ? "El cuadrado, es un cuadrado feliz :D" : "El cuadrado, no es un cuadrado feliz :(");
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

}