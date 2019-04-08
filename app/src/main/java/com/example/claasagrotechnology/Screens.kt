package com.example.claasagrotechnology

import androidx.fragment.app.Fragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {

    class SampleScreen(private val number: Int) : SupportAppScreen() {

        init {
            this.screenKey = javaClass.simpleName + "_" + number
        }

        override fun getFragment(): Fragment {
            return SampleFragment.getNewInstance(number)
        }
    }


}