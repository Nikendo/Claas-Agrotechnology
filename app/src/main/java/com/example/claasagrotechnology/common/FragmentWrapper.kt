package com.example.claasagrotechnology.common

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import java.lang.ref.WeakReference

abstract class FragmentWrapper : BaseMvpAppCompatFragment() {
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        val activity: FragmentActivity? = getActivity()

        if (activity is ChainHolder) {
            (activity as ChainHolder).chain.add(WeakReference<Fragment>(this))
        }
    }

    override fun onDetach() {
        val activity: FragmentActivity? = getActivity()

        if (activity is ChainHolder) {
            val chain = (activity as ChainHolder).chain
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

interface ChainHolder {
    val chain: MutableList<WeakReference<Fragment>>
}