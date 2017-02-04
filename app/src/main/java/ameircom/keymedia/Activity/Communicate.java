
package ameircom.keymedia.Activity;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import ameircom.keymedia.R;
import ameircom.keymedia.adapter.CustomListAdapter;

public class Communicate extends AppCompatActivity {


    ListView list;
    String[] itemname = {
            "Call us",
            "Message us",
            "KeyMedia Chat !"

    };

    Integer[] imgid = {
            R.drawable.imgtwo,
            R.drawable.imgone,
            R.drawable.imgthree,

    };
    ImageView i ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communicate);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        CustomListAdapter adapter = new CustomListAdapter(this, itemname, imgid);
        list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                String Slecteditem = itemname[+position];
                Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();
                if (Slecteditem.equals("Call us")) {
                    String number = "01113031657";
                    Uri call = Uri.parse("tel:" + number);
                    Intent surf = new Intent(Intent.ACTION_DIAL, call);
                    startActivity(surf);

                    Toast.makeText(Communicate.this, "Calling now !", Toast.LENGTH_SHORT).show();
                }
               else if (Slecteditem.equals("Message us")) {
                    Uri uri = Uri.parse("smsto:01113031657");
                    Intent it = new Intent(Intent.ACTION_SENDTO, uri);
                    it.putExtra("sms_body", "The SMS text To Key Media");
                    startActivity(it);

                    Toast.makeText(Communicate.this, "Messaging now !", Toast.LENGTH_SHORT).show();
                    /*startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("sms:"
                            + "01113031657")));*/
                }
               else if (Slecteditem.equals(itemname[2])){

                     startActivity(new Intent(getApplication(), MessageRoomDetailsActivity.class));
                }
                else Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();


            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();

        overridePendingTransition(R.anim.exit_prev, R.anim.enter_rev);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true ;

        }
        return false ;
    }
}

