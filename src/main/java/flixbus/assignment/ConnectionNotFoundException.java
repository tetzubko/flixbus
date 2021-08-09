package flixbus.assignment;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Connection not found")
public class ConnectionNotFoundException extends RuntimeException{
}
