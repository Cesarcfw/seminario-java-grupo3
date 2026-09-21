package br.com.grupo3.seguros;

/**
 * Uma moto e um tipo de veiculo cujo seguro corresponde a 8% de seu valor.
 */
public final class Moto extends Veiculo {
    private static final double TAXA_SEGURO = 0.08;

    public Moto(String modelo, double valor) {
        super(modelo, valor);
    }

    @Override
    public double calcularSeguro() {
        return getValor() * TAXA_SEGURO;
    }
}

