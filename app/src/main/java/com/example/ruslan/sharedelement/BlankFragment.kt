package com.example.ruslan.sharedelement


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.app.Fragment
import android.support.v4.util.Pair
import android.support.v4.view.ViewCompat
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_blank.*


/**
 * A simple [Fragment] subclass.
 */
class BlankFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        list.adapter = MyAdapter(R.layout.item1)
        list.layoutManager = LinearLayoutManager(context)
        open.setOnClickListener {
            val pairs: ArrayList<Pair<View, String>> = ArrayList()
            MainActivity.items.forEachIndexed { index, entity ->
                val holder = list.findViewHolderForAdapterPosition(index)
                holder?.let {
                    with(it as Item) {
                        pairs.add(Pair.create(image, ViewCompat.getTransitionName(image)))
                    }
                }
            }
            val animation = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, *pairs.toTypedArray())
            val intent = Intent(activity, Main2Activity::class.java)
            startActivity(intent, animation.toBundle())
        }
    }
}// Required empty public constructor
