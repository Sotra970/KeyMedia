package ameircom.keymedia.adapter;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.ArrayList;

import ameircom.keymedia.Models.MessageModel;
import ameircom.keymedia.R;

/**
 * Created by sotra on 9/25/2016.
 */
public class MessagesAdapter extends  RecyclerView.Adapter<MessagesAdapter.CoursesViewHolder> {
    private Activity context ;
    private ArrayList<MessageModel> data ;
    private LayoutInflater layoutInflater ;
    int bg_color ;

    public MessagesAdapter(Activity context, ArrayList<MessageModel> data  )  {
        this.context = context;
        this.data = data;
        this.bg_color = bg_color ;
        layoutInflater = LayoutInflater.from(context);
        Log.e("newAdapter","size" + data.size());

    }
    public MessageModel getItem(int postion){
        return  data.get(postion);
    }


    @Override
    public MessagesAdapter.CoursesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.message_item,parent,false);
        CoursesViewHolder coursesViewHolder = new CoursesViewHolder(view);
        return coursesViewHolder;
    }

    @Override
    public void onBindViewHolder(MessagesAdapter.CoursesViewHolder holder, final int position) {
        final MessageModel currentElement =  data.get(position);
        holder.from.setText(currentElement.getName());
        holder.timestamp.setText(currentElement.getTimeStamp());
        holder.message.setText(currentElement.getMessage());
        if (currentElement.getName().equals("me"))
            holder.message_container.setGravity(Gravity.RIGHT);
        Log.e("course member adapter","onb"  );
    }

  

    @Override
    public int getItemCount() {
        return data.size();
    }
    public void insertData(MessageModel data){
        this.data.add(data);
        notifyDataSetChanged();
    }
    public void refresh(ArrayList<MessageModel> data) {
        this.data = data ;
        notifyDataSetChanged();
    }

    public class  CoursesViewHolder extends RecyclerView.ViewHolder {
        TextView name , message , timestamp , from;
        LinearLayout message_container  ;
        public CoursesViewHolder(View itemView) {
            super(itemView);
            message = (TextView) itemView.findViewById(R.id.message);
            timestamp = (TextView) itemView.findViewById(R.id.timestamp);
            from = (TextView) itemView.findViewById(R.id.mess_from);
            message_container =(LinearLayout)itemView.findViewById(R.id.message_container);
        }
    }

}
