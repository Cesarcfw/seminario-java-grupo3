package br.com.grupo3.seguros;

import java.util.List;

public final class Main {
    private Main() {
        // Impede a criacao de objetos de uma classe usada apenas para iniciar o programa.
    }

    public static void main(String[] args) {
        List<Veiculo> veiculos = List.of(
                new Carro("Honda Civic", 150_000.00),
                new Moto("Honda CB 500", 42_000.00),
                new Carro("Toyota Corolla", 145_000.00),
                new Moto("Yamaha MT-03", 32_000.00));

        RelatorioSeguro relatorio = new RelatorioSeguro();
        relatorio.exibir(veiculos);
    }
}
