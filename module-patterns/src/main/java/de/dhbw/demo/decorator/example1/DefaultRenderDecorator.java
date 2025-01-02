package de.dhbw.demo.decorator.example1;

public class DefaultRenderDecorator extends RenderDecorator {

	public DefaultRenderDecorator(Renderer renderer) {
		super(renderer);
	}

	public String render() {
		return super.render();
	}

}