package com.example.whatsappclone.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsappclone.R
import com.example.whatsappclone.models.Chat
import com.example.whatsappclone.models.Contact

private const val TAG = "ChatListAdapter"

class ChatListAdapter(
    private val onClickCallback: (Contact) -> Unit
) : RecyclerView.Adapter<ChatListAdapter.ChatViewHolder>() {

    private val contactList = mutableListOf<Contact>()

    class ChatViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val chatNameTextView: TextView = view.findViewById(R.id.chat_name_text)
        private val chatLastMessageTextView: TextView = view.findViewById(R.id.last_message_text)

        fun bind(contact: Contact, onClickCallback: (Contact) -> Unit) {
            chatNameTextView.text = contact.contactInformation.fullName
            chatLastMessageTextView.text = contact.chat?.messages?.last()?.body

            itemView.setOnClickListener {
                onClickCallback(contact)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.chat_item, parent, false)
        return ChatViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val chatItem = contactList[position]
        holder.bind(chatItem, onClickCallback)
    }

    override fun getItemCount(): Int = contactList.size

    fun submitList(newContacts: List<Contact>) {
        contactList.clear()
        contactList.addAll(newContacts)
        notifyDataSetChanged()
    }
}
