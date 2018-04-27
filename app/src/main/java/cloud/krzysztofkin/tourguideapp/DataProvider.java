package cloud.krzysztofkin.tourguideapp;

import android.content.Context;

import java.util.ArrayList;

public class DataProvider {
    private static ArrayList<Place> listOfPlaces = new ArrayList<>();
    private static ArrayList<String> listOfCategories = new ArrayList<>();

    //Utility classes should not have public constructors - hide public constructor
    private DataProvider() {
        throw new IllegalStateException("Utility class");
    }

    static boolean isEmpty() {
        return listOfPlaces.isEmpty();
    }

    /**
     * Return list of places in specific category
     *
     * @param categoryNr category number on list
     * @return list of places
     */
    public static ArrayList<Place> getListOfPlaces(int categoryNr) {
        ArrayList<Place> list = new ArrayList<>();
        for (Place place : listOfPlaces) {
            if (place.getCategory().equals(listOfCategories.get(categoryNr))) {
                list.add(place);
            }
        }
        return list;
    }

    /**
     * Return list of categories
     *
     * @return list of categories
     */
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

    /**
     * Add place to place list and category to category list
     *
     * @param placeToAdd place object to add
     */
    static void addPlace(Place placeToAdd) {
        listOfPlaces.add(placeToAdd);
        addCategory(placeToAdd.getCategory());
    }

    /**
     * If category is not on list Add category to category list
     *
     * @param newCategory category name to add
     */
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
}
