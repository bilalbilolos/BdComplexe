
package MyInterface;
import MyInterface.models.Temperature;
import java.util.ArrayList;
import java.util.List;
import org.influxdb.InfluxDB;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;
import static org.influxdb.querybuilder.BuiltQuery.QueryBuilder.eq;
import static org.influxdb.querybuilder.BuiltQuery.QueryBuilder.select;

public class ChargerFromDB {
 private static InfluxDB influxDB ;
 
//Instanciation d'un objet de connection
 private static Connection connection=new Connection();
 
 //liste de type temperature ou on va mettre le resultats des requettes  
 private static List<Temperature> temperature;
 

//methode qui retourne une liste des temperatures selon un office name 
public List<Temperature> getElements(String elt) {
    // lancer la connection
     influxDB=connection.getInfluxDB();
     // requette qui va chercher sur le table de temperature selon l'officename saisie
     Query query = select().from("projectDB","temperature").where(eq("officename",elt));
    //Executer la requette
     QueryResult queryResult = influxDB.query(query);
     System.out.println(queryResult);
     temperature=new ArrayList<>();
     // parcours de resultats de requette et remplisage de list des temperatures 
     for( QueryResult.Result result:queryResult.getResults()){
                if (result.getSeries() != null) {
                 for (QueryResult.Series series : result.getSeries()) {
                   for (List<Object> values : series.getValues()) {
                       //ajout dans la liste 
                       temperature.add(new Temperature(values.get(1).toString(), values.get(2).toString()));
                   }
                 }
                 }
                }
     // retourner la liste des temperatures 
    return temperature;
    }
//methode qui retourne une liste qui contient toutes les temperatures sur la table
  public List<Temperature> getAllElements() {
        // lancer la connection
      influxDB=connection.getInfluxDB();
     // requette qui va chercher sur le table tous les temperatures
     Query query = new Query("select * from temperature","projectDB");
   // Executer la requette
     QueryResult queryResult = influxDB.query(query);
     temperature=new ArrayList<>();
     System.out.println(queryResult);
     // parcours de resultats de requette et remplisage de list des temperatures 
     for( QueryResult.Result result:queryResult.getResults()){
                if (result.getSeries() != null) {
                 for (QueryResult.Series series : result.getSeries()) {
                   for (List<Object> values : series.getValues()) {
                       //ajout dans la liste 
                       temperature.add(new Temperature(values.get(1).toString(), values.get(2).toString()));
                   }
                 }
                 }
                }
    // retourner la liste des temperatures 
    return temperature;
    }
    
}
