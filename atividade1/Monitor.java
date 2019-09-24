package atividade1;

/**
 * Monitor
 */
public class Monitor {
    String buffer[];
    int inicio;
    int fim;
    int quantidade;
    int tamanho;

    public Monitor(int tamanho){
        this.inicio = 0;
        this.fim = 0;
        this.quantidade = 0;
        this.tamanho = tamanho;
        this.buffer = new String[tamanho];
    }

    public synchronized String take() {
        if (quantidade == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                System.out.println("Erro na função take");
            }
        }
            this.quantidade--;
            return this.buffer[this.fim];
    }

    public synchronized void put(String message) {
        while() {
            try {
                this.wait();
            } catch (InterruptedException e) {
                System.out.println("Erro na função put");
            }
        }
            this.quantidade++;
            this.buffer[this.inicio] = message;
            this.inicio++;
            this.notifyAll();
    }
}