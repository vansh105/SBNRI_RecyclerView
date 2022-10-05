package com.example.recycler_sample.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycler_sample.R;
import com.example.recycler_sample.model.GeneralViewModel;
import com.example.recycler_sample.model.ShortsModel;

import java.util.List;

public class ParentAdapter extends RecyclerView.Adapter<ParentAdapter.ViewHolder> {
    private final List<ShortsModel> shortsList;
    private final Context context;
    private final List<GeneralViewModel> generalList;
    public ParentAdapter(List<ShortsModel> shortsList, List<GeneralViewModel>generalList, Context context){
        this.context=context;
        this.shortsList=shortsList;
        this.generalList=generalList;
    }

    @NonNull
    @Override
    public ParentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ParentAdapter.ViewHolder vh;
        if (viewType==0){
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.general_view,parent,false);
            vh=new ParentAdapter.ViewHolder(view,0);
        }
        else{
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.shorts_layout,parent,false);
            vh=new ParentAdapter.ViewHolder(view,1);
        }
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ParentAdapter.ViewHolder holder, int position) {
        if (getItemViewType(position)==0){
            if (position<2){
                holder.img.setImageResource(generalList.get(position).img);
                holder.header.setText(generalList.get(position).header);
            }
            else {
                holder.img.setImageResource(generalList.get(position-1).img);
                holder.header.setText(generalList.get(position-1).header);
            }
        }
        else{
            holder.title.setText(shortsList.get(0).title);
            ChildAdapter childAdapter=new ChildAdapter(shortsList.get(0).items);
            holder.rv_child.setHasFixedSize(true);
            holder.rv_child.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
            holder.rv_child.setAdapter(childAdapter);
            Log.d("ParentAdapter","The positions is "+0);
//            childAdapter.notifyDataSetChanged();
        }
    }


    @Override
    public int getItemViewType(int position) {
        // 0 is for the general views and 1 is for the shorts view
        if(position==2){
            return 1;
        }
        return 0;
    }

    @Override
    public int getItemCount() {
        return generalList.size()+shortsList.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder{
      //  For the Shorts one
        private TextView title;
        private RecyclerView rv_child;


     //   For the normal views
        private ImageView img;
        private TextView  header;

        public ViewHolder(@NonNull View itemView,int viewType) {
            super(itemView);
            if (viewType==0){
                img=itemView.findViewById(R.id.video_img);
                header=itemView.findViewById(R.id.header);
            }
            else{
                title=itemView.findViewById(R.id.tv_title);
                rv_child=itemView.findViewById(R.id.child);
            }
        }
    }

}
