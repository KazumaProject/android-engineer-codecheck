/*
 * Copyright © 2021 YUMEMI Inc. All rights reserved.
 */
package jp.co.yumemi.android.code_check.ui.detail

import android.os.Bundle
import android.util.Base64
import android.util.Log
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
import io.noties.markwon.Markwon
import jp.co.yumemi.android.code_check.R
import jp.co.yumemi.android.code_check.databinding.FragmentDetailBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail) {

    private val args: DetailFragmentArgs by navArgs()
    private val viewModel: DetailViewModel by viewModels()

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var markwon: Markwon

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
            detailAvatarUrlImageView.load(item.avatarUrl)
            detailOwnerLogin.text = item.login
            nameView.text = item.fullName
            detailRepositoryDescription.text = item.description
            starsView.text = getString(R.string.stars_count, item.stargazersCount)
            forksView.text = getString(R.string.forks_count, item.forksCount)
            openIssuesView.text = getString(R.string.open_issues_count, item.openIssuesCount)
            watchersView.text = getString(R.string.watchers_count, item.watchersCount)
            languageView.text = item.language
        }
        fetchREADME(item.fullName, markwon)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun fetchREADME(full_name: String, markwon: Markwon) {
        viewLifecycleOwner.lifecycleScope.launch {
            val result = withContext(Dispatchers.IO) {
                viewModel.fetchREADME(full_name)
            }
            result.fold(
                onSuccess = {
                    val decodedBytes = Base64.decode(it.content, Base64.DEFAULT)
                    val rawMarkdown = String(decodedBytes)
                    if (rawMarkdown.isEmpty() || rawMarkdown.isBlank()) {
                        binding.readmeTextView.text = getString(R.string.readme_placeholder)
                    } else {
                        markwon.setMarkdown(binding.readmeTextView, rawMarkdown)
                    }
                },
                onFailure = {
                    Snackbar.make(requireView(), it.message.toString(), Snackbar.LENGTH_LONG).show()
                    Log.e("Error to fetch README: ", it.message.toString())
                }
            )
        }
    }
}
