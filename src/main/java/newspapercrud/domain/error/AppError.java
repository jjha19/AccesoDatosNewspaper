package newspapercrud.domain.error;

public class DatabaseError extends RuntimeException{
    public DatabaseError(String mensage){
        super(mensage);
    }
}
