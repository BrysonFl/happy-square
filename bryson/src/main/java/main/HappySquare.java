package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import static utilities.Util.*;

/**
 * Clase que contiene el método main para la ejecución del programa
 *
 * @author Bryson Florez
 * @version 1.0
 * */
public class HappySquare {

    /**
     * <p>Lógica de ejecución del programa</p>
     * <ol>
     *     <li>Pedir al usuario que ingrese el tamaño de la matriz</li>
     *     <li>Pedir al usuario cómo quiere llenar la matriz 1. Manualmente 2. Automáticamente</li>
     *     <li>Realiazar los debidos cálculos y validacions (Verificar la clase {@link utilities.Util})</li>
     * </ol>
     *
     * @param args Parámetros necesarios para el método main
     */
    public static void main(String... args) {
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
}