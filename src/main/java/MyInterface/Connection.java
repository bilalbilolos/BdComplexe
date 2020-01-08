
package MyInterface;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;
import static org.influxdb.querybuilder.BuiltQuery.QueryBuilder.eq;
import static org.influxdb.querybuilder.BuiltQuery.QueryBuilder.select;

public class Connection {
    
    //creation de variable ou on va mettre le resultat de connection
    
    private InfluxDB influxDB ;
    
    public InfluxDB  getInfluxDB(){
        //connection a la base de données sur le port 8086
        influxDB=InfluxDBFactory.connect("http://localhost:8086");
        //returner l'objet de connection
        return influxDB;
        }
 
}
