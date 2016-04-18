import java.util.ArrayList;

public class SearchDictionary{
	
	private String[] dict;
	public int last;
	
	public SearchDictionary(){
		dict=new String[8];
		last=0;
	}

	public void addWord(String word){
		word=word.toLowerCase();
		if(word.endsWith(","))word=word.replace(word.substring(word.length()-1), "");
		if(word.endsWith("."))word=word.replace(word.substring(word.length()-1), "");
		if(last+1==dict.length){
			enlarge();
		}
		if(last==0){
			last++;
			dict[0]=word;
		}
		else{
			for(int i=0;i<last;i++){
				if(word.equals(dict[i]))
					return;
				if(word.compareTo(dict[i])<0){
					paste(i,word);
					last++;
					return;
				}
			}
			dict[last]=word;
			last++;
		}
	}
	
	private void enlarge(){
		String[] temp=new String[dict.length*2];
		for(int i=0;i<dict.length;i++){
			temp[i]=dict[i];
		}
		dict=temp;
	}
	
	private void paste(int ind,String word){
		for(int i=last;i>=ind;i--){
			dict[i+1]=dict[i];
		}
		dict[ind]=word;
	}

	public String delWord(String word){
		word=word.toLowerCase();
		
		if(last==0)return "No elements present!";
		
		if(last<dict.length/4&&dict.length>8){
			reduce();
		}
		for(int i=0;i<last;i++){
			if(word.equals(dict[i])){
				delete(i);
				last--;
			}
		}
		return word;
	}
	
	private void reduce(){
		String[] temp=new String[dict.length/2];
		for(int i=0;i<dict.length;i++){
			temp[i]=dict[i];
		}
		dict=temp;
	}
	
	private void delete(int ind){
		for(int i=ind;i<dict.length-1;i++){
			dict[i]=dict[i+1];
		}
	}

	public boolean hasWord(String word){
		for(int i=0;i<last;i++){
			if(word.equals(dict[i])){
				return true;
			}
		}
		return false;
		
	}
	
	public String toString(){
		String res="[ ";
		for(int i=0;i<last-1;i++){
			res+=dict[i]+", ";
		}
		return res+dict[last-1]+" ]";
	}

	public Iterable<String> query(String query){
		ArrayList<String> al=new ArrayList<String>();
		for(int i=0;i<last;i++)
			if(dict[i].startsWith(query))
				al.add(dict[i]);
		return al;
		
	}

	public int countWords(){
		return last;
		
	} 
}