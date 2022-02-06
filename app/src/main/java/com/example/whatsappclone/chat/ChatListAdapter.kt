package com.example.whatsappclone.chat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsappclone.R

class ChatListAdapter(private val dataSet: Array<ChatItem>) :
    RecyclerView.Adapter<ChatListAdapter.ChatViewHolder>() {

    class ChatViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val chatNameTextView: TextView = view.findViewById(R.id.chat_name_text)
        private val chatLastMessageTextView: TextView = view.findViewById(R.id.last_message_text)

        fun bind(chat: ChatItem) {
            chatNameTextView.text = chat.chatName
            chatLastMessageTextView.text = chat.chatLastMessage
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.chat_item, parent, false)
        return ChatViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val chatItem = dataSet[position]
        holder.bind(chatItem)
    }

    override fun getItemCount(): Int = dataSet.size
}