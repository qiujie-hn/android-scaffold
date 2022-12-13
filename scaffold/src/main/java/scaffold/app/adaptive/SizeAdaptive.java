package scaffold.app.adaptive;

import android.util.DisplayMetrics;

/**
 * @author 仇杰(Qiu Jie)
 */
public interface SizeAdaptive {

    /**
     * 是否启用尺寸自动适配
     *
     * @return true 表示启用，false 表示不启用。默认为 true
     */
    default boolean isAdaptive(){
        return true;
    }

    /**
     * 设计图页面宽度 (建议设计稿尺寸 360x480)
     * @return 设计图页面尺寸宽度。默认为 360
     */
    default int designDraftWidth(){
        return 360;
    }

    default void adaptive(DisplayMetrics displayMetrics) {
        if (!isAdaptive()) return;

        if (displayMetrics == null) {
            return;
        }

        int density = displayMetrics.widthPixels / designDraftWidth();
        float scaledDensity = density * (displayMetrics.scaledDensity / displayMetrics.density);
        int densityDpi = density * 160;

        displayMetrics.density = density;
        displayMetrics.scaledDensity = scaledDensity;
        displayMetrics.densityDpi = densityDpi;

    }
}
