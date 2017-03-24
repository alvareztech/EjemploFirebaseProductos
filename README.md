# Ejemplo Firebase Realtime Database

Punto de partida del ejemplo de Firebase Realtime Database en objetos Producto.

<img width="400" alt="Screenshot" src="https://cloud.githubusercontent.com/assets/1444991/23933790/490a206a-0917-11e7-9e95-22f849c97812.png">

## Paso 0

Configuración

```java
compile 'com.google.firebase:firebase-database:10.0.1'
```

## Paso 1

```java
private DatabaseReference databaseRef;
```
    
## Paso 2    

```java    
databaseRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference productosRef = databaseRef.child("productos");

productosRef.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot snapshot) {
        productosAdapter.clear();
        for (DataSnapshot msgSnapshot : snapshot.getChildren()) {
            Producto p = msgSnapshot.getValue(Producto.class);
            productosAdapter.add(p);
        }
    }

    @Override
    public void onCancelled(DatabaseError error) {
        Toast.makeText(getApplicationContext(), R.string.cancel_process, Toast.LENGTH_SHORT).show();
    }
});
```

## Paso 3
Para guardar datos en Firebase.

```java
DatabaseReference productosRef = databaseRef.child("productos");
Producto p = new Producto();
p.setNombre("Un producto");
// ...
productosRef.push().setValue(p);
```

## Ejemplos de datos en Firebase

```json
{
    "productos" : {
        "pro1" : {
            "descripcion" : "Vino Aranjuez Tannat Merlot Duo 750ml",
            "fotoUrl" : "https://firebasestorage.googleapis.com/v0/b/products-25e39.appspot.com/o/aranjuez.jpg?alt=media&token=f6485a2d-5049-426f-bf30-006a4bcf91f0",
            "nombre" : "Aranjuez 2",
            "precio" : 40.5
        },
        "pro2" : {
            "descripcion" : "Galleta Walkers Short Fingers 200g",
            "fotoUrl" : "https://firebasestorage.googleapis.com/v0/b/products-25e39.appspot.com/o/walkers.jpg?alt=media&token=6f987056-2a81-4654-9dac-82f03594d47c",
            "nombre" : "Walkers",
            "precio" : 190
        },
        "pro3" : {
            "descripcion" : "Jugo Frut-all 1 litro",
            "fotoUrl" : "https://firebasestorage.googleapis.com/v0/b/products-25e39.appspot.com/o/frutall.jpg?alt=media&token=afff8568-7978-494b-aad6-fce3c24a0a88",
            "nombre" : "Frut-all",
            "precio" : 19.3
        }
    }
}
```