package beams.interfacesForToGet;

import java.util.List;
import java.util.function.Function;

public interface GetList<T> {

   List<T> getAllList();

   Function<Integer,T> findByIdInterfaces( );

}