import java.util.PriorityQueue;

public class GerenciadorChamados {
    private PriorityQueue<Chamado> filaPrioridades;

    public GerenciadorChamados() {
        filaPrioridades = new PriorityQueue<Chamado>();
    }

    public void adicionarChamado(Chamado chamado) {
        filaPrioridades.add(chamado);
    }

    public Chamado atenderChamado() {
        return filaPrioridades.poll();
    }

    public boolean haChamadosPendentes() {
        return !filaPrioridades.isEmpty();
    }
}

class Chamado implements Comparable<Chamado> {
    private String descricao;
    private int prioridade;

    public Chamado(String descricao, int prioridade) {
        this.descricao = descricao;
        this.prioridade = prioridade;
    }

    public int getPrioridade() {
        return prioridade;
    }

    @Override
    public int compareTo(Chamado outroChamado) {
        return Integer.compare(this.prioridade, outroChamado.prioridade);
    }
}
