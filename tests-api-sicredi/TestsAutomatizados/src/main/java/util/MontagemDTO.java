package util;

import dominio.SimulacaoDTO;

import java.math.BigDecimal;

public class MontagemDTO {

    public SimulacaoDTO montarLoteDTOSimulacao(){
        SimulacaoDTO simulacaoDTO = new SimulacaoDTO();
        simulacaoDTO.setNome("Teste Cadastro Simulação");
        simulacaoDTO.setCpf("46723015088");
        simulacaoDTO.setEmail("email@teste.com");
        simulacaoDTO.setValor(BigDecimal.valueOf(1200));
        simulacaoDTO.setParcelas(4);
        simulacaoDTO.setSeguro(true);

        return simulacaoDTO;
    }
}
