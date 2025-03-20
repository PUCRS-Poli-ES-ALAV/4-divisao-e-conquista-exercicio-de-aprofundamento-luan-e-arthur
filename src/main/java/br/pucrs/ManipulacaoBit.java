package br.pucrs;

public class ManipulacaoBit {
    static long contagemIteracoes = 0;

    private static String padLeft(String s, int length) {
        while (s.length() < length) {
            s = "0" + s;
        }
        return s;
    }

    public static long multiply(String X, String Y) {
        int maxLen = Math.max(X.length(), Y.length());
        X = padLeft(X, maxLen);
        Y = padLeft(Y, maxLen);

        if (maxLen % 2 != 0) {
            maxLen++;
            X = padLeft(X, maxLen);
            Y = padLeft(Y, maxLen);
        }
        return multiplayRecursiva(X, Y);
    }

    private static long multiplayRecursiva(String X, String Y) {
        contagemIteracoes++;
        int n = X.length();

        if (n == 1) {
            int a = X.charAt(0) - '0';
            int b = Y.charAt(0) - '0';
            return a * b;
        }

        int m = n / 2;

        String a = X.substring(0, n - m);
        String b = X.substring(n - m);

        String c = Y.substring(0, n - m);
        String d = Y.substring(n - m);

        long e = multiplayRecursiva(a, c);
        long f = multiplayRecursiva(b, d);
        long g = multiplayRecursiva(a, d);
        long h = multiplayRecursiva(b, c);

        return (1L << (2*m)) * e + (1L << m) * (g + h) + f;
    }

    public static void main(String[] args) {
        contagemIteracoes = 0;

        long startTime = System.nanoTime();
        long resultado = multiply("1110", "1111");
        long endTime = System.nanoTime();

        double duracaoMs = (double) (endTime - startTime) / 1000000;

        System.out.println("Resultado: " + resultado);
        System.out.println("Tempo de execução (ms): " + duracaoMs);
        System.out.println("Número de iterações: " + contagemIteracoes);
    }
}