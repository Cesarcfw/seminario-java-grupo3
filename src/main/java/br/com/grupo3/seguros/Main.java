package br.com.grupo3.seguros;

import java.util.List;

public final class Main {
    private Main() {
        // Impede a criacao de objetos de uma classe usada apenas para iniciar o programa.
    }

    public static void main(String[] args) {
        List<Veiculo> veiculos = List.of(
                new Carro("Honda Civic", 150_000.00),
                new Moto("Honda CB 500", 42_000.00));

        System.out.println("=== Simulacao de seguros ===");

        for (Veiculo veiculo : veiculos) {
            veiculo.exibirResumo();
        }
    }
}

