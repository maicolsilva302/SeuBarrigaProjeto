package test;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import core.BaseTest;
import core.Propriedades;
import page.ContasPage;
import page.MenuPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContaTest extends BaseTest {
	
	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();
	
	@Test
	public void test1_InserirConta() {
		menuPage.acessarTelaInserirConta();
		
		contasPage.setNome("Conta Teste");
		contasPage.salvar();
		
		Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());
	}
	
	@Test
	public void test2_AlterarConta() {
		menuPage.acessarTelaListaConta();
		
		contasPage.clicarAlterarConta("Conta Teste");
		contasPage.setNome(Propriedades.NOME_CONTA_ALTERADA);
		contasPage.salvar();
		
		Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMensagemSucesso());
	}
	
	@Test
	public void test3_InserirContaMesmoNome() {
		menuPage.acessarTelaInserirConta();
		contasPage.setNome(Propriedades.NOME_CONTA_ALTERADA);
		contasPage.salvar();
		
		Assert.assertEquals("Já existe uma conta com esse nome!", contasPage.obterMensagemErro());
	}
	
}
