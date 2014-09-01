package JavaPgms1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TwitterMessage {
	public static LinkedList<String> getHashTag(String message){
		LinkedList<String> hashTags = new LinkedList<String>();
		Pattern ht = Pattern.compile("#\\w+");
		Matcher m = ht.matcher(message);
		while(m.find()){
			hashTags.add(m.group());
		}
		return hashTags;
	}
	
	public static LinkedList<String> getMentioned(String message){
		LinkedList<String> mentioned = new LinkedList<String>();
		Pattern ht = Pattern.compile("@\\w[_|\\w]+");
		Matcher m = ht.matcher(message);
		while(m.find()){
			mentioned.add(m.group());
		}
		return mentioned;
		
	}
	
	public static void main(String[] args){
		String message = args[0];
		LinkedList<String> hashTags = getHashTag(message);
		LinkedList<String> mentioned = getMentioned(message);
	
		Iterator<String> itr = hashTags.listIterator();
		System.out.println("Hash tags: ");
		while(itr.hasNext()) System.out.println(itr.next());
		
		itr = mentioned.listIterator();
		System.out.println("mentioned: ");
		while(itr.hasNext()) System.out.println(itr.next());
	}
	
}
