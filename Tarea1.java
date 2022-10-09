package tarea1;

import java.util.ArrayList;
import java.util.Date;

class Cliente{
    private String nombre;
    private String rut;
    public Direccion direc;
    
    public Cliente(String nom, String r){
        nombre = nom;
        rut = r;
    }
    public String getNombreCliente(){
        return this.nombre;
    }
    public void setNombreCliente(String nuevoNomCliente){
        this.nombre = nuevoNomCliente;
    }
     public String getRutCliente(){
        return this.rut;
    }
    public void setRutCliente(String nuevoRutCliente){
        this.nombre = nuevoRutCliente;
    }
    public String getDirCliente(){
        return this.direc.getDireccion();
    }
}

class Direccion{
    private String direccion;
    public Cliente dirCliente;
    public DocumentoTributario docTributario;
    
    public Direccion(String direc){
        direccion = direc;
    } 
    public String getDireccion(){
        return this.direccion;
    }
    public void setDireccion(String newDireccion){
        this.direccion = newDireccion;
    }
}

class OrdenCompra{
    private Date fecha;
    private String estado;
    public DetalleOrden detOrden; //para asociar las clases
    
    public OrdenCompra(String est){
      //  fecha = f;
        estado = est;
    }
    
    public void calcularPrecioSinIva(){
       
    }
    public double calcularIva(float precio){
        double iva = precio*(1.19);
        return iva;
    }
    public void calcularPrecio(){
        
    }
    public void calcularPeso(){
        
    }
    public void addDet(int cant, Articulo a){
        
    }
    
    public String getEstado(){
        return this.estado;
    }
}

class DetalleOrden{
    private int cantidad;
    private ArrayList<Articulo> detalle;
    public OrdenCompra ordenCompra;
    public Articulo producto;
    
    public DetalleOrden(int c){
        cantidad = c;
        detalle = new ArrayList();
    }
    
    public double calcPrecio(Articulo art){
        //calcular precio total
        double calcularPrecio = (float)cantidad*art.getPrecio()*1.19;
//        detalle.add(cantidad, art);
        return calcularPrecio;
    }
    public double calcPrecioSinIva(Articulo art){
//        double iva = art.getPrecio()*0.19;
//        return cantidad*art.getPrecio() - cantidad*iva;
          return cantidad*art.getPrecio();
    }
    public double calcIva(Articulo art){
        double iva= art.getPrecio()*0.19;
        return iva*cantidad;
    }
    public float calcPeso(Articulo art){
        return art.getPeso()*cantidad;
    }
    
    public int getCantidad(){
        return this.cantidad;
    }
}

class Articulo{
    private float peso;
    private String nombre;
    private String descripcion;
    private float precio;  
    public DetalleOrden detOrden;
    
    public Articulo(String nom, String desc, float peso, float prec){
       this.nombre = nom;
       this.descripcion = desc;
       this.precio = prec;
       this.peso = peso;
    }
    public String getNombre(){
        return this.nombre;
    }
    public void setNombre(String nuevoNom){
        this.nombre = nuevoNom;
    }
    public String getDescripcion(){
        return this.descripcion;
    }
    public void setDescripcion(String nuevaDesc){
        this.descripcion= nuevaDesc;
    }
    public Float getPrecio(){
        return this.precio;
    }
    public void setPrecio(Float nuevoPrecio){
        this.precio= nuevoPrecio;
    }
    public Float getPeso(){
        return this.peso;
    }
    public void setPeso(Float nuevoPeso){
        this.precio= nuevoPeso;
    }
}
 
class Pago{
    private float monto;
    private Date fecha;

    
    public Pago(float mont){
        monto = mont;
    }
    public Float getMonto(){
        return this.monto;
    }
    public String metodoPago(){
        return "Metodo Pago: ";
    }
}

class Efectivo extends Pago{
    public Efectivo(int i){
        super(i);
    }
    public float calcDevolucion(float pagado){
        //vuelto
        float total = super.getMonto();
        return pagado-total;
    }
    public String metodoPago(){
        return super.metodoPago()+ "Efectivo";
    }
}
class Transferencia extends Pago{
    private String banco;
    private String numCuenta;
    
    public Transferencia(int i, String banc, String ncuenta){
        super(i);
        banco = banc;
        numCuenta= ncuenta;
    }
    
    public String getBanco(){
        return this.banco;
    }
}

class Tarjeta extends Pago{
    private String tipo;
    private String numTransaccion;
    
    public Tarjeta(int i){
        super(i);
    }
}

class DocumentoTributario{
    private String numero;
    private String rut;
    private Date fecha;
    public Direccion direc; 
    
    public DocumentoTributario(String num, String rutt){
        numero = num;
        rut = rutt;
    }
    
    public String getNumero(){
        return this.numero;
    }
    public String getRut(){
        return this.rut;
    }
    public String getDirec(){
        return this.direc.getDireccion();
    }
}

class Factura extends DocumentoTributario{
    public Factura(String numero, String rut){
        super(numero, rut);
    }
}

class Boleta extends DocumentoTributario{
    public Boleta(){
        
    }
}

public class Tarea1 {

    public static void main(String[] args) {
        //Orden1
        //cliente1
        Cliente cliente1 = new Cliente("Selena Gomez", "11234567-8");
        Direccion direc1 = new Direccion("Las violetas 1234");
        cliente1.direc = direc1;
        System.out.println(cliente1.getNombreCliente()+" " + cliente1.getRutCliente()+ " " + cliente1.getDirCliente());
        
        //cliente2
        Cliente cliente2 = new Cliente("Taylor Swift", "12345678-9");
        Direccion direc2 = new Direccion("Los Lirios 189");
        cliente2.direc = direc2;
        
        
        OrdenCompra orden1 = new OrdenCompra("Pagado");
        DetalleOrden det1 = new DetalleOrden(2);
        DetalleOrden det2 = new DetalleOrden(5);
        DetalleOrden det3 = new DetalleOrden(3);
        Articulo art1 = new Articulo("milka", "chocolate con relleno de trufa", 150, 1600);
        Articulo art2 = new Articulo("super8", "galleta cubierta de chocolate", 80, 300);
        Articulo art3 = new Articulo("chocochips", "con chips de chocolate", 200, 1000);
        Articulo art4 = new Articulo("chocman", "Bizcocho bañado de chocolate", 70, 300);
        Articulo art5 = new Articulo("chocochips", "con chips de chocolate", 200, 1000);
        Articulo art6 = new Articulo("Sprite", "bebida salor limon", 500, 1200);
        
        System.out.println("---Detalle compra---");
        System.out.println("Cantidad: " + det1.getCantidad()+ " " +art1.getNombre() + " " + art1.getDescripcion() + " " + art1.getPeso()+ "gr " + art1.getPrecio()+" PRECIO:"+ det1.calcPrecioSinIva(art1)+" IVA:"+ det1.calcIva(art1)+" TOTAL:"+ det1.calcPrecio(art1));
        System.out.println("Cantidad: " + det2.getCantidad()+" " + art2.getNombre() + " " + art2.getDescripcion() + " " + art2.getPeso()+ "gr " + art2.getPrecio()+" PRECIO:"+ det2.calcPrecioSinIva(art2)+" IVA:"+ det2.calcIva(art2)+" TOTAL:"+ det2.calcPrecio(art2));
        System.out.println("Cantidad: " + det3.getCantidad()+" " +art4.getNombre() + " " + art4.getDescripcion() + " " + art4.getPeso()+ "gr " + art4.getPrecio()+" PRECIO:"+ det3.calcPrecioSinIva(art4)+" IVA:"+ det3.calcIva(art4)+" TOTAL:"+ det3.calcPrecio(art4));
        
        double total= det1.calcPrecio(art1)+ det2.calcPrecio(art2)+det3.calcPrecio(art4);
        System.out.println("TOTAL: " + total);
        System.out.println("Estado: " + orden1.getEstado());
        
        /*
        ArrayList<Articulo> detalle1 = new ArrayList<>();
            detalle1.add(new Articulo("chocochips", "con chips de chocolate", 200, 1000));
            detalle1.add(new Articulo("Rolls", "mani cubierto de chocolate", 150, 1500));
            detalle1.add(new Articulo("milka", "chocolate con relleno de trufa", 150, 1600));
            detalle1.add(new Articulo("super8", "galleta cubierta de chocolate", 80, 300));
            detalle1.add(new Articulo("chocman", "Bizcocho bañado de chocolate", 70, 300));
         
         System.out.println("---Detalle compra---");
         System.out.println("Estado: " + orden1.getEstado());
         
        // System.out.println(art1.getNombre()+ ": " + art1.getDescripcion()+ " " + art1.getPrecio());
         System.out.println(detalle1.get(0).getNombre() + " " +detalle1.get(0).getDescripcion()+ " " + detalle1.get(0).getPeso()+" gr " + " " +detalle1.get(0).getPrecio());
         System.out.println(detalle1.get(1).getNombre() + " " +detalle1.get(1).getDescripcion()+ " " + detalle1.get(1).getPeso()+" gr " + " " +detalle1.get(1).getPrecio());
         System.out.println(detalle1.get(2).getNombre() + " " +detalle1.get(2).getDescripcion()+ " " + detalle1.get(2).getPeso()+" gr " + " " +detalle1.get(2).getPrecio());
         System.out.println(detalle1.get(3).getNombre() + " " +detalle1.get(3).getDescripcion()+ " " + detalle1.get(3).getPeso()+" gr " + " " +detalle1.get(3).getPrecio());
         System.out.println(detalle1.get(4).getNombre() + " " +detalle1.get(4).getDescripcion()+ " " + detalle1.get(4).getPeso()+" gr " + " " +detalle1.get(4).getPrecio());
         
         System.out.println("IVA total: " + det1.calcIva(detalle1.get(0)));
         System.out.println("IVA producto 2: " + det1.calcIva(detalle1.get(1)));
        */ 
         System.out.println("---Detalle Pago---");
         Transferencia tr = new Transferencia(2, "Estado", "189023");
         System.out.println("Banco: " + tr.getBanco());
         
        //"Tipo Documento:"
         DocumentoTributario doc = new DocumentoTributario("123", "12345-6");
         Factura factura = new Factura("13", "12345-6"); 
         if(doc.getNumero().equals(factura.getNumero())){
             System.out.println("Tipo Documento: Factura");
         }
         else System.out.println("Tipo Documento: Boleta");

        Pago pa = new Pago(10000);
        Efectivo e = new Efectivo(20000);
        System.out.println("Tipo pago: ");
        System.out.println("vuelto: " + e.calcDevolucion(10000));
        
        //orden2
        System.out.println();
        System.out.println(cliente2.getNombreCliente()+" " + cliente2.getRutCliente()+ " " + cliente2.getDirCliente());
        System.out.println("---Detalle compra---");
        
        OrdenCompra orden2 = new OrdenCompra("Pagado");
        DetalleOrden det4 = new DetalleOrden(1);
        DetalleOrden det5 = new DetalleOrden(3);
        
        System.out.println("Cantidad: " + det4.getCantidad()+ " " +art6.getNombre() + " " + art6.getDescripcion() + " " + art6.getPeso()+ "gr " + art6.getPrecio()+" PRECIO:"+ det4.calcPrecioSinIva(art6)+" IVA:"+ det4.calcIva(art6)+" TOTAL:"+ det4.calcPrecio(art6));
        System.out.println("Cantidad: " + det5.getCantidad()+" " + art5.getNombre() + " " + art5.getDescripcion() + " " + art5.getPeso()+ "gr " + art5.getPrecio()+" PRECIO:"+ det5.calcPrecioSinIva(art5)+" IVA:"+ det5.calcIva(art5)+" TOTAL:"+ det5.calcPrecio(art5));
        
        double total2 = det4.calcPrecio(art6)+ det5.calcPrecio(art5);
        System.out.println("TOTAL: " + total2);
        System.out.println("Estado: " + orden1.getEstado());
        
        //"Tipo Documento:"
         DocumentoTributario docu2 = new DocumentoTributario("12", "1232845-6");
         Factura factura2 = new Factura("13", "123405-6"); 
         if(docu2.getNumero().equals(factura2.getNumero())){
             System.out.println("Tipo Documento: Factura");
         }
         else System.out.println("Tipo Documento: Boleta");

        Pago pa2 = new Pago(10000);
        Efectivo e2 = new Efectivo(10000);
        System.out.println("Tipo pago: ");
        System.out.println("vuelto: " + e2.calcDevolucion(5000));
    }
    
}
