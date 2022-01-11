package com.datechnologies.androidtest.chat;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.datechnologies.androidtest.MainActivity;
import com.datechnologies.androidtest.MessageModel;
import com.datechnologies.androidtest.R;
import com.datechnologies.androidtest.api.ChatLogMessageModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Screen that displays a list of chats from a chat log.
 */
public class ChatActivity extends AppCompatActivity {

    //==============================================================================================
    // Class Properties
    //==============================================================================================

    private RecyclerView recyclerView;
    private ChatAdapter chatAdapter;

    //==============================================================================================
    // Static Class Methods
    //==============================================================================================

    public static void start(Context context)
    {
        Intent starter = new Intent(context, ChatActivity.class);
        context.startActivity(starter);
    }

    //==============================================================================================
    // Lifecycle Methods
    //==============================================================================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        ActionBar actionBar = getSupportActionBar();

        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        //loadMessages();
        ArrayList<MessageModel> messagesList = new ArrayList<>();

        ChatAdapter chatAdapter = new ChatAdapter(this, messagesList);

        recyclerView.setAdapter(chatAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL,
                false));

        ArrayList<MessageModel> tempList = new ArrayList<MessageModel>();

        MessageModel messageTest = new MessageModel(
                "Tom",
                "random message",
                1
        );
        messageTest.message = "This is test data. Please retrieve real data.";

        tempList.add(messageTest);
        tempList.add(messageTest);
        tempList.add(messageTest);
        tempList.add(messageTest);
        tempList.add(messageTest);
        tempList.add(messageTest);
        tempList.add(messageTest);
        tempList.add(messageTest);

        chatAdapter.setChatLogMessageModelList(tempList);

        // TODO: Make the UI look like it does in the mock-up. Allow for horizontal screen rotation.

        // TODO: Retrieve the chat data from http://dev.rapptrlabs.com/Tests/scripts/chat_log.php
        // TODO: Parse this chat data from JSON into ChatLogMessageModel and display it.
    }

    public void loadMessages(){
        MessageModel message = new MessageModel(
                "Tom",
                "random message",
                1
        );
        chatAdapter.addMessage(message);
    }

    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
