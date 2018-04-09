package cloud.krzysztofkin.tourguideapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PlaceArrayAdapter extends ArrayAdapter<Place> {

    PlaceArrayAdapter(@NonNull Context context, int resource, @NonNull List<Place> places) {
        super(context, resource, places);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.place_item, parent, false);
        }
        Place currentPlace = getItem(position);
        TextView placeName = listItemView.findViewById(R.id.place_name);
        TextView placeShortDescription = listItemView.findViewById(R.id.place_short_description);
        ImageView placeImage = listItemView.findViewById(R.id.place_image);

        placeName.setText(currentPlace.getName());
        placeShortDescription.setText(currentPlace.getShortDescription());
        placeImage.setImageResource(currentPlace.getImageId());

        return listItemView;
    }
}
