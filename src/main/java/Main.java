import application.service.FuncionarioService;
import application.service.UsuarioService;
import domain.model.Funcionario;
import domain.model.valueobjects.Email;
import domain.model.valueobjects.Telefone;
import domain.repository.CargoRepository;
import domain.repository.FuncionarioRepository;
import infrastructure.persistence.CargoRepositoryImpl;
import infrastructure.persistence.FuncionarioRepositoryImpl;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {


            System.out.println("Erro ao cadastrar funcionário: " + e.getMessage());
        }
    }
}
