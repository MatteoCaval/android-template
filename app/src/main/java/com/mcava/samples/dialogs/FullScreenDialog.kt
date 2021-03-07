package com.mcava.samples.dialogs

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.mcava.samples.R
import kotlinx.android.synthetic.main.full_screen_dialog.view.*

class FullScreenDialog : DialogFragment() {

    companion object {
        fun newInstance(): FullScreenDialog {
            return FullScreenDialog()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialogTheme)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.full_screen_dialog, container, false)

        view.toolbar.apply {
            title = "FullScreenDialog"
            setNavigationIcon(R.drawable.ic_close)
            setNavigationOnClickListener {
                dismiss()
            }
            inflateMenu(R.menu.menu_full_screen_dialog)
            setOnMenuItemClickListener {
                dismiss()
                true
            }
        }

        return view
    }


}