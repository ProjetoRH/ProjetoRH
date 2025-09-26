package view.utils;

public class ConsoleUtils {
    public static void limparTela() {
        try {
            System.getProperty("os.name").contains("Windows");
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch(Exception e){
            throw new RuntimeException("Erro ao limpar tela: " + e);
        }
    }
}

