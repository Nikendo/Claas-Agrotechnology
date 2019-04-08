package com.example.claasagrotechnology.ui.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.android.support.SupportAppScreen

class CASupportAppNavigator(private val activity: FragmentActivity, private val containerId: Int):
    SupportAppNavigator(activity, containerId) {



    override fun createFragment(screen: SupportAppScreen?): Fragment {
        return super.createFragment(screen)
    }


}

