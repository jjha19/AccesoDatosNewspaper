package newspapercrud.domain.error;

public class AppError extends RuntimeException{
    public AppError(String mensage){
        super(mensage);
    }
}
