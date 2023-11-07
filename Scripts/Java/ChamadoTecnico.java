class ChamadoTecnico {
    private int numeroChamado;
    private String descricao;
    private String status;
    private String tecnicoResponsavel;

    public ChamadoTecnico(int numeroChamado, String descricao, String tecnicoResponsavel) {
        this.numeroChamado = numeroChamado;
        this.descricao = descricao;
        this.status = "Aberto";
        this.tecnicoResponsavel = tecnicoResponsavel;
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

    public String getTecnicoResponsavel() {
        return tecnicoResponsavel;
    }
}
