package com.example.ruslan.sharedelement

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.util.Pair
import android.support.v4.view.ViewCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        val items = mutableListOf(
                Entity("http://bipbap.ru/wp-content/uploads/2017/09/44_20140925_1955853838-220x220.gif", "1"),
                Entity("http://ruizdat.ru/photos/p9411_c129.jpg", "2"),
                Entity("https://cdn.fishki.net/upload/post/2017/03/19/2245758/tn/02-funny-cat-wallpapercat-wallpaper.jpg", "3"),
                Entity("https://s1.1zoom.ru/big0/930/Coast_Sunrises_and_sunsets_Waves_USA_Ocean_Kaneohe_521540_1280x775.jpg","4"),
                Entity("https://cdn.fishki.net/upload/post/2017/03/19/2245758/tn/01-beautiful-white-cat-imagescar-wallpaper.jpg","5"),
                Entity("http://www.cruzo.net/user/images/k/6befd660cb87fdaec9c9c6908a10523f_136.jpg","6"))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.root, BlankFragment()).commit()
        }
    }
}

class MyAdapter(val layout: Int) : RecyclerView.Adapter<Item>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Item {
        val inflate = LayoutInflater.from(parent?.context).inflate(layout, parent, false)
        return Item(inflate)
    }

    override fun getItemCount(): Int {
        return MainActivity.items.size
    }

    override fun onBindViewHolder(holder: Item?, position: Int) {
        holder ?: return
        ViewCompat.setTransitionName(holder.image, MainActivity.items[position].id)
        Picasso.with(holder.image.context).load(MainActivity.items[position].url).into(holder.image)
    }

}

class Item(view: View) : RecyclerView.ViewHolder(view) {
    val image = view.findViewById<ImageView>(R.id.image)
}

data class Entity(val url: String, val id: String)