 public static objProducto[] fusionarInventarios(objProducto[] tienda1, objProducto[] tienda2) {
        objProducto[] resultado = new objProducto[tienda1.length + tienda2.length];
        int indiceResultado = 0;

        // Copiar primera tienda
        for (int i = 0; i < tienda1.length; i++) {
            resultado[indiceResultado++] = new objProducto(
                tienda1[i].getNombre(), 
                tienda1[i].getPrecio(), 
                tienda1[i].getStock()
            );
        }

        // Procesar segunda tienda
        for (int j = 0; j < tienda2.length; j++) {
            boolean encontrado = false;
            for (int k = 0; k < indiceResultado; k++) {
                if (resultado[k].getNombre().equals(tienda2[j].getNombre())) {
                    resultado[k].setStock(resultado[k].getStock() + tienda2[j].getStock());
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                resultado[indiceResultado++] = new objProducto(
                    tienda2[j].getNombre(), 
                    tienda2[j].getPrecio(), 
                    tienda2[j].getStock()
                );
            }
        }

        // Crear arreglo final del tamaño exacto
        objProducto[] finalResultado = new objProducto[indiceResultado];
        for (int i = 0; i < indiceResultado; i++) {
            finalResultado[i] = resultado[i];
        }
        return finalResultado;
}
}
