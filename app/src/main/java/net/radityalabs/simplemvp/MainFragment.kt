package net.radityalabs.simplemvp

import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import net.radityalabs.simplemvp.interactor.MainFragmentPresenterImpl
import net.radityalabs.simplemvp.presenter.MainFragmentPresenter
import net.radityalabs.simplemvp.view.MainFragmentView

class MainFragment : Fragment(), MainFragmentView {

    companion object {
        @JvmField
        val TAG = MainFragment::class.java.simpleName
        @JvmField
        val PARAM_1 = "param1"
        @JvmField
        val PARAM_2 = "param2"

        @JvmStatic
        fun newInstance(param1: String, param2: String): MainFragment {
            val fragment = MainFragment()
            val bundle = Bundle()
            bundle.putString(PARAM_1, param1)
            bundle.putString(PARAM_2, param2)
            fragment.arguments = bundle
            return fragment
        }
    }

    private lateinit var presenter: MainFragmentPresenter
    private lateinit var mView: View

    override
    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = MainFragmentPresenterImpl(context, this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mView = view
        val fab = view.findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener {
            presenter.doSomeWork()
        }
    }

    override fun doSomeWorkSuccess(message: String) {
        Snackbar.make(mView, message, Snackbar.LENGTH_LONG).setAction("Action", null).show()
    }
}
