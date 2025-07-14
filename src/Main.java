import java.io.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String text = "public enum MonitorType {\n" +
                "    IPS(\"tip IPS\"),TN(\"tip TN\"),VA(\"ttip VA\");\n" +
                "\n" +
                "    private String translation;\n" +
                "\n" +
                "    MonitorType(String translation){\n" +
                "        this.translation = translation;\n" +
                "    }\n" +
                "    public String getTranslation() {\n" +
                "        return translation;";

        String filePath = "C:\\Users\\adani\\OneDrive\\Рабочий стол\\таро\\steam.txt";

        try {
            FileOutputStream folder = new FileOutputStream(filePath);

             byte[] buf = text.getBytes();
             folder.write(buf);
             System.out.println("запись прошла успешно");

    } catch (FileNotFoundException e) {
            throw new MyException("Не удалось найти файл" + e.getMessage(), e);
        } catch (IOException e) {
            // Перехватываем IOException и выбрасываем MyFileWriteException
            throw new MyException("Ошибка при записи в файл: " + e.getMessage(), e);
        } catch (SecurityException e) {
            // Перехватываем SecurityException и выбрасываем MyFileWriteException
            throw new MyException("Ошибка безопасности при записи в файл: " + e.getMessage(), e);
        }
        try {
            readAndPrintFileContent(filePath);
        } catch (FileNotFoundException e) {
            System.err.println("Ошибка: Файл не найден при чтении: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Ошибка при чтении из файла: " + e.getMessage());
        } catch (MyException e) {
            System.err.println("Критическая ошибка при работе с файлом (чтение): " + e.getMessage());
        }
    }
    public static void readAndPrintFileContent(String filePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            int byteData;
            while ((byteData = fis.read()) != -1) {
                System.out.print((char) byteData);
            }
            System.out.println();
        }
    }
}


