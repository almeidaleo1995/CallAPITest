# language: pt
# enconding:utf-8


@Restricao

Funcionalidade: Verificar comportamento da API ao realizar uma consulta de restrição

  @ConsultarCPF
Esquema do Cenário: Validar a consulta de restricao de CPF
Dado que sera realizado uma consulta de restricao
Quando informo o cpf <cpf> para consultar a restricao
Então o sistema deve retornar um status <statuscode> de consulta de restricao


Exemplos:
| cpf              | statuscode  |
| "97093236014"    |   200       |
| "84809766080"    |   200       |
| "62648716050"    |   200       |
| "26276298085"    |   200       |
| "01317496094"    |   200       |
| "55856777050"    |   200       |
| "19626829001"    |   200       |
| "24094592008"    |   200       |
| "58063164083"    |   200       |
| "63419532083"    |   204       |
| "83737304009"    |   204       |
| "83737304009"    |   204       |








