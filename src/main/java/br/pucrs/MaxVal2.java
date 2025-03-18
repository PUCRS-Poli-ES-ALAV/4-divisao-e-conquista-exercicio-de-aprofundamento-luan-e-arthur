package br.pucrs;

import java.util.Random;

public class MaxVal2 {
    static long contagemIteracoes = 0;

    public static long maxVal(long[] a, int init, int end) {
        if (end - init < 2) {
            contagemIteracoes++;
            return a[init];
        } else {
            int m = (init + end) / 2;
            long v1 = maxVal(a, init, m);
            long v2 = maxVal(a, m, end);
            return Math.max(v1, v2);
        }
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

        maxVal(array, 0, array.length);

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

    //Tempo de execução (ms): 0.0523
    //Número de iterações: 32
    //Tempo de execução (ms): 0.4943
    //Número de iterações: 2048
    //Tempo de execução (ms): 7.7827
    //Número de iterações: 1048576
}
