package stepdefinitions;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;
import dominio.SimulacaoDTO;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.E;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Entao;
import org.junit.Assert;
import request.APIRequest;
import util.GeradorCPF;
import util.MontagemDTO;

import java.math.BigDecimal;

public class StepSimulacaoPost {


    GeradorCPF geradorCpf = new GeradorCPF();
    SimulacaoDTO simulacaoDTO;
    MontagemDTO montagemDTO = new MontagemDTO();
    APIRequest request = new APIRequest();
    HttpResponse<String> response;


    //Dado
    @Dado("que sera realizado uma simulação")
    public void realizar_simulacao(){
        simulacaoDTO = montagemDTO.montarLoteDTOSimulacao();

    }

    @Quando("informo o cpf {string}, email {string}, valor {int}, parcelas {int}, seguro {string}")
    public void informo_valores(String cpf, String email, Integer valor, Integer parcelas, String seguro) throws UnirestException {

        cpf = geradorCpf.cpf();
        simulacaoDTO.setCpf(cpf);
        simulacaoDTO.setEmail(email);
        simulacaoDTO.setValor(BigDecimal.valueOf(valor));
        simulacaoDTO.setParcelas(parcelas);
        simulacaoDTO.setSeguro(Boolean.valueOf(seguro));
        response = request.PostSimulacao(simulacaoDTO);

    }

    @Quando("informo o cpf {string} ja utilizado em uma requisao anterior")
    public void informo_cpf_duplicado( String cpf) throws UnirestException {

        simulacaoDTO.setCpf(cpf);
        request.PostSimulacao(simulacaoDTO);
        response = request.PostSimulacao(simulacaoDTO);

    }

    @Quando("informo o cpf {string} invalido na adição de simulação")
    public void informo_cpf_invalido_no_post( String cpf) throws UnirestException {

        simulacaoDTO.setCpf(cpf);
        request.PostSimulacao(simulacaoDTO);
        response = request.PostSimulacao(simulacaoDTO);

    }


    @Quando("informo o email {string}, valor {int}, parcelas {int}, seguro {string} com dados invalidos")
    public void informo_valores_invalidoss( String email, Integer valor, Integer parcelas, String seguro) throws UnirestException {
        String cpf = geradorCpf.cpf();
        simulacaoDTO.setCpf(cpf);
        simulacaoDTO.setEmail(email);
        simulacaoDTO.setValor(BigDecimal.valueOf(valor));
        simulacaoDTO.setParcelas(parcelas);
        simulacaoDTO.setSeguro(Boolean.valueOf(seguro));
        response = request.PostSimulacao(simulacaoDTO);

    }


    @Entao("o sistema deve retornar um status {int}")
    public void sistema_retorna(Integer statuscode){
        Integer code = response.getStatus();
        Assert.assertEquals(code, statuscode);

    }

    @E("o retorno conter a seguinte mensagem {string}")
    public void sistema_retorna_mensagem_na_adicao(String mensagem){
        String body = response.getBody();
        Assert.assertTrue(body.contains(mensagem));

    }



}
