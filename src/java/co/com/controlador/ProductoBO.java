package co.com.controlador;

import co.com.entidades.Plproducto;
import co.com.modelo.PLproductoDaoJpa;
import java.text.SimpleDateFormat;
import java.util.List;
import javafx.css.StyleOrigin;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;


@ManagedBean(name = "productoBO")
@SessionScoped

public class ProductoBO {
    
    private Plproducto plproducto;
    private PLproductoDaoJpa plproductoDaoJpa;
    private List<Plproducto>productosList;
    private Plproducto seleccionarProducto;
    

    
//    metodo constructor
    public ProductoBO() {
        plproductoDaoJpa = new PLproductoDaoJpa();
        init();     
    }

    
    


private void init(){

    plproducto = new  Plproducto();
    productosList = plproductoDaoJpa.listAll();
    seleccionarProducto = new Plproducto();
    }

    
    
    
    public String agregarProductos(){
        
        
        System.out.print("ENTRO METODO AGREGAR......");
        plproductoDaoJpa.crearProducto(plproducto);
        init();
//       EntityConverter.ejecutarUpdate(EntityConverter.buscarHtmlComponete("incluirProducto").getClientId());

        return null;
       }    

      
    
    
     public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Producto Seleccionado", ((Plproducto) event.getObject()).getNombre());
        FacesContext.getCurrentInstance().addMessage(null, msg);
             }
    
      public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Producto Unselected", ((Plproducto) event.getObject()).getNombre());
        FacesContext.getCurrentInstance().addMessage(null, msg);
            }
     
      
      
//      Metodo para dar formato a las fechas
      
      
       public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }
     
       
         public void click() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
         
        requestContext.update("form:display");
        requestContext.execute("PF('dlg').show()");
    }
    
    
//    metodos set y get
    public Plproducto getPlproducto() {
        return plproducto;
    }

    public void setPlproducto(Plproducto plproducto) {
        this.plproducto = plproducto;
    }

    public PLproductoDaoJpa getPlproductoDaoJpa() {
        return plproductoDaoJpa;
    }

    public void setPlproductoDaoJpa(PLproductoDaoJpa plproductoDaoJpa) {
        this.plproductoDaoJpa = plproductoDaoJpa;
    }

    public List<Plproducto> getProductosList() {
        return productosList;
    }

    public void setProductosList(List<Plproducto> productosList) {
        this.productosList = productosList;
    }

    public Plproducto getSeleccionarProducto() {
        return seleccionarProducto;
    }

    public void setSeleccionarProducto(Plproducto seleccionarProducto) {
        this.seleccionarProducto = seleccionarProducto;
    }
    
    
}
