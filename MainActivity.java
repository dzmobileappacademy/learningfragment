package dzmobileappacademy.com.fragmentlearning;

import android.app.Activity;
import android.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends FragmentActivity implements ListPage.CommunicationInterface {
    @Override
    public void selectedTitle(int position) {
        SecondPage detailFragment = (SecondPage) getSupportFragmentManager().findFragmentById(R.id.detail_fragment);
        if (detailFragment != null) {
            detailFragment.refreshContent(position);
        } else {

            SecondPage newFragment = new SecondPage();
            Bundle argument = new Bundle();
            argument.putInt(SecondPage.ARG_POSITION, position);
            newFragment.setArguments(argument);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.container, newFragment);
            transaction.addToBackStack(null);
            transaction.commit();

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_list_page);
        // ghadi nverifiw yelakan activity raha testa3mel layout m3a fragment_container

        if (findViewById(R.id.container) != null) {
            if (savedInstanceState != null) {
                return;

            }
            // create fragment
            ListPage listFragment = new ListPage();
            listFragment.setArguments(getIntent().getExtras());
            // add fragment to container
            getSupportFragmentManager().beginTransaction().add(R.id.container, listFragment).commit();

        }
    }
}


