package com.saico.poketindernew.ui.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import com.saico.poketindernew.R
import com.saico.poketindernew.databinding.FragmentHomeBinding
import com.saico.poketindernew.databinding.FragmentInfoBinding
import com.saico.poketindernew.ui.viewmodel.InfoViewModel

class InfoFragment : BaseFragment<FragmentInfoBinding>(FragmentInfoBinding::inflate) {

    private lateinit var viewModel: InfoViewModel

    private lateinit var webView: WebView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val url = "https://pokemongolive.com/es/"

        webView = binding.wvMain

        webView.settings.javaScriptEnabled = true

        webView.webViewClient = PokemonWebClient()

        webView.loadUrl(url)

    }

    inner class PokemonWebClient: WebViewClient() {
        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            webView.loadUrl("javascript:(function() { " +
                "document.getElementByClassName('navbar top')[0].style.display='none'; })()")
        }
    }

}