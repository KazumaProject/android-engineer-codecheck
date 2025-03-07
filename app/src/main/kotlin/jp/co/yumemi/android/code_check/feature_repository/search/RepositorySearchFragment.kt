/*
 * Copyright © 2021 YUMEMI Inc. All rights reserved.
 */
package jp.co.yumemi.android.code_check.feature_repository.search

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
import jp.co.yumemi.android.code_check.OneFragmentDirections
import jp.co.yumemi.android.code_check.R
import jp.co.yumemi.android.code_check.adapters.GitRepositoryListAdapter
import jp.co.yumemi.android.code_check.databinding.FragmentOneBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RepositorySearchFragment : Fragment(R.layout.fragment_one) {

    private var _binding: FragmentOneBinding? = null
    private val binding get() = _binding!!

    private val viewModel: RepositorySearchViewModel by viewModels()

    private var gitRepositoryListAdapter: GitRepositoryListAdapter? = null

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

        val linearLayoutManager = LinearLayoutManager(requireContext())
        val dividerItemDecoration =
            DividerItemDecoration(requireContext(), linearLayoutManager.orientation)

        gitRepositoryListAdapter = GitRepositoryListAdapter()
        gitRepositoryListAdapter?.setOnItemClickListener { item ->
            gotoRepositoryFragment(item)
        }

        binding.apply {
            searchInputText.setOnEditorActionListener { editText, action, _ ->
                if (action == EditorInfo.IME_ACTION_SEARCH) {
                    editText.text.toString().let {
                        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
                            viewModel.searchResults(it, requireContext()).let { items ->
                                withContext(Dispatchers.Main) {
                                    gitRepositoryListAdapter?.repositoryItems = items
                                }
                            }
                        }
                    }
                    return@setOnEditorActionListener true
                }
                return@setOnEditorActionListener false
            }

            recyclerView.apply {
                layoutManager = linearLayoutManager
                addItemDecoration(dividerItemDecoration)
                this.adapter = gitRepositoryListAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.recyclerView.adapter = null
        gitRepositoryListAdapter = null
        _binding = null
    }

    private fun gotoRepositoryFragment(item: Item) {
        val action =
            OneFragmentDirections.actionRepositoriesFragmentToRepositoryFragment(item = item)
        findNavController().navigate(action)
    }
}
