package com.doneed.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.doneed.R;
import com.doneed.adapter.RecycleAdapter;
import com.doneed.model.Donators;

import java.util.ArrayList;

public class MainFragment extends Fragment {

    private static final String KEY_POSITION="position";

    RecyclerView recyclerView;
    RecycleAdapter donatorAdapter;
    ArrayList<Donators> donatorData = new ArrayList<>();

    String[]ID={"121","111","131","141","051"};
    String[]Names= new String[]{"Ahmed", "Mohamed" , "Ali", "Asmaa" ,"Aya"};
    String[]Phones= new String[]{"010112356", "010110121" , "010118745", "012350121" ,"016110121"};
    String[]Cateogry= new String[]{"Food", "clothes" , "Money", "others"};
    String[]amount= new String[]{"1132", "65698" , "98956", "32655" ,"76521"};
    String[]address= new String[]{"cairo", "alex" , "tanta", "menof" ,"shebin"};
    String[]details=new String[]{"Nothing important","Bla bla" , "Meow" , "Rawr"," "};
    String profileimg="R.drawable.ic_account";

    public static MainFragment newInstance(int position) {
        MainFragment frag=new MainFragment();
        Bundle args=new Bundle();
        args.putInt(KEY_POSITION, position);
        frag.setArguments(args);
        return(frag);
    }

//    public void updateMovies(){
//
//        adapter.clear();
//
//        SharedPreferences sharedPrefs= PreferenceManager.getDefaultSharedPreferences(getActivity());
//        String sortType = sharedPrefs.getString(getString(R.string.pref_sort_key),getString(R.string.pref_sort_pop_value));
//
//        if(!sortType.equals(getString(R.string.pref_sort_fav_value))) {
//            FetchMovies fetch = new FetchMovies(getActivity(), grid, arrayList, adapter);
//            fetch.execute(sortType);
//        }else{
//
//            DetailsFragment detailsFragment = new DetailsFragment();
//            getActivity().getSupportFragmentManager().beginTransaction()
//                    .detach(detailsFragment)
//                    .commit();
//            updateFavoritesData();
//
//        }


    @Override
    public void onStart() {
        super.onStart();

        donatorAdapter.clear();

        ProgressDialog prog=ProgressDialog.show(getContext(), "Loading!", "Please Wait ... ");

        for(int i=0 ; i<4; i++)
        donatorData.add(new Donators(ID[i], Names[i], profileimg,
                Phones[i], address[i], details[i], Cateogry[i], amount[i]) );
        donatorAdapter.setArrayData(donatorData);

        prog.dismiss();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View result=inflater.inflate(R.layout.main_fragment_content, container, false);

        donatorAdapter = new RecycleAdapter(donatorData, getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView = (RecyclerView) result.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        if (recyclerView != null) {
            recyclerView.setAdapter(donatorAdapter);
        }

        return(result);
    }


}
