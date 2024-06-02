package com.example.smoothieandbooks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class SmoothieFragment : Fragment() {

    private lateinit var flavorRadioGroup: RadioGroup
    private lateinit var iceRadioGroup: RadioGroup
    private lateinit var sizeRadioGroup: RadioGroup
    private lateinit var prepareButton: Button
    private lateinit var clearButton: Button
    private lateinit var goToBooksButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_smoothie, container, false)

        flavorRadioGroup = view.findViewById(R.id.flavorRadioGroup)
        iceRadioGroup = view.findViewById(R.id.iceRadioGroup)
        sizeRadioGroup = view.findViewById(R.id.sizeRadioGroup)
        prepareButton = view.findViewById(R.id.prepareButton)
        clearButton = view.findViewById(R.id.clearButton)
        goToBooksButton = view.findViewById(R.id.goToBooksButton)

        prepareButton.setOnClickListener {
            prepareSmoothie()
        }

        clearButton.setOnClickListener {
            clearSelections()
        }

        goToBooksButton.setOnClickListener {
            // Navigate to BooksFragment directly
            findNavController().navigate(R.id.booksFragment)
        }

        return view
    }

    private fun prepareSmoothie() {
        val selectedFlavorId = flavorRadioGroup.checkedRadioButtonId
        val selectedIceId = iceRadioGroup.checkedRadioButtonId
        val selectedSizeId = sizeRadioGroup.checkedRadioButtonId

        if (selectedFlavorId == -1 || selectedIceId == -1 || selectedSizeId == -1) {
            Toast.makeText(context, "Please select flavor, ice, and size", Toast.LENGTH_SHORT).show()
            return
        }

        val selectedFlavor = view?.findViewById<RadioButton>(selectedFlavorId)?.text
        val selectedIce = view?.findViewById<RadioButton>(selectedIceId)?.text
        val selectedSize = view?.findViewById<RadioButton>(selectedSizeId)?.text

        val message = "Your $selectedSize $selectedFlavor smoothie with $selectedIce has been prepared. Enjoy!"
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    private fun clearSelections() {
        flavorRadioGroup.clearCheck()
        iceRadioGroup.clearCheck()
        sizeRadioGroup.clearCheck()
    }
}
