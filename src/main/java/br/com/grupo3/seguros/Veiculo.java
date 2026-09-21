package br.com.grupo3.seguros;

/**
 * Representa as caracteristicas comuns a qualquer veiculo do sistema.
 *
 * A classe e abstrata porque um "veiculo generico" nao possui uma regra
 * unica para o calculo do seguro. Cada tipo concreto define a propria regra.
 */
public abstract class Veiculo {
    private final String modelo;
    private final double valor;

    protected Veiculo(String modelo, double valor) {
        if (modelo == null || modelo.isBlank()) {
            throw new IllegalArgumentException("O modelo deve ser informado.");
        }

        if (valor <= 0) {
            throw new IllegalArgumentException("O valor deve ser maior que zero.");
        }

        this.modelo = modelo;
        this.valor = valor;
    }

    public String getModelo() {
        return modelo;
    }

    public double getValor() {
        return valor;
    }

    /**
     * Obriga cada subclasse a fornecer sua regra de calculo.
     */
    public abstract double calcularSeguro();

    public String getTipo() {
        return getClass().getSimpleName();
    }
}
