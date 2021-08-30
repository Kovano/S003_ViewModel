package kovano.github.s003_viewmodel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import kovano.github.s003_viewmodel.databinding.FragmentBlank1Binding


class BlankFragment1 : Fragment() {

    private val obmenModel : ObmenModel by activityViewModels();
    lateinit var binding: FragmentBlank1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBlank1Binding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.bSendToActivityFromFrag1.setOnClickListener{
            obmenModel.message01.value = "Сообщение для активити из Фр.1"
        }
        binding.bSendToFrag2.setOnClickListener {
            obmenModel.message_For_Frag2.value = "Сообщение для фрагмента 2"
        }
        obmenModel.message_For_Frag1.observe(activity as LifecycleOwner,{
            binding.textMessageFrag1.text = it
        })
    }

    companion object {

        @JvmStatic
        fun newInstance() = BlankFragment1()

    }
}