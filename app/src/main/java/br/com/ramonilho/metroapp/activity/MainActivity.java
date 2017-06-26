package br.com.ramonilho.metroapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import br.com.ramonilho.metroapp.R;
import br.com.ramonilho.metroapp.adapter.LineAdapter;
import br.com.ramonilho.metroapp.api.APIUtils;
import br.com.ramonilho.metroapp.api.LineAPI;
import br.com.ramonilho.metroapp.model.Line;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rvLines) RecyclerView rvLines;
    private LineAdapter lineAdapter;
    private LineAPI lineAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        rvLines = (RecyclerView) findViewById(R.id.rvLines);
        ButterKnife.bind(this);

        lineAdapter = new LineAdapter(new ArrayList<Line>());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvLines.setLayoutManager(layoutManager);
        rvLines.setAdapter(lineAdapter);
        rvLines.setHasFixedSize(true);
//        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
//        rvLines.addItemDecoration(itemDecoration);

        Log.i("MainActivity", "precarregando dados");
        carregaDados();
    }

    private void carregaDados(){
        lineAPI = APIUtils.getLineAPIVersion();
        Log.i("MainActivity", "carregando dados");

        lineAPI.getLines().enqueue(new Callback<List<Line>>() {
            @Override
            public void onResponse(Call<List<Line>> call, Response<List<Line>> response) {
                if (response.isSuccessful()) {
                    Log.i("MainActivityLine", response.body().toString());

                    lineAdapter.update(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Line>> call, Throwable t) {
                Log.i("MainActivity", "erro ao carregar dados: "+t.getLocalizedMessage());
            }
        });
    }
}
