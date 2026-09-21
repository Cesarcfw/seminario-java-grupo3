package br.com.grupo3.seguros;

public final class TesteVeiculos {
    private static final double TOLERANCIA = 0.001;

    private TesteVeiculos() {
        // Impede a criacao de objetos de uma classe usada apenas para testes.
    }

    public static void main(String[] args) {
        testarSeguroDoCarro();
        testarSeguroDaMoto();

        System.out.println("Todos os testes passaram.");
    }

    private static void testarSeguroDoCarro() {
        Veiculo carro = new Carro("Carro de teste", 100_000.00);

        verificarValor(5_000.00, carro.calcularSeguro(), "seguro do carro");
    }

    private static void testarSeguroDaMoto() {
        Veiculo moto = new Moto("Moto de teste", 20_000.00);

        verificarValor(1_600.00, moto.calcularSeguro(), "seguro da moto");
    }

    private static void verificarValor(
            double valorEsperado,
            double valorObtido,
            String descricao) {

        if (Math.abs(valorEsperado - valorObtido) > TOLERANCIA) {
            throw new AssertionError(
                    descricao
                            + ": esperado R$ "
                            + valorEsperado
                            + ", mas foi obtido R$ "
                            + valorObtido);
        }
    }
}

