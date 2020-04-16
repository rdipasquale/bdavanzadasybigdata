package ar.edu.uca.project_template.ws;

//@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExampleException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 883140272099748679L;

	public ExampleException(String exception) {
		super(exception);
	}

}