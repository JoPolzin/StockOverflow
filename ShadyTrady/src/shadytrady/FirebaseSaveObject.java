/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shadytrady;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import control.maincontrol;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FirebaseSaveObject {

    public static void main(String[] args) {
        Item item = new Item();
        item.setId(25L);
        item.setName("AutoG");
        item.setPrice(800.00);

        // save item objec to firebase.
        FirebaseSaveObject fso = new FirebaseSaveObject();
        fso.initFirebase();
        fso.save(item);
        fso.receive();
        
        String s = "\"/testnutzer";
        String t = "dfsdf";
        fso.Login(s, t);
    }

    private FirebaseDatabase firebaseDatabase;
    private maincontrol c;

    
    public FirebaseSaveObject() {
    }
    
    public FirebaseSaveObject(maincontrol mc) {
        this.c = mc;
    }

    /**
     * initialize firebase.
     */
    private void initFirebase() {
        try {
            FileInputStream serviceAccount = new FileInputStream("aktienspiel-97ea0-c6776b4f804e.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://aktienspiel-97ea0.firebaseio.com/")
                    .build();

            FirebaseApp.initializeApp(options);
            firebaseDatabase = FirebaseDatabase.getInstance();
            firebaseDatabase.getReference("/").addValueEventListener(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // for example: if you're expecting your user's data as an object of the "User" class.
                        Item item = dataSnapshot.getValue(Item.class);
                System.err.println(item.getPrice());
                        ;
                    }
                    
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // read query is cancelled.
                    }
                });
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(FirebaseSaveObject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Save item object in Firebase.
     *
     * @param item
     */
    private void save(Item item) {
        if (item != null) {
            //initFirebase();

            /* Get database root reference */
            DatabaseReference databaseReference = firebaseDatabase.getReference("/");

            /* Get existing child or will be created new child. */
            DatabaseReference childReference = databaseReference.child("Benutzer");
            Map<String, Object> userUpdates = new HashMap<>();
            userUpdates.put("alanisawesome/nickname", "Alan The Machine");
            userUpdates.put("alanisawesome/passwort", "geheim");
            userUpdates.put("testnutzer/nickname", "test");
            userUpdates.put("testnutzer/passwort", "geheim");
            userUpdates.put("testnutzer/vorname", "Test");
            userUpdates.put("gracehop/nickname", "Amazing Grace");
            userUpdates.put("teacher/nickname", "Muster");

            databaseReference.updateChildrenAsync(userUpdates);
            /**
             * The Firebase Java client uses daemon threads, meaning it will not
             * prevent a process from exiting. So we'll
             * wait(countDownLatch.await()) until firebase saves record. Then
             * decrement `countDownLatch` value using
             * `countDownLatch.countDown()` and application will continues its
             * execution.
             */
            CountDownLatch countDownLatch = new CountDownLatch(1);
            childReference.setValue(item, new DatabaseReference.CompletionListener() {

                @Override
                public void onComplete(DatabaseError de, DatabaseReference dr) {
                    System.out.println("Record saved!");
                    // decrement countDownLatch value and application will be continues its execution.
                    countDownLatch.countDown();
                }
            });
            try {
                //wait for firebase to saves record.
                countDownLatch.await();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void receive() {
        //final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = firebaseDatabase.getReference("/testnutzer");

// Attach a listener to read the data at our posts reference
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //Post post = dataSnapshot.getValue(Post.class);
                System.out.println(dataSnapshot.getValue());
                //Item it = dataSnapshot.getValue(Item.class);
                System.out.println(dataSnapshot.getValue());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });
    }
    
    /**
     *
     * @param Benutzername
     */
    public void Login(String Benutzername, String Password) {
        //final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = firebaseDatabase.getReference("/" + Benutzername );

        
        
        
  
// Attach a listener to read the data at our posts reference
        ref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //Post post = dataSnapshot.getValue(Post.class);
               
                //Item it = dataSnapshot.getValue(Item.class);
                    
                 String data = dataSnapshot.getValue().toString();
                 
                 String[] datarray;
                 
                 datarray = data.split(", ");
                 datarray = data.split("=");
                 
                 
            
                
                
                
                
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });
        

    
    
}
}
