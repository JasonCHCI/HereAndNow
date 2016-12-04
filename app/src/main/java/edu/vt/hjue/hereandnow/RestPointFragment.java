package edu.vt.hjue.hereandnow;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Callback} interface
 * to handle interaction events.
 */
public class RestPointFragment extends Fragment {

    private Callback callback;

    public RestPointFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle  savedInstanceState) {
        // Inflate the layout for this fragment
        RecyclerView view = (RecyclerView) inflater.inflate(R.layout.fragment_rest_list, container, false);
        view.setLayoutManager(new LinearLayoutManager(getContext()));
        RewardAdapter adapter = new RewardAdapter(getContext(), callback);
        view.setAdapter(adapter);
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Callback) {
            callback = (Callback) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement Callback");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callback = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface Callback {

        void onResPointSelected(Restaurant res);
    }
}

