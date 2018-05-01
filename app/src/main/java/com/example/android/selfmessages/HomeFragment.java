package com.example.android.selfmessages;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    ListView messages;
    Button sendMessage;
    EditText sendMessageEditText;
    EditText sendMessageSenderText;
    private MessageAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.frag_home, container, false);
        messages = view.findViewById(R.id.messagesList);
        sendMessage = view.findViewById(R.id.sendMessage);
        sendMessageEditText = view.findViewById(R.id.sendMessageText);
        sendMessageSenderText = view.findViewById(R.id.userName);

        adapter = new MessageAdapter(view.getContext(), 0 , MainActivity.messagesArray);

        messages.setAdapter(adapter);

        sendMessage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!sendMessageEditText.getText().toString().isEmpty())
                {
                    MainActivity.messagesArray.add(new Message(sendMessageSenderText.getText().toString(),
                            sendMessageEditText.getText().toString()));
                    messages.setAdapter(adapter);
                    sendMessageEditText.setText("");
                }
            }
        });

        messages.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MainActivity.item_position = position;
                android.support.v4.app.FragmentTransaction fr =
                        getActivity().getSupportFragmentManager().beginTransaction();
                fr.replace(R.id.messageFrame, new MessageDetails()).commit();
            }
        });
        return view;
    }

}
