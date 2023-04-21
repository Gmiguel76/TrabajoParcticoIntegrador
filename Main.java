package TrababajoIntegrador;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
public class Main {

    public static void main(String[] args) {

        Collection <Partido> partidos = new ArrayList<Partido>();
        String ruta1 = "C:\\Users\\Gloria\\eclipse-workspace\\TP-grupo10\\src\\test\\resources\\Resultados.csv";
        Path pathResultados = Paths.get(ruta1);
        List<String> lineasResultados =  null;
        try {
            lineasResultados = Files.readAllLines(pathResultados);
        } catch (IOException e) {

            System.out.println ("Sin leer resultado");
            System.exit (1);
        }
        boolean primera = true;

        for (String lineaResultado:lineasResultados) {
            if (primera) {
                primera = false;
            }else {

                String[] orden = lineaResultado.split(",");
                Equipo equipo1 = new Equipo (orden[0]);
                Equipo equipo2  = new Equipo (orden[3]);
                Partido partido = new Partido (equipo1,equipo2);
                partido.setGolesEquipo1 (Integer.parseInt(orden[1]));
                partido.setGolesEquipo2(Integer.parseInt(orden[2]));
                partidos.add(partido);
            }
        }


        int puntos = 0;
        String ruta2 = "C:\\Users\\Gloria\\eclipse-workspace\\TP-grupo10\\src\\test\\resources\\Pronostico.csv";
        Path pathPronostico = Paths.get(ruta2);
        List<String> lineasPronostico =  null;
        try {
            lineasPronostico = Files.readAllLines(pathPronostico);
        } catch (IOException e) {

            System.out.println ("Sin leer pronostico");
            System.exit (1);
        }
        primera = true;

        for (String lineaPronostico:lineasPronostico) {
            if (primera) {
                primera = false;
            }else {
                String[] orden = lineaPronostico.split(",");
                Equipo equipo1 = new Equipo (orden[0]);
                Equipo equipo2  = new Equipo (orden[4]);
                Partido partido = null;

                for (Partido partidocoleccion: partidos) {
                    if(partidocoleccion.getEquipo1().getNombre().equals(equipo1.getNombre())&&
                            partidocoleccion.getEquipo2().getNombre().equals(equipo2.getNombre()));
                    partido = partidocoleccion;
                }


                Equipo equipo = null;
                ResultadoEnum resultado = null;

                if("X".equals(orden[1])) {
                    equipo = equipo1;
                    resultado = ResultadoEnum.Ganador;
                }

                if("X".equals(orden[2])) {
                    equipo = equipo1;
                    resultado = ResultadoEnum.Empate;
                }

                if("X".equals(orden[3])) {
                    equipo = equipo1;
                    resultado = ResultadoEnum.Perdedor;
                }


                Pronostico pronostico = new Pronostico (partido, equipo, resultado);

                puntos += pronostico.puntos();
            }


            System.out.println ("Los puntos totales del participante fueron: " + puntos);

        }

    }
}
