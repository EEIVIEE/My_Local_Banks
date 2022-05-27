package sg.edu.rp.c346.id21021397.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
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
                Intent intentWebsite = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.dbslink)));
                startActivity(intentWebsite);

                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) {
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + R.strSing.dbscontact));
                startActivity(intentCall);

                return true; //menu item successfully handled
            }
        } else if (item.getGroupId() == 1) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intentWebsite = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.ocbclink)));
                startActivity(intentWebsite);

                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) {
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + R.string.ocbccontact));
                startActivity(intentCall);

                return true; //menu item successfully handled
            }
        } else if (item.getGroupId() == 2) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intentWebsite = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.uoblink)));
                startActivity(intentWebsite);

                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) {
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + R.string.uobcontact));
                startActivity(intentCall);

                return true; //menu item successfully handled
            }


        }
        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            dbs.setText(R.string.dbs);
            ocbc.setText(R.string.ocbc);
            uob.setText(R.string.uob);
            return true;
        } else if (id == R.id.ChineseSelection) {
            dbs.setText(R.string.dbschinese);
            ocbc.setText(R.string.ocbcchinese);
            uob.setText(R.string.uobchinese);
            return true;
        } else{

        }

        return super.onOptionsItemSelected(item);
    }

}