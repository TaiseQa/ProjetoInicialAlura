package br.com.alura.leilao.login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

    public static final String URL_LOGIN = "http://localhost:8080/login";


    //atributo da class de teste
    private WebDriver browser;


    //construtor
    public LoginPage() {
        //abrir navegador
        WebDriverManager.chromedriver().setup();
        this.browser = new ChromeDriver();
        //entrar na pagina passadando a url
        browser.navigate().to(URL_LOGIN);
    }

    //metodo de fechar a pagina
    public void fechar() {
        this.browser.quit();
    }


    public void preencheFormularioDeLogin(String username, String password) {
        browser.findElement(By.id("username")).sendKeys(username);
        browser.findElement(By.id("password")).sendKeys(password);
    }

    public void efetuaLogin() {
        //vai submeter o formulario (Enviar,como fosse clicar no botão. pode ser usado tag Form ou input)
        browser.findElement(By.id("login-form")).submit();
    }

    public boolean isPaginaDeLogin() {
        //retorna a url atual, e verifica que igual a que foi passada por parametro
        return browser.getCurrentUrl().equals(URL_LOGIN);
    }

    public String getNomeUsuarioLogado() {
        try {
            //pega o texto do elemento
            return browser.findElement(By.id("usuario-logado")).getText();
            //se não encontrar o elemento devolve Nulo
        } catch (NoSuchElementException e) {
        }
        return null;
    }


    public void navegaParaPaginaDeLances() {
        this.browser.navigate().to("http://localhost:8080/login/2");
    }

    public boolean contemTexto(String texto) {
        return browser.getPageSource().contains(texto);
    }

    public boolean isPaginaDeLoginComDaDosInvalidos() {
        return browser.getCurrentUrl().equals(URL_LOGIN + "?error");
    }
}
