package kovano.github.s003_viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import kovano.github.s003_viewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    private val actObmenModel:ObmenModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        openFrag(BlankFragment1.newInstance(),R.id.place_Holder1)
        openFrag(BlankFragment2.newInstance(),R.id.place_Holder2)
        actObmenModel.message01.observe(this,{
            binding.textView1.text  = it
        })

    }

    private fun openFrag(f:Fragment, idHolder: Int) {
        supportFragmentManager
            .beginTransaction()
            .replace(idHolder, f)
            .commit()
    }

}