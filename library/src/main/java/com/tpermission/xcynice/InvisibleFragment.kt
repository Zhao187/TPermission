package com.tpermission.xcynice

import android.content.pm.PackageManager
import androidx.fragment.app.Fragment

/**

 * Copyright (C)

 * FileName: InvisibleFragment

 * @author: Steven.zhao

 * Date: 2020/5/7 12:09

 * Description: 透明Fragment

 */
//给  (Boolean, List<String>) -> Unit 指定一个别名
typealias PermissionCallback = (Boolean, List<String>) -> Unit

class InvisibleFragment : Fragment() {

    //定义一个 callback 作为运行时权限申请结果的回调通知方式
    private var callback: PermissionCallback? = null

    //定义申请权限的方法,vararg 表示可变长度的 permissions 参数列表
    fun requestNow(cb: PermissionCallback, vararg permission: String) {
        callback = cb
        requestPermissions(permission, 1);
    }

    /**
     * 请求返回结果
     * @param requestCode Int 请求码
     * @param permissions Array<String> 权限
     * @param grantResults IntArray 请求结果
     */
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == 1) {
            // deniedList 用来记录被用户拒绝的权限
            val deniedList = ArrayList<String>()
            for ((index, result) in grantResults.withIndex()) {
                if (result != PackageManager.PERMISSION_GRANTED) {
                    deniedList.add(permissions[index])
                }
            }

            // allGranted 用来标识是否所有申请的权限都已经授权
            val allGranted = deniedList.isEmpty()

            callback?.let {
                it(allGranted, deniedList)
            }
        }
    }
}