package com.example.roomapi.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomapi.database.db.HololiveDB
import com.example.roomapi.database.model.LiveEntity
import com.example.roomapi.databinding.ActivityMainBinding
import com.example.roomapi.hololive.api.model.LiveItem
import com.example.roomapi.hololive.api.model.UpcomingItem
import com.example.roomapi.hololive.api.service.HololiveListener
import com.example.roomapi.hololive.api.service.HololiveService

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    val upcomingItems = arrayListOf<UpcomingItem>()
    private val mFragmentManager = supportFragmentManager
    private var dialogFragment : MyLiveList? = null
    companion object{
        public lateinit var hololiveDB: HololiveDB
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBar?.title = "Hololive Schedule"
        hololiveDB = HololiveDB.getInstance(this)
        fetchApi()
        setupRecyclerView()
        setupFragment()
    }

    private fun setupRecyclerView(){
        binding.rcLive.layoutManager = LinearLayoutManager(this@MainActivity)
    }

    private fun fetchApi(){
        HololiveService().getLive(liveItemListener)
        HololiveService().getSchedule(scheduleListener)
    }

    private fun setupFragment(){
        dialogFragment = MyLiveList(hololiveDB.holoDao().getAllLiveData())
        val fragment = MyLiveList::class.java.simpleName
        binding.button.setOnClickListener{
            dialogFragment?.show(mFragmentManager, fragment)
        }
    }

    @Suppress("UNCHECKED_CAST")
    private val liveItemListener = object : HololiveListener<List<LiveItem>> {
        override fun <T> onSucces(items: T) {

        }

        override fun <T> onFailed(msg: String) {
            Log.d("Live get error", msg)
        }
    }

    @Suppress("UNCHECKED_CAST")
    private val scheduleListener = object : HololiveListener<List<UpcomingItem>> {
        override fun <T> onSucces(items: T) {
            val data = items as ArrayList<UpcomingItem>
            upcomingItems.addAll(data)
            binding.rcLive.adapter = UpcomingAdapter(upcomingItems)
        }

        override fun <T> onFailed(msg: String) {
            Log.d("Schedule get error", msg)
        }
    }

}