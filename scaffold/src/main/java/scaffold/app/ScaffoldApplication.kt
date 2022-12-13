package scaffold.app

import android.app.Application
import scaffold.app.adaptive.SizeAdaptive

/**
 * @author 仇杰(Qiu Jie)
 */
class ScaffoldApplication : Application(), Thread.UncaughtExceptionHandler, ApplicationCallback,
    SizeAdaptive {

    override fun onCreate() {
        super.onCreate()
        ApplicationDelegate(this, this, this, this)
    }

    override fun uncaughtException(t: Thread, e: Throwable) = Unit

    /**
     * 应用进入前台时
     */
    override fun onApplicationEnterForeground() = Unit

    /**
     * 应用进入后台时
     */
    override fun onApplicationEnterBackground() = Unit
}