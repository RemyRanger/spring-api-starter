package api.springapistarter.config.exception;

import org.springframework.http.HttpStatus;

public class TeamMembersFullException extends BusinessAbstractException {

    public TeamMembersFullException() {
        super("Team members list is full", HttpStatus.BAD_REQUEST);
    }

}
