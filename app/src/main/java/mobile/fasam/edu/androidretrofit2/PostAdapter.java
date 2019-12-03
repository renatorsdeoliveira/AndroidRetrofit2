package mobile.fasam.edu.androidretrofit2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class PostAdapter extends BaseAdapter {
    Context context;
    List<Posts> colecao;
    LayoutInflater inflter;

    public PostAdapter(final Context applicationContext,
                       final List<Posts> colecao) {
        this.context = applicationContext;
        this.colecao = colecao;
    }

    @Override
    public int getCount() {
        return this.colecao!=null ? this.colecao.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return this.colecao.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {


        if (view == null) {
            view = LayoutInflater.from(context).
                    inflate(R.layout.item_post,
                            parent, false);
        }

        Posts posts = (Posts)getItem(position);

        TextView userId, title;

        userId = view.findViewById(R.id.txtUserId);
        title = view.findViewById(R.id.txtTitle);

        userId.setText(String.valueOf(posts.getUserId()));
        title.setText(posts.getTitle());

        return view;
    }
}
