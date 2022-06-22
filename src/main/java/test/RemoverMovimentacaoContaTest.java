package test;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;
import core.Propriedades;
import page.ContasPage;
import page.MenuPage;

public class RemoverMovimentacaoContaTest extends BaseTest {

	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();
	
	@Test
	public void testExcluirContaComMovimentacao(){
		menuPage.acessarTelaListaConta();
		
		contasPage.clicarExcluirConta(Propriedades.NOME_CONTA_ALTERADA);
		
		Assert.assertEquals("Conta em uso na movimentações", contasPage.obterMensagemErro());
	}

}
