package com.jakester.doordashchallenge;

import android.content.Context;

import com.jakester.doordashchallenge.models.Business;
import com.jakester.doordashchallenge.models.FavoritesManager;
import com.jakester.doordashchallenge.models.Resturant;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith(MockitoJUnitRunner.class)
public class DoorDashUnitTest {

    @Mock
    Context mMockContext;

    //Verifies that the business is created successfully
    @Test
    public void verifyBusiness() throws Exception {
        Resturant resturant = new Resturant();
        resturant.setStatus("23 minutes");
        resturant.setBusiness(new Business());
        resturant.getBusiness().setId("23");
        resturant.getBusiness().setName("CREAM");
        resturant.setFavorited(false);

        assertEquals("23 minutes", resturant.getStatus());
        assertEquals("23", resturant.getBusiness().getId());
        assertEquals("CREAM", resturant.getBusiness().getName());
        assertEquals(false, resturant.getFavorite());

    }

    //This verifies the favorite item selected and moved on the list works
    @Test
    public void verifyFavorite() throws Exception {
        Resturant resturant = new Resturant();
        resturant.setStatus("23 minutes");
        resturant.setBusiness(new Business());
        resturant.getBusiness().setId("23");
        resturant.getBusiness().setName("CREAM");
        resturant.setFavorited(false);

        Resturant resturantTwo = new Resturant();
        resturantTwo.setStatus("10 Minutes");
        resturantTwo.setBusiness(new Business());
        resturantTwo.getBusiness().setId("41532");
        resturantTwo.getBusiness().setName("Taco Bell");
        resturantTwo.setFavorited(false);

        Resturant resturantThree = new Resturant();
        resturantThree.setStatus("Closed");
        resturantThree.setBusiness(new Business());
        resturantThree.getBusiness().setId("2580124");
        resturantThree.getBusiness().setName("Bill's Cafe");
        resturantThree.setFavorited(false);

        List<Resturant> resturants = new ArrayList<Resturant>();
        resturants.add(resturant);
        resturants.add(resturantTwo);
        resturants.add(resturantThree);

        resturants.get(1).setFavorited(true);
        assertNotNull(mMockContext);
        FavoritesManager.getInstance(mMockContext).addFavorite(resturants.get(1).getBusiness().getId());

        resturants = FavoritesManager.getInstance(mMockContext).rearrangeResturantsWithFavorites(resturants);
        assertEquals(true, resturants.get(0).getFavorite());
    }
}