package com.test.diwakarsinghtest.views

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SimpleItemAnimator
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.facebook.shimmer.ShimmerFrameLayout
import com.test.diwakarsinghtest.R
import com.test.diwakarsinghtest.pojo.Model
import com.test.diwakarsinghtest.utils.NetworkUtil
import com.test.diwakarsinghtest.utils.Util
import com.test.diwakarsinghtest.view.NoInternetConnectionFragment
import com.test.diwakarsinghtest.view.SimpleCallBack
import com.test.diwakarsinghtest.view.adapters.Adapter
import com.test.diwakarsinghtest.viewmodel.RetroViewModel


class MainActivity : AppCompatActivity(), SimpleCallBack {

    private lateinit var toolbar: Toolbar
    private lateinit var shimmerFrameLayout: ShimmerFrameLayout
    private var retroViewModel: RetroViewModel? = null
    private lateinit var recyclerView: RecyclerView
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var container: LinearLayout
    private var adapter: Adapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        initViewModel()
        swipeRefreshListener()
        setFlowForCaching()
    }

    private fun setFlowForCaching() {
        if (retroViewModel?.isFirstTimeAppLaunch()!!){
            val currentTIme = retroViewModel?.calculateCurrentTime()
            currentTIme?.let { retroViewModel?.updateLastTime(it) }
            checkInternetAndFetchData()
            retroViewModel?.updateIsFirstFlag()
        }
        else{
            val currentTIme = retroViewModel?.calculateCurrentTime()
            val timeDiff = currentTIme?.let { retroViewModel?.calculateTimeDifference(it) }
            if (timeDiff != null && timeDiff<2) {
                retroViewModel?.getDataFromLocal()?.let { setDataInAdapter(it) }
            }
            else {
                retroViewModel?.calculateCurrentTime()?.let { retroViewModel?.updateLastTime(it) }
                checkInternetAndFetchData()
            }
        }
    }

    private fun checkInternetAndFetchData() {
        if (NetworkUtil.isOnline(this)){
            fetchRemoteData()
        }
        else{
            showNoInternetFragment()
        }
    }

    private fun showNoInternetFragment() {
        container.visibility = View.INVISIBLE
        shimmerFrameLayout.stopShimmerAnimation()
        val commit = supportFragmentManager
            .beginTransaction()
            .add(R.id.shimmer_view_container, NoInternetConnectionFragment(), Util.FRAG_TAG)
            .commit()
    }

    private fun initViews() {
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        shimmerFrameLayout = findViewById(R.id.shimmer_view_container)
        recyclerView = findViewById(R.id.recycler_view)
        swipeRefreshLayout = findViewById(R.id.swipe_refresh_layout)
        container = findViewById(R.id.container)
    }

    private fun fetchRemoteData() {
        shimmerFrameLayout.startShimmerAnimation()
        retroViewModel?.fetchRemoteData(1)?.observe(this,
            Observer<List<Model>> { data ->
                data?.apply {
                    setDataInAdapter(data)
                    //save data in local.
                    retroViewModel?.saveDataInLocal(data)
                }
            })
    }

    private fun setDataInAdapter(data: List<Model>) {
        adapter = Adapter(data,this)
        val layoutManager = LinearLayoutManager(this)
        (recyclerView.itemAnimator as SimpleItemAnimator?)?.supportsChangeAnimations = false
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)
        shimmerFrameLayout.stopShimmerAnimation()
        shimmerFrameLayout.visibility = View.GONE
    }

    private fun initViewModel() {
        Log.e("error","init");
        retroViewModel = ViewModelProviders.of(this).get(RetroViewModel::class.java)
    }



    private fun swipeRefreshListener() {
        swipeRefreshLayout.setOnRefreshListener {
            retroViewModel?.calculateCurrentTime()?.let { retroViewModel?.updateLastTime(it) }
            onRetry()
        }
    }

    private fun removeNoInternetFragment(){
        val fragment = supportFragmentManager.findFragmentByTag(Util.FRAG_TAG)
        if (fragment != null) supportFragmentManager.beginTransaction().remove(fragment).commit()
    }

    override fun onRetry() {
        removeNoInternetFragment()
        if (container.visibility == View.INVISIBLE) {
            container.visibility = View.VISIBLE
        }
        checkInternetAndFetchData()
        adapter?.notifyDataSetChanged()
        swipeRefreshLayout.isRefreshing = false
    }
}
