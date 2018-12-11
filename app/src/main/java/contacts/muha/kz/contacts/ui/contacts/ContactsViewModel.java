package contacts.muha.kz.contacts.ui.contacts;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Room;
import android.support.annotation.NonNull;

import java.util.List;

import contacts.muha.kz.contacts.data.Contact;
import contacts.muha.kz.contacts.data.ContactsDatabase;

public class ContactsViewModel extends AndroidViewModel {
    private ContactsDatabase contactsDatabase;
    private LiveData<List<Contact>> contactsLiveData;


    public ContactsViewModel(@NonNull Application application) {
        super(application);

        contactsDatabase = Room.databaseBuilder(getApplication().getApplicationContext(),
                ContactsDatabase.class, "postDb").allowMainThreadQueries().build();

        contactsLiveData = contactsDatabase.contactsDao().getContacts();
    }

    public void addFavPost(Contact contact){
        contactsDatabase.contactsDao().addContact(contact);
    }

    public LiveData<List<Contact>> getFavPosts(){
        return contactsLiveData;
    }
}
