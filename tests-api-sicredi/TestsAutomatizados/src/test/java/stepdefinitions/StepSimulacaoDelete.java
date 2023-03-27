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
import util.TransformacaoJson;

public class StepSimulacaoDelete {
    GeradorCPF geradorCpf = new GeradorCPF();
    SimulacaoDTO simulacaoDTO;

    SimulacaoDTO simulacaoDTOTransformado;
    MontagemDTO montagemDTO = new MontagemDTO();
    APIRequest request = new APIRequest();
    HttpResponse<String> response;
    TransformacaoJson transformacaoJson = new TransformacaoJson();

    Long idSimulacao;



    //Dado
    @Dado("que sera realizado um delete de uma simulação")
    public void montoArquivo_delete_simulacao(){
        simulacaoDTO = montagemDTO.montarLoteDTOSimulacao();

    }

    @Quando("informo o id valido")
    public void informo_id_valido() throws UnirestException {
        String cpf = geradorCpf.cpf();
        simulacaoDTO.setCpf(cpf);
        response = request.PostSimulacao(simulacaoDTO);
        String body = response.getBody();
        simulacaoDTOTransformado = transformacaoJson.stringParaJson(body);
        this.idSimulacao = simulacaoDTOTransformado.getId();
        response = request.DeleteSimulacao(idSimulacao);

    }

    @Quando("informo o id {string} invalido")
    public void informo_id_invalido(String id) throws UnirestException {

        response = request.DeleteSimulacao(Long.valueOf(id));

    }



    @Entao("o sistema deve retornar um status {int} de delete")
    public void sistema_retorna_delete(Integer statuscode){
        Integer code = response.getStatus();
        Assert.assertEquals(code, statuscode);

    }
}
