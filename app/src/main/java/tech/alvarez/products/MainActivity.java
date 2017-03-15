package tech.alvarez.products;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;



import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Paso 1

    private ListView productsListView;
    private ProductosAdapter productosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Producto> products = new ArrayList<>();
        productosAdapter = new ProductosAdapter(this, products);

        productsListView = (ListView) findViewById(R.id.productosListView);
        productsListView.setAdapter(productosAdapter);


        // Firebase

        // Paso 2
    }

    public void adicionarProducto(View view) {
        // Cuando se presiona el botón de adicionar

    }
}
