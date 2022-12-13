package scaffold.view.recyclerview

import androidx.viewbinding.ViewBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * @author 仇杰(Qiu Jie)
 */
abstract class BindingAdapter<T, VB : ViewBinding>(private val currentList: List<T>?) :
    RecyclerView.Adapter<BindingViewHolder<VB>>() {


    override fun onBindViewHolder(holder: BindingViewHolder<VB>, position: Int) {
        getItem(position)?.let { onBindViewHolder(holder, position, it) }
    }

    abstract fun onBindViewHolder(holder: BindingViewHolder<VB>, position: Int, item: T)

    override fun getItemCount(): Int {
        return currentList?.run { size } ?: 0
    }

    open fun getItem(position: Int): T? {
        return currentList?.run { get(position) }
    }
}