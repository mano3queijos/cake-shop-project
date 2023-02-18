package ucsal.br.bes.poo20222.avaliacaopontuada2.domain;

import ucsal.br.bes.poo20222.avaliacaopontuada2.exception.QtdMinPedidoInvalidaException;

public class Doce extends Produto {
	
	private Integer minPedido;

	public Doce() {
		// TODO Auto-generated constructor stub
	}
	public Doce(Integer codigo, String descricao, Double valorUnitario, Integer minPedido) {
		super(codigo, descricao, valorUnitario);
		this.minPedido = minPedido;
	}

	public Integer getMinPedido() {
		return minPedido;
	}

	public void setMinPedido(Integer minPedido) throws QtdMinPedidoInvalidaException {
		validarMinPedido(minPedido);
		this.minPedido = minPedido;
	}
	
	public static void validarMinPedido(Integer minPedido) throws QtdMinPedidoInvalidaException {
		if(minPedido<50) {
			throw new QtdMinPedidoInvalidaException("Numero de doces eh muito baixo para continuar a operacao, por favor, peça pelo menos 50 docinhos.");
		}
	}

	@Override
	public String toString() {
		return "Doce [minPedido=" + minPedido + ", getCodigo()=" + getCodigo() + ", getDescricao()=" + getDescricao()
				+ ", getValorUnitario()=" + getValorUnitario() + "]";
	}

	
	
}