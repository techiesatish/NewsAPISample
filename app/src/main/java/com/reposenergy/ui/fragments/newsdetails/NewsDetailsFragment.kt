package com.reposenergy.ui.fragments.newsdetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.reposenergy.R
import com.reposenergy.data.models.Article
import com.reposenergy.databinding.FragmentNewsDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsDetailsFragment : Fragment() {
    lateinit var binding:FragmentNewsDetailsBinding
    private val args: NewsDetailsFragmentArgs  by navArgs()
    private val article: Article by lazy { args.stringNewsdetails }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentNewsDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUIData(article)
    }

    private fun initUIData(article: Article) {
        binding.article.title.text=article.title
        binding.article.description.text=article.description
        Glide.with(requireContext()).load(article.urlToImage).into(binding.articleImage)

        binding.toolbarNewsDetails.navigationContentDescription = resources.getString(R.string.nav_up)
        binding.toolbarNewsDetails.setNavigationOnClickListener { findNavController().navigateUp() }
        binding.toolbarNewsDetails.apply {
            setTitle(article.source!!.name)
            navigationContentDescription = resources.getString(R.string.nav_up)
            setNavigationOnClickListener { findNavController().navigateUp() }

        }







    }





}