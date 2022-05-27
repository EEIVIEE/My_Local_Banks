package sg.edu.rp.c346.id21021397.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView dbs;
    TextView ocbc;
    TextView uob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbs = findViewById(R.id.textViewDBS);
        ocbc = findViewById(R.id.textViewOCBC);
        uob = findViewById(R.id.textViewUOB);

        registerForContextMenu(dbs);
        registerForContextMenu(ocbc);
        registerForContextMenu(uob);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v == dbs) {
            menu.add(0, 0, 0, "Website");
            menu.add(0, 1, 1, "Contact the Bank");
        } else if (v == ocbc) {
            menu.add(1, 0, 0, "Website");
            menu.add(1, 1, 1, "Contact the Bank");
        } else if (v == uob) {
            menu.add(2, 0, 0, "Website");
            menu.add(2, 1, 1, "Contact the Bank");
        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getGroupId() == 0) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intentWebsite = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg/index/default.page"));
                startActivity(intentWebsite);

                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) {
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "1800 111 1111"));
                startActivity(intentCall);

                return true; //menu item successfully handled
            }
        } else if (item.getGroupId() == 1) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intentWebsite = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com/group/gateway.page"));
                startActivity(intentWebsite);

                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) {
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "1800 363 3333"));
                startActivity(intentCall);

                return true; //menu item successfully handled
            }
        } else if (item.getGroupId() == 2) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intentWebsite = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
                startActivity(intentWebsite);

                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) {
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "1800 222 2121"));
                startActivity(intentCall);

                return true; //menu item successfully handled
            }


        }
        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }
}