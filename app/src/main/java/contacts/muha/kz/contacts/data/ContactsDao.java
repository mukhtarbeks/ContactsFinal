package contacts.muha.kz.contacts.data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface ContactsDao {
    @Insert
    void addContact(Contact contact);

    @Query("select * from contacts")
    LiveData<List<Contact>> getContacts();
}
