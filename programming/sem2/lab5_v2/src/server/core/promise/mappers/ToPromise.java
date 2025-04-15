package server.core.promise.mappers;

import server.core.promise.Promise;
import server.network.NetworkDTO;

public class ToPromise{
    public static Promise fromNetworkDTO (NetworkDTO data){
        return new Promise(
                data.opName(),
                data.args()
        );
    }
}
