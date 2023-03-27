package util;

import com.fasterxml.jackson.databind.ObjectMapper;
import dominio.SimulacaoDTO;

import java.io.IOException;

public class TransformacaoJson {

    public SimulacaoDTO stringParaJson(String body){
        ObjectMapper mapper = new ObjectMapper();
        SimulacaoDTO simulacaoDTOTransformado = new SimulacaoDTO();
        try {
            simulacaoDTOTransformado = mapper.readValue(body, SimulacaoDTO.class);
        }catch(IOException e){
            e.printStackTrace();
        }
        return simulacaoDTOTransformado;
    }
}
