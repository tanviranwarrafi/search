package com.example.searchrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> implements Filterable {

    private List<UserModel> userModelList;
    private Boolean userList;
    private List<UserModel> filterModelList;

    public UserAdapter(List<UserModel> userModelList, Boolean userList) {
        this.userModelList = userModelList;
        this.userList = userList;
        this.filterModelList = userModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_item_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        int resource = userModelList.get(position).getUserImage();
        String name = userModelList.get(position).getUserName();
        String description = userModelList.get(position).getUserDescription();
        viewHolder.setData(resource, name, description);
    }

    @Override
    public int getItemCount() {
            return userModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView userImage;
        private TextView userName;
        private TextView userDescription;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userImage = itemView.findViewById(R.id.userImage);
            userName = itemView.findViewById(R.id.username);
            userDescription = itemView.findViewById(R.id.userDescription);
        }

        private void setData(int resource, String name, String description){
            userImage.setImageResource(resource);
            userName.setText(name);
            userDescription.setText(description);
        }
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charString = constraint.toString();
                if (charString.isEmpty()){
                    userModelList = filterModelList;
                }else{
                    List<UserModel> filterList = new ArrayList<>();
                    for (UserModel data : filterModelList){
                        if ((data.getUserName().toUpperCase()).contains(charString.toUpperCase())){
                            filterList.add(data);
                        }
                    }
                    userModelList = filterList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = userModelList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                userModelList = (List<UserModel>) results.values;
                notifyDataSetChanged();
            }
        };
    }
}

