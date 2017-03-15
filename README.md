# Ejemplo Firebase Realtime Database

Punto de partida del ejemplo de Firebase Realtime Database en objetos Producto.

![device-2017-03-15-002344](https://cloud.githubusercontent.com/assets/1444991/23933790/490a206a-0917-11e7-9e95-22f849c97812.png)

## Paso 0

    compile 'com.google.firebase:firebase-database:10.0.1'

## Paso 1

    private DatabaseReference databaseRef;
    
## Paso 2    
    
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