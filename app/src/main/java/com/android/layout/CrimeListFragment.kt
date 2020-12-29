package com.android.layout

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

import com.android.layout.adapter.CrimeAdapter
import com.android.layout.bean.Crime
import com.android.layout.bean.CrimeListViewModel
import java.util.*

/**
 * A fragment representing a list of Items.
 */
class CrimeListFragment : Fragment() {

    interface Callbacks {
        fun onCrimeSelected(crimeId: UUID)
    }

    private lateinit var crimeRecyclerView: RecyclerView
    private var callbacks: Callbacks? = null

    //    private var mCrimeList: MutableList<Crime> = mutableListOf()
    private var mAdapter: CrimeAdapter = CrimeAdapter(emptyList(), callbacks)

    private val crimeListViewModel: CrimeListViewModel by lazy {
        ViewModelProvider(this).get(CrimeListViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        crimeListViewModel.crimeListLiveData.observe(
//            viewLifecycleOwner,
//            androidx.lifecycle.Observer {  }
//        )

//        crimeListViewModel.addCrime()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_crime_list, container, false)

        crimeRecyclerView = view.findViewById(R.id.crime_recycler_view)
        crimeRecyclerView.layoutManager = LinearLayoutManager(context)
        crimeRecyclerView.adapter = mAdapter
        Log.d("CrimeList#", "加载onCreateView")

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("CrimeList#", "加载onViewCreated")
        crimeListViewModel.crimeListLiveData.observe(
            viewLifecycleOwner,
            androidx.lifecycle.Observer { crimes ->
                crimes?.let {
                    Log.i("CrimeListFragment#", "Got crimes ${crimes.size}")
                    updateUI(crimes)
                }
            }
        )
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("CrimeList#", "加载onActivityCreated")

    }

    private fun updateUI(crimes: List<Crime>) {

        mAdapter = CrimeAdapter(crimes, callbacks)
        crimeRecyclerView.adapter = mAdapter

//        Log.d("crimeListActivity#", "更新")
//        val layoutManager = LinearLayoutManager(context)
//        mAdapter = CrimeAdapter(mCrimeList)
//        rvCrime.layoutManager = layoutManager
//        rvCrime.adapter = mAdapter
//        rvCrime.itemAnimator = DefaultItemAnimator()

//        val crimes = crimeListViewModel.crimeListLiveData
//        mAdapter = CrimeAdapter(crimes, callbacks)
//        crimeRecyclerView.adapter = mAdapter
//        crimeRecyclerView.itemAnimator = DefaultItemAnimator()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callbacks = context as Callbacks?
    }

    override fun onDetach() {
        super.onDetach()
        callbacks = null
    }

//    companion object {
//        @JvmStatic
//        fun newInstance(): CrimeListFragment {
//            return CrimeListFragment()
//        }
//    }
}