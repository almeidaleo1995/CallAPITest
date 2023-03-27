# language: pt
# enconding:utf-8


@Simulaçãoo

Funcionalidade: Verificar comportamento da API ao realizar uma simulação

  @InserirSimulacaoValida
Esquema do Cenário: Validar a inserção de uma simulação
Dado que sera realizado uma simulação
Quando informo o cpf <cpf>, email <email>, valor <valor>, parcelas <parcela>, seguro <seguro>
Então o sistema deve retornar um status <statuscode>


Exemplos:
| cpf              | email             | valor  | parcela | seguro     | statuscode  |
| "33570784061"    | "teste@teste.com" | 1600   |    6    |  "true"    |   201       |




  @InserirSimulacaoInvalida
  Esquema do Cenário: Validar a inserção de uma simulação invalida
    Dado que sera realizado uma simulação
    Quando informo o email <email>, valor <valor>, parcelas <parcela>, seguro <seguro> com dados invalidos
    Então o sistema deve retornar um status <statuscode>
    E o retorno conter a seguinte mensagem <mensagem>


    Exemplos:
      |    email         | valor  | parcela  | seguro     | statuscode  | mensagem                                   |
      |"emailinvalido"   | 1600   |    6     |  "true"    |   400       | "E-mail deve ser um e-mail válido"         |
      |"teste@teste.com" | 200    |    6     |  "true"    |   400       | "Valor deve ser maior ou igual a R$ 1.000" |
      |"teste@teste.com" | 50000  |    6     |  "true"    |   400       | "Valor deve ser menor ou igual a R$ 40.000"|
      | "teste@teste.com"| 1600   |    1     |  "true"    |   400       |"Parcelas deve ser igual ou maior que 2"    |
      | "teste@teste.com"| 1600   |    50    |  "true"    |   400       | "Parcelas deve ser igual ou menor que 48"  |

  @InserirSimulacaoDuplicada
  Esquema do Cenário: Validar a inserção de uma simulação duplicada
    Dado que sera realizado uma simulação
    Quando informo o cpf <cpf> ja utilizado em uma requisao anterior
    Então o sistema deve retornar um status <statuscode>
    E o retorno conter a seguinte mensagem <mensagem>


    Exemplos:
      | cpf              | statuscode  |  mensagem      |
      | "94629364048"    |   400       |"CPF duplicado" |

  @InserirSimulacaoCPFinvalido
  Esquema do Cenário: Validar a inserção de uma simulação com cpf invalido
    Dado que sera realizado uma simulação
    Quando informo o cpf <cpf> invalido na adição de simulação
    Então o sistema deve retornar um status <statuscode>


    Exemplos:
      | cpf              | statuscode  |
      | "***********"    |   400       |
      | "999.999.999-99" |   400       |
      | "1234"           |   400       |

  @ConsultarSimulacaoValida
  Esquema do Cenário: Validar consulta de simulação valida
    Dado que sera realizado uma consulta de simulação
    Quando informo o cpf <cpf>
    Então o sistema deve retornar um status <statuscode> de consulta


    Exemplos:
      | cpf              |  statuscode  |
      | "33570784061"    |    200       |


  @ConsultarimulacaoInvalida
  Esquema do Cenário: Validar consulta de simulação invalida
    Dado que sera realizado uma consulta de simulação
    Quando informo o cpf <cpf> invalido
    Então o sistema deve retornar um status <statuscode> de consulta


    Exemplos:
      | cpf              |  statuscode  |
      | "62698066075"    |    404       |
      | "***********"    |    404       |
      | "999.999.999-99" |    404       |
      | "62698066075"    |    404       |

  @DeletarSimulacaoValida
  Esquema do Cenário: Validar delete de uma simulação
    Dado que sera realizado um delete de uma simulação
    Quando informo o id valido
    Então o sistema deve retornar um status <statuscode> de delete


    Exemplos:
         |  statuscode  |
         |    200       |

  @DeletarSimulacaoInvalida
  Esquema do Cenário: Validar delete de uma simulação invalida
    Dado que sera realizado um delete de uma simulação
    Quando informo o id <id> invalido
    Então o sistema deve retornar um status <statuscode> de delete


    Exemplos:
      |  id           |  statuscode  |
      |  "99999999"   |    400       |
      |  "00000000"   |    400       |



  @AtualizarSimulacaoValido
  Esquema do Cenário: Validar autualização de uma simulação
    Dado que sera realizado um update de uma simulação
    Quando informo o cpf valido de atualizacao
    Então o sistema deve retornar um status <statuscode> de atualizacao


    Exemplos:
      |  statuscode  |
      |    200       |

  @AtualizarSimulacaoInvalido
  Esquema do Cenário: Validar autualização de uma simulação
    Dado que sera realizado um update de uma simulação
    Quando informo o cpf valido de atualizacao
    Então o sistema deve retornar um status <statuscode> de atualizacao


    Exemplos:
      |  statuscode  |
      |    400       |

  @ConsultaSimulacoes
  Esquema do Cenário: Validar autualização de todas as simulações
    Dado que sera realizado uma consulta de todas as simulações
    Quando realizo a consulta
    Então o sistema deve retornar um status <statuscode> de consulta de simulacoes


    Exemplos:
      |  statuscode  |
      |    200       |





