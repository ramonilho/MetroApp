package br.com.ramonilho.metroapp.api;

import java.util.List;

import br.com.ramonilho.metroapp.model.Line;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by logonrm on 26/06/2017.
 */

public interface LineAPI {

    @GET("/linhas")
    Call<List<Line>> getLines();

}
