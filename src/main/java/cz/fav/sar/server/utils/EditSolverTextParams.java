package cz.fav.sar.server.utils;

public class EditSolverTextParams{
	Long id;
	String text;
	Long difficulty;
	
	public EditSolverTextParams(){}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	public Long getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(Long difficulty){
		this.difficulty = difficulty;
	}
}
