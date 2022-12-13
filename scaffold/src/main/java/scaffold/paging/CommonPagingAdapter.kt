package scaffold.paging

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import kotlinx.coroutines.CoroutineDispatcher
import scaffold.view.recyclerview.CommonViewHolder

/**
 * @author 仇杰(Qiu Jie)
 */
abstract class CommonPagingAdapter<T : Any> : PagingDataAdapter<T, CommonViewHolder> {

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

    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommonViewHolder

    override fun onBindViewHolder(holder: CommonViewHolder, position: Int) {
        getItem(position)?.apply { onBindViewHolder(holder, position, this) }
    }

    abstract fun onBindViewHolder(holder: CommonViewHolder, position: Int, item: T)
}