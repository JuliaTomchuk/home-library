package my.home.library.service;

import java.util.List;

public interface Validator <T>{
	
   boolean isValid ( T t );
   boolean isValid(List <T> t);
    

}
