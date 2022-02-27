package com.example.whatsappclone.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsappclone.databinding.FragmentNewChatBinding
import com.example.whatsappclone.data.models.Contact

private const val TAG = "NewChatCandidateRecycle"

class AddNewChatAdapter(
) : RecyclerView.Adapter<AddNewChatAdapter.ViewHolder>() {

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
        val contact = contacts[position]

        holder.idView.text = contact.id
        holder.contentView.text = contact.contactInformation.fullName
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