package br.com.alura.leilao.login;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest {
    private LoginPage paginaDeLogin;


    //Antes de cada metodo execute essa metodo primeiro
    @BeforeEach
    public void beforeEach() {
        //istanciar a pagina de login
        this.paginaDeLogin = new LoginPage();
    }

    //Depois de cada metodo execute essa metodo
    @AfterEach
    public void afeterEach() {
        this.paginaDeLogin.fechar();
    }


    @Test
    public void deveriaEfetuarLoginComDadosValidos() {

        paginaDeLogin.preencheFormularioDeLogin("fulano", "pass");
        paginaDeLogin.efetuaLogin();

        //Verificar que nao esta mais na url de login
        //verificar que a url atual não é igual a url de login, passado por parametro
        Assert.assertFalse(paginaDeLogin.isPaginaDeLogin());
        //verificar que o nome do usuario esta aparecendo na pagina
        Assert.assertEquals("fulano", paginaDeLogin.getNomeUsuarioLogado());

    }

    @Test

    public void naoDeveriaLogarComDadosInvalidos() {

        paginaDeLogin.preencheFormularioDeLogin("invalido", "123123");
        paginaDeLogin.efetuaLogin();
        Assert.assertTrue(paginaDeLogin.isPaginaDeLoginComDaDosInvalidos());
        Assert.assertNull(paginaDeLogin.getNomeUsuarioLogado());
        Assert.assertTrue(paginaDeLogin.contemTexto("Usuário e senha inválidos."));

        //Verfica que permaneceu na tela de login (True condição verdadeira)
        // Assert.assertTrue(browser.getCurrentUrl().equals("http://localhost:8080/login?error"));
        //getPageSource esse metodo devolve uma String com codigo da pagina, contains verifica que contem o texto no codigo
        // Assert.assertTrue(browser.getPageSource().contains("Usuário e senha inválidos."));
        //Verifica que não existe o elemento na pagina
        //Assert.assertThrows(NoSuchElementException.class, () -> browser.findElement(By.id("usuario-logado")));

    }

    @Test
    public void naoDeveriaAcessarPaginaRestritaSemEstarLogado() {
        paginaDeLogin.navegaParaPaginaDeLances();
        Assert.assertTrue(paginaDeLogin.isPaginaDeLogin());
        //verifica que não contem o texto passado por parametro
        Assert.assertFalse(paginaDeLogin.contemTexto("Dados do Leilão"));
        //verifica que esta na url passada por parametro
        // Assert.assertTrue(browser.getCurrentUrl().equals("http://localhost:8080/login"));


    }

}
