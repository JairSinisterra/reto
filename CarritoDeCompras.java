import java.util.ArrayList;
import java.util.Scanner;

public class CarritoDeCompras {
// Jair Sinisterra, Daisy Malagon, Cristina Samboni
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> productos = new ArrayList<>();
        ArrayList<Integer> cantidades = new ArrayList<>();
        ArrayList<Double> precios = new ArrayList<>();

        while (true) {
            
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Insertar producto");
            System.out.println("2. Eliminar producto");
            System.out.println("3. Actualizar producto");
            System.out.println("4. Aplicar descuento");
            System.out.println("5. Generar ticket");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
               
                    System.out.print("Ingresa el nombre del producto: ");
                    String producto = scanner.nextLine();
                    System.out.print("Ingresa la cantidad: ");
                    int cantidad = scanner.nextInt();
                    System.out.print("Ingresa el precio del producto: ");
                    double precio = scanner.nextDouble();
                    // Agregar 
                    productos.add(producto);
                    cantidades.add(cantidad);
                    precios.add(precio);
                    System.out.println("Producto '" + producto + "' agregado al carrito.");
                    break;

                case 2:
                    // Eliminar
                    System.out.print("Ingresa el nombre del producto a eliminar: ");
                    String productoEliminar = scanner.nextLine();
                    int indexEliminar = productos.indexOf(productoEliminar);
                    if (indexEliminar != -1) {
                        productos.remove(indexEliminar);
                        cantidades.remove(indexEliminar);
                        precios.remove(indexEliminar);
                        System.out.println("Producto '" + productoEliminar + "' eliminado del carrito.");
                    } else {
                        System.out.println("El producto no se encuentra en el carrito.");
                    }
                    break;

                case 3:
                  
                    System.out.print("Ingresa el nombre del producto a actualizar: ");
                    String productoActualizar = scanner.nextLine();
                    int indexActualizar = productos.indexOf(productoActualizar);
                    if (indexActualizar != -1) {
                        System.out.print("Ingresa la nueva cantidad: ");
                        int nuevaCantidad = scanner.nextInt();
                        System.out.print("Ingresa el nuevo precio: ");
                        double nuevoPrecio = scanner.nextDouble();
                        cantidades.set(indexActualizar, nuevaCantidad);
                        precios.set(indexActualizar, nuevoPrecio);
                        System.out.println("Producto '" + productoActualizar + "' actualizado.");
                    } else {
                        System.out.println("El producto no se encuentra en el carrito.");
                    }
                    break;

                case 4:
                   
                    System.out.print("Ingresa el porcentaje de descuento (por ejemplo, 10 para 10%): ");
                    double descuento = scanner.nextDouble();
                    // Aplicar descuento 
                    for (int i = 0; i < precios.size(); i++) {
                        double precioOriginal = precios.get(i);
                        double precioConDescuento = precioOriginal * (1 - descuento / 100);
                        precios.set(i, precioConDescuento);
                    }
                    System.out.println("Descuento del " + descuento + "% aplicado a todos los productos.");
                    break;

                case 5:
                    // Generar ticket
                    double total = 0;
                    System.out.println("\n--- TICKET ---");
                    for (int i = 0; i < productos.size(); i++) {
                        String prod = productos.get(i);
                        int cant = cantidades.get(i);
                        double precioFinal = precios.get(i);
                        double subtotal = cant * precioFinal;
                        total += subtotal;
                        System.out.println(prod + " | Cantidad: " + cant + " | Precio: $" + precioFinal + " | Subtotal: $" + subtotal);
                    }
                    System.out.println("Total a pagar: $" + total);
                    break;

                case 6:
                    // Salir
                    System.out.println("¡Gracias por usar el carrito de compras!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
                    
            }
        }
    }
}