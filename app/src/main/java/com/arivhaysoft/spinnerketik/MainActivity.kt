package com.arivhaysoft.spinnerketik

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.arivhaysoft.libspinnerketik.SpinnerDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnTest.setOnClickListener {
            val listSpinner = ArrayList<String>()

            var spinnerDialog: SpinnerDialog? = null
            listSpinner.clear()

            listSpinner.add("Merah")
            listSpinner.add("Kuning")
            listSpinner.add("Hijau")
            listSpinner.add("Biru")
            listSpinner.add("Putih")
            listSpinner.add("Abu-abu")
            listSpinner.add("Silver")
            listSpinner.add("Jingga")
            listSpinner.add("Kelabu")
            listSpinner.add("Merah Muda")
            listSpinner.add("Hijau Tua")
            listSpinner.add("Biru Dongker")
            listSpinner.add("Merah maron")
            listSpinner.add("Kuning Tua")
            listSpinner.add("Hijau Muda")
            listSpinner.add("Biru Langit")
            listSpinner.add("Ungu")
            listSpinner.add("Hitam")
            spinnerDialog = SpinnerDialog(this, listSpinner, "Pilih Warna", R.style.DialogAnimations_SmileWindow, "Tutup")
            spinnerDialog.bindOnSpinerListener { item, position ->
                Toast.makeText(this,item,Toast.LENGTH_SHORT).show()
            }
            spinnerDialog.showSpinerDialog()
        }


    }
}
