package kovano.github.s003_viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class ObmenModel : ViewModel () {
    val message01 : MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val message_For_Frag1 : MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val message_For_Frag2 : MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}