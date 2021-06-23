package com.charleston.bottomsheet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private val bottomSheetWithLayout by lazy { BottomSheetBehavior.from(findViewById(R.id.layout_bottom_sheet)) }
    private val bottomSheetFragment by lazy { MyBottomSheet() }

    private var toggle = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindList()

        findViewById<MaterialButton>(R.id.button).setOnClickListener {
            bottomSheetWithLayout.state =
                if (toggle) BottomSheetBehavior.STATE_EXPANDED else BottomSheetBehavior.STATE_COLLAPSED

            toggle = !toggle
        }

        findViewById<MaterialButton>(R.id.buttonFragment).setOnClickListener {
            bottomSheetFragment.show(supportFragmentManager, "bottomSheetFragment")
        }
    }

    private fun bindList() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.apply {
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
            adapter = ListAdapter()
        }
    }
}