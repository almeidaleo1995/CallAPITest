package dominio;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;


@Getter
@Setter
@NoArgsConstructor
public class SimulacaoDTO {

    @JsonProperty(value = "id", required = true)
    private Long id;

    @JsonProperty(value = "nome")
    private String nome;

    @JsonProperty(value = "cpf")
    private String cpf;

    @JsonProperty(value = "email")
    private String email;

    @JsonProperty(value = "valor")
    private BigDecimal valor;

    @JsonProperty(value = "parcelas")
    private Integer parcelas;

    @JsonProperty(value = "seguro")
    private Boolean seguro;


}
