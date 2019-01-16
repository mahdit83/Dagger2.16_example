package ir.bitecode.android.androidjunittestexample;

import android.os.Parcel;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class UserTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testUserParcelable() throws Exception {

        List<User> alisFamilyList = new ArrayList<>();
        User child = new User("ali",2,null,alisFamilyList);
        List<User> shabiesFamilyList = new ArrayList<>();
        shabiesFamilyList.add(child);
        User wife = new User("shaby",27,new ArrayList<String>(){{add("09121311509");}},shabiesFamilyList);
        List<User> mahdisFamilyList = new ArrayList<>();
        mahdisFamilyList.add(wife);
        mahdisFamilyList.add(child);
        User testUser = new User("mahdi",35,null,mahdisFamilyList);
        Parcel parcel = Parcel.obtain();
        testUser.writeToParcel(parcel, 0);
        //done writing, now reset parcel for reading
        parcel.setDataPosition(0);
        //finish round trip
        User testUserFromParcelable = User.CREATOR.createFromParcel(parcel);

        assertEquals(testUser, testUserFromParcelable);
    }
}