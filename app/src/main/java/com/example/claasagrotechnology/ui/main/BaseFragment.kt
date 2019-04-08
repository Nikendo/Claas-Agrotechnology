package com.example.claasagrotechnology.ui.main

import android.app.PendingIntent.getActivity
import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

import java.lang.ref.WeakReference

abstract class BaseFragment : MvpAppCompatFragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val activity = getActivity()
        if (activity is ChainHolder) {
            (activity as ChainHolder).getChain().add(WeakReference<Fragment>(this))
        }
    }

    fun onDetach() {
        val activity = getActivity()
        if (activity is ChainHolder) {
            val chain = (activity as ChainHolder).getChain()
            val it = chain.iterator()
            while (it.hasNext()) {
                val fragmentReference = it.next()
                val fragment = fragmentReference.get()
                if (fragment != null && fragment === this) {
                    it.remove()
                    break
                }
            }
        }
        super.onDetach()
    }
}