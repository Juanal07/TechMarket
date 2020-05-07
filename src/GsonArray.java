import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GsonArray {

    public static List<Persona> desserializarJsonAArrayPersona() {
        String jsonInString = "personas.json";
        List<Persona> listaPersonas = null;
        try (Reader reader = new FileReader(jsonInString)) {
            Gson gson = new Gson();
            Type tipoListaPersonas = new TypeToken<List<Persona>>() {}.getType();
            List<Persona> personas = gson.fromJson(reader, tipoListaPersonas);
            listaPersonas = personas;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaPersonas;
    }

    public static List<Registro> desserializarJsonAArrayRegistro() {
        String jsonInString = "registros.json";
        List<Registro> listaRegistros = null;
        try (Reader reader = new FileReader(jsonInString)) {
            Gson gson = new Gson();
            Type tipoListaRegistros = new TypeToken<List<Registro>>() {}.getType();
            List<Registro> registros = gson.fromJson(reader, tipoListaRegistros);
            listaRegistros = registros;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaRegistros;
    }



    public static void EscribirJson(String representacionBonita, String ruta) {
        try {
            BufferedWriter bw; // Escribimos la info en el archivo json
            bw = new BufferedWriter(new FileWriter(ruta));
            bw.write(representacionBonita);
            bw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

//    lista.add(nuevo); // añadimos el nuevo usuario a la lista
//    Gson prettyGson = new GsonBuilder().setPrettyPrinting().create(); // Pasamos la lista a formato json
//    String representacionBonita = prettyGson.toJson(lista);
//    String ruta = "usuarios.json";
//	GsonGeneral.EscribirJson(representacionBonita, ruta);


}
