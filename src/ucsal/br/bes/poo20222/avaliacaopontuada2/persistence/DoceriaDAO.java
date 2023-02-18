package ucsal.br.bes.poo20222.avaliacaopontuada2.persistence;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

import ucsal.br.bes.poo20222.avaliacaopontuada2.domain.Bolo;
import ucsal.br.bes.poo20222.avaliacaopontuada2.domain.Produto;

public class DoceriaDAO {

	private static List<Produto> produtos = new ArrayList<>();
	private static HashSet<String> hsTemas = new HashSet<String>();

	public static void adicionar(Produto produto) {
		produtos.add(produto);
	}

	public static List<Produto> obterTodosProdutos() {
		return new ArrayList<>(produtos);
	}

	public static List<Produto> listarPorOrdemCresteValorUnitarioEDescricao() {

		produtos.sort(Comparator.comparing(Produto::getValorUnitario).thenComparing(Produto::getDescricao));

		return produtos;
	}

	public static HashSet<String> listarTemasSemRepeticao() {

		/*
		 * crio um vetor pra guardar apenas os temas dos bolos,depois adiciono eles a
		 * uma lista hashset pra não poder haver repetição de elementos, em seguida
		 * retorno eles pra poder fazer alguma operação em algum outro metodo
		 */
		String vetor[] = new String[produtos.size()];
		for (int i = 0; i < produtos.size(); i++) {
			if (produtos.get(i) instanceof Bolo) {
				vetor[i] = (((Bolo) produtos.get(i)).getTema());
			}

		}

		for (int i = 0; i < vetor.length; i++) {
			if (vetor[i] != null) {
				hsTemas.add(vetor[i]);

			}
		}

		return hsTemas;

	}

}
