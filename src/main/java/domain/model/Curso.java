package domain.model;

public class Curso {

     int id_curso;
     String nome;
     String data_inicio;
     String data_termino;
     String statusCurso;

    public Curso(int id_curso, String nome, String data_inicio, String data_termino, String statusCurso) {
        this.id_curso = id_curso;
        this.nome = nome;
        this.data_inicio = data_inicio;
        this.data_termino = data_termino;
        this.statusCurso = statusCurso;
    }

    public Curso() {

    }

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(String data_inicio) {
        this.data_inicio = data_inicio;
    }

    public String getData_termino() {
        return data_termino;
    }

    public void setData_termino(String data_termino) {
        this.data_termino = data_termino;
    }

    public String getStatusCurso() {
        return statusCurso;
    }

    public void setStatusCurso(String statusCurso) {
        this.statusCurso = statusCurso;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "nome='" + nome + '\'' +
                ", data início='" + data_inicio + '\'' +
                ", data término='" + data_termino + '\'' +
                ", status='" + statusCurso + '\'' +
                '}';
    }

}
