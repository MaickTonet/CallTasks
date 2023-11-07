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
    private TipoChamado tipo;
    private int prioridade;

    public Chamado(String descricao, TipoChamado tipo, int prioridade) {
        this.descricao = descricao;
        this.tipo = tipo;
        this.prioridade = prioridade;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public TipoChamado getTipo() {
        return tipo;
    }

    @Override
    public int compareTo(Chamado outroChamado) {
        return Integer.compare(this.prioridade, outroChamado.prioridade);
    }
}

class TipoChamado {
    private String nome;

    public TipoChamado(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
