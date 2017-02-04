package ameircom.keymedia.Activity;

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


import java.util.ArrayList;

import ameircom.keymedia.Models.MessageModel;
import ameircom.keymedia.R;
import ameircom.keymedia.adapter.MessagesAdapter;

public class MessageRoomDetailsActivity extends AppCompatActivity {
    SwipeRefreshLayout swipeRefresh ;
    RecyclerView course_member_list;
    ArrayList<MessageModel> messageModels = new ArrayList<>();
    private MessagesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_room_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        course_member_list = (RecyclerView) findViewById(R.id.message_recycler_view);

        for (int i=0 ; i<6 ; i++){

            MessageModel messageModel1 = new MessageModel();
            MessageModel messageModel2 = new MessageModel();
            MessageModel messageModel3 = new MessageModel();
            MessageModel messageModel4 = new MessageModel();



            messageModel2.setName("username " + (i+1));
            messageModel1.setName("username " + (i+1));
            messageModel2.setMessage("hello ");
            messageModel1.setMessage("hello ");
            messageModel2.setTimeStamp("12:00 AM ");
            messageModel1.setTimeStamp("12:00 AM ");

            messageModels.add(messageModel1);
            messageModels.add(messageModel2);


            messageModel3.setName("username  ano ");
            messageModel3.setMessage("hello there ");
            messageModel3.setTimeStamp("12:05 AM ");
            messageModels.add(messageModel3);

            messageModel4.setName("me");
            messageModel4.setMessage("hello from right side ");
            messageModel4.setTimeStamp("1:00 pm ");
            messageModels.add(messageModel4);



            Log.e("room for loob" , ",mess size" + messageModels.size());
        }
        setupRefreshLayout();
        recycleSetUP();
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
            course_member_list.setAlpha(0);
            course_member_list.animate().alpha(1);
        }else {
            course_member_list.setVisibility(View.VISIBLE);
        }
    }

    void recycleSetUP() {
        adapter = new MessagesAdapter(this, messageModels);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        course_member_list.setLayoutManager(layoutManager);
        course_member_list.setAdapter(adapter);
        Log.e("members " , messageModels.size() +"");


    }
    private void get_intersted_courses_data() {
        endLoading();
    }

}
