package test;

import static utils.DataUtils.obterDataFormatada;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import core.BaseTest;
import core.Propriedades;
import page.MenuPage;
import page.MovimentacaoPage;
import utils.DataUtils;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MovimentacaoTest extends BaseTest {
	private MenuPage menuPage = new MenuPage();
	private MovimentacaoPage movPage = new MovimentacaoPage();
	
	@Test
	public void test1InserirMovimentacao() {
		menuPage.acessarTelaInserirMovimentacao();
		
		movPage.setDataMovimentacao(obterDataFormatada(new Date()));
		movPage.setDataPagamento(obterDataFormatada(new Date()));
		movPage.setDescricao("Movimenta��o do Teste");
		movPage.setInteressado("Interessado Teste");
		movPage.setValor("750");
		movPage.setConta(Propriedades.NOME_CONTA_ALTERADA);
		movPage.setStatusPago();
		movPage.salvar();
	}
	
	@Test
	public void test2CamposObrigatorios(){
		menuPage.acessarTelaInserirMovimentacao();
		
		movPage.salvar();
		List<String> erros = movPage.obterErros();
//		Assert.assertEquals("Data da Movimenta��o � obrigat�rio", erros.get(0));
//		Assert.assertTrue(erros.contains("Data da Movimenta��o � obrigat�rio"));
		Assert.assertTrue(erros.containsAll(Arrays.asList(
				"Data da Movimenta��o � obrigat�rio", "Data do pagamento � obrigat�rio",
				"Descri��o � obrigat�rio", "Interessado � obrigat�rio", 
				"Valor � obrigat�rio", "Valor deve ser um n�mero")));
		Assert.assertEquals(6, erros.size());
	}
	
	@Test
	public void test3InserirMovimentacaoFutura(){
		menuPage.acessarTelaInserirMovimentacao();
		
		Date dataFutura = DataUtils.obterDataComDiferencaDias(5);
		
		movPage.setDataMovimentacao(obterDataFormatada(dataFutura));
		movPage.setDataPagamento(obterDataFormatada(dataFutura));
		movPage.setDescricao("Movimenta��o do Teste");
		movPage.setInteressado("Interessado Qualquer");
		movPage.setValor("900");
		movPage.setConta(Propriedades.NOME_CONTA_ALTERADA);
		movPage.setStatusPago();
		movPage.salvar();
		
		List<String> erros = movPage.obterErros();
		Assert.assertTrue(
				erros.contains("Data da Movimenta��o deve ser menor ou igual � data atual"));
		Assert.assertEquals(1, erros.size());
	}

}
