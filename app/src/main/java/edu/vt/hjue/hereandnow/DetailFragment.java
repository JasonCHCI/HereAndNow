package edu.vt.hjue.hereandnow;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_RES = "param1";


    private Restaurant mParam1;


    public DetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param restaurant Parameter 1.
     * @return A new instance of fragment DetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailFragment newInstance(Restaurant restaurant) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_RES, restaurant);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getParcelable(ARG_RES);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        ImageView pic = (ImageView) view.findViewById(R.id.profile);
        TextView textView = (TextView) view.findViewById(R.id.title);
        TextView pointView = (TextView) view.findViewById(R.id.points);
        RatingBar ratingBar = (RatingBar) view.findViewById(R.id.indRating);
        TextView type = (TextView) view.findViewById(R.id.type);
        pic.setImageResource(mParam1.getProfile_pic_id());
        textView.setText(mParam1.getName());
        ratingBar.setRating(mParam1.getRate());
        type.setText("Type: " + mParam1.getType());

        LinearLayout mLL;
        mLL = (LinearLayout) view.findViewById(R.id.rect);
        Paint paint = new Paint();
        int point = mParam1.getPoints();
        String color;
        if (point == 50) {
            pointView.setText("Redeem your coupon now!");
            color = "#FFB90F";
        }
        else {
            pointView.setText("Reward Points: " + Integer.toString(point) + "/50");
            color = "#3f51b5";
        }
        paint.setColor(Color.parseColor(color));
        Bitmap bg = Bitmap.createBitmap(800, 800, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bg);
        canvas.drawRect(20, 100, 20 + point * 15, 250, paint);
        BitmapDrawable bd = new BitmapDrawable(bg);
        mLL.setBackgroundDrawable(bd);


        return view;
    }

}
