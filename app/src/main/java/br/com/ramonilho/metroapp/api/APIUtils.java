package br.com.ramonilho.metroapp.api;

/**
 * Created by logonrm on 26/06/2017.
 */

public class APIUtils {
    private APIUtils() {}

    public static final String BASE_URL = "http://10.3.1.9:3000";

    public static LineAPI getLineAPIVersion() {
        return RetrofitClient.getClient(BASE_URL).create(LineAPI.class);
    }
}
