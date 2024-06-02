package com.example.smoothieandbooks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class BooksFragment : Fragment() {

    private lateinit var bookRadioGroup: RadioGroup

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_books, container, false)

        bookRadioGroup = view.findViewById(R.id.bookRadioGroup)

        val readNowButton: Button = view.findViewById(R.id.readNowButton)
        val readAtHomeButton: Button = view.findViewById(R.id.readAtHomeButton)
        val clearButton: Button = view.findViewById(R.id.clearButton)
        val goToSmoothieButton: Button = view.findViewById(R.id.goToSmoothieButton)

        readNowButton.setOnClickListener {
            val selectedBookId = bookRadioGroup.checkedRadioButtonId
            if (selectedBookId != -1) {
                // Show a sample paragraph of the selected book
                Toast.makeText(context, "Reading now: [Sample paragraph of the book]", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Please select a book", Toast.LENGTH_SHORT).show()
            }
        }

        readAtHomeButton.setOnClickListener {
            val selectedBookId = bookRadioGroup.checkedRadioButtonId
            if (selectedBookId != -1) {
                // Show a message for taking the book home
                Toast.makeText(context, "You can take this book for one month and should return it within a month.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Please select a book", Toast.LENGTH_SHORT).show()
            }
        }

        clearButton.setOnClickListener {
            bookRadioGroup.clearCheck()
            Toast.makeText(context, "Selections cleared", Toast.LENGTH_SHORT).show()
        }

        goToSmoothieButton.setOnClickListener {
            // Navigate back to SmoothieFragment
            findNavController().navigate(R.id.action_booksFragment_to_smoothieFragment)
        }

        return view
    }
}
