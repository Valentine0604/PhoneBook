import java.util.ArrayList;
import java.util.List;

public class ContactManager {
    private ArrayList<Contact> contacts;

    public ContactManager(ArrayList<Contact> contacts){
    }

    public Contact getContact(int index){
        return contacts.get(index);
    }

    public void setContact(Contact contact, int index){
        contacts.set(index,contact);
    }

}
