package int221.project.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(){
        super();
    }
    public ProductNotFoundException(String msg, Throwable cause){
        super(msg,cause);
    }
    public ProductNotFoundException(String msg){
        super(msg);
    }
    public ProductNotFoundException(Throwable cause){
        super(cause);
    }
}
