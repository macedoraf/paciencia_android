package br.com.paciencia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.paciencia.negocio.Mesa

class MainActivity : AppCompatActivity() {

    lateinit var mesa: Mesa
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mesa = Mesa()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {

        findViewById<RecyclerView>(R.id.rv_items).apply {
            val myAdapter = ColumnAdapter(mesa.colunas.toList())
            adapter = myAdapter
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            ItemTouchHelper(ItemMoveCallback(myAdapter)).run {
                attachToRecyclerView(this@apply)
            }
        }
    }
}