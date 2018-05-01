package com.example.android.selfmessages;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


public class MessageAdapter extends ArrayAdapter<Message> {

    private Context mContext;
    private List<Message> messages;

    public MessageAdapter(@NonNull Context context, int resource, @NonNull List<Message> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.messages = objects;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.message, parent, false);

        Message currentMessage = messages.get(position);

        TextView messageText = (TextView) listItem.findViewById(R.id.message_text);
        TextView sender = (TextView) listItem.findViewById(R.id.sender);
        TextView date = (TextView) listItem.findViewById(R.id.date);

        messageText.setText(currentMessage.getMessage());
        sender.setText(currentMessage.getSender());
        date.setText(currentMessage.getMessage_date());

        return listItem;
    }
}
