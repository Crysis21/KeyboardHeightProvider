package com.hold1.keyboardheightprovider

/**
 * Created by Cristian Holdunu on 12/01/2019.
 */
object KeyboardInfo {
    const val HEIGHT_NOT_COMPUTED = -1
    const val STATE_UNKNOWN = -1
    const val STATE_CLOSED = 0
    const val STATE_OPENED = 1

    /**
     * Cached keyboard height. This will keep the last keyboard height value and not
     * it's current height
     */
    var keyboardHeight = HEIGHT_NOT_COMPUTED

    /**
     * Real time keyboard state
     */
    var keyboardState = STATE_UNKNOWN
}