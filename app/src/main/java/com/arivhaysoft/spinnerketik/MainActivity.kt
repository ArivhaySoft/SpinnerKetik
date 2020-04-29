package com.arivhaysoft.spinnerketik

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.arivhaysoft.libspinnerketik.ModelData
import com.arivhaysoft.libspinnerketik.SpinnerDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnTest.setOnClickListener {
            val listSpinner = ArrayList<ModelData>()

            var spinnerDialog: SpinnerDialog? = null
            listSpinner.clear()

            listSpinner.add(ModelData("MRH","MERAH"))
            listSpinner.add(ModelData("MRH","MUDA MERAH"))
            listSpinner.add(ModelData("KNG","KUNING"))
            listSpinner.add(ModelData("HJU","HUJAU"))

            spinnerDialog = SpinnerDialog(this, listSpinner, "Pilih Warna", R.style.DialogAnimations_SmileWindow, "Tutup")
            spinnerDialog.bindOnSpinerListener { item, position ->
                Toast.makeText(this,item.kode,Toast.LENGTH_SHORT).show()
            }
            spinnerDialog.showSpinerDialog()
        }


    }
}
