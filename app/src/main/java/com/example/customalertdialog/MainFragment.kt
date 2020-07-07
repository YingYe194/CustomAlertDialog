package com.example.customalertdialog


import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.customalertdialog.data.New
import com.example.customalertdialog.data.News
import com.example.customalertdialog.databinding.DialogInfoBinding
import com.example.customalertdialog.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    lateinit var fragmentBinding: FragmentMainBinding

    lateinit var dialogBinding: DialogInfoBinding

    lateinit var alertDialog: AlertDialog

    val list = listOf(
        New("This is Title1","This is this is a long long long description 1"),
        New("This is Title2","This is this is a long long long description 2"),
        New("This is Title3","This is this is a long long long description 3")
    )

    val new = New("This is Title1","This is this is a long long long description 1")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_main, container, false)
        fragmentBinding = DataBindingUtil.inflate(
            LayoutInflater.from(this.context),
            R.layout.fragment_main,
            container,
            false
        )
        fragmentBinding.btnShowDialog.setOnClickListener {
            alertDialog.show()
        }

        //dialog initial
        dialogBinding = DataBindingUtil.inflate(
            LayoutInflater.from(this.context),
            R.layout.dialog_info,
            container,
            false
        )
        val alertDialogBuilder: AlertDialog.Builder = AlertDialog.Builder(context)
        alertDialogBuilder.setView(dialogBinding.root)
        alertDialog = alertDialogBuilder.create()
        dialogBinding.ivClose.setOnClickListener {
            alertDialog.dismiss()
        }
        dialogBinding.item = new //give data to the info
        return fragmentBinding.root
    }

}
