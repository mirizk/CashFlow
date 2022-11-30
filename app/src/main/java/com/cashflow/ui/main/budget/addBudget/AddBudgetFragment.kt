package com.cashflow.ui.main.budget.addBudget

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.cashflow.databinding.FragmentAddBudgetBinding
import com.cashflow.data.enums.BudgetType
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*
import android.text.Editable
import android.text.TextWatcher
import com.cashflow.R


@AndroidEntryPoint
class AddBudgetFragment : Fragment() {

    private val viewModel: AddBudgetViewModel by viewModels()
    private lateinit var binding: FragmentAddBudgetBinding
    val args: AddBudgetFragmentArgs by navArgs()

    private var name: String = ""
    private var sum: Int = 0
    private var date: Date = Date()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddBudgetBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("NewApi")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        when (args.type) {
            BudgetType.INCOME -> binding.title.text = getString(R.string.add_income_title)
            BudgetType.EXPENSE -> binding.title.text = getString(R.string.add_expense_title)
        }

        setUpDate()
        setUpName()
        setUpSum()

        binding.save.setOnClickListener {
            viewModel.saveNewBudget(args.type, name, sum, date)
            findNavController().popBackStack()
        }
    }

    private fun setUpSum() {
        binding.editSum.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                sum = if (s.isNotEmpty()) Integer.parseInt(s.toString()) else 0
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })
    }

    private fun setUpName() {
        binding.editName.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                name = s.toString()
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })
    }

    private fun setUpDate() {
        binding.editDate.setText(SimpleDateFormat("dd/MM/yy", Locale.getDefault()).format(Date()))
        binding.editDate.setOnClickListener {
            val picker = createPicker()
            picker.show()
        }
    }

    private fun createPicker(): DatePickerDialog {
        val picker = DatePickerDialog(
            requireContext(),
        )
        picker.setOnDateSetListener { _, i, i2, i3 ->
            val cal = Calendar.getInstance()
            cal.set(i, i2, i3)
            date = cal.time
            binding.editDate.setText(
                SimpleDateFormat(
                    "dd/MM/yy",
                    Locale.getDefault()
                ).format(cal.time)
            )
        }
        return picker
    }
}