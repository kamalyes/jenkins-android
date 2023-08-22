package io.github.kamalyes.crash.ui;

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import io.github.kamalyes.R
import io.github.kamalyes.crash.db.DbManager

class CrashInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crash_info)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val intExtra = intent.getIntExtra("id", 0)
        val queryById = DbManager.getInstance(this).queryById(intExtra)
        if (queryById.size > 0) {
            findViewById<TextView>(R.id.tvDetail).text = queryById[0]["detail"]
        } else {
//            Toast.makeText(this, "index:$intExtra", Toast.LENGTH_LONG).show()
            startActivity(Intent(this, CrashViewerActivity::class.java))
            finish()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}