package infrastructure.persistence.xlsx;

import application.dto.funcionario.FuncionarioControllerRequest;
import domain.model.valueobjects.Email;
import domain.model.valueobjects.Telefone;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LerExcel {

    public List<FuncionarioControllerRequest> lerExcel(String filepath) throws IOException {

        List<FuncionarioControllerRequest> funcionarios = new ArrayList<>();

        try (FileInputStream stream = new FileInputStream(filepath);
             XSSFWorkbook workbook = new XSSFWorkbook(stream)) {

            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                if (row.getRowNum() == 0) {
                    continue;
                }

                try {
                    Iterator<Cell> cellIterator = row.cellIterator();

                    String nome = "";
                    String emailString = "";
                    String telefoneString = "";
                    String cargo = "";
                    String departamento = "";

                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        int columnIndex = cell.getColumnIndex();

                        switch (columnIndex) {
                            case 0 -> nome = cell.toString();
                            case 1 -> emailString = cell.toString();
                            case 2 -> telefoneString = cell.toString();
                            case 3 -> cargo = cell.toString();
                            case 4 -> departamento = cell.toString();
                        }
                    }

                    Email email = new Email(emailString);
                    Telefone telefone = new Telefone(telefoneString);

                    funcionarios.add(new FuncionarioControllerRequest(nome, email, telefone, cargo, departamento));

                } catch (Exception e) {

                    System.err.println("AVISO: Erro ao processar a linha " + (row.getRowNum() + 1) + " da planilha. Causa: " + e.getMessage());
                }
            }
            return funcionarios;
        }
    }
}