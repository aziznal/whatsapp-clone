package com.example.whatsappclone.fragments.newChat

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsappclone.databinding.FragmentNewChatBinding
import com.example.whatsappclone.models.Contact

private const val TAG = "NewChatCandidateRecycle"

class NewChatCandidateRecyclerViewAdapter(
) : RecyclerView.Adapter<NewChatCandidateRecyclerViewAdapter.ViewHolder>() {

    val contacts = mutableListOf<Contact>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            FragmentNewChatBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = contacts[position]

        holder.idView.text = item.id
        holder.contentView.text = item.fullName
    }

    override fun getItemCount(): Int = contacts.size

    fun submitList(newContacts: List<Contact>) {
        contacts.clear()
        contacts.addAll(newContacts)
        notifyDataSetChanged()
    }

    inner class ViewHolder(binding: FragmentNewChatBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.itemNumber
        val contentView: TextView = binding.content

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

}