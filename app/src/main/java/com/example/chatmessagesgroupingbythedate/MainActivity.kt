package com.example.chatmessagesgroupingbythedate

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chatmessagesgroupingbythedate.adapter.ConversationAdapter
import com.example.chatmessagesgroupingbythedate.databinding.ActivityMainBinding
import com.example.chatmessagesgroupingbythedate.dataclass.Message

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setupAdapter()
    }

    private fun setupAdapter() {

        val layoutManager = LinearLayoutManager(this)
        binding.conversationRecyclerView.layoutManager = layoutManager
        val list = listOf<Message>(
            Message(id = "41", text = "Almost there!", time = "2023-04-31", type = "outgoing"),
            Message(id = "42", text = "Take your time.", time = "2023-04-31", type = "incoming"),
            Message(id = "43", text = "See you soon!", time = "2023-04-31", type = "outgoing"),
            Message(id = "44", text = "Goodbye!", time = "2023-04-31", type = "incoming"),
            Message(
                id = "45",
                text = "It was nice talking to you.",
                time = "2023-04-31",
                type = "outgoing"
            ),
            Message(id = "46", text = "Likewise!", time = "2023-04-31", type = "incoming"),
            Message(id = "47", text = "Have a great day!", time = "2023-04-31", type = "outgoing"),
            Message(id = "48", text = "You too!", time = "2023-04-31", type = "incoming"),
            Message(id = "49", text = "Bye!", time = "2023-04-31", type = "outgoing"),
            Message(id = "50", text = "See you!", time = "2023-04-31", type = "incoming"),

            Message(id = "51", text = "Almost there!", time = "2023-05-31", type = "outgoing"),
            Message(id = "52", text = "Take your time.", time = "2023-05-31", type = "incoming"),
            Message(id = "53", text = "See you soon!", time = "2023-05-31", type = "outgoing"),
            Message(id = "54", text = "Goodbye!", time = "2023-05-31", type = "incoming"),
            Message(
                id = "55",
                text = "It was nice talking to you.",
                time = "2023-05-31",
                type = "outgoing"
            ),
            Message(id = "56", text = "Likewise!", time = "2023-05-31", type = "incoming"),
            Message(id = "57", text = "Have a great day!", time = "2023-05-31", type = "outgoing"),
            Message(id = "58", text = "You too!", time = "2023-05-31", type = "incoming"),
            Message(id = "59", text = "Bye!", time = "2023-05-31", type = "outgoing"),
            Message(id = "60", text = "See you!", time = "2023-05-31", type = "incoming"),

            Message(id = "61", text = "Almost there!", time = "2023-06-31", type = "outgoing"),
            Message(id = "62", text = "Take your time.", time = "2023-06-31", type = "incoming"),
            Message(id = "63", text = "See you soon!", time = "2023-06-31", type = "outgoing"),
            Message(id = "64", text = "Goodbye!", time = "2023-06-31", type = "incoming"),
            Message(
                id = "65",
                text = "It was nice talking to you.",
                time = "2023-06-31",
                type = "outgoing"
            ),
            Message(id = "66", text = "Likewise!", time = "2023-06-31", type = "incoming"),
            Message(id = "67", text = "Have a great day!", time = "2023-06-31", type = "outgoing"),
            Message(id = "68", text = "You too!", time = "2023-06-31", type = "incoming"),
            Message(id = "69", text = "Bye!", time = "2023-06-31", type = "outgoing"),
            Message(id = "70", text = "See you!", time = "2023-06-31", type = "incoming"),


            Message(id = "91", text = "Almost there!", time = "2023-09-31", type = "outgoing"),
            Message(id = "92", text = "Take your time.", time = "2023-09-31", type = "incoming"),
            Message(id = "93", text = "See you soon!", time = "2023-09-31", type = "outgoing"),
            Message(id = "94", text = "Goodbye!", time = "2023-09-31", type = "incoming"),
            Message(
                id = "95",
                text = "It was nice talking to you.",
                time = "2023-09-31",
                type = "outgoing"
            ),
            Message(id = "96", text = "Likewise!", time = "2023-09-31", type = "incoming"),
            Message(id = "97", text = "Have a great day!", time = "2023-09-31", type = "outgoing"),
            Message(id = "98", text = "You too!", time = "2023-09-31", type = "incoming"),
            Message(id = "99", text = "Bye!", time = "2023-09-31", type = "outgoing"),
            Message(id = "100", text = "See you!", time = "2023-09-31", type = "incoming"),

            Message(id = "81", text = "Almost there!", time = "2023-08-31", type = "outgoing"),
            Message(id = "82", text = "Take your time.", time = "2023-08-31", type = "incoming"),
            Message(id = "83", text = "See you soon!", time = "2023-08-31", type = "outgoing"),
            Message(id = "84", text = "Goodbye!", time = "2023-08-31", type = "incoming"),
            Message(
                id = "85",
                text = "It was nice talking to you.",
                time = "2023-08-31",
                type = "outgoing"
            ),
            Message(id = "86", text = "Likewise!", time = "2023-08-31", type = "incoming"),
            Message(id = "87", text = "Have a great day!", time = "2023-08-31", type = "outgoing"),
            Message(id = "88", text = "You too!", time = "2023-08-31", type = "incoming"),
            Message(id = "89", text = "Bye!", time = "2023-08-31", type = "outgoing"),
            Message(id = "90", text = "See you!", time = "2023-08-31", type = "incoming"),



            Message(id = "71", text = "Almost there!", time = "2023-07-31", type = "outgoing"),
            Message(id = "72", text = "Take your time.", time = "2023-07-31", type = "incoming"),
            Message(id = "73", text = "See you soon!", time = "2023-07-31", type = "outgoing"),
            Message(id = "74", text = "Goodbye!", time = "2023-07-31", type = "incoming"),
            Message(
                id = "75",
                text = "It was nice talking to you.",
                time = "2023-07-31",
                type = "outgoing"
            ),
            Message(id = "76", text = "Likewise!", time = "2023-07-31", type = "incoming"),
            Message(id = "77", text = "Have a great day!", time = "2023-07-31", type = "outgoing"),
            Message(id = "78", text = "You too!", time = "2023-07-31", type = "incoming"),
            Message(id = "79", text = "Bye!", time = "2023-07-31", type = "outgoing"),
            Message(id = "80", text = "See you!", time = "2023-07-31", type = "incoming"),


            Message(
                id = "101",
                text = "Almost there!",
                time = "2023-08-01",
                type = "outgoing"
            ),
            Message(id = "102", text = "Take your time.", time = "2023-08-01", type = "incoming"),
            Message(id = "103", text = "See you soon!", time = "2023-08-01", type = "outgoing"),
            Message(id = "104", text = "Goodbye!", time = "2023-08-01", type = "incoming"),
            Message(
                id = "105",
                text = "It was nice talking to you.",
                time = "2023-08-01",
                type = "outgoing"
            ),
            Message(id = "106", text = "Likewise!", time = "2023-08-01", type = "incoming"),
            Message(id = "107", text = "Have a great day!", time = "2023-08-01", type = "outgoing"),
            Message(id = "108", text = "You too!", time = "2023-08-01", type = "incoming"),
            Message(id = "109", text = "Bye!", time = "2023-08-01", type = "outgoing"),
            Message(id = "110", text = "See you!", time = "2023-08-01", type = "incoming")

        )
        val adapter = ConversationAdapter(this)
        binding.conversationRecyclerView.adapter = adapter
        adapter.submitList(list)


    }


}