package br.pucrs;

import java.util.Random;

public class MaxValue {
    static long contagemIteracoes = 0;

    public static long maxVal(long[] A, int n) {
        long max = A[0];

        for (int i = 1; i < n; i++) {
            contagemIteracoes++;
            if (A[i] > max) {
                max = A[i];
            }
        }
        return max;
    }

    public static long[] gerarAleatorio(int tamanho) {
        Random random = new Random();
        long[] array = new long[tamanho];

        for (int i = 0; i < tamanho; i++) {
            array[i] = random.nextLong();
        }
        return array;
    }

    public static void testarMaxVal(long[] array) {
        contagemIteracoes = 0;

        long startTime = System.nanoTime();

        maxVal(array, array.length);

        long endTime = System.nanoTime();
        long duracao = endTime - startTime;

        double duracaoMs = (double) duracao / 1000000;

        System.out.println("Tempo de execução (ms): " + duracaoMs);
        System.out.println("Número de iterações: " + contagemIteracoes);
    }

    public static void main(String[] args) {
        long[] array1 = gerarAleatorio(32);
        testarMaxVal(array1);

        long[] array2 = gerarAleatorio(2048);
        testarMaxVal(array2);

        long[] array3 = gerarAleatorio(1048576);
        testarMaxVal(array3);
    }

    //Tempo de execução (ms): 0.0055
    //Número de iterações: 31
    //Tempo de execução (ms): 0.0848
    //Número de iterações: 2047
    //Tempo de execução (ms): 6.39
    //Número de iterações: 1048575

}
