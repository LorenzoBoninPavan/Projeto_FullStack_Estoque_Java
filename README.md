# Sistema de Gerenciamento de Estoque desenvolvido em 2023
  Este projeto consiste num sistema desktop desenvolvido em Java com interface gráfica baseada em Java Swing e persistência de dados em MySQL. A aplicação foi estruturada seguindo o padrão de arquitetura DAO (Data Access Object) e o modelo de classes de domínio (Beans), oferecendo um painel interativo para o gerenciamento de rotinas de stock, tais como o cadastro e controle de fornecedores e registos de compras

#Funcionalidades e Estrutura do Sistema
  Interface Gráfica Base (TelaPrincipal): Painel centralizado em formato JDesktopPane com menus interativos para navegação fluida entre os módulos do sistema.

  Gestão Completa de Fornecedores:
    Formulário interativo para cadastro, edição, limpeza de campos e exclusão de fornecedores (Razão Social, CNPJ, E-mail e Telefone).
    Listagem dinâmica integrada em tabela (JTable) com suporte a eventos de clique para preenchimento e seleção direta de registos.

  Módulo de Compras: Estrutura pronta para o registo e rastreio de datas de compras efetuadas, conectando o fluxo de aquisições ao ecossistema do stock.
  Camada de Conexão Segura: Gerenciador centralizado de conexões com o banco de dados via JDBC/PDO (MySQL), implementando o tratamento adequado de exceções e o encerramento seguro de recursos abertos (Connection, PreparedStatement e ResultSet).

#Tecnologias Utilizadas
  Linguagem: Java (Orientação a Objetos)
  Interface Gráfica: Java Swing/JInternalFrame
  Banco de Dados; MySQL
  Arquitetura: Padrão DAO + Beans + Conexão Modularizada
