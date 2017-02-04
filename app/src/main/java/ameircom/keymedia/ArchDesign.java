
package ameircom.keymedia;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import ameircom.keymedia.Activity.Pa360DetailsActivity;
import ameircom.keymedia.Models.FeedModel;
import ameircom.keymedia.adapter.CustomListAdapterTwo;
import ameircom.keymedia.adapter.MessagesAdapter;
import ameircom.keymedia.adapter.NewsFeedAdapter;
import ameircom.keymedia.data.Config;
import ameircom.keymedia.helper.RecyclerViewTouchHelper;

public class ArchDesign extends AppCompatActivity {
    SwipeRefreshLayout swipeRefresh ;
    ArrayList<FeedModel> data = new ArrayList<>() ; 
    RecyclerView news_recycler ; 
    NewsFeedAdapter adapter ;

    String[] itemname  ;

    Integer[] imgid   ;
    ImageView i ;
    int type ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arch_design);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        news_recycler = (RecyclerView) findViewById(R.id.news_recycler_view);

        try {
          type =   getIntent().getExtras().getInt("type");
            switch (type ){
                case Config.media : {

                     itemname = new String[]{
                             "Key Media 1",
                             "Key Media 2",
                             "Key Media 3",
                             "Key Media 4",
                             "Key Media 5",
                             "Key Media 6",
                             "Key Media 7"
                     };

                    imgid = new Integer[]{
                            R.drawable.mediaone,
                            R.drawable.mediatwo,
                            R.drawable.mediathree,
                            R.drawable.mediafour,
                            R.drawable.mediafive,
                            R.drawable.mediasix,
                            R.drawable.mediaseven


                    };

                 break;
                }

                case Config.adv : {
                     itemname = new String[]{
                             "خدماتنا",
                             "حتما سنعود",
                             "من نحن",
                             "Make today Amazing",
                             "Key Media"
                     };

                 imgid = new Integer[]{
                         R.drawable.onee,
                         R.drawable.twoo,
                         R.drawable.thrie,
                         R.drawable.fourrr,
                         R.drawable.fiveee,

                 };

                 break;
                }

                case Config.mob : {
                    itemname = new String[]{
                            "Key Media 1",
                            "Key Media 2",
                            "Key Media 3",
                            "Key Media 4",
                            "Key Media 5",
                            "Key Media 6",
                            "Key Media 7"
                    };

                    imgid = new Integer[]{
                            R.drawable.mediaone,
                            R.drawable.mediatwo,
                            R.drawable.mediathree,
                            R.drawable.mediafour,
                            R.drawable.mediafive,
                            R.drawable.mediasix,
                            R.drawable.mediaseven


                    };


                    break;
                }
                case Config.arc : {
                 itemname = new String[]{
                         "Key Media 1",
                         "Key Media 2",
                         "Key Media 3",
                         "Key Media 4",
                         "Key Media 5",
                         "Key Media 6",
                         "Key Media 7",
                         "Key Media 8",
                         "Key Media 9",
                         "Key Media 10"
                 };

                imgid = new Integer[]{
                        R.drawable.archone,
                        R.drawable.archtwo,
                        R.drawable.archthree,
                        R.drawable.archfour,
                        R.drawable.archfive,
                        R.drawable.archsix,
                        R.drawable.archseven,
                        R.drawable.archeight,
                        R.drawable.archnine,
                        R.drawable.archten

                };

                 break;
                }
                case Config.pa360 : {
                    itemname = new String[]{
                            "Key Media 1",
                            "Key Media 2",
                            "Key Media 3",
                            "Key Media 4",
                            "Key Media 5",
                            "Key Media 6",
                            "Key Media 7"
                    };

                    imgid = new Integer[]{
                            R.drawable.mediaone,
                            R.drawable.mediatwo,
                            R.drawable.mediathree,
                            R.drawable.mediafour,
                            R.drawable.mediafive,
                            R.drawable.mediasix,
                            R.drawable.mediaseven


                    };

                 break;
                }
            }

        }catch (NullPointerException e){

        }
        setupRefreshLayout();
        recycleSetUP();

        for (int i =0; i<imgid.length ;i++ ){
            FeedModel model = new FeedModel() ;
            model.setImg(imgid[i]);
            model.setText(itemname[i]);
            data.add(model) ;
        }

        adapter.notifyDataSetChanged();
        
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            supportFinishAfterTransition();

        return  true ;
    }

    private void setupRefreshLayout(){
        swipeRefresh = (SwipeRefreshLayout) findViewById(R.id.swipeRefresh);
        swipeRefresh.setColorSchemeColors(ContextCompat.getColor(getApplicationContext(),R.color.red));
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                get_intersted_courses_data();
            }
        });
    }

    private void endLoading() {
        swipeRefresh.post(new Runnable() {
            @Override
            public void run() {
                swipeRefresh.setRefreshing(false);
            }
        });
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1) {
            news_recycler.setAlpha(0);
            news_recycler.animate().alpha(1);
        }else {
            news_recycler.setVisibility(View.VISIBLE);
        }
    }

    void recycleSetUP() {
        adapter = new NewsFeedAdapter(this, data);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        news_recycler.setLayoutManager(layoutManager);
        news_recycler.setAdapter(adapter);
        Log.e("members " , data.size() +"");
        news_recycler.addOnItemTouchListener(new RecyclerViewTouchHelper(getApplicationContext(), news_recycler, new RecyclerViewTouchHelper.recyclerViewTouchListner() {
            @Override
            public void onclick(View child, int postion) {
                if (type == Config.pa360){
                        startPa360Details(child.findViewById(R.id.news_cover_img));
                }else {}
            }

            @Override
            public void onLongClick(View child, int postion) {

            }
        }));


    }
    private void get_intersted_courses_data() {
        endLoading();
    }

    void startPa360Details(View view){

        Intent intent = new Intent(getApplicationContext() , Pa360DetailsActivity.class);
//        intent.putExtra("extra_id", extra.getCreator_id());
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
//            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(ArchDesign.this,
//                    view, getString(R.string.pa360_details_transition));
//
//
//            startActivity(intent,options.toBundle());
//        }else {
//            startActivity(intent);
//        }
        startActivity(intent);

    }

}
