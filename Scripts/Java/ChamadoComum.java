class ChamadoComum {
    private int numeroChamado;
    private String descricao;
    private String status;

    public ChamadoComum(int numeroChamado, String descricao) {
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
