package dzmobileappacademy.com.fragmentlearning;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListPage.CommunicationInterface} interface
 * to handle interaction events.
 * Use the {@link ListPage#calledInstance} factory method to
 * create an instance of this fragment.
 */
public class ListPage extends ListFragment {
    CommunicationInterface calledInstance;


public interface CommunicationInterface {
    public void selectedTitle(int position);
}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // il faut ajouter ce code

        int layout = Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB ?
                android.R.layout.simple_list_item_activated_1 : android.R.layout.simple_expandable_list_item_1;
        setListAdapter(new ArrayAdapter<String>(getActivity(), layout, Model.titles));

    }
    // il faut ajouter onStart pask c'est le point de depart

    @Override
    public void onStart() {
        super.onStart();
        if(getFragmentManager().findFragmentById(R.id.detail_fragment) != null) {
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_page, container, false);
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof CommunicationInterface) {
            calledInstance = (CommunicationInterface) activity;
        } else {
            throw new ClassCastException(activity.toString()
                    + " must implement CommunicationInterface");
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        calledInstance.selectedTitle(position);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        calledInstance = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */

}
