package br.pucrs;

public class Multiplicacao {
    static long contagemIteracoes = 0;

    public static long multiplicacao(long x, long y, int n) {
        contagemIteracoes++;

        if (n == 1) {
            return x*y;
        } else {
            int m = n / 2;
            long a = x / (1L << m); // a = x / 2^m
            long b = x % (1L << m); // b = x mod 2^m
            long c = y / (1L << m);
            long d = y % (1L << m);

            long e = multiplicacao(a, c, m);
            long f = multiplicacao(b, d, m);
            long g = multiplicacao(a, d, m);
            long h = multiplicacao(b, c, m);

            return (1L << (2*m)) * e + (1L << m) * (g + h) + f;
        }
    }

    public static void testarMultiplicacao(long x, long y, int n) {
        contagemIteracoes = 0;

        long startTime = System.nanoTime();

        long resultado = multiplicacao(x, y, n);

        long endTime = System.nanoTime();
        long duracao = endTime - startTime;

        double duracaoMs = (double) duracao / 1000000;

        System.out.println("Resultado: " + resultado);
        System.out.println("Tempo de execução (ms): " + duracaoMs);
        System.out.println("Número de iterações: " + contagemIteracoes);
    }

    public static void main(String[] args) {
        // 4 bits
        long x4 = 15;
        long y4 = 3;
        testarMultiplicacao(x4, y4, 4);

        // 16 bits
        long x16 = 30000;
        long y16 = 20000;
        testarMultiplicacao(x16, y16, 16);

        // 64 bits
        long x64 = 1234567890123456789L;
        long y64 = 987654321987654321L;
        testarMultiplicacao(x64, y64, 64);
    }

    //Resultado: 45
    //Tempo de execução (ms): 0.0058
    //Número de iterações: 21
    //Resultado: 600000000
    //Tempo de execução (ms): 0.0523
    //Número de iterações: 341
    //Resultado: 2522429437567159313
    //Tempo de execução (ms): 0.4592
    //Número de iterações: 5461
}
