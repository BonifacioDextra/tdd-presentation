Feature: Leitura e manipulação de arquivos está funcionando?
  Queremos saber se os comportamentos do componente de manipulação dos arquivos estão corretos

  Scenario: Manipulação dos arquivos está funcionando
    Given carrega o arquivo "test.txt"
     When inverte o conteúdo do arquivo
      And salva novo arquivo "test2.txt"
      And carrega novo arquivo "test2.txt"
     Then verifica se o conteúdo está invertido