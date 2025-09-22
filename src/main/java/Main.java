import model.Funcionario;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        LerExcel lerExcel = new LerExcel();

        Scanner sc = new Scanner(System.in);

        List<Funcionario> funcionarios = lerExcel.lerExcel(sc.nextLine());

        for (Funcionario f : funcionarios) {
            System.out.println(f.toString());
        }
    }
}
