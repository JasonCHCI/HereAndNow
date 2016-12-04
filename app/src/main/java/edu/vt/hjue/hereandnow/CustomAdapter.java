/**
 * Created by jhou on 12/3/16.
 */

package edu.vt.hjue.hereandnow;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import edu.vt.hjue.hereandnow.RestListFragment;
import edu.vt.hjue.hereandnow.ResUtils;

/**
 * Created by hjue on 12/1/2015.
 */
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private ArrayList<Restaurant> mRes;
    private RestListFragment.Callback mCallback;


    public CustomAdapter(Context context, RestListFragment.Callback callback) {
        mRes = ResUtils.loadDocs(context);
        mCallback = callback;
    }

    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_view_doc, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomAdapter.ViewHolder holder, int position) {
        final Restaurant restaurant = mRes.get(position);
        holder.mTitleTextView.setText(restaurant.getName());
        holder.mTimeTextView.setText(restaurant.getTime());
        Paint paint = new Paint();
        int length = restaurant.getNumber();
        String color;
        if (length <= 5) {
            color = "#6df02d";
        }
        else if (length <= 10) {
            color = "#5a983b";
        }
        else if (length <= 15) {
            color = "#e2e334";
        }
        else if (length <= 20) {
            color = "#ffc205";
        }
        else if (length <=25) {
            color = "#ff7705";
        }
        else {
            color = "#ff0000";
        }
        paint.setColor(Color.parseColor(color));
        Bitmap bg = Bitmap.createBitmap(800, 800, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bg);
        canvas.drawRect(40, 100, length * 24, 350, paint);
        BitmapDrawable bd = new BitmapDrawable(bg);
        holder.mLL.setBackgroundDrawable(bd);
        holder.mItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.onResSelected(restaurant);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mRes.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout mItem;
        TextView mTitleTextView;
        TextView mTimeTextView;
        LinearLayout mLL;

        public ViewHolder(View itemView) {
            super(itemView);
            mItem = (RelativeLayout) itemView.findViewById(R.id.list_item);
            mTitleTextView = (TextView) itemView.findViewById(R.id.name);
            mTimeTextView = (TextView) itemView.findViewById(R.id.time);
            mLL = (LinearLayout) itemView.findViewById(R.id.rect);
        }
    }
}