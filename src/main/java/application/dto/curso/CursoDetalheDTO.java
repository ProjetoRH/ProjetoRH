package application.dto.curso;

public class CursoDetalheDTO {
    private final int idCurso;
    private final String nomeCurso;
    private final String descricaoCompleta;
    private final String statusPessoal;
    private final String statusGeral;

    public CursoDetalheDTO(int idCurso, String nomeCurso, String descricaoCompleta, String statusPessoal, String statusGeral) {
        this.idCurso = idCurso;
        this.nomeCurso = nomeCurso;
        this.descricaoCompleta = descricaoCompleta;
        this.statusPessoal = statusPessoal;
        this.statusGeral = statusGeral;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public String getDescricaoCompleta() {
        return descricaoCompleta;
    }

    public String getStatusPessoal() {
        return statusPessoal;
    }

    public String getStatusGeral() {
        return statusGeral;
    }
}

