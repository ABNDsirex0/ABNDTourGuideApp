package cloud.krzysztofkin.tourguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class CategoryFragment extends Fragment {

    private static final String ARG_CATEGORY_NR = "categoryNr";

    //category for fragment
    private int mCategory;

    public CategoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_category, container, false);

        final ArrayList<Place> places = DataProvider.getListOfPlaces(mCategory);
        PlaceArrayAdapter adapter = new PlaceArrayAdapter(getActivity(), 0, places);

        ListView listView = rootView.findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Place currentPlace = places.get(position);

                Intent placeIntent = new Intent(getActivity(), PlaceActivity.class);
                placeIntent.putExtra(PlaceActivity.PLACE, currentPlace);
                startActivity(placeIntent);
            }
        });
        return rootView;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param categoryNr category number for fragment.
     * @return A new instance of fragment CategoryFragment.
     */
    public static CategoryFragment newInstance(int categoryNr) {
        CategoryFragment fragment = new CategoryFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_CATEGORY_NR, categoryNr);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * read saved category onCreate fragment
     *
     * @param savedInstanceState saved Instance State
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mCategory = getArguments().getInt(ARG_CATEGORY_NR);
        }
    }
}