package shadytrady;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
//import com.javaquery.bean.Item;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.CountDownLatch;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.io.IOException;

/**
 * Example of Firebase save.
 *
 * @author javaQuery
 * @date 7th September, 2016
 * @Github: https://github.com/javaquery/Examples
 */
public class FirebaseSaveObject {

    public static void main(String[] args) {
        Item item = new Item();
        item.setId(1L);
        item.setName("MotoG");
        item.setPrice(100.12);

        // save item objec to firebase.
        new FirebaseSaveObject().save(item);
    }

    private FirebaseDatabase firebaseDatabase;

    /**
     * initialize firebase.
     */
    private void initFirebase() throws IOException {
        try {
            // .setDatabaseUrl("https://fir-66f50.firebaseio.com") - Firebase project url.

            // Firebase private key(Generated while creating service account) file path.
            // .setServiceAccount(new FileInputStream(new File("filepath")))
            FirebaseOptions firebaseOptions = new FirebaseOptions.Builder()
                    .setDatabaseUrl("https://aktienspiel-97ea0.firebaseio.com")
                    .setServiceAccount(new FileInputStream(new File("aktienspiel-97ea0-firebase-adminsdk-27qmq-4a3a6ba14e.json")))
                    .build();
            FileInputStream serviceAccount
                    = new FileInputStream("path/to/serviceAccountKey.json");

            FirebaseOptions options = new FirebaseOptions.Builder().setCredentials(GoogleCredentials.fromStream(serviceAccount)).setDatabaseUrl("https://aktienspiel-97ea0.firebaseio.com").build();

            FirebaseApp.initializeApp(options);
            /*
            FirebaseApp.initializeApp(firebaseOptions);
            firebaseDatabase = FirebaseDatabase.getInstance();*/
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Save item object in Firebase.
     *
     * @param item
     */
    private void save(Item item) {
        if (item != null) {
            initFirebase();

            /* Get database root reference */
            DatabaseReference databaseReference = firebaseDatabase.getReference("/");

            /* Get existing child or will be created new child. */
            DatabaseReference childReference = databaseReference.child("item");

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
}
