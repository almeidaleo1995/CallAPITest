package request;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import dominio.SimulacaoDTO;
import org.json.JSONObject;

public class APIRequest {
    public static String baseLocal = "http://localhost:8080/api/v1/";

    public HttpResponse<String>  PostSimulacao(SimulacaoDTO payload) throws UnirestException {

        JSONObject json = new JSONObject(payload);

        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.post(baseLocal+ "simulacoes")
                .header("Content-Type", "application/json")
                .body(json)
                .asString();


        return response;


    }

    public HttpResponse<String> GetSimulacaoCPF(String cpf) throws UnirestException {

        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.get(baseLocal+ "simulacoes/"+ cpf)
                .asString();


        return response;


    }

    public HttpResponse<String> GetSimulacao() throws UnirestException {

        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.get(baseLocal+ "simulacoes")
                .asString();


        return response;


    }

    public HttpResponse<String> DeleteSimulacao(Long id) throws UnirestException {

        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.delete(baseLocal+ "simulacoes/" + id)
                .asString();



        return response;


    }

    public HttpResponse<String> PutSimulacao(SimulacaoDTO payload, String cpf) throws UnirestException {

        JSONObject json = new JSONObject(payload);
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.put(baseLocal+ "simulacoes/"+ cpf)
                .header("Content-Type", "application/json")
                .body(json)
                .asString();

        return response;


    }


    public HttpResponse<String> GetRestricoesCPF( String cpf) throws UnirestException {

        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.get(baseLocal+ "restricoes/"+ cpf)
                .asString();


        return response;


    }

}



