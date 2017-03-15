package tech.alvarez.products;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference databaseRef;

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

        databaseRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference productosRef = databaseRef.child("productos");

        productosRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                productosAdapter.clear();
                for (DataSnapshot msgSnapshot : snapshot.getChildren()) {
                    Producto msg = msgSnapshot.getValue(Producto.class);
                    productosAdapter.add(msg);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(getApplicationContext(), R.string.cancel_process, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void adicionarProducto(View view) {
        // Cuando se presiona el botón de adicionar

    }
}
