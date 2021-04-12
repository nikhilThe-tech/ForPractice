package functionInterface;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.function.Function;
import java.util.stream.Collectors;

class Person{
	int id;
	String name;
	public Person(int id,String name) {
		this.id = id;
		this.name = name;
	
			
	}
	
	public Person() {
		
	
			
	}
}
public class Main {

	public static void main(String[] args) {
		DemoFunctionalInterFace demoFunctionalInterFace = (int x) ->x*x;
		System.out.println(demoFunctionalInterFace.test(2));
		List<Person> personList = Arrays.asList(new Person[] {new Person(1,"Nikhil"),new Person(2,"Ram"),new Person(3,"Shayam")});
		List<Integer> idList = personList.stream().map(person->person.id).collect(Collectors.toList());
		Map<Integer,String> map = personList.stream().collect(Collectors.toMap(person->person.id, person->person.name));
		
		String name = Optional.ofNullable(map.get(3)).orElse("Right").toLowerCase();
		System.out.println(name);
		
		StringJoiner joiner1 = new StringJoiner(",","{","}");
		joiner1.add("Sonu");
		joiner1.add("Nigam");
		System.out.println(joiner1);
		StringJoiner joiner2 = new StringJoiner(":","QW","WQ");
		joiner2.add("Lal");
		joiner2.add("Singh");
		StringJoiner merged = joiner2.merge(joiner1);
		System.out.println(merged);
		
		//java 10
		var map2 = new HashMap<String,String>();
		for(var entry:map2.entrySet()) {
			entry.getValue();
		}
		List<String> list = List.of("ram","shyam");
		List<String> newListJava8 = list.stream().collect(Collectors.toList());
		newListJava8.add("mm");
		List<String> newListJava10 = list.stream().collect(Collectors.toUnmodifiableList());
		//newListJava10.add("mm");//Exception in thread "main" java.lang.UnsupportedOperationException
		System.out.println(newListJava8+" "+newListJava10);
		
		//java 11
		String [] arr = newListJava8.toArray(size-> new String[size]);
		Function<Integer,Integer> f  = (a)->a+a; //java 8
		Function f1  = (var a)->a; //java 11
		String g = "  ";
		g.isBlank(); //true
		String gh = "hii \n"
				+ "hello";
		System.out.println(gh.lines().collect(Collectors.toList())); //[hii , hello]
		
		String ram = " ram ";
		System.out.println(ram.trim());
		System.out.println(ram.strip());
		System.out.println(ram.stripLeading());
		System.out.println(ram.stripTrailing());
		System.out.println(ram.repeat(3)); //ram ram  ram
		
		

	}

}
