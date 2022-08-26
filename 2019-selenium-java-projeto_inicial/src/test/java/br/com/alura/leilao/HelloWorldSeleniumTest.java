package br.com.alura.leilao;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class HelloWorldSeleniumTest {
    @Test
    public void hello() {
        //informa aonde esta o driver
       // System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        //abrir navegador
        WebDriverManager.chromedriver().setup();
        WebDriver browser = new ChromeDriver();
        //entrar na pagina
        browser.navigate().to("http://localhost:8080/leiloes");
        //fechar a pagina
        browser.quit();
    }
}