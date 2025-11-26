package br.com.agenda;

import br.com.agenda.model.*;
import br.com.agenda.service.Agenda;
import br.com.agenda.exception.ContatoException;
import java.util.List;
import java.util.Scanner;

/**
 * CLASSE PRINCIPAL: Responsável pela interface com o usuário e execução do programa
 * CONTROLE DE FLUXO: Menu interativo e gerência das operações
 */
public class Main {
    // ATRIBUTOS: Agenda e Scanner para entrada de dados
    private static Agenda agenda = new Agenda();
    private static Scanner scanner = new Scanner(System.in);

    // MÉTODO main(): Ponto de entrada da aplicação
    public static void main(String[] args) {
        int opcao;
        
        do {
            exibirMenu();
            opcao = lerInteiro("Escolha uma opção: ");

            // CONTROLE DE FLUXO: Switch para opções do menu
            switch (opcao) {
                case 1 -> adicionarContato();
                case 2 -> listarContatos();
                case 3 -> buscarContato();
                case 4 -> editarContato();
                case 5 -> removerContato();
                case 0 -> System.out.println("Saindo da agenda...");
                default -> System.out.println("Opção inválida!");
            }
            
        } while (opcao != 0);
        
        scanner.close();
    }

    // MÉTODO exibirMenu(): Mostra as opções disponíveis
    private static void exibirMenu() {
        System.out.println("\n=== AGENDA DE CONTATOS ===");
        System.out.println("1. Adicionar Contato");
        System.out.println("2. Listar Contatos");
        System.out.println("3. Buscar Contato");
        System.out.println("4. Editar Contato");
        System.out.println("5. Remover Contato");
        System.out.println("0. Sair");
        System.out.println("==========================");
    }

    /**
     * MÉTODO adicionarContato(): Interface para adicionar novo contato
     * POLIMORFISMO: Pode criar ContatoPessoal ou ContatoProfissional tratados como Contato
     */
    private static void adicionarContato() {
        System.out.println("\n--- ADICIONAR CONTATO ---");
        
        System.out.println("Tipo de contato:");
        System.out.println("1. Pessoal");
        System.out.println("2. Profissional");
        int tipo = lerInteiro("Escolha: ");
        
        if (tipo != 1 && tipo != 2) {
            System.out.println("Tipo inválido!");
            return;
        }
        
        String nome = lerString("Nome: ");
        
        try {
            Contato contato; // POLIMORFISMO: Referência da classe base

            // HERANÇA: Criando instâncias das subclasses
            if (tipo == 1) {
                String aniversario = lerString("Data de aniversário: ");
                contato = new ContatoPessoal(nome, aniversario); // Instância de ContatoPessoal
            } else {
                String empresa = lerString("Empresa: ");
                String cargo = lerString("Cargo: ");
                contato = new ContatoProfissional(nome, empresa, cargo); // Instância de ContatoProfissional
            }
            
            // Adicionar telefones
            System.out.println("Telefones (digite 'fim' para parar):");
            while (true) {
                String telefone = lerString("Telefone: ");
                if (telefone.equalsIgnoreCase("fim")) break;
                contato.adicionarTelefone(telefone); // MÉTODO da classe Contato
            }
            
            // Adicionar emails
            System.out.println("Emails (digite 'fim' para parar):");
            while (true) {
                String email = lerString("Email: ");
                if (email.equalsIgnoreCase("fim")) break;
                contato.adicionarEmail(email); // MÉTODO da classe Contato
            }
            
            // Adicionar endereço (COMPOSIÇÃO: Contato tem um Endereco)
            System.out.println("Endereço (opcional - pressione Enter para pular):");
            String rua = lerString("Rua: ");
            if (!rua.isEmpty()) {
                String cidade = lerString("Cidade: ");
                String estado = lerString("Estado: ");
                String cep = lerString("CEP: ");
                Endereco endereco = new Endereco(rua, cidade, estado, cep); // COMPOSIÇÃO
                contato.setEndereco(endereco);
            }
            
            agenda.adicionarContato(contato); // MÉTODO da classe Agenda
            System.out.println("Contato adicionado com sucesso!");
            
        } catch (ContatoException e) {
            // TRATAMENTO DE EXCEÇÕES: Captura e trata exceções personalizadas
            System.out.println("Erro ao adicionar contato: " + e.getMessage());
        }
    }

    /**
     * MÉTODO listarContatos(): Lista todos os contatos
     * POLIMORFISMO: Chama toString() que se comporta diferente para cada tipo de contato
     */
    private static void listarContatos() {
        System.out.println("\n--- LISTA DE CONTATOS ---");
        List<Contato> contatos = agenda.listarTodos(); // MÉTODO da classe Agenda
        
        if (contatos.isEmpty()) {
            System.out.println("Nenhum contato cadastrado.");
        } else {
            for (int i = 0; i < contatos.size(); i++) {
                System.out.println("\nContato #" + (i + 1));
                // POLIMORFISMO: toString() se comporta diferente para cada tipo de contato
                System.out.println(contatos.get(i));
            }
        }
    }

    // MÉTODO buscarContato(): Interface para busca de contatos
    private static void buscarContato() {
        System.out.println("\n--- BUSCAR CONTATO ---");
        System.out.println("1. Por nome");
        System.out.println("2. Por email");
        int opcao = lerInteiro("Escolha: ");
        
        List<Contato> resultados;
        
        if (opcao == 1) {
            String nome = lerString("Nome: ");
            resultados = agenda.buscarPorNome(nome); // MÉTODO da classe Agenda
        } else if (opcao == 2) {
            String email = lerString("Email: ");
            resultados = agenda.buscarPorEmail(email); // MÉTODO da classe Agenda
        } else {
            System.out.println("Opção inválida!");
            return;
        }
        
        if (resultados.isEmpty()) {
            System.out.println("Nenhum contato encontrado.");
        } else {
            System.out.println("\nResultados da busca:");
            for (Contato contato : resultados) {
                // POLIMORFISMO: Cada contato mostra informações específicas no toString()
                System.out.println(contato);
            }
        }
    }

    // MÉTODO editarContato(): Interface para edição de contatos
    private static void editarContato() {
        System.out.println("\n--- EDITAR CONTATO ---");
        String nome = lerString("Nome do contato a editar: ");
        
        List<Contato> contatos = agenda.buscarPorNome(nome);
        
        if (contatos.isEmpty()) {
            System.out.println("Contato não encontrado!");
            return;
        }
        
        // Implementação simplificada - na prática, seria mais complexa
        System.out.println("Funcionalidade de edição avançada será implementada...");
    }

    // MÉTODO removerContato(): Interface para remoção de contatos
    private static void removerContato() {
        System.out.println("\n--- REMOVER CONTATO ---");
        String nome = lerString("Nome do contato a remover: ");
        
        if (agenda.removerContato(nome)) {
            System.out.println("Contato removido com sucesso!");
        } else {
            System.out.println("Contato não encontrado!");
        }
    }
    
    // MÉTODO lerString(): Auxiliar para entrada de strings
    private static String lerString(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    /**
     * MÉTODO lerInteiro(): Auxiliar para entrada de números inteiros
     * TRATAMENTO DE EXCEÇÕES: Trata entradas inválidas do usuário
     */
    private static int lerInteiro(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                int valor = Integer.parseInt(scanner.nextLine());
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um número válido!");
            }
        }
    }
}
