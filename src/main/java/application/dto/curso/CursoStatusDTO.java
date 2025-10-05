package application.dto.curso;

public class CursoStatusDTO {
    private final int idCurso;
    private final String nomeCurso;
    private final String statusPessoal;
    private final String statusGeral;

    public CursoStatusDTO(int idCurso, String nomeCurso, String statusPessoal, String statusGeral) {
        this.idCurso = idCurso;
        this.nomeCurso = nomeCurso;
        this.statusPessoal = statusPessoal;
        this.statusGeral = statusGeral;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public String getStatusPessoal() {
        return statusPessoal;
    }

    public String getStatusGeral() {
        return statusGeral;
    }
}

