package stepdefinitions;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;
import dominio.SimulacaoDTO;
import io.cucumber.java.es.Dado;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Entao;
import org.junit.Assert;
import request.APIRequest;
import util.GeradorCPF;
import util.MontagemDTO;

public class StepSimulacaoGet {
    GeradorCPF geradorCpf = new GeradorCPF();
    SimulacaoDTO simulacaoDTO;
    MontagemDTO montagemDTO = new MontagemDTO();
    APIRequest request = new APIRequest();
    HttpResponse<String> response;


    //Dado
    @Dado("que sera realizado uma consulta de simulação")
    public void montoArquivo_consulta_simulacao(){
        simulacaoDTO = montagemDTO.montarLoteDTOSimulacao();

    }

    @Quando("informo o cpf {string}")
    public void informo_cpf( String cpf) throws UnirestException {

        simulacaoDTO.setCpf(cpf);
        request.PostSimulacao(simulacaoDTO);
        response = request.GetSimulacaoCPF(cpf);

    }

    @Quando("informo o cpf {string} invalido")
    public void informo_cpf_invalido( String cpf) throws UnirestException {

        response = request.GetSimulacaoCPF(cpf);

    }



    @Entao("o sistema deve retornar um status {int} de consulta")
    public void sistema_retorna_consulta(Integer statuscode){
        Integer code = response.getStatus();
        Assert.assertEquals(code, statuscode);

    }
}
