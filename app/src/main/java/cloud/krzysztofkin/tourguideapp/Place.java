package cloud.krzysztofkin.tourguideapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Place implements Parcelable {
    private String category;
    private String name;
    private String shortDescription;
    private String longDescription;
    private int imageId;

    /**
     * @param category         category
     * @param name             name
     * @param shortDescription short description
     * @param longDescription  long description
     * @param imageId          image res Id
     */
    Place(String category, String name, String shortDescription, String longDescription, int imageId) {
        this.category = category;
        this.name = name;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public int getImageId() {
        return imageId;
    }

    public String getCategory() {
        return category;
    }

    //****************Parceling part**************************
    protected Place(Parcel in) {
        category = in.readString();
        name = in.readString();
        shortDescription = in.readString();
        longDescription = in.readString();
        imageId = in.readInt();
    }

    public static final Creator<Place> CREATOR = new Creator<Place>() {
        @Override
        public Place createFromParcel(Parcel in) {
            return new Place(in);
        }

        @Override
        public Place[] newArray(int size) {
            return new Place[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(category);
        parcel.writeString(name);
        parcel.writeString(shortDescription);
        parcel.writeString(longDescription);
        parcel.writeInt(imageId);
    }
}
