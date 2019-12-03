package mobile.fasam.edu.androidretrofit2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommentsActivity extends AppCompatActivity {

    EditText txtId;
    EditText txtUserId;
    EditText txtTitulo;
    EditText txtBoddy;
    ListView listView;


    CommentsService commentService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);
    }

    private void carregarDados(){

        // fazer injeção de dependencias da interface
        commentService = BoostrapApi.getclient().create(CommentsService.class);

        Call<List<Comments>> get = commentService.get();

        get.enqueue(new Callback<List<Comments>>() {
            @Override
            public void onResponse(Call<List<Comments>> call, Response<List<Comments>> response) {
                //Recuperar a lista de posts
                List<Comments> posts = response.body();

                //pegar referencia da listview
                listView = findViewById(R.id.listviewPost);

                CommentsAdapter adapter =
                        new CommentsAdapter(getApplicationContext(), posts);

                //Fazer "bind" com a listView;
                listView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<Comments>> call, Throwable t) {

            }
        });

    }
    public void adicionar(View view) {
        carregarDados();
    }
}
