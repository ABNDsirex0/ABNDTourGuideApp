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

    /**
     * If list of places is empty return true
     *
     * @return true if list of places is empty
     */
    static boolean isEmpty() {
        return listOfPlaces.isEmpty();
    }

    /**
     * Adds new Place to the list
     *
     * @param placeToAdd new place to add
     */
    static void addPlace(Place placeToAdd) {
        listOfPlaces.add(placeToAdd);
        addCategory(placeToAdd.getCategory());
    }

    /**
     * Add new category to list of categories
     *
     * @param newCategory category name
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
     * Adds data from res file to list
     */
    public static void addDataFromRes(Context context) {
        Place place;
        int placeImageID;
        String[] places = context.getResources().getStringArray(R.array.places);
        for (String placeString : places) {
            String[] placeData = placeString.split(";");
            placeImageID = context.getResources().getIdentifier(placeData[4], "drawable", context.getPackageName());
            place = new Place(placeData[0], placeData[1], placeData[2], placeData[3], placeImageID);
            addPlace(place);
        }
    }

    /**
     * Add sample data to list
     *
     * @param numberOfCategories number Of Categories
     * @param countInCategory    number places In Category
     * @param imageId            imageId
     */
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
