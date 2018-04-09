package cloud.krzysztofkin.tourguideapp;

import android.content.Context;

import java.util.ArrayList;

public class DataProvider {
    private static ArrayList<Place> listOfPlaces = new ArrayList<>();
    private static ArrayList<String> listOfCategories = new ArrayList<>();

    static boolean isEmpty() {
        if (listOfPlaces.isEmpty())
            return true;
        else
            return false;

    }

    static void addPlace(Place placeToAdd) {
        listOfPlaces.add(placeToAdd);
        addCategory(placeToAdd.getCategory());
    }

    private static void addCategory(String newCategory) {
        boolean onList = false;
        for (String category : listOfCategories) {
            if (category.equals(newCategory)) {
                onList = true;
                break;
            }
        }
        if (!onList) {
            listOfCategories.add(newCategory);
        }
    }

    public static ArrayList<Place> getListOfPlaces(int categoryNr) {
        ArrayList<Place> list = new ArrayList<>();
        for (Place place : listOfPlaces) {
            if (place.getCategory().equals(listOfCategories.get(categoryNr))) {
                list.add(place);
            }
        }
        return list;
    }

    public static ArrayList<String> getListOfCategories() {
        return listOfCategories;
    }

    /**
     * Adds data from res file to
     */
    public static void addDataFromRes(Context context) {
        Place place;
        int placeImageID;
        //todo ogarnąć import arraya jest wstring rozbićpo średniku i dodać obiekt
        String[] places = context.getResources().getStringArray(R.array.places);
        for (String placeString : places) {
            String[] placeData = placeString.split(";");
            placeImageID = context.getResources().getIdentifier(placeData[4], "drawable", context.getPackageName());
            place = new Place(placeData[0], placeData[1], placeData[2], placeData[3], placeImageID);
            addPlace(place);
        }
    }

    public static void addSampleData(int numberOfCategories, int countInCategory, int imageId) {
        for (int categoryNr = 0; categoryNr < numberOfCategories; categoryNr++) {
            for (int placeNr = 0; placeNr < countInCategory; placeNr++) {
                addPlace(new Place("category " + categoryNr,
                        "Name " + categoryNr + "." + placeNr,
                        "short description for place " + placeNr,
                        "long description for place " + placeNr,
                        imageId));
            }
        }
    }
}
