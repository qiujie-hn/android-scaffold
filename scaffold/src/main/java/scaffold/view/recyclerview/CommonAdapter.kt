package scaffold.view.recyclerview

import androidx.recyclerview.widget.RecyclerView

/**
 * @author 仇杰(Qiu Jie)
 */
abstract class CommonAdapter<T>(private val currentList: List<T>?) : RecyclerView.Adapter<CommonViewHolder>() {

    override fun onBindViewHolder(holder: CommonViewHolder, position: Int) {
        getItem(position)?.let { onBindViewHolder(holder, position, it) }
    }

    abstract fun onBindViewHolder(holder: CommonViewHolder, position: Int, item: T)

    override fun getItemCount(): Int {
        return currentList?.run { size } ?: 0
    }

    open fun getItem(position: Int): T? {
        return currentList?.run { get(position) }
    }
}