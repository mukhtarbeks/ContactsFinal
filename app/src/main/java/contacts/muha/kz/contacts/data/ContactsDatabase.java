package contacts.muha.kz.contacts.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Contact.class},version = 1, exportSchema = false)
public abstract class ContactsDatabase extends RoomDatabase{
    public abstract ContactsDao contactsDao();
}
