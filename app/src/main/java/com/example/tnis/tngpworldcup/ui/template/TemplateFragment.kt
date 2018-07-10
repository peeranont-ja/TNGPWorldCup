package com.example.tnis.tngpworldcup.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.tnis.tngpworldcup.R


//Extend Fragment
class TemplateFragment : Fragment() {

    //Static Method for Activity to call new instance
    companion object {
        fun newInstance(): TemplateFragment {
            return TemplateFragment()
        }
    }

    //Link XML to the fragment
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.template_fragment,
                container, false)
    }

    //Set up view actions when view is already created
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initInstance()

    }

    //Function to define view actions
    private fun initInstance() {
        //Use Glide to display image from URL show in view ID name's "fullscreen_background"


    }
}

