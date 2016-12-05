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
public class RewardAdapter extends RecyclerView.Adapter<RewardAdapter.ViewHolder> {

    private ArrayList<Restaurant> mRes;
    private RestPointFragment.Callback mCallback;


    public RewardAdapter(Context context, RestPointFragment.Callback callback) {
        mRes = ResUtils.loadDocs(context);
        mCallback = callback;
    }

    @Override
    public RewardAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_view_doc, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RewardAdapter.ViewHolder holder, int position) {
        final Restaurant restaurant = mRes.get(position);
        holder.mTitleTextView.setText(restaurant.getName());
        Paint paint = new Paint();
        int point = restaurant.getPoints();
        String color;
        if (point == 50) {
            holder.mTimeTextView.setText("Redeem your coupon now! (50/50)");
            color = "#FFB90F";
        }
        else {
            holder.mTimeTextView.setText("Reward Points: " + Integer.toString(point) + "/50");
            color = "#3f51b5";
        }
        paint.setColor(Color.parseColor(color));
        Bitmap bg = Bitmap.createBitmap(800, 800, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bg);
        canvas.drawRect(40, 100, 40 + point * 15, 350, paint);
        BitmapDrawable bd = new BitmapDrawable(bg);
        holder.mLL.setBackgroundDrawable(bd);
        holder.mItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.onResPointSelected(restaurant);
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
