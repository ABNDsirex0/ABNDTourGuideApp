package cloud.krzysztofkin.tourguideapp;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class AttractionsFragmentPageAdapter extends FragmentStatePagerAdapter {
    AttractionsFragmentPageAdapter(FragmentManager fm) {
        super(fm);
    }

    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position position on page adapter
     */
    @Override
    public Fragment getItem(int position) {
        return CategoryFragment.newInstance(position);
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return DataProvider.getListOfCategories().size();
    }

    /**
     * This method may be called by the ViewPager to obtain a title string
     * to describe the specified page. This method may return null
     * indicating no title for this page. The default implementation returns
     * null.
     *
     * @param position The position of the title requested
     * @return A title for the requested page
     */
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return DataProvider.getListOfCategories().get(position);
    }
}
