package scaffold.view.recyclerview

import androidx.viewbinding.ViewBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.ListAdapter

/**
 * @author 仇杰(Qiu Jie)
 */
abstract class BindingListAdapter<T, VB : ViewBinding> : ListAdapter<T, BindingViewHolder<VB>> {

    protected constructor(diffCallback: DiffUtil.ItemCallback<T>) : super(diffCallback)
    protected constructor(config: AsyncDifferConfig<T>) : super(config)

    override fun onBindViewHolder(holder: BindingViewHolder<VB>, position: Int) {
        getItem(position)?.let { onBindViewHolder(holder, holder.binding, it) }
    }

    abstract fun onBindViewHolder(holder: BindingViewHolder<VB>, binding: VB, item: T)
}