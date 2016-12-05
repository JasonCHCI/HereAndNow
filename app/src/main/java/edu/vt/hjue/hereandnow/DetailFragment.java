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
        TextView timeView = (TextView) view.findViewById(R.id.current_time);
        RatingBar ratingBar = (RatingBar) view.findViewById(R.id.indRating);
        TextView type = (TextView) view.findViewById(R.id.type);
        pic.setImageResource(mParam1.getProfile_pic_id());
        textView.setText(mParam1.getName());
        ratingBar.setRating(mParam1.getRate());
        type.setText("Type: " + mParam1.getType());

        LinearLayout mLL;
        LinearLayout mTimeLayout;
        mLL = (LinearLayout) view.findViewById(R.id.rect);
        mTimeLayout = (LinearLayout) view.findViewById(R.id.time_rect);

        Paint paintTime = new Paint();
        float length = mParam1.getTime();
        String color1;
        if (length <= 5) {
            timeView.setText("Current wait time: <= 5min");
            color1 = "#6df02d";
        }
        else if (length <= 10) {
            timeView.setText("Current wait time: <= 10min");
            color1 = "#5a983b";
        }
        else if (length <= 15) {
            timeView.setText("Current wait time: <= 15min");
            color1 = "#e2e334";
        }
        else if (length <= 20) {
            timeView.setText("Current wait time: <= 20min");
            color1 = "#ffc205";
        }
        else if (length <=25) {
            timeView.setText("Current wait time: <= 25min");
            color1 = "#ff7705";
        }
        else {
            timeView.setText("Current wait time: > 25min");
            color1 = "#ff0000";
        }
        paintTime.setColor(Color.parseColor(color1));
        Bitmap bgTime = Bitmap.createBitmap(800, 400, Bitmap.Config.ARGB_8888);
        Canvas canvasTime = new Canvas(bgTime);
        canvasTime.drawRect(20, 100, 20 + length * 24, 250, paintTime);
        BitmapDrawable bdTime = new BitmapDrawable(bgTime);
        mTimeLayout.setBackgroundDrawable(bdTime);




        Paint paint = new Paint();
        int point = mParam1.getPoints();
        String color;
        if (point == 50) {
            ImageView qr = (ImageView) view.findViewById(R.id.qrcode);
            qr.getLayoutParams().width = 350;
            qr.getLayoutParams().height = 350;
            qr.setImageResource(R.drawable.qrcode);
            pointView.setText("Redeem your coupon now! (50/50 points)");
            color = "#FFB90F";
        }
        else {
            pointView.setText("Reward Points: " + Integer.toString(point) + "/50");
            color = "#3f51b5";
        }
        paint.setColor(Color.parseColor(color));
        Bitmap bg = Bitmap.createBitmap(800, 400, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bg);
        canvas.drawRect(20, 100, 20 + point * 15, 250, paint);
        BitmapDrawable bd = new BitmapDrawable(bg);
        mLL.setBackgroundDrawable(bd);


        return view;
    }

}
