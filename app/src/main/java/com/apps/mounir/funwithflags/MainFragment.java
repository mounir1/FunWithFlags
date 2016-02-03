package com.apps.mounir.funwithflags;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment implements SearchView.OnQueryTextListener {
    protected static int AllFlags = 400;


    String[] Numbers = new String[AllFlags];

    public ArrayList<String> FlagsName = new ArrayList<>();
    public ArrayList<Integer> FlagIds = new ArrayList<>();

    int[] AfricanFlagsIds = Flags.Africa;
    String[] AfricanFlagsName = new String[AfricanFlagsIds.length];


    int[] IOFlagsIds = Flags.IO;
    String[] IOFlagsName = new String[IOFlagsIds.length];

    int[] EuroFlagIds = Flags.Europe;
    String[] EuroFlagsName = new String[EuroFlagIds.length];

    int[] AsiaFlagIds = Flags.Asia;
    String[] AsiaFlagName = new String[AsiaFlagIds.length];

    int[] NAmericaFlagIds = Flags.NAmerica;
    String[] NAmericaFlagName = new String[NAmericaFlagIds.length];


    int[] SAmericaFlagIds = Flags.SAmerica;
    String[] SAmericaFlagName = new String[SAmericaFlagIds.length];

    int[] OceanaFlagIds = Flags.Oceana;
    String[] OceanaFlagName = new String[OceanaFlagIds.length];

    Field[] ID_Fields = R.drawable.class.getFields();

    public ArrayList<Flag> FlagsList = new ArrayList<>();

    private RecyclerView mRecyclerView;

    private MyAdapter mAdapter;

    private static String Type;


    public static MainFragment newInstance(String type) {
        Type = type;
        return new MainFragment();
    }

    public void getAllFlagNames() {
        for (int i = 0; i < ID_Fields.length; i++) {
            try {
                if (ID_Fields[i].getName().startsWith("_")) {
                    FlagIds.add(ID_Fields[i].getInt(null));
                    FlagsName.add(ID_Fields[i].getName());
                } else
                    continue;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < FlagsName.size(); i++) {
            Numbers[i] = String.format("%03d", i + 1);
            FlagsName.set(i, FlagsName.get(i).substring(1).substring(0, 1).toUpperCase() + FlagsName.get(i).substring(2).replace("_", " "));
        }
    }

    public void setAllFlags() {

        for (int i = 0; i < FlagIds.size(); i++) {

            FlagsList.add(new Flag(FlagsName.get(i), FlagIds.get(i)));
        }
    }

    private void setSAmerica() {


        for (int i = 0; i < SAmericaFlagIds.length; i++) {
            int ID = SAmericaFlagIds[i];
            String name = FlagsName.get(FlagIds.indexOf(SAmericaFlagIds[i]));
            Country country = new Country(name);
            Flag flag = new Flag(name, ID, country, MainActivity.SouthAmerica);

            FlagsList.add(flag);
        }

    }

    public void setIO() {
        Flag flag;
        for (int i = 0; i < IOFlagsIds.length; i++) {
            int ID = IOFlagsIds[i];
            String name = FlagsName.get(FlagIds.indexOf(IOFlagsIds[i]));
            flag = new Flag(name, ID);
            FlagsList.add(flag);
        }
    }

    public void setAfrica() {

        for (int i = 0; i < AfricanFlagsIds.length; i++) {
            int ID = AfricanFlagsIds[i];
            String name = FlagsName.get(FlagIds.indexOf(AfricanFlagsIds[i]));
            Country country = new Country(name);
            Flag flag = new Flag(name, ID, country, MainActivity.Africa);
            FlagsList.add(flag);
        }
    }

    public void setAsian() {

        for (int i = 0; i < AsiaFlagIds.length; i++) {
            int ID = AsiaFlagIds[i];
            String name = FlagsName.get(FlagIds.indexOf(AsiaFlagIds[i]));
            Country country = new Country(name);
            Flag flag = new Flag(name, ID, country, MainActivity.Asia);
            FlagsList.add(flag);

        }
    }

    private void setNAmerica() {

        for (int i = 0; i < NAmericaFlagIds.length; i++) {
            int ID = NAmericaFlagIds[i];
            String name = FlagsName.get(FlagIds.indexOf(NAmericaFlagIds[i]));
            Country country = new Country(name);
            Flag flag = new Flag(name, ID, country, MainActivity.NorthAmerica);
            FlagsList.add(flag);
        }
    }

    private void setOceana() {
        for (int i = 0; i < OceanaFlagIds.length; i++) {
            int ID = OceanaFlagIds[i];
            String name = FlagsName.get(FlagIds.indexOf(OceanaFlagIds[i]));
            Country country = new Country(name);
            Flag flag = new Flag(name, ID, country, MainActivity.Oceana);
            FlagsList.add(flag);
        }
    }

    private void setEurope() {

        for (int i = 0; i < EuroFlagIds.length; i++) {
            int ID = EuroFlagIds[i];
            String name = FlagsName.get(FlagIds.indexOf(EuroFlagIds[i]));
            Country country = new Country(name);
            Flag flag = new Flag(name, ID, country, MainActivity.Europe);
            FlagsList.add(flag);
        }
    }
    @Override
    public boolean onQueryTextChange(String query) {
        final List<Flag> filteredModelList = filter(FlagsList, query);
        mAdapter.animateTo(filteredModelList);
        mRecyclerView.scrollToPosition(0);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    private List<Flag> filter(List<Flag> models, String query) {
        query = query.toLowerCase();

        final List<Flag> filteredModelList = new ArrayList<>();
        for (Flag model : models) {
            final String text = model.getFlagName().toLowerCase();
            if (text.contains(query)) {
                filteredModelList.add(model);
            }
        }
        return filteredModelList;
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.listmenu, menu);

        final MenuItem item = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.recyclefragment, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
        getAllFlagNames();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        System.out.println("FLAG TYPE: " + Type);
        switch (Type) {

            case MainActivity.AllFlags: {

                setAllFlags();
                break;
            }
            case MainActivity.IOFlags: {
                setIO();
                break;
            }
            case MainActivity.AsiaFlags: {
                setAsian();
                break;
            }
            case MainActivity.EuroFlags: {
                setEurope();
                break;
            }
            case MainActivity.AfroFlags: {
                setAfrica();
                break;
            }
            case MainActivity.OceanaFlags: {
                setOceana();
                break;
            }
            case MainActivity.NAmerica: {
                setNAmerica();
                break;
            }
            case MainActivity.SAmerica: {
                setSAmerica();
                break;
            }
        }
        mAdapter = new MyAdapter(getActivity(), FlagsList);
        mRecyclerView.setAdapter(mAdapter);
    }

}




