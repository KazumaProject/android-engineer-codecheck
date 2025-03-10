package jp.co.yumemi.android.code_check.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView
import jp.co.yumemi.android.code_check.R
import jp.co.yumemi.android.code_check.domain.model.RepositorySearchResult
import java.text.DecimalFormat

class GitRepositoryListAdapter :
    RecyclerView.Adapter<GitRepositoryListAdapter.GitRepositoryListViewHolder>() {
    inner class GitRepositoryListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val diffCallback = object : DiffUtil.ItemCallback<RepositorySearchResult>() {
        override fun areItemsTheSame(
            oldItem: RepositorySearchResult,
            newItem: RepositorySearchResult
        ): Boolean {
            return oldItem.fullName == newItem.fullName
        }

        override fun areContentsTheSame(
            oldItem: RepositorySearchResult,
            newItem: RepositorySearchResult
        ): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    private var onItemClickListener: ((RepositorySearchResult) -> Unit)? = null

    fun setOnItemClickListener(onItemClick: (RepositorySearchResult) -> Unit) {
        this.onItemClickListener = onItemClick
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    var repositoryItems: List<RepositorySearchResult>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitRepositoryListViewHolder {
        return GitRepositoryListViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.layout_item, parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return repositoryItems.size
    }

    override fun onBindViewHolder(holder: GitRepositoryListViewHolder, position: Int) {
        val decimalFormat = DecimalFormat("#,###.##")
        val item = repositoryItems[position]
        holder.itemView.apply {
            findViewById<MaterialTextView>(R.id.ownerLoginNameView).text = item.login
            findViewById<MaterialTextView>(R.id.repositoryNameView).text =
                item.fullName
            findViewById<ShapeableImageView>(R.id.avatarUrlImageView).load(item.avatarUrl)
            findViewById<MaterialTextView>(R.id.repositoryDescriptionView).text = item.description
            findViewById<MaterialTextView>(R.id.repositoryStarNumberView).text =
                decimalFormat.format(item.stargazersCount)
            findViewById<MaterialTextView>(R.id.repositoryLanguageTextView).text = item.language
            setOnClickListener {
                onItemClickListener?.let { click ->
                    click(item)
                }
            }
        }
    }
}
