package com.example.chatmessagesgroupingbythedate.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.chatmessagesgroupingbythedate.databinding.IncomingLayoutBinding
import com.example.chatmessagesgroupingbythedate.databinding.OutgoingLayoutBinding
import com.example.chatmessagesgroupingbythedate.dataclass.Message
import java.text.SimpleDateFormat
import java.util.Calendar

class ConversationAdapter(private val context: Context) :
    ListAdapter<Message, RecyclerView.ViewHolder>(MESSAGE_COMPARATOR) {

    companion object {
        private val MESSAGE_COMPARATOR = object : DiffUtil.ItemCallback<Message>() {
            override fun areItemsTheSame(oldItem: Message, newItem: Message): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Message, newItem: Message): Boolean {
                return ((oldItem.name == newItem.name) && (oldItem.text == oldItem.text) && (oldItem.time == newItem.time) && (oldItem.type == newItem.type))
            }
        }
        private const val INCOMING_MESSAGE = 1
        private const val OUTGOING_MESSAGE = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return when (viewType) {
            INCOMING_MESSAGE -> {
                IncomingViewHolder(
                    IncomingLayoutBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                    )
                )
            }

            else -> {
                OutGoingViewHolder(
                    OutgoingLayoutBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                    )
                )
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is IncomingViewHolder -> {
                val currentItem = getItem(position)
                holder.bindItem(currentItem)

                if (position > 0) {
                    val previousItem = getItem(position - 1)

                    if (currentItem.time != previousItem.time) {
                        holder.binding.timing.text = getFormattedTime(currentItem.time)
                        holder.binding.timing.visibility = View.VISIBLE
                    } else {
                        holder.binding.timing.visibility = View.GONE
                    }
                }
                else {
                    // If it's the first item, show the timing view
                    holder.binding.timing.text = getFormattedTime(currentItem.time)
                    holder.binding.timing.visibility = View.VISIBLE
                }
            }

            is OutGoingViewHolder -> {
                val currentItem = getItem(position)
                holder.bindItem(currentItem)

                if (position > 0) {
                    val previousItem = getItem(position - 1)

                    if (currentItem.time != previousItem.time) {
                        holder.binding.timing.text = getFormattedTime(currentItem.time)
                        holder.binding.timing.visibility = View.VISIBLE
                    } else {
                        holder.binding.timing.visibility = View.GONE
                    }
                } else {
                    // If it's the first item, show the timing view
                    holder.binding.timing.text = getFormattedTime(currentItem.time)
                    holder.binding.timing.visibility = View.VISIBLE
                }
            }
        }
    }

    private fun getFormattedTime(time: String?): String? {
        val formatter = SimpleDateFormat("yyyy-MM-dd")
        val formattedDate = formatter.format(Calendar.getInstance().time)
        val yesterday = Calendar.getInstance()
        yesterday.add(Calendar.DAY_OF_YEAR, -1)
        val formattedYesterday = formatter.format(yesterday.time)

        return when (time) {
            formattedDate -> "Today"
            formattedYesterday -> "Yesterday"
            else -> time
        }
    }




    override fun getItemViewType(position: Int): Int {

        return when {
            getItem(position).type.equals("incoming") -> {
                INCOMING_MESSAGE
            }

            getItem(position).type.equals("outgoing") -> {
                OUTGOING_MESSAGE
            }

            else -> {
                super.getItemViewType(position)
            }

        }
    }


    inner class IncomingViewHolder(val binding: IncomingLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindItem(item: Message) {
            binding.incomingMessage.text = item.text
            binding.timing.text = item.time
        }
    }

    inner class OutGoingViewHolder(val binding: OutgoingLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindItem(item: Message) {
            binding.outGoingMessage.text = item.text
            binding.timing.text = item.time
        }
    }
}