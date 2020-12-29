package com.android.layout

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.android.layout.bean.Crime
import com.android.layout.bean.CrimeDetailViewModel
import java.util.*


class CrimeFragment : Fragment() {

    private lateinit var crime: Crime
    private lateinit var titleField: EditText
    private lateinit var dataButton: Button
    private lateinit var solvedCheckBox: CheckBox
    private lateinit var cid: TextView

    private val crimeDetailViewModel: CrimeDetailViewModel by lazy {
        ViewModelProvider(this).get(CrimeDetailViewModel::class.java)
    }

//    private var crimeId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        crime = Crime()

        val crimeId: UUID = arguments?.getSerializable("crime_id") as UUID
        Log.d("CrimeFragment#", crimeId.toString())
        crimeDetailViewModel.loadCrime(crimeId)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_crime, container, false)

        //        etTitle.text = intent.getIntExtra("id", 0) as CharSequence
//        crimeId = intent.getIntExtra("id", 0)
//        val crimeInfo = Crime.defaultList[crimeId]

//        etTitle.setText(crimeInfo.title)
//        btnDate.text = crimeInfo.date.toString()
//        cbSolved.isChecked = crimeInfo.solver
//
//        etTitle.addTextChangedListener(EditWatcher())

        titleField = view.findViewById(R.id.etTitle)
        dataButton = view.findViewById(R.id.btnDate)
        solvedCheckBox = view.findViewById(R.id.cbSolved)
        cid = view.findViewById(R.id.tvId)

        dataButton.apply {
            text = crime.date.toString()
            isEnabled = false
        }

        return view

    }
//  在onCreateView后被触发，在onActivityCreated的前面
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        crimeDetailViewModel.crimeLiveData.observe(
            viewLifecycleOwner,
            androidx.lifecycle.Observer { crime ->
                crime?.let {
                    this.crime = crime
                    updateUI()
                }
            }
        )
    }

    private fun updateUI() {

        Log.d("CrimeFragment#", crime.toString())

        titleField.setText(crime.title)
        dataButton.text = crime.date.toString()
        cid.text = crime.id.toString()
        solvedCheckBox.apply {
            isChecked = crime.solver
            jumpDrawablesToCurrentState()
        }
    }

    override fun onStart() {
        super.onStart()

        val titleWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                crime.title = s.toString()
            }

            override fun afterTextChanged(s: Editable?) {
            }

        }

        titleField.addTextChangedListener(titleWatcher)

        solvedCheckBox.apply {
            setOnCheckedChangeListener { _, isChecked ->
                crime.solver = isChecked
            }
        }
    }

    override fun onStop() {
        super.onStop()
        crimeDetailViewModel.saveCrime(crime)
    }

    companion object {
        fun newInstance(crimeId: UUID): CrimeFragment {
            val args = Bundle().apply {
                putSerializable("crime_id", crimeId)
            }
            return CrimeFragment().apply {
                arguments = args
            }
        }
    }
}