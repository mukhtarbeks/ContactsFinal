package contacts.muha.kz.contacts;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import contacts.muha.kz.contacts.ui.contacts.ContactsFragment;

public class MainActivity extends AppCompatActivity {
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openContacts();
    }

    private void openContacts(){
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        ContactsFragment contactsFragment = new ContactsFragment();

        fragmentTransaction.add(R.id.main_frame, contactsFragment, ContactsFragment.TAG);
        fragmentTransaction.addToBackStack(ContactsFragment.TAG);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        int count = getSupportFragmentManager().getBackStackEntryCount();

        if(count != 1){
            super.onBackPressed();
        }else {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }
}
