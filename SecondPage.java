package dzmobileappacademy.com.fragmentlearning;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



public class SecondPage extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    static final String ARG_POSITION = "position";
    int currentPosition = 0;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if(savedInstanceState != null) {
            currentPosition = savedInstanceState.getInt(ARG_POSITION);
        }

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second_page, container, false);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(ARG_POSITION, currentPosition);
    }

    @Override
    public void onStart() {
        super.onStart();
        Bundle argument = getArguments();
        if(argument != null) {
            refreshContent(argument.getInt(ARG_POSITION));

        } else if(currentPosition !=  0) {
            refreshContent(currentPosition);
        }
    }

    public  void refreshContent(int position) {
        TextView story = (TextView) getActivity().findViewById(R.id.detail);
        story.setText((Model.titleDetails[position]));
        currentPosition = position;

    }
}
