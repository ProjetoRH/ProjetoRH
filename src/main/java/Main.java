import application.service.FuncionarioService;
import application.service.UsuarioService;
import domain.model.Funcionario;
import domain.repository.CargoRepository;
import domain.repository.FuncionarioRepository;
import domain.repository.UsuarioRepository;
import infrastructure.persistence.CargoRepositoryImpl;
import infrastructure.persistence.FuncionarioRepositoryImpl;
import infrastructure.persistence.UsuarioRepositoryImpl;
import infrastructure.persistence.xlsx.LerExcel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final LerExcel leitorExcel = new LerExcel();

    public static void main(String[] args) {

    }
}