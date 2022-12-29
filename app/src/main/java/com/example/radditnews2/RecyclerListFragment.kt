package com.example.radditnews2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.radditnews2.model.ArticleList
import com.example.radditnews2.viewmodel.RadditNewsViewModel
import com.example.redditnews.adapter.ArticleAdapter


class RecyclerListFragment : Fragment() {

    private lateinit var articleAdapter: ArticleAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_recycler_list, container, false)
        initViewModel(view)
        initViewModel()
        return view
    }

    fun initViewModel(view:View){
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycle)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        val dicoration = DividerItemDecoration(activity,DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(dicoration)
        articleAdapter = ArticleAdapter()
        recyclerView.adapter = articleAdapter
    }
    fun initViewModel()
    {
        val viewModel = ViewModelProvider(this).get(RadditNewsViewModel::class.java)
        viewModel.getRecyclerListObserver().observe(viewLifecycleOwner , Observer<ArticleList> {
            if(it != null ){
                articleAdapter.setList(it.children)
            }
            else{
                Toast.makeText(activity,"error to get article data",Toast.LENGTH_LONG).show()
            }
        })
        viewModel.makeApiCall()
    }

    companion object {

        @JvmStatic
        fun newInstance() = RecyclerListFragment()
    }
}