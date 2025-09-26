package infrastructure.persistence;

import domain.model.Funcionario;
import domain.repository.FuncionarioRepository;

import java.util.Optional;

public class    FuncionarioRepositoryImpl implements FuncionarioRepository {
    @Override
    public void cadastrarFuncionario(Funcionario funcionario) {
        String query = """
                INSERT INTO Funcionario
                
                """

    }

    @Override
    public Optional<Funcionario> buscarFuncionario(int id) {
        return Optional.empty();
    }

    @Override
    public void desativarFuncionario(int id) {

    }

    @Override
    public Optional<Funcionario> listarFuncionario() {
        return Optional.empty();
    }
}
