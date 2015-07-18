package gudong.easyfragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import gudong.easyfragment.Fragment.Fragment1;
import gudong.easyfragment.Fragment.Fragment2;
import gudong.easyfragment.Fragment.ItemFragment;
import gudong.easyfragment.Fragment.PlusOneFragment;

public class MainActivity extends Activity implements IFragment1Talk2Main, ItemFragment.OnFragmentInteractionListener,PlusOneFragment.OnFragmentInteractionListener {

    Button bt1, bt2, bt3, bt4;
    Fragment fragment1, fragment2, fragment3, fragment4;

    View.OnClickListener changeClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FragmentManager fragManager = getFragmentManager();
            FragmentTransaction transaction = fragManager.beginTransaction();

            if (v == bt1) {
                if (fragment1 == null) {
                    fragment1 = new Fragment1();
                }
                transaction.replace(R.id.fragment_container, fragment1);

            } else if (v == bt2) {
                if (fragment2 == null) {
                    fragment2 = new Fragment2();
                }
                transaction.replace(R.id.fragment_container, fragment2);
            } else if (v == bt3) {
                if (fragment3 == null) {
                    fragment3 = new ItemFragment();
                }
                transaction.replace(R.id.fragment_container, fragment3);
            } else if (v == bt4) {
                if (fragment4 == null) {
                    fragment4 = new PlusOneFragment();
                }
                transaction.replace(R.id.fragment_container, fragment4);
            }
            transaction.commit();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1 = (Button) findViewById(R.id.first);
        bt2 = (Button) findViewById(R.id.second);
        bt3 = (Button) findViewById(R.id.third);
        bt4 = (Button) findViewById(R.id.fouth);

        bt1.setOnClickListener(changeClick);
        bt2.setOnClickListener(changeClick);
        bt3.setOnClickListener(changeClick);
        bt4.setOnClickListener(changeClick);
    }


    //talk fragment1
    @Override
    public void talk(String something) {
        Toast.makeText(this, something, Toast.LENGTH_LONG).show();
    }

    //talk fragment3
    @Override
    public void onFragmentInteraction(String id) {

    }

    //talk fragment4
    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

