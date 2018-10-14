package elshaarawyx.pagging.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import elshaarawyx.pagging.viewmodel.MainViewMode
import elshaarawyx.pagging.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private val mainViewMode by lazy { ViewModelProviders.of(this).get(MainViewMode::class.java) }
    private val usersAdapter = UsersAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        rvUsers.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = usersAdapter
        }

        fab.setOnClickListener {
            mainViewMode.loadUsers().observe(this, Observer(usersAdapter::submitList))
        }
    }
}
