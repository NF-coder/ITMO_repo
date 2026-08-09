package storage.commands.components.sql;

import storage.commands.components.sql.operations.CollectionTable;
import storage.commands.components.sql.operations.DTOs.CityIdAndCreatorDTO;

import java.sql.SQLException;
import java.util.function.Function;

public class CheckOwner {
    public static Boolean apply(Long id, String creator){
        CityIdAndCreatorDTO info = null;
        try {
            info = SQLVault.connectionExecutor(
                    new CollectionTable()::getElemInfoById,
                    id
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return info.creator().equals(creator);
    }
    public static Boolean apply(String id, String creator){
        CityIdAndCreatorDTO info = null;
        try {
            info = SQLVault.connectionExecutor(
                    new CollectionTable()::getElemInfoById,
                    Long.parseLong(id)
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return info.creator().equals(creator);
    }
}
