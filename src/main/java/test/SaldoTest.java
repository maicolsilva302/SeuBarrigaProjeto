package test;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;
import core.Propriedades;
import page.HomePage;
import page.MenuPage;

public class SaldoTest extends BaseTest {
	HomePage page = new HomePage();
	MenuPage menu = new MenuPage();
	
	@Test
	public void testSaldoConta() {
		menu.acessarTelaPrincipal();
		Assert.assertEquals("750.00", page.obterSaldoConta(Propriedades.NOME_CONTA_ALTERADA));
	}

}
