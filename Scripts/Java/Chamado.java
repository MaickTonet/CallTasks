class Chamado {
    private int numeroChamado;
    private String descricao;
    private String status;

    public Chamado(int numeroChamado, String descricao) {
        this.numeroChamado = numeroChamado;
        this.descricao = descricao;
        this.status = "Aberto";
    }

    public void fecharChamado() {
        this.status = "Fechado";
    }

    public int getNumeroChamado() {
        return numeroChamado;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getStatus() {
        return status;
    }
}
