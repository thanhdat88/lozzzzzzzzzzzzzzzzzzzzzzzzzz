package com.example.quanlydiemsinhvien.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

public class DialogBasic extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //Cài đặt các thuộc tính
        builder.setTitle("Xác nhận !");
        builder.setMessage("Bạn Thực sự muốn thêm không ?");
//        builder.setIcon(R.drawable.delete2);
        // Cài đặt button Cancel- Hiển thị Toast
        builder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "Cancel", Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });
        // Cài đặt button Yes Dismiss ẩn Dialog
        builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dismiss();
            }
        });
        return builder.create();
    }
}
