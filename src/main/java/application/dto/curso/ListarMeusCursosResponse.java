package application.dto.curso;

public class ListarMeusCursosResponse {
    private int idCurso;
    private String nomeCurso;
    private String statusPessoal;
    private String statusGeral;

    public ListarMeusCursosResponse() {}

    public ListarMeusCursosResponse(int idCurso, String nomeCurso, String statusPessoal, String statusGeral) {
        this.idCurso = idCurso;
        this.nomeCurso = nomeCurso;
        this.statusPessoal = statusPessoal;
        this.statusGeral = statusGeral;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getStatusPessoal() {
        return statusPessoal;
    }

    public void setStatusPessoal(String statusPessoal) {
        this.statusPessoal = statusPessoal;
    }

    public String getStatusGeral() {
        return statusGeral;
    }

    public void setStatusGeral(String statusGeral) {
        this.statusGeral = statusGeral;
    }
}

