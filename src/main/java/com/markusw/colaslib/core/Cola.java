package com.markusw.colaslib.core;

public class Cola<T> {

    private Nodo<T> cabeza;
    private Nodo<T> cola;
    private String contenido;

    public Cola() {
        cabeza = null;
        cola = null;
        contenido = "";
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    /*
     * Encola un elemento en la lista
     * */
    public void encolar(T elemento) {

        Nodo<T> nuevo = new Nodo<>(elemento);
        nuevo.setSiguiente(null);

        if (estaVacia()) {
            this.cabeza = nuevo;
            this.cola = nuevo;
            return;
        }

        this.cola.setSiguiente(nuevo);
        this.cola = nuevo;
    }

    /*
     * Extrae/desencola los elementos de la lista
     * */
    public T desencolar() {

        if (estaVacia()) {
            return null;
        }

        T elemento = cabeza.getValor();

        if (cabeza == cola) {
            cabeza = null;
            cola = null;
        } else {
            cabeza = cabeza.getSiguiente();
        }

        return elemento;
    }

    /*
     * Imprime por consola el contenido de la lista
     * */
    public void imprimirLista() {

        Nodo<T> mensajero = cabeza;
        String colaInvertida = "";

        while (mensajero != null) {
            contenido += mensajero.getValor().toString() + " ";
            mensajero = mensajero.getSiguiente();
        }

        String[] cadena = contenido.split(" ");

        for (int i = cadena.length - 1; i >= 0; i--) {
            colaInvertida += " " + cadena[i];
        }

        System.out.println(colaInvertida);

        contenido = "";
    }


}
