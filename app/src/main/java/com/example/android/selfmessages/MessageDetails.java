package com.example.android.selfmessages;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class MessageDetails extends Fragment implements View.OnClickListener {

    private int index;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_message_details, container, false);
        // everything..

        Button cancel = (Button) view.findViewById(R.id.cancel_fragment);
        Button delete = (Button) view.findViewById(R.id.delete_message);

        cancel.setOnClickListener(this);
        delete.setOnClickListener(this);

        TextView sender = (TextView) view.findViewById(R.id.sender_name_box);
        TextView date = (TextView) view.findViewById(R.id.message_date_box);
        TextView msg = (TextView) view.findViewById(R.id.message_box);

        sender.setText(MainActivity.messagesArray.get(MainActivity.item_position).getSender());
        date.setText(MainActivity.messagesArray.get(MainActivity.item_position).getMessage_date());
        msg.setText(MainActivity.messagesArray.get(MainActivity.item_position).getMessage());

        return view;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.delete_message:
                MainActivity.messagesArray.remove(MainActivity.item_position);
            default:
                android.support.v4.app.FragmentTransaction fr =
                        getActivity().getSupportFragmentManager().beginTransaction();
                fr.replace(R.id.messageFrame, new HomeFragment()).commit();
        }
    }
}
