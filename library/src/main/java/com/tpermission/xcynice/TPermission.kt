package com.tpermission.xcynice

import androidx.fragment.app.FragmentActivity

/**

 * Copyright (C)

 * FileName: TPermission

 * @author: Steven.zhao

 * Date: 2020/5/7 12:41

 * Description: 权限管理

 */
object TPermission {
    private const val TAG = "InvisibleFragment"

    fun request(
        activity: FragmentActivity,
        vararg permission: String,
        callback: PermissionCallback
    ) {
        val fragmentManager = activity.supportFragmentManager
        val existedFragment = fragmentManager.findFragmentByTag(TAG)

        val fragment = if (existedFragment != null) {
            existedFragment as InvisibleFragment
        } else {
            val invisibleFragment = InvisibleFragment()
            fragmentManager.beginTransaction().add(invisibleFragment, TAG).commitNow()
            invisibleFragment
        }

        fragment.requestNow(callback, *permission)
    }
}