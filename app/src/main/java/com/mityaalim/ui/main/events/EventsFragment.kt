package com.mityaalim.ui.main.events

import android.content.Intent
import android.icu.util.Calendar
import android.os.Bundle
import android.provider.CalendarContract
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.mityaalim.data.general.Event
import com.mityaalim.databinding.FragmentEventsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EventsFragment : Fragment() {

    private val viewModel: EventsViewModel by viewModels()

    private lateinit var binding: FragmentEventsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEventsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.events.observe(viewLifecycleOwner) {
            val adapter = EventAdapter({
                val intent = Intent(Intent.ACTION_INSERT)
                intent.setData(CalendarContract.Events.CONTENT_URI)
                intent.putExtra(CalendarContract.Events.TITLE, it.title)
                intent.putExtra(CalendarContract.Events.DESCRIPTION, it.description)
                intent.putExtra(CalendarContract.Events.EVENT_LOCATION, it.location)
                intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, it.time?.toDate()?.time)
                intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
                    it.time?.toDate()?.time?.plus(3600000) ?: 0
                )

                startActivity(intent)
            })
            val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            binding.recyclerview.adapter = adapter
            binding.recyclerview.layoutManager = layoutManager
            adapter.submitList(it?.convertToView())
        }
    }

    private fun List<Event>.convertToView(): List<EventItem> {
        return map {
            EventItem(
                it.id, it.title, it.description, it.time, it.location
            )
        }
    }
}


