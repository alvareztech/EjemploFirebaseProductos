package tech.alvarez.products;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ProductosAdapter extends ArrayAdapter<Producto> {

    public ProductosAdapter(Context context, List<Producto> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.item_producto, parent, false);
        }

        ImageView fotoImageView = (ImageView) convertView.findViewById(R.id.fotoImageView);
        TextView nombreTextView = (TextView) convertView.findViewById(R.id.nombreTextView);
        TextView descripcionTextView = (TextView) convertView.findViewById(R.id.descripcionTextView);
        TextView precioTextView = (TextView) convertView.findViewById(R.id.precioTextView);

        Producto p = getItem(position);

        nombreTextView.setText(p.getNombre());
        descripcionTextView.setText(p.getDescripcion());
        precioTextView.setText(p.getPrecio() + "");

        Glide.with(getContext())
                .load(p.getFotoUrl())
                .centerCrop()
                .crossFade()
                .into(fotoImageView);

        return convertView;
    }
}
