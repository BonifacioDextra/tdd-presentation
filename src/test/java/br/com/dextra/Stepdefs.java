package br.com.dextra;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class Stepdefs {

    private Parser parser = new Parser();

    @Given("carrega o arquivo {string}")
    public void carregaArquivo(String arquivo) {
        parser.loadFile("src/test/resources/static/" + arquivo);
    }

    @When("inverte o conteúdo do arquivo")
    public void interteConteudoDoArquivo() {
        parser.parse();
    }

    @When("salva novo arquivo {string}")
    public void salvaNovoArquivo(String arquivo) {
        parser.writeFile("src/test/resources/static/" + arquivo);
    }

    @When("carrega o novo arquivo {string}")
    public void carregaNovoArquivo(String arquivo) {
        parser.loadFile("src/test/resources/static/" + arquivo);
    }

    @Then("verifica se o conteúdo está invertido")
    public void verificaSeConteudoEstaInvertido() {
        assertEquals(parser.getContent(), "54321");
    }

}
