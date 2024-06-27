import java.io.*;
import java.util.*;

public class ORLibraryParser {
    public static Grafo parseInstance(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line = reader.readLine();
        String[] parts = line.split("\\s+");
        int numVertices = Integer.parseInt(parts[0]);
        int k = Integer.parseInt(parts[1]);
        
        Grafo grafo = new Grafo(numVertices);

        while ((line = reader.readLine()) != null) {
            parts = line.split("\\s+");
            int u = Integer.parseInt(parts[0]) - 1;
            int v = Integer.parseInt(parts[1]) - 1;
            double weight = Double.parseDouble(parts[2]);
            grafo.addAresta(u, v, weight);
        }
        
        reader.close();
        return grafo;
    }

    public static void main(String[] args) {
        try {
            Grafo grafo = parseInstance("./txt_files/pmed1.txt");
            int k = 5;  // Exemplo, deve ser ajustado conforme a instância
            List<Integer> centers = KCenters.kCenters(grafo, k);
            System.out.println("Centros selecionados: " + centers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
