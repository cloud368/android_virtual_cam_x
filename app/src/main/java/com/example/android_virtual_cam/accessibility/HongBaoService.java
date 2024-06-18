package com.example.android_virtual_cam.accessibility;

import android.accessibilityservice.AccessibilityService;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

import com.example.android_virtual_cam.XposedBridge;

import java.util.ArrayList;
import java.util.List;

public class HongBaoService extends AccessibilityService {
    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        AccessibilityNodeInfo nodeInfo = getRootInActiveWindow();
        initWindowInfo(nodeInfo);
    }

    private void initWindowInfo(AccessibilityNodeInfo info) {
        List<AccessibilityNodeInfo> accessibilityNodeInfos = new ArrayList<>();
        getAccessibilityNodeInfoS(accessibilityNodeInfos, info);
    }

    public void getAccessibilityNodeInfoS(List<AccessibilityNodeInfo> nodeInfos, AccessibilityNodeInfo node) {
        if (node == null) {
            return;
        }
        for (int i = 0; i < node.getChildCount(); i++) {
            AccessibilityNodeInfo accessibilityNodeInfo = node.getChild(i);
            if (accessibilityNodeInfo != null) {
                nodeInfos.add(accessibilityNodeInfo);
                getAccessibilityNodeInfoS(nodeInfos, accessibilityNodeInfo);
            }
        }
    }


    @Override
    public void onInterrupt() {

    }
}
