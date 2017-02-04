package ameircom.keymedia.Activity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import ameircom.keymedia.adapter.CustomListAdapter;
import ameircom.keymedia.R;


public class Main2Activity extends AppCompatActivity{

    ListView list;
    String[] itemname ={

            "Our Departmenmts",
            "Cashing/Order",
            "About us",
            "Comminucate with us"
    };

    Integer[] imgid={

            R.drawable.imgone,
            R.drawable.imgthree,
            R.drawable.imgfour,
            R.drawable.imgfive
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        CustomListAdapter adapter=new CustomListAdapter(this, itemname, imgid);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        list.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                String Slecteditem= itemname[+position];
                if ( Slecteditem.equals("About us"))
                {
                    Intent i = new Intent(Main2Activity.this , AboutUS.class);startActivity(i);
                    overridePendingTransition(R.anim.products_enter, R.anim.products_exit);
                }
                else  if ( Slecteditem.equals("Our Departmenmts"))
                {
                    Intent i = new Intent(Main2Activity.this , MainActivity.class);startActivity(i);
                    overridePendingTransition(R.anim.products_enter, R.anim.products_exit);
                }
                else if ( Slecteditem.equals("Comminucate with us"))
                {
                    Intent i = new Intent(Main2Activity.this , Communicate.class);startActivity(i);
                    overridePendingTransition(R.anim.products_enter, R.anim.products_exit);
                }
                else Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();

            }
        });
    }
}