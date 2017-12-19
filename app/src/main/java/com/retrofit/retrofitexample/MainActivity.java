package com.retrofit.retrofitexample;

import android.app.Service;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.retrofit.retrofitexample.models.Catalogo;
import com.retrofit.retrofitexample.models.Course;
import com.retrofit.retrofitexample.models.Instructor;
import com.retrofit.retrofitexample.services.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Funciona: ";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit  = new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService service = retrofit.create(ApiService.class);
        Call<Catalogo> requesCatalogo = service.listaCatalogo();


        requesCatalogo.enqueue(new Callback<Catalogo>() {
            @Override
            public void onResponse(Call<Catalogo> call, Response<Catalogo> response) {
                if (!response.isSuccessful()){
                    Log.i("TAG", "Error" + response.code());
                }else {
                    Catalogo catalogo = response.body();
                    for (Course c : catalogo.courses) {
                        Log.i(TAG, String.format("%s: %s", c.title, c.subtitle));

                        for (Instructor i : c.instructors) {
                            Log.i(TAG, i.name);
                        }
                        Log.i(TAG, "-------------");
                    }
                }
            }

            @Override
            public void onFailure(Call<Catalogo> call, Throwable t) {
                Log.e(TAG, "Error: " + t.getMessage());
            }
        });
    }
}
