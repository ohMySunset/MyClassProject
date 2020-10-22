package generic;

public class FruitBox<T> {

	T fruit;  //Apple fruit
	
	
	public FruitBox(T fruit) { 
		this.fruit = fruit;
	}


	public void store(T fruit) {  //public void store(Apple fruit)
		this.fruit = fruit;
	}
	
	public T pullOut() {  //public Apple pullOut()
		return fruit;
	}
}
