package com.permissionx.guomenglongdev

import androidx.fragment.app.FragmentActivity

/**
 * @author 郭梦龙
 * @data 8/26/21-7:44 PM
 * @Description
 */
object PermissionX {
    private const val TAG="InvisibleFragment"
    fun request(activity:FragmentActivity,vararg permissions:String,callback: PermissionCallback){
        val fragmentManager=activity.supportFragmentManager
        val existedFragment=fragmentManager.findFragmentByTag(TAG)
        val fragment=if (existedFragment!=null){
            existedFragment as InvisibleFragment
        }else{
            val invisibleFragment=InvisibleFragment()
            fragmentManager.beginTransaction().add(invisibleFragment, TAG).commitNow()
            invisibleFragment
        }
        fragment.requestNow(callback,*permissions)
    }
}