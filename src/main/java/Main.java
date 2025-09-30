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

        try (Scanner sc = new Scanner(System.in)) {
            // 1. OBTER O CAMINHO DO ARQUIVO
            System.out.println("Digite o caminho completo do arquivo Excel e pressione Enter:");
            String filepath = sc.nextLine();

            // 2. LER OS FUNCIONÁRIOS DO ARQUIVO
            System.out.println("Lendo o arquivo... Por favor, aguarde.");
            List<Funcionario> funcionarios = leitorExcel.lerExcel(filepath);
            System.out.println(">>> " + funcionarios.size() + " funcionários encontrados no arquivo.");

            // 3. INICIALIZAR DEPENDÊNCIAS (Repositórios e Serviços)
            // Aqui criamos as implementações concretas que se conectarão ao banco de dados
            FuncionarioRepository funcionarioRepository = new FuncionarioRepositoryImpl();
            CargoRepository cargoRepository = new CargoRepositoryImpl();
            UsuarioRepository usuarioRepository = new UsuarioRepositoryImpl(); // Assumindo que esta classe existe

            // O UsuarioService precisa do seu repositório
            UsuarioService usuarioService = new UsuarioService();

            // O FuncionarioService precisa de todos os outros para funcionar
            FuncionarioService funcionarioService = new FuncionarioService(
                    funcionarioRepository,
                    cargoRepository,
                    usuarioService
            );

            // 4. EXECUTAR A AÇÃO PRINCIPAL
            System.out.println("\nIniciando o processo de cadastro no banco de dados...");
            funcionarioService.cadastrarMultiplosFuncionarios(funcionarios);
            System.out.println("\n>>> PROCESSO CONCLUÍDO! Todos os funcionários foram cadastrados com sucesso.");

        } catch (IOException e) {
            System.err.println("\nERRO DE ARQUIVO: Não foi possível ler o arquivo. Verifique o caminho e as permissões.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("\nERRO DE BANCO DE DADOS: Ocorreu um problema durante o cadastro.");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("\nERRO INESPERADO: Ocorreu um erro geral na aplicação.");
            e.printStackTrace();
        }
    }
}