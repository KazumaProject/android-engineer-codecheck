package jp.co.yumemi.android.code_check.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import jp.co.yumemi.android.code_check.R
import jp.co.yumemi.android.code_check.domain.model.RepositorySearchResult

class GitRepositoryListAdapter :
    RecyclerView.Adapter<GitRepositoryListAdapter.GitRepositoryListViewHolder>() {
    inner class GitRepositoryListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val diffCallback = object : DiffUtil.ItemCallback<RepositorySearchResult>() {
        override fun areItemsTheSame(
            oldItem: RepositorySearchResult,
            newItem: RepositorySearchResult
        ): Boolean {
            return oldItem.name == newItem.name
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
        val item = repositoryItems[position]
        (holder.itemView.findViewById<TextView>(R.id.repositoryNameView)).text = item.name
        holder.itemView.setOnClickListener {
            onItemClickListener?.let { click ->
                click(item)
            }
        }
    }
}
