package br.com.grupo3.seguros;

/**
 * Um carro e um tipo de veiculo cujo seguro corresponde a 5% de seu valor.
 */
public final class Carro extends Veiculo {
    private static final double TAXA_SEGURO = 0.05;

    public Carro(String modelo, double valor) {
        super(modelo, valor);
    }

    @Override
    public double calcularSeguro() {
        return getValor() * TAXA_SEGURO;
    }
}

