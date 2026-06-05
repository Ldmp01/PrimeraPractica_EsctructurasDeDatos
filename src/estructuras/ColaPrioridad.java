package estructuras;

import modelo.Ticket;

public class ColaPrioridad {
    // Atributos
    private Nodo primero;

    // Constructor
    public ColaPrioridad() {
        this.primero = null;
    }

    // Getters y Setters
    public Nodo getPrimero() {
        return primero;
    }

    public void setPrimero(Nodo primero) {
        this.primero = primero;
    }

    // Operaciones
    private boolean estaVacia() {
        return primero == null;
    }

    public void ingresar(Ticket nuevoTicket) {
        Nodo nodo = new Nodo(nuevoTicket);

        // Si está vacía o el nuevo tiene más prioridad
        if (estaVacia() || nuevoTicket.getPrioridad() < primero.getTicket().getPrioridad()) {
            nodo.setSiguiente(primero);
            this.primero = nodo;
        } else {
            Nodo temp = primero;
            while (temp.getSiguiente() != null && temp.getSiguiente().getTicket().getPrioridad() <= nuevoTicket.getPrioridad()) {
                temp = temp.getSiguiente();
            }
            nodo.setSiguiente(temp.getSiguiente());
            temp.setSiguiente(nodo);
        }
    }

    public Ticket eliminar() {
        if (estaVacia()) {
            System.out.println("La lista está vacía.\n");
            return null;
        }
        Ticket temp = primero.getTicket();
        this.primero = primero.getSiguiente();
        return temp;
    }

    public Ticket verFrente() {
        if (estaVacia()) {
            System.out.println("La lista está vacía.\n");
            return null;
        }
        return primero.getTicket();
    }
}