package infrastructure.persistence.xlsx;

import domain.model.Funcionario;
import domain.model.valueobjects.Email;
import domain.model.valueobjects.Telefone;
import org.apache.poi.ss.formula.functions.T;
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

    public List<Funcionario> lerExcel(String filepath) throws IOException {

        List<Funcionario> funcionarios = new ArrayList<>();
        FileInputStream stream = new FileInputStream(filepath);

        XSSFWorkbook workbook = new XSSFWorkbook(stream);
        XSSFSheet sheet = workbook.getSheetAt(0);

        Iterator<Row> rowIterator = sheet.iterator();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            if (row.getRowNum() == 0) continue;

            Iterator<Cell> cellIterator = row.cellIterator();

            String nome = "";
            String emailString = "";
            String telefoneString = "";
            String cargo = "";
            String departamento = "";

            Email email = null;
            Telefone telefone = null;

            while (cellIterator.hasNext()) {

                Cell cell = cellIterator.next();
                switch (cell.getColumnIndex()) {
                    case 0:
                        nome = cell.toString();
                        break;
                    case 1:
                        emailString = cell.toString();
                        email = new Email(emailString);
                        break;
                    case 2:
                        telefoneString = cell.toString();
                        telefone = new Telefone(telefoneString);
                        break;
                    case 3:
                        cargo = cell.toString();
                        break;
                    case 4:
                        departamento = cell.toString();
                        break;
                }
            }
            funcionarios.add(new Funcionario(nome, email, telefone, cargo, departamento));
        }
        return funcionarios;
    }

}

