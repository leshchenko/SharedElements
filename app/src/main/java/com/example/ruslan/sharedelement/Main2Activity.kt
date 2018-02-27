package com.example.ruslan.sharedelement

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewCompat
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        postponeEnterTransition()
        list.layoutManager = GridLayoutManager(baseContext, 2)
        list.adapter = MyAdapter(R.layout.item2)
        root.viewTreeObserver.addOnGlobalLayoutListener { startPostponedEnterTransition() }
    }
}

class MyAdapter2(context: Context, val list: MutableList<Entity>) : ArrayAdapter<Entity>(context, R.layout.item1) {
    override fun getCount(): Int {
        return list.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflate = LayoutInflater.from(parent?.context).inflate(R.layout.item2, parent, false)
        val imageView = inflate.findViewById<ImageView>(R.id.image)
        ViewCompat.setTransitionName(inflate, list[position].id)
        Picasso.with(parent?.context).load(list[position].url).into(imageView)
        return inflate
    }
}