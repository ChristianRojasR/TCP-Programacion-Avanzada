package PackageClases;

import java.util.Iterator;
import java.util.Stack;

public class CompositeIterator implements Iterator<Producto>{
	private Stack<Iterator<Producto>> stack;
	
	
	public CompositeIterator(Iterator<Producto> iterator) {
		this.stack = new Stack<>();
		stack.push(iterator);
	}

	@Override
	public boolean hasNext() {
		if(stack.isEmpty())
			return false;
		else {
			Iterator<Producto> iterator = stack.peek();
			if(!iterator.hasNext()) {
				stack.pop();
				return hasNext();
			} else
			return true;
		}
	}

	@Override
	public Producto next() {
//		if(hasNext()) {
//			Iterator<Producto> iterator = stack.peek();
//			Producto producto = iterator.next();
//			if(producto instanceof Paquete)
//				stack.push((Paquete) producto).createIterator();
//		}
		return null;
	}

}
