package scaffold.view.recyclerview

import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

/**
 * @author 仇杰(Qiu Jie)
 */
abstract class CommonListAdapter<T> : ListAdapter<T, CommonViewHolder> {

    protected constructor(diffCallback: DiffUtil.ItemCallback<T>) : super(diffCallback)
    protected constructor(config: AsyncDifferConfig<T>) : super(config)

    override fun onBindViewHolder(holder: CommonViewHolder, position: Int) {
        getItem(position)?.let { onBindViewHolder(holder, position, it) }
    }

    abstract fun onBindViewHolder(holder: CommonViewHolder, position: Int, item: T)
}