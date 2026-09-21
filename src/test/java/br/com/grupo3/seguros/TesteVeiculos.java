package br.com.grupo3.seguros;

import java.util.List;

public final class TesteVeiculos {
    private static final double TOLERANCIA = 0.001;

    private TesteVeiculos() {
        // Impede a criacao de objetos de uma classe usada apenas para testes.
    }

    public static void main(String[] args) {
        testarSeguroDoCarro();
        testarSeguroDaMoto();
        testarModeloVazio();
        testarValorInvalido();
        testarTotalDosSeguros();
        testarRelatorioSemVeiculos();

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

    private static void testarModeloVazio() {
        verificarExcecao(
                () -> new Carro(" ", 50_000.00),
                "veiculo com modelo vazio");
    }

    private static void testarValorInvalido() {
        verificarExcecao(
                () -> new Moto("Moto de teste", 0),
                "veiculo com valor igual a zero");
    }

    private static void testarTotalDosSeguros() {
        List<Veiculo> veiculos = List.of(
                new Carro("Carro de teste", 100_000.00),
                new Moto("Moto de teste", 20_000.00));

        RelatorioSeguro relatorio = new RelatorioSeguro();

        verificarValor(
                6_600.00,
                relatorio.calcularTotalSeguro(veiculos),
                "total dos seguros");
    }

    private static void testarRelatorioSemVeiculos() {
        RelatorioSeguro relatorio = new RelatorioSeguro();

        verificarExcecao(
                () -> relatorio.calcularTotalSeguro(List.of()),
                "relatorio sem veiculos");
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

    private static void verificarExcecao(Runnable operacao, String descricao) {
        try {
            operacao.run();
            throw new AssertionError(
                    descricao + ": era esperada uma IllegalArgumentException.");
        } catch (IllegalArgumentException excecao) {
            // A excecao confirma que a validacao funcionou corretamente.
        }
    }
}
