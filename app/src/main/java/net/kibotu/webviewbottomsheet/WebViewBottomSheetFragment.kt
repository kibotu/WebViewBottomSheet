package net.kibotu.webviewbottomsheet

import android.annotation.SuppressLint
import android.app.Dialog
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class WebViewBottomSheetFragment : BottomSheetDialogFragment() {

    private var webView: WebView? = null

    override fun onCreateDialog(
        savedInstanceState: Bundle?,
    ): Dialog = BottomSheetDialog(
        requireContext(),
        R.style.WebViewBottomSheet,
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View = inflater.inflate(R.layout.fragment_webview_bottom_sheet, container, false)

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val web = view.findViewById<WebView>(R.id.webView)
        webView = web
        web.settings.apply {
            javaScriptEnabled = true
            domStorageEnabled = true
            loadWithOverviewMode = true
            useWideViewPort = true
            mediaPlaybackRequiresUserGesture = false
            allowFileAccess = false
            allowContentAccess = false
            setSupportZoom(true)
            builtInZoomControls = true
            displayZoomControls = false
        }

        webView?.setOnTouchListener { v: View, event: MotionEvent ->
            v.parent.requestDisallowInterceptTouchEvent(v.scrollY > 0)
            v.onTouchEvent(event)
            true
        }

        web.webViewClient = WebViewClient()
        web.webChromeClient = WebChromeClient()
        web.loadUrl(URL)
    }

    override fun onStart() {
        super.onStart()
        val dialog = dialog as? BottomSheetDialog ?: return
        dialog.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        val sheet = dialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet) ?: return
        sheet.setBackgroundColor(Color.TRANSPARENT)
        sheet.layoutParams = sheet.layoutParams.apply { height = ViewGroup.LayoutParams.MATCH_PARENT }
        BottomSheetBehavior.from(sheet).apply {
            state = BottomSheetBehavior.STATE_EXPANDED
            skipCollapsed = true
            isHideable = true
        }
    }

    override fun onResume() {
        super.onResume()
        webView?.onResume()
    }

    override fun onPause() {
        webView?.onPause()
        super.onPause()
    }

    override fun onDestroyView() {
        webView?.apply {
            stopLoading()
            loadUrl("about:blank")
            (parent as? ViewGroup)?.removeView(this)
            destroy()
        }
        webView = null
        super.onDestroyView()
    }

    companion object {
        const val TAG = "WebViewBottomSheetFragment"
        private const val URL = "https://trail.kibotu.net"
    }
}
