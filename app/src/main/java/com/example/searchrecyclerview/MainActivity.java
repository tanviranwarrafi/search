package com.example.searchrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SearchView searchView;
    List<UserModel> userModelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        userModelList.add(new UserModel(R.drawable.mobile, "Ridmi Note 4","Ridmi Note Mobile Released on january"));
        userModelList.add(new UserModel(R.drawable.bag, "Bag","Ridmi Note Mobile Released on january"));
        userModelList.add(new UserModel(R.drawable.outlet, "Outlet","Ridmi Note Mobile Released on january"));
        userModelList.add(new UserModel(R.drawable.map, "Map","Ridmi Note Mobile Released on january"));
        userModelList.add(new UserModel(R.drawable.thinking_man, "Thinking Man","Ridmi Note Mobile Released on january"));

        userModelList.add(new UserModel(R.drawable.mobile, "Ridmi Note 4","Ridmi Note Mobile Released on january"));
        userModelList.add(new UserModel(R.drawable.bag, "Bag","Ridmi Note Mobile Released on january"));
        userModelList.add(new UserModel(R.drawable.outlet, "Outlet","Ridmi Note Mobile Released on january"));
        userModelList.add(new UserModel(R.drawable.map, "Map","Ridmi Note Mobile Released on january"));
        userModelList.add(new UserModel(R.drawable.thinking_man, "Thinking Man","Ridmi Note Mobile Released on january"));

        userModelList.add(new UserModel(R.drawable.mobile, "Ridmi Note 4","Ridmi Note Mobile Released on january"));
        userModelList.add(new UserModel(R.drawable.bag, "Bag","Ridmi Note Mobile Released on january"));
        userModelList.add(new UserModel(R.drawable.outlet, "Outlet","Ridmi Note Mobile Released on january"));
        userModelList.add(new UserModel(R.drawable.map, "Map","Ridmi Note Mobile Released on january"));
        userModelList.add(new UserModel(R.drawable.thinking_man, "Thinking Man","Ridmi Note Mobile Released on january"));

        final UserAdapter userAdapter = new UserAdapter(userModelList, true);
        recyclerView.setAdapter(userAdapter);
        userAdapter.notifyDataSetChanged();

        searchView = findViewById(R.id.searchView);
        searchView.setQueryHint("Search here....");
        searchView.setActivated(true);
        searchView.setIconified(true);
        searchView.clearFocus();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (userAdapter != null){
                    userAdapter.getFilter().filter(newText);
                }
                return true;
            }
        });
    }
}
