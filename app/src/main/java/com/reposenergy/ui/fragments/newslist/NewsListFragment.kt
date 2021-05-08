package com.reposenergy.ui.fragments.newslist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.reposenergy.R
import com.reposenergy.data.models.Article
import com.reposenergy.databinding.FragmentNewsListBinding
import com.reposenergy.listeners.OnNewsItemClick
import com.reposenergy.ui.adapter.NewsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_news_details.*

@AndroidEntryPoint
class NewsListFragment : Fragment(),OnNewsItemClick {

lateinit var binding: FragmentNewsListBinding
lateinit var adapter:NewsAdapter
    private val mViewModel :NewsListViewModel by viewModels<NewsListViewModel >()
    var list:List<Article>?=null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        return inflater.inflate(R.layout.fragment_news_list, container, false)

        binding = FragmentNewsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        mViewModel.fetchNews()
        observeLiveData()


    }
    private fun initRecyclerView() {
        binding.rvNews.layoutManager = LinearLayoutManager(requireContext())
        adapter = NewsAdapter(requireContext(),this)
        binding.rvNews.addItemDecoration(DividerItemDecoration(binding.rvNews.context, (binding.rvNews.layoutManager as LinearLayoutManager).orientation))
        binding.rvNews.adapter = adapter
    }
    fun observeLiveData(){
        mViewModel.articleList.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            list=it
            adapter.updateList(it)
            binding.progressBar.visibility=View.GONE
            binding.rvNews.visibility=View.VISIBLE
        })
    }



    override fun onNewsItemClick(newsItemData: Article) {
        findNavController().navigate(NewsListFragmentDirections.actionNavigationHomeToNavigationNewsdetails(newsItemData))
    }
}