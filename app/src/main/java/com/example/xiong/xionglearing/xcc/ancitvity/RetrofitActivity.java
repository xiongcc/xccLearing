package com.example.xiong.xionglearing.xcc.ancitvity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.xiong.xionglearing.R;


public class RetrofitActivity extends AppCompatActivity {
    public static final String BASE_URL = "http://api.myservice.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        String API = "https://api.github.com";

//        RestAdapter restAdapter = new RestAdapter.Builder().setLogLevel(RestAdapter.LogLevel.FULL).setEndpoint(API).build();
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();

//        GitHubService git = retrofit.create(GitHubService.class);
//
//        git.listRepos()


//        RestAdapter restAdapter = new RestAdapter.Builder();
//                .setEndpoint("https://api.github.com")
//                .build();
//
//        GitHubService service = restAdapter.create(GitHubService.class);

    }
}
