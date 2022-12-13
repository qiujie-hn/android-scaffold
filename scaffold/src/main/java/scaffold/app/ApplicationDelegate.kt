package scaffold.app

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import scaffold.app.adaptive.SizeAdaptive

/**
 * @author 仇杰(Qiu Jie)
 */
class ApplicationDelegate(
    application: Application,
    handler: Thread.UncaughtExceptionHandler,
    private val callback: ApplicationCallback,
    private val adaptive: SizeAdaptive
) : Application.ActivityLifecycleCallbacks {

    private var mAppIsBackground = false
    private var mActiveActivity = 0

    init {
        application.apply {
            registerActivityLifecycleCallbacks(this@ApplicationDelegate)
            Thread.setDefaultUncaughtExceptionHandler(handler)
            Handler(Looper.getMainLooper()).post {
                while (true) {
                    try {
                        Looper.loop() //主线程的异常会从这里抛出
                    } catch (e: Throwable) {
                        handler.uncaughtException(Looper.getMainLooper().thread, e)
                    }
                }
            }
            adaptive.adaptive(application.resources.displayMetrics)
        }
    }

    override fun onActivityPreCreated(activity: Activity, savedInstanceState: Bundle?) {
        if (activity is SizeAdaptive) {
            val adaptive = activity as SizeAdaptive
            adaptive.adaptive(activity.resources.displayMetrics)
        } else {
            adaptive.adaptive(activity.resources.displayMetrics)
        }
    }

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) = Unit
    override fun onActivityStarted(activity: Activity) {
        ++mActiveActivity
        if (mAppIsBackground) {
            mAppIsBackground = false
            callback.onApplicationEnterForeground()
        }
    }

    override fun onActivityResumed(activity: Activity) = Unit
    override fun onActivityPaused(activity: Activity) = Unit
    override fun onActivityStopped(activity: Activity) {
        --mActiveActivity
        if (mActiveActivity == 0) {
            mAppIsBackground = true
            callback.onApplicationEnterBackground()
        }
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) = Unit
    override fun onActivityDestroyed(activity: Activity) = Unit
}