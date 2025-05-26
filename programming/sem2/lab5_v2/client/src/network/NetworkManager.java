package network;

import network.drivers.INetworkDriver;
import shared.objects.NetworkResponseDTO;

import java.io.*;

/**
 * Управление получением и отправкой данных на клиенте
 */
public class NetworkManager {
    INetworkDriver driver;

    /**
     * @param driver драйвер для взаимодействия по сети
     */
    public NetworkManager(INetworkDriver driver) {
        this.driver = driver;
        try {
            this.driver.init();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Отправка данных
     * @param obj отправляемый объект
     * @throws IOException если не удалось отправить
     */
    public void send(Object obj) throws IOException{
        this.driver.send(
                this.serialize(obj)
        );
    }

    /**
     * Получение данных
     * @return результат обработки команды сервером
     * @throws IOException если возникли проблемы с сетью или не удалось десериализовать
     * @throws ClassNotFoundException если не получилось десериализовать
     */
    public NetworkResponseDTO receive() throws IOException, ClassNotFoundException{
        return this.deserialize(
                this.driver.receive()
        );
    }

    /**
     * Сериализация отправляемых данных
     * TODO: в отдельный файл
     * @param obj объект, который нужно превратить в массив байтов
     * @return данные для отправки
     * @throws IOException если не удалось сериализовать
     */
    private byte[] serialize(Object obj) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(obj);
        oos.close();
        return bos.toByteArray();
    }

    /**
     * Десериализация данных
     * TODO: В отдельный файл
     * @param bytes массив байтов, который нужно десериализовать
     * @return результат десериазизации
     * @throws IOException если не удалось десериализовать байты
     * @throws ClassNotFoundException если не удалось приведение типов
     */
    private NetworkResponseDTO deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        //if (bytes == null) return null;
        InputStream is = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(is);
        return (NetworkResponseDTO) ois.readObject();
    }
}
