/*
 * Copyright © 2021 YUMEMI Inc. All rights reserved.
 */
package jp.co.yumemi.android.code_check.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import coil.load
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import jp.co.yumemi.android.code_check.R
import jp.co.yumemi.android.code_check.databinding.FragmentDetailBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail) {

    private val args: DetailFragmentArgs by navArgs()
    private val viewModel: DetailViewModel by viewModels()

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val item = args.repoInfo
        binding.apply {
            ownerIconView.load(
                item.avatarUrl
            )
            nameView.text = item.fullName
            languageView.text = item.language
            starsView.text = getString(R.string.stars_count, item.stargazersCount)
            watchersView.text = getString(R.string.watchers_count, item.watchersCount)
            forksView.text = getString(R.string.forks_count, item.forksCount)
            openIssuesView.text = getString(R.string.open_issues_count, item.openIssuesCount)
        }
        fetchREADME(item.fullName)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun fetchREADME(full_name: String) {
        viewLifecycleOwner.lifecycleScope.launch {
            val result = withContext(Dispatchers.IO) {
                viewModel.fetchREADME(full_name)
            }
            result.fold(
                onSuccess = {
                    Snackbar.make(requireView(), "README found", Snackbar.LENGTH_LONG).show()
                },
                onFailure = {
                    Snackbar.make(requireView(), "No README", Snackbar.LENGTH_LONG).show()
                }
            )
        }
    }
}
