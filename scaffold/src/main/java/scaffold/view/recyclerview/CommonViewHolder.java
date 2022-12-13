package scaffold.view.recyclerview;

import android.util.SparseArray;
import android.view.View;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author 仇杰(Qiu Jie)
 */
public class CommonViewHolder extends RecyclerView.ViewHolder {

    private final SparseArray<View> views = new SparseArray<>();

    public CommonViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public <T extends View> T getView(@IdRes int id) {
        if (id == View.NO_ID) {
            return null;
        }
        View v = views.get(id);
        if (v == null) {
            v = itemView.findViewById(id);
        }
        return (T) v;
    }
}