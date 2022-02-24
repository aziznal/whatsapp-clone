package com.example.whatsappclone.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsappclone.R
import com.example.whatsappclone.models.Chat

private const val TAG = "ChatListAdapter"

class ChatListAdapter(
    private val dataSet: Array<Chat>,
    private val onClickCallback: (Chat) -> Unit
) : RecyclerView.Adapter<ChatListAdapter.ChatViewHolder>() {

    class ChatViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val chatNameTextView: TextView = view.findViewById(R.id.chat_name_text)
        private val chatLastMessageTextView: TextView = view.findViewById(R.id.last_message_text)

        fun bind(chat: Chat, onClickCallback: (Chat) -> Unit) {
            chatNameTextView.text = chat.otherPersonContactId.toString()
            chatLastMessageTextView.text = "I know what you did :)"

            itemView.setOnClickListener {
                onClickCallback(chat)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.chat_item, parent, false)
        return ChatViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val chatItem = dataSet[position]
        holder.bind(chatItem, onClickCallback)
    }

    override fun getItemCount(): Int = dataSet.size
}
