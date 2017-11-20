package app.proyectos.desarrollo.asitenteacademico.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import app.proyectos.desarrollo.asitenteacademico.R;

public class AdaperEventos extends BaseAdapter {

    Context contex;
    private int layout;
    private List<String> fechas;

    public AdaperEventos(Context contex, int layout, List<String> fechas) {
        this.contex = contex;
        this.layout = layout;
        this.fechas = fechas;
    }

    @Override
    public int getCount() {
        return this.fechas.size();
    }

    @Override
    public Object getItem(int position) {
        return this.fechas.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if(convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(this.contex);
            convertView = layoutInflater.inflate(R.layout.layout_fecha,null);
            holder = new ViewHolder();
            holder.tvRango = (TextView) convertView.findViewById(R.id.tvRango);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        String fecha_a = (String) fechas.get(position);

        holder.tvRango.setText(fecha_a);

        return convertView;
    }

    static class ViewHolder{
        private TextView tvRango;
    }
}
