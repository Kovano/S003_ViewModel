package kovano.github.s003_viewmodel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import kovano.github.s003_viewmodel.databinding.FragmentBlank2Binding

class BlankFragment2 : Fragment() {

    private val obmenModel : ObmenModel by activityViewModels();
    lateinit var binding: FragmentBlank2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBlank2Binding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.bSendToActivityFromFrag2.setOnClickListener{
            obmenModel.message01.value = "Сообщение для активити из Фр. 2"
        }
        binding.bSendToFrag1.setOnClickListener {
            obmenModel.message_For_Frag1.value = "Сообщение для фрагмента 1"
        }
        obmenModel.message_For_Frag2.observe(activity as LifecycleOwner,{
            binding.textMessageFrag2.text = it
        })
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            BlankFragment2()
   }
}
