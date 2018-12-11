package contacts.muha.kz.contacts.ui.contacts;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import contacts.muha.kz.contacts.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactItemFragment extends Fragment {


    public ContactItemFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact_item, container, false);
    }

}
