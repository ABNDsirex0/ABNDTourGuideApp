package cloud.krzysztofkin.tourguideapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PlaceActivity extends AppCompatActivity {
    static final String PLACE = "place";
    Place currentPlace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);
        Intent intentFromList = getIntent();
        currentPlace = intentFromList.getParcelableExtra(PLACE);

        ImageView placeImage = findViewById(R.id.place_image);
        TextView placeShortDescription = findViewById(R.id.place_short_description_activity);
        TextView placeLongDescription = findViewById(R.id.place_long_description_activity);

        setTitle(currentPlace.getName());
        placeImage.setImageResource(currentPlace.getImageId());
        placeShortDescription.setText(currentPlace.getShortDescription());
        placeLongDescription.setText(currentPlace.getLongDescription());
    }
}

