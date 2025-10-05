package application.dto.curso;

public class DetalheCursoResponse {
    private int idCurso;
    private String nomeCurso;
    private String descricao;
    private String statusPessoal;
    private String statusGeral;

    public DetalheCursoResponse() {}

    public DetalheCursoResponse(int idCurso, String nomeCurso, String descricao, String statusPessoal, String statusGeral) {
        this.idCurso = idCurso;
        this.nomeCurso = nomeCurso;
        this.descricao = descricao;
        this.statusPessoal = statusPessoal;
        this.statusGeral = statusGeral;
    }

    public int getIdCurso() { return idCurso; }
    public void setIdCurso(int idCurso) { this.idCurso = idCurso; }
    public String getNomeCurso() { return nomeCurso; }
    public void setNomeCurso(String nomeCurso) { this.nomeCurso = nomeCurso; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public String getStatusPessoal() { return statusPessoal; }
    public void setStatusPessoal(String statusPessoal) { this.statusPessoal = statusPessoal; }
    public String getStatusGeral() { return statusGeral; }
    public void setStatusGeral(String statusGeral) { this.statusGeral = statusGeral; }
}

