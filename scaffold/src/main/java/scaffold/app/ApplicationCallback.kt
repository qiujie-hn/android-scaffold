package scaffold.app

/**
 * @author 仇杰(Qiu Jie)
 */
interface ApplicationCallback {
    /**
     * 应用进入前台时
     */
    fun onApplicationEnterForeground()
    /**
     * 应用进入后台时
     */
    fun onApplicationEnterBackground()
}