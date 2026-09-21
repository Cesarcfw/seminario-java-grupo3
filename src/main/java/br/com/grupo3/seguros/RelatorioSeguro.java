package br.com.grupo3.seguros;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

/**
 * Apresenta os resultados da simulacao sem misturar formatacao com as
 * regras de negocio das classes de veiculos.
 */
public final class RelatorioSeguro {
    private final NumberFormat formatadorMoeda;

    public RelatorioSeguro() {
        formatadorMoeda = NumberFormat.getCurrencyInstance(Locale.of("pt", "BR"));
    }

    public void exibir(List<Veiculo> veiculos) {
        validarLista(veiculos);

        System.out.println("=== Simulacao de seguros ===");

        for (Veiculo veiculo : veiculos) {
            exibirVeiculo(veiculo);
        }

        double total = calcularTotalSeguro(veiculos);
        System.out.println("----------------------------------------");
        System.out.println("Total dos seguros: " + formatarMoeda(total));
    }

    public double calcularTotalSeguro(List<Veiculo> veiculos) {
        validarLista(veiculos);

        double total = 0;

        for (Veiculo veiculo : veiculos) {
            total += veiculo.calcularSeguro();
        }

        return total;
    }

    private void exibirVeiculo(Veiculo veiculo) {
        if (veiculo == null) {
            throw new IllegalArgumentException("A lista nao pode conter veiculos nulos.");
        }

        System.out.printf(
                "%s | Modelo: %s | Valor: %s | Seguro: %s%n",
                veiculo.getTipo(),
                veiculo.getModelo(),
                formatarMoeda(veiculo.getValor()),
                formatarMoeda(veiculo.calcularSeguro()));
    }

    private String formatarMoeda(double valor) {
        return formatadorMoeda.format(valor);
    }

    private void validarLista(List<Veiculo> veiculos) {
        if (veiculos == null || veiculos.isEmpty()) {
            throw new IllegalArgumentException("A lista de veiculos deve ser informada.");
        }

        if (veiculos.stream().anyMatch(veiculo -> veiculo == null)) {
            throw new IllegalArgumentException("A lista nao pode conter veiculos nulos.");
        }
    }
}
