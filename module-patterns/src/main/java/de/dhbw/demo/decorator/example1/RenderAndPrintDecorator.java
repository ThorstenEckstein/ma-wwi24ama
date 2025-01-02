package de.dhbw.demo.decorator.example1;

public class RenderAndPrintDecorator extends RenderDecorator {

	public RenderAndPrintDecorator(Renderer renderer) {
		super(renderer);
	}
	
	public String render() {
		super.render();
		complementaryProcess();
		return "now printing ...";
	}
	
	private void complementaryProcess() { /* ... */ }

}