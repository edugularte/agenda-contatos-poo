# Agenda de Contatos em Java

Uma aplicação completa de agenda de contatos desenvolvida em Java, aplicando os principais conceitos de Programação Orientada a Objetos.

## Funcionalidades

- ✅ Adicionar contatos pessoais e profissionais
- ✅ Listar todos os contatos
- ✅ Buscar contatos por nome ou e-mail
- ✅ Editar contatos
- ✅ Remover contatos
- ✅ Armazenamento em memória com ArrayList
- ✅ Tratamento de exceções

## Estrutura do Projeto

src/br/com/agenda/

├── model/ # Classes de domínio

├── service/ # Lógica de negócio

├── exception/ # Tratamento de exceções

└── Main.java # Classe principal

## Conceitos de POO Aplicados

- **Classes e Objetos**: Modelagem dos elementos da agenda
- **Encapsulamento**: Atributos privados com getters/setters
- **Herança**: ContatoPessoal e ContatoProfissional herdam de Contato
- **Polimorfismo**: Sobrescrita do método toString()
- **Composição**: Contato contém Endereco
- **Tratamento de Exceções**: Validação de dados e operações

## Tecnologias

- Java 8+
- ArrayList para armazenamento
- Scanner para entrada de dados

## Como Executar

1. Clone o repositório
2. Compile os arquivos Java:
   ```bash
   javac -d bin src/br/com/agenda/**/*.java
