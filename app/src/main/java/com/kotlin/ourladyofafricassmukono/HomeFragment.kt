package com.kotlin.ourladyofafricassmukono

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.URLUtil
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {


    override fun onCreateView(
        //these are the parameters of the function
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val mywebview:WebView = view.findViewById(R.id.webhome)
        mywebview.webViewClient = object :WebViewClient(){
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                url:String
            ): Boolean {
                if (view != null) {
                    view.loadUrl(url)
                }
                return true
            }

        }
        mywebview.loadUrl("https://mukonocampus.ourladyofafricaschools.sc.ug")
        mywebview.settings.javaScriptEnabled = true
        mywebview.settings.domStorageEnabled = true
        mywebview.settings.useWideViewPort = true
        mywebview.settings.allowContentAccess = true

    }


}