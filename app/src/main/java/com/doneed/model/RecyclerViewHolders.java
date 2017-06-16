package com.doneed.model;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.doneed.R;

import java.util.ArrayList;

/**
 * Created by hepo3 on 4/2/2017.
 */

public class RecyclerViewHolders extends RecyclerView.ViewHolder implements OnClickListener {

    public TextView donatorName;
    public ImageView donatorProfilePicture;
    public TextView donatorPhone;
    public TextView donatorAddress;
    public String donatorDetails;
    public TextView donatorCateogry;
    public TextView donatorAmount;
    private CheckBox deliveryChkBox;
    private ArrayList<Donators> selectedDonator;
    public static Donators donator;

    public RecyclerViewHolders(View itemView, ArrayList<Donators> selectedDonator) {
        super(itemView);
        itemView.setOnClickListener(this);
        this.selectedDonator = selectedDonator;
        donatorName = (TextView) itemView.findViewById(R.id.name);
        donatorProfilePicture= (ImageView) itemView.findViewById(R.id.icon);
        donatorPhone= (TextView) itemView.findViewById(R.id.phone);
        donatorAddress= (TextView) itemView.findViewById(R.id.address);
        donatorCateogry= (TextView) itemView.findViewById(R.id.cateogry);
        donatorAmount= (TextView) itemView.findViewById(R.id.amount);
        deliveryChkBox=(CheckBox)itemView.findViewById(R.id.delivered_checkBox);
    }

    @Override
    public void onClick(View v) {
        Context context = v.getContext();
        donator = selectedDonator.get(getAdapterPosition());

        donatorDetails=donator.getdetails();

        if (donatorDetails != null && !donatorDetails.isEmpty()) {

            new AlertDialog.Builder(context).setMessage(donatorDetails)
                    .setTitle("Details")
                    .setCancelable(true)
                    .setNeutralButton(android.R.string.ok,
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    dialog.dismiss();
                                }
                            })
                    .show();
        } else {
            Toast.makeText(context, "There aren't details provided by this donator.", Toast.LENGTH_SHORT).show();
        }

    }
}
