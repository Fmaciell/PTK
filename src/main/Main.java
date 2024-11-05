package main;

import modelo.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Estacionamento estacionamento = new Estacionamento();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Cadastrar Vaga");
            System.out.println("2. Registrar Entrada de Veículo");
            System.out.println("3. Registrar Saída de Veículo");
            System.out.println("4. Relatório de Vagas Ocupadas");
            System.out.println("5. Histórico de Veículo");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                
                System.out.print("Digite o número da vaga: ");
                int numeroVaga = scanner.nextInt();
                scanner.nextLine(); 

                System.out.print("Digite o tamanho da vaga (pequeno, médio, grande): ");
                String tamanhoVaga = scanner.nextLine();

                
                System.out.print("A vaga está disponível? (sim/nao): ");
                String disponibilidade = scanner.nextLine().toLowerCase();

                boolean isDisponivel = false; 
                if (disponibilidade.equals("sim")) {
                    isDisponivel = true; 
                }

                
                Vaga novaVaga = new Vaga(numeroVaga, tamanhoVaga, isDisponivel);
                estacionamento.adicionarVaga(novaVaga);

                System.out.println("Vaga cadastrada com sucesso!");
            } else if (opcao == 2) {
                
                System.out.print("Placa do veículo: ");
                String placa = scanner.nextLine();
                System.out.print("Modelo do veículo: ");
                String modelo = scanner.nextLine();
                System.out.print("Tamanho do veículo (pequeno, médio, grande): ");
                String tamanho = scanner.nextLine();

                
                Veiculo veiculo = new Veiculo(placa, modelo, tamanho);
                estacionamento.registrarEntrada(veiculo);
            } else if (opcao == 3) {
                
                System.out.print("Placa do veículo para saída: ");
                String placa = scanner.nextLine();

                Veiculo veiculo = new Veiculo(placa, "", "");
                estacionamento.registrarSaida(veiculo);
            } else if (opcao == 4) {
                estacionamento.relatorioVagasOcupadas();
            } else if (opcao == 5) {
                System.out.print("Placa do veículo para histórico: ");
                String placa = scanner.nextLine();
                estacionamento.historicoVeiculo(placa);
            } else if (opcao == 6) {
                System.out.println("Saindo...");
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}
