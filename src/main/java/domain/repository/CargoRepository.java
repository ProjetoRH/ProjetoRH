package domain.repository;

public interface CargoRepository {

    public int buscarIdCargo(String nome, String departamento);

    public int cadastrarCargo(String nome, String departamento);
}
