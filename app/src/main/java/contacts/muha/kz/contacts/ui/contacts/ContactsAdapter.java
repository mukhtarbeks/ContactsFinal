package contacts.muha.kz.contacts.ui.contacts;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import contacts.muha.kz.contacts.R;
import contacts.muha.kz.contacts.data.Contact;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {
    private List<Contact> contactList;
    private ContactClickCallback contactClickCallback;

    public ContactsAdapter(ContactClickCallback contactClickCallback) {
        this.contactClickCallback = contactClickCallback;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView name;

        public ViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.image);
            name = view.findViewById(R.id.name);
        }
    }

    @NonNull
    @Override
    public ContactsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.contact_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsAdapter.ViewHolder viewHolder, int i) {
            viewHolder.name.setText(contactList.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }
}
