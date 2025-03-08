/*
 * Copyright © 2021 YUMEMI Inc. All rights reserved.
 */
package jp.co.yumemi.android.code_check.reposearch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import jp.co.yumemi.android.code_check.R
import jp.co.yumemi.android.code_check.adapters.GitRepositoryListAdapter
import jp.co.yumemi.android.code_check.databinding.FragmentOneBinding
import jp.co.yumemi.android.code_check.feature_repository.search.RepositorySearchFragmentDirections
import jp.co.yumemi.android.code_check.data.source.network.RepoInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RepositorySearchFragment : Fragment(R.layout.fragment_one) {

    private var _binding: FragmentOneBinding? = null
    private val binding get() = _binding!!

    private val viewModel: RepositorySearchViewModel by viewModels()
    private lateinit var gitRepositoryListAdapter: GitRepositoryListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOneBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        initSearchInput()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.recyclerView.adapter = null
        _binding = null
    }

    private fun initRecyclerView() {
        val layoutManager = LinearLayoutManager(requireContext())
        val dividerItemDecoration =
            DividerItemDecoration(requireContext(), layoutManager.orientation)

        gitRepositoryListAdapter = GitRepositoryListAdapter().apply {
            setOnItemClickListener { item ->
                navigateToRepositoryDetail(item)
            }
        }

        binding.recyclerView.apply {
            this.layoutManager = layoutManager
            addItemDecoration(dividerItemDecoration)
            adapter = gitRepositoryListAdapter
        }
    }

    private fun initSearchInput() {
        binding.searchInputText.setOnEditorActionListener { editText, action, _ ->
            if (action == EditorInfo.IME_ACTION_SEARCH) {
                performSearch(editText.text.toString())
                true
            } else {
                false
            }
        }
    }

    private fun performSearch(query: String) {
        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
            val items = viewModel.searchResults(query, requireContext())
            withContext(Dispatchers.Main) {
                gitRepositoryListAdapter.repositoryItems = items
            }
        }
    }

    private fun navigateToRepositoryDetail(repoInfo: RepoInfo) {
        val action =
            RepositorySearchFragmentDirections.actionRepositoriesFragmentToRepositoryFragment(
                repoInfo = repoInfo
            )
        findNavController().navigate(action)
    }

}
