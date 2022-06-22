package suiteTest;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import core.DriverFactory;
import page.LoginPage;
import test.ContaTest;
import test.MovimentacaoTest;
import test.RemoverMovimentacaoContaTest;
import test.ResumoTest;
import test.SaldoTest;

@RunWith(Suite.class)
@SuiteClasses({
	ContaTest.class,
	MovimentacaoTest.class,
	RemoverMovimentacaoContaTest.class,
	SaldoTest.class,
	ResumoTest.class,
})
public class SuiteGeral {
	
	private static LoginPage page = new LoginPage();
	
	@BeforeClass
	public static void inicializa() {
		page.acessarTelaInicial();
		page.setEmail("maicol.maicol@maicol.com");
		page.setSenha("teste123");
		page.entrar();
	}
	
	@AfterClass
	public static void finaliza() {
		DriverFactory.killDriver();
	}

}
