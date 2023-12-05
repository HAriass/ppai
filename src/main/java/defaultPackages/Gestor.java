
package defaultPackages;

import com.hernan.ppai.dominio.Encuesta;
import com.hernan.ppai.dominio.IAgregado;
import com.hernan.ppai.dominio.IIterador;
import com.hernan.ppai.dominio.IteradorEncuesta;
import java.util.ArrayList;

public class Gestor implements IAgregado<Encuesta>{
    

    @Override
    public IIterador<Encuesta> crearIterador(ArrayList<Encuesta> listaElementos) {
        ArrayList <Encuesta> listaEncuestas = listaElementos;
        IteradorEncuesta iteradorEncuesta = new IteradorEncuesta(listaEncuestas);
        return iteradorEncuesta;
    }
    
}
