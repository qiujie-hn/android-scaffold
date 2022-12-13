package scaffold.view.recyclerview

import androidx.recyclerview.widget.DiffUtil
import java.util.*

/**
 * @author 仇杰(Qiu Jie)
 */
class CommonDiffItemCallback : DiffUtil.ItemCallback<Any>() {
    override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean {
        return Objects.equals(oldItem,newItem)
    }
}