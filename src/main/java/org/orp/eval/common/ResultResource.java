package org.orp.eval.common;

import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;

public interface ResultResource {
	
	/**
	 * 
	 * @return score by required measurement and scoring model.
	 */
	@Get
	public Representation summary();
	
	/**
	 * 
	 * @param commands, including:
	 * 1.score: get scores by different measurements. A data block like {"score":{
	 * "measure":"[measureName]"}} should follow the command. If scores by all measurements
	 * are needed, type in "all" instead of name of measurement. 
	 * 
	 * 2.download: download a result report.
	 * @return 
	 */
	@Post
	public Representation execute(JsonRepresentation data);
	
}
