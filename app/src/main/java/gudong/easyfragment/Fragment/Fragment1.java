package gudong.easyfragment.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import gudong.easyfragment.IFragment1Talk2Main;
import gudong.easyfragment.R;


/**
 * Created by fangtest on 15-7-18.
 */
public class Fragment1 extends Fragment {
    Button btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_frag1, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initUI();
    }

    private void initUI() {
        btn = (Button) getView().findViewById(R.id.frag1Talk2Main);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getActivity() instanceof IFragment1Talk2Main) {
                    IFragment1Talk2Main instance = (IFragment1Talk2Main) getActivity();
                    instance.talk(Fragment1.class.getName());
                }
            }
        });
    }
}
