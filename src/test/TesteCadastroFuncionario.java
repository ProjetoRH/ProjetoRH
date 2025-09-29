package test;

import application.service.FuncionarioService;
import domain.model.Funcionario;
import domain.model.valueobjects.Email;
import domain.model.valueobjects.Telefone;
import domain.repository.CargoRepository;
import domain.repository.FuncionarioRepository;
import infrastructure.persistence.CargoRepositoryImpl;
import infrastructure.persistence.FuncionarioRepositoryImpl;

public class TesteCadastroFuncionario {
    public static void main(String[] args) {
        FuncionarioRepository funcionarioRepository = new FuncionarioRepositoryImpl();
        CargoRepository cargoRepository = new CargoRepositoryImpl();
        FuncionarioService service = new FuncionarioService(funcionarioRepository, cargoRepository);

        Funcionario funcionario = new Funcionario(
                "João Silva",
                new Email("joao.silva@email.com"),
                new Telefone("11999999999"),
                "Analista",
                "TI"
        );

        try {
            service.cadastrarFuncionario(funcionario);
            System.out.println("Funcionário cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar funcionário: " + e.getMessage());
        }
    }
}

