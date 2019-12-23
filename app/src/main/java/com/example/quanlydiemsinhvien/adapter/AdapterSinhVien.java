package com.example.quanlydiemsinhvien.adapter;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.quanlydiemsinhvien.R;
import com.example.quanlydiemsinhvien.model.StudentDTO;

import java.util.ArrayList;
import java.util.List;

public class AdapterSinhVien extends BaseAdapter {
    private List<StudentDTO> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public AdapterSinhVien(Context context, List<StudentDTO> listData) {
        this.context = context;
        this.listData = listData;
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_sinhvien_row, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        StudentDTO studentDTO = this.listData.get(position);
        holder.txtID.setText(String.valueOf(studentDTO.getStudentId()));
        holder.txtTen.setText(studentDTO.getStudentName());
        holder.txtQuequan.setText(studentDTO.getStudentAdress());
        holder.txtNamsinh.setText(studentDTO.getStudentBirhDay());
        return convertView;
       }

    static class ViewHolder {
        TextView txtID;
        TextView txtTen;
        TextView txtQuequan;
        TextView txtNamsinh;

        public ViewHolder(View view) {
            txtID = view.findViewById(R.id.txtID);
            txtTen = view.findViewById(R.id.txtTen);
            txtQuequan = view.findViewById(R.id.txtQuequan);
            txtNamsinh = view.findViewById(R.id.txtNamsinh);
        }
    }

}
