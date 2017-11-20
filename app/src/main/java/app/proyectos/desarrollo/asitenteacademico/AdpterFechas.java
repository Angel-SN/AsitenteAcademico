package app.proyectos.desarrollo.asitenteacademico;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdpterFechas extends BaseAdapter {

    Context contex;
    private int layout;
    private List<String> fechas;

    public AdpterFechas(Context contex, int layout, List<String> fechas) {
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
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(this.contex);
            convertView = layoutInflater.inflate(R.layout.layout_fecha,null);
            holder = new ViewHolder();

            holder.tvnumperiodo = (TextView) convertView.findViewById(R.id.tvNumPeriodo);
            holder.tvRango = (TextView) convertView.findViewById(R.id.tvRango);
        } else{
            holder = (ViewHolder) convertView.getTag();
        }

        String fecha_a = (String) fechas.get(position);

        holder.tvnumperiodo.setText((position+1) + "° Periodo");
        holder.tvRango.setText(fecha_a);

        return convertView;
    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }

    static class ViewHolder {
        private TextView tvnumperiodo;
        private TextView tvRango;

    }
}
