package modelo;

public class Vaga {
    private int numero;       
    private String tamanho;   
    private boolean disponivel;

    
    public Vaga(int numero, String tamanho, boolean disponivel) {
        this.numero = numero;
        this.tamanho = tamanho;
        this.disponivel = disponivel;  
    }

    
    public int getNumero() {
        return numero;
    }

    public String getTamanho() {
        return tamanho;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    
    public void ocupar() {
        this.disponivel = false; 
    }

    
    public void liberar() {
        this.disponivel = true; 
    }
}
