package stepdefinitions;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.cucumber.java.es.Dado;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Entao;
import org.junit.Assert;
import request.APIRequest;


public class StepSimulacoesGet {

    APIRequest request = new APIRequest();
    HttpResponse<String> response;


    //Dado
    @Dado("que sera realizado uma consulta de todas as simulações")
    public void montoArquivo_consulta_restricao(){
        Assert.assertTrue(true);

    }

    @Quando("realizo a consulta")
    public void informo_cpf_restricao() throws UnirestException {

        response = request.GetSimulacao();

    }

    @Entao("o sistema deve retornar um status {int} de consulta de simulacoes")
    public void sistema_retorna_consulta_restricao(Integer statuscode){
        Integer code = response.getStatus();
        Assert.assertEquals(code, statuscode);

    }
}
