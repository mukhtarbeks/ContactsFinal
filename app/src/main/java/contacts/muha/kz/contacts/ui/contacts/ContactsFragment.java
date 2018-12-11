package contacts.muha.kz.contacts.ui.contacts;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.List;

import contacts.muha.kz.contacts.R;
import contacts.muha.kz.contacts.data.Contact;
import contacts.muha.kz.contacts.utils.Constants;


public class ContactsFragment extends Fragment {
    public static final String TAG = Constants.CONTACTSFRAGMENT;

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private FloatingActionButton addButton;

    public ContactsViewModel contactsViewModel;
    private ContactsAdapter contactsAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contacts, container, false);
        initViews(view);

        contactsAdapter = new ContactsAdapter(contactClickCallback);
        recyclerView.setAdapter(contactsAdapter);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        contactsViewModel = ViewModelProviders.of(this).get(ContactsViewModel.class);
        observeViewModel(contactsViewModel);
    }

    private void observeViewModel(ContactsViewModel viewModel){
        viewModel.getFavPosts().observe(getActivity(), new Observer<List<Contact>>() {
            @Override
            public void onChanged(@Nullable List<Contact> contacts) {
                contactsAdapter.setContactList(contacts);
            }
        });
    }

    private void initViews(View view) {
        recyclerView = view.findViewById(R.id.contacts_list);
        progressBar = view.findViewById(R.id.progressbar);
        addButton = view.findViewById(R.id.add_button);

        setListeners();
    }

    private void setListeners() {
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private final ContactClickCallback contactClickCallback = new ContactClickCallback(){
        @Override
        public void onClick(Contact contact) {

        }
    };
}
