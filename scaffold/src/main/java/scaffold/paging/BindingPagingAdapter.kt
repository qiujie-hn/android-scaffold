package scaffold.paging

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.viewbinding.ViewBinding
import kotlinx.coroutines.CoroutineDispatcher
import scaffold.view.recyclerview.BindingViewHolder

/**
 * @author 仇杰(Qiu Jie)
 */
abstract class BindingPagingAdapter<T : Any, VB : ViewBinding> :
    PagingDataAdapter<T, BindingViewHolder<VB>> {

    constructor(diffCallback: DiffUtil.ItemCallback<T>) : super(diffCallback)

    constructor(
        diffCallback: DiffUtil.ItemCallback<T>,
        mainDispatcher: CoroutineDispatcher
    ) : super(diffCallback, mainDispatcher)

    constructor(
        diffCallback: DiffUtil.ItemCallback<T>,
        mainDispatcher: CoroutineDispatcher,
        workerDispatcher: CoroutineDispatcher
    ) : super(diffCallback, mainDispatcher, workerDispatcher)

    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder<VB>

    override fun onBindViewHolder(holder: BindingViewHolder<VB>, position: Int) {
        getItem(position)?.apply { onBindViewHolder(holder, holder.binding, this) }
    }

    abstract fun onBindViewHolder(holder: BindingViewHolder<VB>, binding: VB, item: T)
}