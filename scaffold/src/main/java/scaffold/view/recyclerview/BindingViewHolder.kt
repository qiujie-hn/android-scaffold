package scaffold.view.recyclerview

import androidx.viewbinding.ViewBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * @author 仇杰(Qiu Jie)
 */
class BindingViewHolder<VB : ViewBinding>(val binding: VB) : RecyclerView.ViewHolder(binding.root)