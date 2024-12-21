package com.example.proyectodsa_android.activity;

import android.os.Bundle;
import android.widget.Toast;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectodsa_android.ApiService;
import com.example.proyectodsa_android.MessageAdapter;
import com.example.proyectodsa_android.R;
import com.example.proyectodsa_android.RetrofitClient;
import com.example.proyectodsa_android.models.Message;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MessageActivity extends AppCompatActivity {

    private ApiService apiService;
    private RecyclerView rvMessages;
    private MessageAdapter messageAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);

        rvMessages = findViewById(R.id.messages);

        apiService = RetrofitClient.getInstance().getApi();
        if(apiService == null){
            Log.e("MessageActivity","ApiService is null");
        }

        messageAdapter = new MessageAdapter();
        rvMessages.setAdapter(messageAdapter);
        rvMessages.setLayoutManager(new LinearLayoutManager(this));

        loadMessages();
    }

    private void loadMessages(){
        apiService.getMessages().enqueue(new Callback<List<Message>>() {
            @Override
            public void onResponse(Call<List<Message>> call, Response<List<Message>> response) {
                if(response.isSuccessful() && response.body()!=null){
                    messageAdapter.setMessages(response.body());
                }else {
                    Toast.makeText(MessageActivity.this,
                            "Error loading messages: " + response.code(),
                            Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Message>> call, Throwable t) {
                Toast.makeText(MessageActivity.this,
                        "Error loading messages: " + t.getMessage(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
