import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

class Servicio {
    private String nombre;
    private double precio;
    
    public Servicio(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public double getPrecio() {
        return precio;
    }
}

class Cliente {
    private String nombre;
    private HashSet<Servicio> servicios;
    
    public Cliente(String nombre) {
        this.nombre = nombre;
        servicios = new HashSet<>();
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public HashSet<Servicio> getServicios() {
        return servicios;
    }
    
    public void agregarServicio(Servicio servicio) {
        servicios.add(servicio);
    }
    
    public void cambiarServicio(Servicio servicioAnterior, Servicio nuevoServicio) {
        servicios.remove(servicioAnterior);
        servicios.add(nuevoServicio);
    }
    
    public void eliminarServicio(Servicio servicio) {
        servicios.remove(servicio);
    }
}

class Netflix {
    private HashMap<String, Servicio> servicios;
    private LinkedList<Cliente> clientes;
    
    public Netflix() {
        servicios = new HashMap<>();
        clientes = new LinkedList<>();
    }
    
    public void agregarServicio(Servicio servicio) {
        servicios.put(servicio.getNombre(), servicio);
    }
    
    public void venderServicio(String nombreCliente, String nombreServicio) {
        Servicio servicio = servicios.get(nombreServicio);
        if (servicio != null) {
            Cliente cliente = new Cliente(nombreCliente);
            cliente.agregarServicio(servicio);
            clientes.add(cliente);
        }
    }
    
    public boolean buscarServicio(String nombreCliente, String nombreServicio) {
        for (Cliente cliente : clientes) {
            if (cliente.getNombre().equals(nombreCliente)) {
                HashSet<Servicio> serviciosCliente = cliente.getServicios();
                for (Servicio servicio : serviciosCliente) {
                    if (servicio.getNombre().equals(nombreServicio)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public void verInventario() {
        System.out.println("Servicios disponibles:");
        for (String nombreServicio : servicios.keySet()) {
            Servicio servicio = servicios.get(nombreServicio);
            System.out.println("- " + servicio.getNombre() + " ($" + servicio.getPrecio() + ")");
        }
    }
    
    public void verClientes() {
        System.out.println("Clientes:");
        for (Cliente cliente : clientes) {
            System.out.println("- " + cliente.getNombre() + ":");
            HashSet<Servicio> serviciosCliente = cliente.getServicios();
            for (Servicio servicio : serviciosCliente) {
                System.out.println("  - " + servicio.getNombre() + " ($" + servicio.getPrecio() + ")");
            }
        }
    }
    
    public int cantidadServicios() {
        return servicios.size();
    }
    
    public int cantidadClientes() {
        return clientes.size();
    }
    
    public void vaciarColecciones() {
        servicios.clear();
        clientes.clear();
    }
    
    /**
     * @param nombreCliente
     * @param servicioAnterior
     * @param nuevoServicio
     */
    public void cambiarPlan(String nombreCliente, Servicio servicioAnterior, Servicio nuevoServicio) {
        for (Cliente cliente : clientes) {
            if (cliente.getNombre().equals(nombreCliente)) {
                cliente.cambiarServicio(servicioAnterior, nuevoServicio);
            }
        }
    }
}