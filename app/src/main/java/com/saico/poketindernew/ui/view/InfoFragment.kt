package com.saico.poketindernew.ui.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.viewModels
import com.saico.poketindernew.R
import com.saico.poketindernew.databinding.FragmentHomeBinding
import com.saico.poketindernew.databinding.FragmentInfoBinding
import com.saico.poketindernew.ui.viewmodel.HomeViewModel
import com.saico.poketindernew.ui.viewmodel.InfoViewModel

class InfoFragment : BaseFragment<FragmentInfoBinding>(FragmentInfoBinding::inflate) {

    private val viewModel: InfoViewModel by viewModels()

    private lateinit var webView: WebView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        webView = binding.wvMain

        webView.settings.javaScriptEnabled = true

        webView.webViewClient = PokemonWebClient()

        viewModel.getUrlPokemon().observe(viewLifecycleOwner) {
            webView.loadUrl(it)
        }
    }

    inner class PokemonWebClient: WebViewClient() {
        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            webView.loadUrl("javascript:(function() { " +
                "document.getElementByClassName('navbar top')[0].style.display='none'; })()")
        }
    }

}