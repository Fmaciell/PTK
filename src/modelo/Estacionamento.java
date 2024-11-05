package modelo;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {
    private List<Vaga> vagas; 
    private List<Veiculo> veiculos; 

    
    public Estacionamento() {
        vagas = new ArrayList<>();
        veiculos = new ArrayList<>();
    }

    
    public void adicionarVaga(Vaga vaga) {
        vagas.add(vaga); 
    }

   
    public Vaga buscarVagaDisponivel(String tamanhoVeiculo) {
        for (Vaga vaga : vagas) {
            if (vaga.isDisponivel() && vaga.getTamanho().equals(tamanhoVeiculo)) {
                return vaga; 
            }
        }
        return null; 
    }

    
    public void registrarEntrada(Veiculo veiculo) {
        Vaga vagaDisponivel = buscarVagaDisponivel(veiculo.getTamanho());
        if (vagaDisponivel != null) {
            vagaDisponivel.ocupar();
            veiculo.setHoraEntrada(java.time.LocalDateTime.now());
            veiculos.add(veiculo);
            System.out.println("Veículo " + veiculo.getPlaca() + " estacionado na vaga " + vagaDisponivel.getNumero());
        } else {
            System.out.println("Não há vaga disponível para o veículo " + veiculo.getPlaca());
        }
    }

    
    public void registrarSaida(Veiculo veiculo) {
        for (Vaga vaga : vagas) {
            if (!vaga.isDisponivel()) {
                for (Veiculo v : veiculos) {
                    if (v.getPlaca().equals(veiculo.getPlaca())) {
                        v.setHoraSaida(java.time.LocalDateTime.now());
                        long tempo = v.calcularTempoPermanencia();
                        double valor = calcularValor(tempo);
                        vaga.liberar();
                        System.out.println("Veículo " + veiculo.getPlaca() + " saiu. Tempo de permanência: " 
                                + tempo + " horas. Valor a pagar: R$ " + valor);
                        return;
                    }
                }
            }
        }
    }

    
    public double calcularValor(long tempo) {
        if (tempo <= 1) {
            return 5.00;
        } else if (tempo <= 3) {
            return 10.00;
        } else {
            return 15.00;
        }
    }

    
    public void relatorioVagasOcupadas() {
        System.out.println("Vagas Ocupadas:");
        for (Vaga vaga : vagas) {
            if (!vaga.isDisponivel()) {
                System.out.println("Vaga " + vaga.getNumero() + " - " + vaga.getTamanho());
            }
        }
    }

    
    public void historicoVeiculo(String placa) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equals(placa)) {
                System.out.println("Histórico de " + placa + ":");
                System.out.println("Entrada: " + veiculo.getHoraEntrada());
                System.out.println("Saída: " + veiculo.getHoraSaida());
                System.out.println("Tempo de permanência: " + veiculo.calcularTempoPermanencia() + " horas");
                System.out.println("Valor pago: R$ " + calcularValor(veiculo.calcularTempoPermanencia()));
            }
        }
    }
}
