public class Main {
    public static void main(String[] args) {
        // crear una instancia de Netflix
        Netflix netflix = new Netflix();

        // agregar algunos servicios
        netflix.agregarServicio(new Servicio("Netflix Premium", 19.99));
        netflix.agregarServicio(new Servicio("Netflix Básico", 7.99));

        // vender algunos servicios a clientes
        netflix.venderServicio("Juan", "Netflix Premium");
        netflix.venderServicio("María", "Netflix Básico");

        // mostrar el inventario de servicios
        netflix.verInventario();

        // mostrar la lista de clientes
        netflix.verClientes();
    }
}
