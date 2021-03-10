package com.example.rodrigotaboadaexamen

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.rodrigotaboadaexamen.Data.ListUsers
import com.example.rodrigotaboadaexamen.databinding.ActivityHomeBinding
import com.example.rodrigotaboadaexamen.databinding.ActivityRegisterBinding

class HomeActivity: AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private val listQuiz= ListUsers()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setTitle((R.string.text_Home))
        var email: String? =intent.getStringExtra("email")
        if(email==null){
            email=""
        }
        val adapter = ArrayAdapter<String>(this@HomeActivity,android.R.layout.simple_list_item_1,listQuiz.getStringArrayQuiz())
        binding.listQuiz.adapter = adapter

        binding.listQuiz.setOnItemClickListener { adapterView: AdapterView<*>, view1: View, position: Int, id: Long ->

            val builder = AlertDialog.Builder(this)
            builder.setTitle("¿Que quieres hacer?")
            builder.setPositiveButton("Editar") { dialog, which ->
                /*val selectedItem = adapterView.getItemAtPosition(position)

                Toast.makeText(this@ListEditDeleteActivity, "$position $id $selectedItem", Toast.LENGTH_SHORT).show()

                val intent = Intent(this@ListEditDeleteActivity, EditActivity::class.java).apply {

                    putExtra(Constants.ID, position)
                }*/

                val intent=Intent(this@HomeActivity,EditActivity::class.java)
                startActivity(intent)
            }

            builder.setNegativeButton("Eliminar") { dialog, which ->
                val id:Int=listQuiz.existsQuiz(email)
                val quiz = listQuiz.getQuiz(id)
                listQuiz.delete(quiz.email)
            }
            builder.setNeutralButton ("Ver") { dialog, which ->
                val intent = Intent(this@HomeActivity, DetailActivity::class.java)

                startActivity(intent)
            }


            builder.show()

        }

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_form_2, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.itmNew -> {
                var email: String? =intent.getStringExtra("email")
                val intent = Intent(this@HomeActivity, SurveyActivity::class.java)
                intent.putExtra("email", email)

                startActivity(intent)
            }

        }
        return super.onOptionsItemSelected(item)
    }


}