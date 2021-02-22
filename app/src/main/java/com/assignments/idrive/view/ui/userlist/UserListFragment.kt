package com.assignments.idrive.view.ui.userlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
 import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.assignments.idrive.R
import com.assignments.idrive.databinding.UserlistFragmentBinding

import com.assignments.idrive.view.adapter.UserListAdapter
import com.assignments.idrive.viewmodel.UserListViewModel
import kotlinx.android.synthetic.main.userlist_fragment.*
import org.jetbrains.anko.longToast


class UserListFragment : Fragment() {
    private lateinit var userlistFragmentBinding: UserlistFragmentBinding
    private lateinit var adapter: UserListAdapter

    private lateinit var viewModel: UserListViewModel
    var swipeCount = 0

    /**
     * CallBack method
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        userlistFragmentBinding = UserlistFragmentBinding.inflate(inflater, container, false).apply {

           viewmodel = ViewModelProviders.of(this@UserListFragment).get(UserListViewModel::class.java)
            setLifecycleOwner(viewLifecycleOwner)
        }
        return userlistFragmentBinding.root
    }

    /**
     * CallBack method
     */

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        userlistFragmentBinding.viewmodel?.fetchUserList()

        setupAdapter()
        setupObservers()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val swipeRefreshLayout = view.findViewById<SwipeRefreshLayout>(R.id.swipe_refresh_layout)
        swipeRefreshLayout.setOnRefreshListener {

            swipeCount += 1;
            if (swipeCount > 0) {
                userlistFragmentBinding.viewmodel?.fetchUserList()
            }
            swipeRefreshLayout.isRefreshing = false
        }
        super.onViewCreated(view, savedInstanceState)
    }

    /**
     * Setting up Observers to observe the changes
     */
    private fun setupObservers() {
        userlistFragmentBinding.viewmodel?.userListLiveData?.observe(viewLifecycleOwner, Observer {
            adapter.updateRepoList(it)
        })

        userlistFragmentBinding.viewmodel?.toastMessage?.observe(viewLifecycleOwner, Observer {
            activity?.longToast(it)
        })
    }

    /**
     * Setting adapter to list
     */
    private fun setupAdapter() {
        val viewModel = userlistFragmentBinding.viewmodel
        if (viewModel != null) {
            adapter = UserListAdapter(userlistFragmentBinding.viewmodel!!)
            val layoutManager = LinearLayoutManager(activity)
            user_list_rv.layoutManager = layoutManager
            user_list_rv.addItemDecoration(DividerItemDecoration(activity, layoutManager.orientation))
            user_list_rv.adapter = adapter
        }
    }





}