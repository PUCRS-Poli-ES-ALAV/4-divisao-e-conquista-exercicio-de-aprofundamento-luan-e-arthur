package br.pucrs;

import java.util.Random;

public class MergeSort {

    static long contagemIteracoes = 0;

    public static int[] mergeSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }

        int meio = array.length / 2;
        int[] esquerda = new int[meio];
        int[] direita = new int[array.length - meio];

        System.arraycopy(array, 0, esquerda, 0, meio);
        System.arraycopy(array, meio, direita, 0, array.length - meio);

        esquerda = mergeSort(esquerda);
        direita = mergeSort(direita);

        return merge(esquerda, direita);
    }


    public static int[] merge(int[] esquerda, int[] direita) {
        int[] resultado = new int[esquerda.length + direita.length];
        int i = 0, j = 0, k = 0;

        while (i < esquerda.length && j < direita.length) {
            contagemIteracoes++;
            if (esquerda[i] <= direita[j]) {
                resultado[k++] = esquerda[i++];
            } else {
                resultado[k++] = direita[j++];
            }
        }

        while (i < esquerda.length) {
            resultado[k++] = esquerda[i++];
        }

        while (j < direita.length) {
            resultado[k++] = direita[j++];
        }

        return resultado;
    }

    public static int[] gerarAleatorio(int tamanho) {
        Random random = new Random();
        int[] array = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            array[i] = random.nextInt(10000);
        }

        return array;
    }

    public static void testeMerge(int[] array) {
        contagemIteracoes = 0;

        long startTime = System.nanoTime();

        mergeSort(array);

        long endTime = System.nanoTime();
        long duracao = endTime - startTime;

        double duracaoMs = (double) duracao / 1000000;

        System.out.println("Tempo de execução (ms): " + duracaoMs);
        System.out.println("Número de iterações: " + contagemIteracoes);
    }

    public static void main(String[] args) {
        int[] array1 = gerarAleatorio(32);
        testeMerge(array1);

        int[] array2 = gerarAleatorio(2048);
        testeMerge(array2);

        int[] array3 = gerarAleatorio(1048576);
        testeMerge(array3);
    }

    //Tempo de execução (ms): 0.0395
    //Número de iterações: 122
    //Tempo de execução (ms): 1.1857
    //Número de iterações: 19961
    //Tempo de execução (ms): 306.2865
    //Número de iterações: 19645829
}
