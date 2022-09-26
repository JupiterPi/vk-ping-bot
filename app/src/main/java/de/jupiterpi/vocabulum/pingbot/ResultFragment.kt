package de.jupiterpi.vocabulum.pingbot

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

private const val ARG_RESULT_TEXT = "resultText"

class ResultFragment : Fragment() {
    private var resultText: String = "Unset"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        resultText = arguments?.getString(ARG_RESULT_TEXT) ?: resultText
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_result, container, false)
        view.findViewById<TextView>(R.id.text_result_title)?.text = resultText
        return view
    }

    companion object {
        fun newInstance(resultText: String) =
            ResultFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_RESULT_TEXT, resultText)
                }
            }
    }
}