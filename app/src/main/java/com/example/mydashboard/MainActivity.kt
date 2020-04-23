package com.example.mydashboard

import Adapter
import Model
import SpaceItemdecoration
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: Adapter
    lateinit var itemList:MutableList<Model>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()
        setData()
    }

    private fun setData() {
        adapter=Adapter(this,itemList)

        val layoutManager = GridLayoutManager(this, Common.NUM_OF_COLUMN, RecyclerView.VERTICAL, false)
        layoutManager.spanSizeLookup=object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(i: Int): Int {
                return if (adapter !=null) {
                    when (adapter!!.getItemViewType(i))
                    {
                        1 -> 1
                        0 -> Common.NUM_OF_COLUMN
                        else -> -1
                    }
                }else {
                    -1
                }
            }

        }
        recyclerview.layoutManager=layoutManager
        recyclerview.addItemDecoration(SpaceItemdecoration(4))

        recyclerview.adapter=adapter

    }
    private fun initData() {
        itemList=ArrayList()

        itemList.add(Model(R.drawable.android_nb, "Android"))
        itemList.add(Model(R.drawable.browser_nb, "Browser"))
        itemList.add(Model(R.drawable.twitter_nb, "Twitter"))
        itemList.add(Model(R.drawable.youtube, "Youtube"))
        itemList.add(Model(R.drawable.facebook_nb, "Facebook"))
        itemList.add(Model(R.drawable.github_nb, "Github"))
        itemList.add(Model(R.drawable.instagram_nb, "Instagram"))
        itemList.add(Model(R.drawable.linkedin, "Linkedin"))
        itemList.add(Model(R.drawable.playstore_nb, "Playstore"))
        itemList.add(Model(R.drawable.calendar_nb, "Calendar"))
        itemList.add(Model(R.drawable.contact_nb, "Contact"))
        itemList.add(Model(R.drawable.skype_nb, "Skype"))
    }

    override fun onStart() {
        super.onStart()
        Log.i("","onStart")

    }

    override fun onResume() {
        super.onResume()
        Log.i("","onResume")

    }


    override fun onPause()  {
        super.onPause()
        Log.i("", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i( "", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("","onDestroy")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.i("","onRestoreInstanceState")
    }



}



