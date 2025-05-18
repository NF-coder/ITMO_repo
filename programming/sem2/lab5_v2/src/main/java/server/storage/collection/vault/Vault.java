package server.storage.collection.vault;

import server.storage.collection.drivers.IStructDriver;
import server.storage.objects.City;
import server.storage.objects.exceptions.UnacceptableValue;

import java.io.*;

/**
 * Класс, отвечающий за сохранение коллекции на диск
 */
public class Vault {
    private final String path = System.getenv("COLLECTION_HOME");

    /**
     * Сохранение данных на диск
     * @param data csv-строка
     * @throws IOException если не удалось сохранить данные
     */
    public synchronized void save(String data) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        writer.write(data);
        writer.flush();
    }

    /**
     * Загрузка данных с диска
     * @param driver драйвер структуры данных
     * @throws IOException если не удалось считать данные
     */
    public synchronized void load(IStructDriver driver) throws IOException {
        driver.clearCollection();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            reader.lines()
                    .forEach(elem -> {
                        try {
                            City newCity = new City();
                            newCity.fromCSVString(elem);
                            driver.add(newCity);
                        }
                        catch (UnacceptableValue ignored) {}

                    });
        } catch (IOException e) {
            System.out.println("Failed to save data: " + e.getMessage());
        }
    }
}
