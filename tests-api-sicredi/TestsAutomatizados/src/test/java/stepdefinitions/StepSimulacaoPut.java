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


public class StepSimulacaoPut {
    GeradorCPF geradorCpf = new GeradorCPF();
    SimulacaoDTO simulacaoDTO;
    MontagemDTO montagemDTO = new MontagemDTO();
    APIRequest request = new APIRequest();
    HttpResponse<String> response;


    //Dado
    @Dado("que sera realizado um update de uma simulação")
    public void montoArquivo_atualizacao_simulacao(){
        simulacaoDTO = montagemDTO.montarLoteDTOSimulacao();

    }

    @Quando("informo o cpf valido de atualizacao")
    public void informo_cpf_valido_de_atualizacao() throws UnirestException {
        String cpf = geradorCpf.cpf();
        simulacaoDTO.setCpf(cpf);
        response = request.PostSimulacao(simulacaoDTO);
        simulacaoDTO.setNome("Teste de Autlizacao");
        simulacaoDTO.setEmail("emaelatualizado@email.com");
        response = request.PutSimulacao(simulacaoDTO,cpf);

    }

    @Quando("informo o cpf invalido de atualizacao")
    public void informo_cpf_invalido_de_atualizacao(String id) throws UnirestException {

        String cpf = "63419532083";
        simulacaoDTO.setCpf(cpf);
        response = request.PostSimulacao(simulacaoDTO);
        simulacaoDTO.setNome("Teste de Autlizacao");
        simulacaoDTO.setEmail("emaelatualizado@email.com");
        cpf = geradorCpf.cpf();
        response = request.PutSimulacao(simulacaoDTO,cpf);

    }



    @Entao("o sistema deve retornar um status {int} de atualizacao")
    public void sistema_retorna_atulizacao(Integer statuscode){
        Integer code = response.getStatus();
        Assert.assertEquals(code, statuscode);

    }
}
