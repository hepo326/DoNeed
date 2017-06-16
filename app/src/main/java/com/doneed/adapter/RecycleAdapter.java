package com.doneed.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.doneed.R;
import com.doneed.model.Donators;
import com.doneed.model.RecyclerViewHolders;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;



public class RecycleAdapter extends RecyclerView.Adapter<RecyclerViewHolders>  {

    private ArrayList<Donators> donatorData;
    private Context context;

    public RecycleAdapter(ArrayList<Donators> donatorData, Context context){
        this.donatorData=donatorData;
        this.context=context;
    }

    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_content,parent,false);

        return  new RecyclerViewHolders(view , donatorData);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {
        holder.donatorName.setText(donatorData.get(position).getname());

        String PROFILE_PICTURE_URL = donatorData.get(position).getProfilePicture();


        Picasso.with(context)
                .load(PROFILE_PICTURE_URL)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.drawable.ic_account)
                .into(holder.donatorProfilePicture);

        holder.donatorPhone.setText(donatorData.get(position).getphone());
        holder.donatorAddress.setText(donatorData.get(position).getaddress());
        holder.donatorDetails=donatorData.get(position).getdetails();
        holder.donatorCateogry.setText(donatorData.get(position).getcateogry());
        holder.donatorAmount.setText(donatorData.get(position).getamount());



    }

    @Override
    public int getItemCount() {
        return donatorData.size();
    }

    public Donators getDonator(){
        return RecyclerViewHolders.donator;
    }

    public void setArrayData(ArrayList<Donators> donatorData){

        this.donatorData = donatorData ;
        notifyDataSetChanged();
    }

    public void clear(){

        donatorData.clear();
        notifyDataSetChanged();
    }
}

