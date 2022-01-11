package com.datechnologies.androidtest.chat;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.datechnologies.androidtest.MessageModel;

import com.datechnologies.androidtest.R;
import com.datechnologies.androidtest.api.ChatLogMessageModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A recycler view adapter used to display chat log messages in {@link ChatActivity}.

 */
public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder>
{
    private final Context context;
    ArrayList<MessageModel> messages = new ArrayList<MessageModel>();
    //==============================================================================================
    // Constructor
    //==============================================================================================
    public ChatAdapter(Context context, ArrayList<MessageModel> messages)
    {
        //chatLogMessageModelList = new ArrayList<>();
        this.context = context;
        this.messages = messages;
    }
    private static final int VIEW_TYPE_MESSAGE = 1;

    public void addMessage(MessageModel message){
        messages.add(message);
        notifyDataSetChanged();
    }

    //==============================================================================================
    // Class Properties
    //==============================================================================================

    //private List<ChatLogMessageModel> chatLogMessageModelList;

    //==============================================================================================
    // Class Instance Methods
    //==============================================================================================

    public void setChatLogMessageModelList(ArrayList<MessageModel> messages2)
    {
        this.messages = messages2;
        notifyDataSetChanged();
    }

    //==============================================================================================
    // RecyclerView.Adapter Methods
    //==============================================================================================

    @Override
    public int getItemViewType(int position) {
        MessageModel message = messages.get(position);
        if(message.messageType == 1){
            return VIEW_TYPE_MESSAGE;
        }
        else
            return 0;
    }

    @Override
    public ChatViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.item_chat, parent, false);

        //return new ChatViewHolder(itemView);
        if(viewType == VIEW_TYPE_MESSAGE){
            return new ChatViewHolder(LayoutInflater.from(context).inflate(R.layout.item_chat, parent, false));
        }
        return new ChatViewHolder(LayoutInflater.from(context).inflate(R.layout.item_chat, parent, false));
    }

    @Override
    public void onBindViewHolder(ChatViewHolder viewHolder, int position)
    {
        //ChatLogMessageModel chatLogMessageModel = chatLogMessageModelList.get(position);

        //viewHolder.messageTextView.setText(chatLogMessageModel.message);
        if (messages.get(position).messageType == VIEW_TYPE_MESSAGE) {
            ((ChatViewHolder) viewHolder).bind(position);
        } else {
            ((ChatViewHolder) viewHolder).bind(position);
        }
    }

    @Override
    public int getItemCount()
    {
        return messages.size();
    }

    //==============================================================================================
    // ChatViewHolder Class
    //==============================================================================================

    public class ChatViewHolder extends RecyclerView.ViewHolder
    {
        TextView userTextView;
        TextView messageTextView;

        ChatViewHolder(final View view)
        {
            super(view);
            //avatarImageView = (ImageView)view.findViewById(R.id.avatarImageView);
            //messageTextView = (TextView)view.findViewById(R.id.messageTextView);
            userTextView = itemView.findViewById(R.id.userTextView);
            messageTextView = itemView.findViewById(R.id.messageTextView);

        }

        void bind(int position){
            MessageModel messageModel = messages.get(position);
            userTextView.setText(messageModel.user);
            messageTextView.setText(messageModel.message);
        }

    }

}
