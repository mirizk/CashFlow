package com.cashflow.ui.main.investment.payment

import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.cashflow.R
import com.cashflow.databinding.FragmentPaymentBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class PaymentFragment : Fragment() {

    private lateinit var binding: FragmentPaymentBinding
    val args: PaymentFragmentArgs by navArgs()

    private var creditCardNumber: Long = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPaymentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.sum.text = args.price.toString()
        setUpCreditNumber()
        binding.payment.setOnClickListener {
            if (isValid(creditCardNumber))
                showDialog()
            else {
                Toast.makeText(context,
                R.string.invalid_card, Toast.LENGTH_LONG).show()}
        }
    }

    private fun showDialog() {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("רכשת את השירות בהצלחה")
        builder.setMessage("ניתן לממשו על ידי הקוד " + java.util.Random().nextLong())
        builder.setPositiveButton(android.R.string.yes) { _, _ -> }
        builder.show()

    }

    private fun setUpCreditNumber() {
        binding.creditCardNumber.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                creditCardNumber = if (s.isNotEmpty()) s.toString().toLong() else 0
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })
    }

    fun isValid(number: Long): Boolean {
        return (getSize(number) >= 13 &&
                getSize(number) <= 16 &&
                (prefixMatched(number, 4) ||
                        prefixMatched(number, 5) ||
                        prefixMatched(number, 37) ||
                        prefixMatched(number, 6)) &&
                (sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 === 0)
    }

    fun getSize(d: Long): Int {
        val num = d.toString() + ""
        return num.length
    }

    fun prefixMatched(number: Long, d: Int): Boolean {
        return getPrefix(number, getSize(d.toLong())) == d.toLong()
    }

    fun getPrefix(number: Long, k: Int): Long {
        if (getSize(number) > k) {
            val num = number.toString() + ""
            return num.substring(0, k).toLong()
        }
        return number
    }
    fun sumOfOddPlace(number: Long): Int {
        var sum = 0
        val num = number.toString() + ""
        var i = getSize(number) - 1
        while (i >= 0) {
            sum += (num[i].toString() + "").toInt()
            i -= 2
        }
        return sum
    }

    fun sumOfDoubleEvenPlace(number: Long): Int {
        var sum = 0
        val num = number.toString() + ""
        var i = getSize(number) - 2
        while (i >= 0) {
            sum += getDigit((num[i].toString() + "").toInt() * 2)
            i -= 2
        }
        return sum
    }

    fun getDigit(number: Int): Int {
        return if (number < 9) number else number / 10 + number % 10
    }
}