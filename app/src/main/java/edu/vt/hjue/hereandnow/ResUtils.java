package edu.vt.hjue.hereandnow;

/**
 * Created by jhou on 12/3/16.
 */
import android.content.Context;
import android.content.res.TypedArray;

import java.util.ArrayList;

/**
 * Created by boutell on 12/1/2015.
 */
public class ResUtils {



    public static ArrayList<Restaurant> loadDocs(Context context) {
        String[] names = new String[]{
                "NCB",
                "Zeppolli's",
                "Chipotle",
                "Chinese Kitchen",
                "India Garden",
                "Panda Express",
                "Green's Grill/Sushi",
                "Cafe De Bangkok",
                "Cook Out"};
        String[] times = new String[]{
                "<= 5min",
                "<= 5min",
                "<= 5min",
                "<= 10min",
                "<= 10min",
                "<= 15min",
                "<= 20min",
                "<= 25min",
                "> 25min"
        };

        Integer[] number = new Integer[]{
                2,
                3,
                5,
                8,
                10,
                13,
                17,
                22,
                27
        };
        Integer[] points = new Integer[]{
                50,
                40,
                40,
                25,
                20,
                15,
                15,
                5,
                0
        };

        float[] ratings = new float[]{
                5,
                3.5f,
                4,
                3,
                3,
                2.5f,
                5,
                3.5f,
                2
        };

        String[] type = new String[]{
                "Special",
                "Salad, Italian, Wine Bars",
                "Mexican, Fast Food",
                "Chinese",
                "Indian, Buffets",
                "Chinese, Fast Food",
                "Sushi Bars",
                "Thai",
                "Fast Food, Burgers, Hot Dogs"
        };

        ArrayList<Restaurant> docs = new ArrayList<>();
        TypedArray profile_pics = context.getResources().obtainTypedArray(R.array.profile);
        for (int i = 0; i < names.length; i++) {

            Restaurant doc = new Restaurant(
                    names[i],
                    times[i],
                    number[i],
                    points[i],
                    profile_pics.getResourceId(i, -1),
                    ratings[i],
                    type[i]
            );
            docs.add(doc);

        }
        return docs;
    }


}
